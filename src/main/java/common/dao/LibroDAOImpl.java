package common.dao;

import common.dominios.Autor;
import common.dominios.Libro;
import common.dominios.Recurso;
import common.dominios.Topico;
import common.dominios.enums.Tabla;
import common.interfaces.dao.LibroDAO;

import java.sql.*;
import java.util.List;

/**
 * Implentacion de los métodos de la Interfaz LibroDAO
 */
public class LibroDAOImpl implements LibroDAO {

    private static final String SAVE_RECURSO =
        "INSERT INTO " + Tabla.Recurso + "(titulo, tipo_recurso, tipo_texto, id_editorial, total_paginas) VALUES (?, ?, ?, ?, ?)";
    private static final String SAVE_LIBRO =
        "INSERT INTO " + Tabla.Libro + "(id_recurso, isbn, lomo, contraportada, portada) VALUES (?, ?, ?, ?, ?)";

    private static final String SAVE_RECURSO_AUTOR =
        "INSERT INTO " + Tabla.Recurso_Autor + "(id_recurso, id_autor) VALUES (? , ?)";

    public static final String SAVE_TOPICO_RECURSO = "";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Libro find(int id) throws Exception {
        return null;
    }

    @Override
    public List<Libro> findAll() throws Exception {
        return null;
    }

    @Override
    public void save(Libro entity) throws Exception {

    }

    @Override
    public void update(Libro entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public void saveRecurso(Libro entity, Recurso recurso, List<Autor> autores, List<Topico> topicos) throws Exception {


        try {
            connection = Database.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SAVE_RECURSO, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, recurso.getTitulo());
            statement.setInt(2, recurso.getTipoRecurso().ordinal());
            statement.setInt(3, recurso.getTipoTexto().ordinal());
            statement.setInt(4, recurso.getEditorial().getId());
            statement.setInt(5, recurso.getTotalPaginas());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            int idRecurso = resultSet.next() ? resultSet.getInt(1) : 0;

            if (idRecurso == 0) {
                throw new Exception("No se obtuvo una id de recurso");
            }

            statement = connection.prepareStatement(SAVE_RECURSO_AUTOR);

            for (Autor autor : autores) {
                statement.setInt(1, idRecurso);
                statement.setInt(2, autor.getId());
                int update = statement.executeUpdate();
                if (update == 0) {
                    throw new Exception("No se ingreso un autor del libro");
                }
            }

            statement = connection.prepareStatement(SAVE_LIBRO);
            statement.setInt(1, idRecurso);
            statement.setString(2, entity.getIsbn());
            statement.setString(3, entity.getLomo());
            statement.setString(4, entity.getContraportada());
            statement.setString(5, entity.getPortada());
            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se insertó ningun libro");
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("SQLException in LibroDAO.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }
}
