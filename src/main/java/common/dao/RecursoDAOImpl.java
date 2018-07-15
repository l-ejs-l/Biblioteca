package common.dao;

import common.dominios.*;
import common.dominios.enums.Tabla;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import common.interfaces.dao.RecursoDAO;

import java.sql.*;
import java.util.List;

/**
 * Esta clase implementa la interfaz RecursoDAO y sus métodos para mantener la entidad Recurso
 */
public class RecursoDAOImpl implements RecursoDAO {

    private static final String SAVE_RECURSO = "INSERT INTO " + Tabla.Recurso + " (titulo, tipo_recurso, tipo_texto, id_editorial, total_paginas) VALUES (?, ?, ?, ?, ?)";
    private static final String SAVE_LIBRO = "INSERT INTO " + Tabla.Libro + " (id_recurso, isbn, lomo, contraportada, portada) VALUES (?, ?, ?, ?, ?)";
    private static final String SAVE_REVISTA = "INSERT INTO " + Tabla.Revista + " (id_recurso) VALUES (?)";
    private static final String SAVE_PERIODICO = "INSERT INTO " + Tabla.Periodico + " (id_recurso, lema, fecha_publicacion) VALUES (?, ?, ?)";
    private static final String SAVE_RECURSO_AUTOR = "INSERT INTO " + Tabla.Recurso_Autor + " (id_recurso, id_autor) VALUES (? , ?)";
    public static final String SAVE_TOPICO_RECURSO = "INSERT INTO " + Tabla.Topico_Recurso + " (id_recurso, id_topico) VALUES  (?, ?)";


    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Recurso findById(int id) {
        return null;
    }

    @Override
    public List<Recurso> findAll() {
        return null;
    }

    @Override
    public void save(Recurso entity) throws Exception {
        try {
            // Recurso
            connection = Database.getConnection();
            // Auto commit manual para generar un movimiento transaccional y poder hacer rollback en caso de error
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SAVE_RECURSO, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getTitulo());
            statement.setInt(2, entity.getTipoRecurso().ordinal());
            statement.setInt(3, entity.getTipoTexto().ordinal());
            statement.setInt(4, entity.getEditorial().getId());
            statement.setInt(5, entity.getTotalPaginas());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            // Obtengo clave autogenerada del crecurso creado
            int idRecurso = resultSet.next() ? resultSet.getInt(1) : 0;

            if (idRecurso == 0) {
                throw new Exception("No se obtuvo una id de recurso");
            }

            // Autor_Recurso
            statement = connection.prepareStatement(SAVE_RECURSO_AUTOR);
            List<Autor> autores = entity.getAutores();
            for (Autor autor : autores) {
                statement.setInt(1, idRecurso);
                statement.setInt(2, autor.getId());
                int update = statement.executeUpdate();
                if (update == 0) {
                    throw new Exception("No se ingreso un autor del libro");
                }
            }

            // Topico_Recurso
            statement = connection.prepareStatement(SAVE_TOPICO_RECURSO);
            List<Topico> topicos = entity.getTopicos();

            for (Topico topico : topicos) {
                statement.setInt(1, idRecurso);
                statement.setInt(2, topico.getId());
                int update = statement.executeUpdate();
                if (update == 0) {
                    throw new Exception("No se ingresó un tipico");
                }
            }

            // Libro
            if (entity.getRecurso() instanceof Libro) {
                Libro libro = (Libro) entity.getRecurso();

                statement = connection.prepareStatement(SAVE_LIBRO);
                statement.setInt(1, idRecurso);
                statement.setString(2, libro.getIsbn());
                statement.setString(3, libro.getLomo());
                statement.setString(4, libro.getContraportada());
                statement.setString(5, libro.getPortada());
                int update = statement.executeUpdate();

                if (update == 0) {
                    throw new Exception("No se insertó ningun Libro");
                }
            }

            // Periodico
            if (entity.getRecurso() instanceof Periodico) {
                Periodico periodico = (Periodico) entity.getRecurso();

                statement = connection.prepareStatement(SAVE_PERIODICO);
                statement.setInt(1, idRecurso);
                statement.setString(2, periodico.getLema());
                statement.setDate(3, periodico.getFechaPublicacion());
                int update = statement.executeUpdate();

                if (update == 0) {
                    throw new Exception("No se insertó ningun periodico");
                }
            }

            // Revista
            if (entity.getRecurso() instanceof Revista) {
                Revista revista = (Revista) entity.getRecurso();

                statement = connection.prepareStatement(SAVE_REVISTA);
                statement.setInt(1, idRecurso);
                int update = statement.executeUpdate();

                if (update == 0) {
                    throw new Exception("No se insertó ningun periodico");
                }
            }

            // Commit si no hay problemas en los puntos anteriores
            connection.commit();
        } catch (SQLException e) {
            // Rollback en caso de excepcion
            connection.rollback();
            System.out.println("SQLException in LibroDAO.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Recurso entity) {


    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso) throws Exception {
        return null;
    }

    @Override
    public List<Recurso> findByTipoTexto(TipoTexto tipoTexto) throws Exception {
        return null;
    }

    @Override
    public List<Recurso> findByName(String name) throws Exception {
        return null;
    }
}
