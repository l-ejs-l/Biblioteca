package common.dao;

import common.dominios.Autor;
import common.dominios.enums.Tabla;
import common.interfaces.dao.AutorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz AutorDAO y sus métodos para mantener la entidad Autor
 */
public class AutorDAOImpl implements AutorDAO {

    private static final String SAVE_AUTOR = "INSERT INTO " + Tabla.Autor + "(nombre_autor, apaterno_autor) VALUES (?, ?)";
    private static final String FIND_AUTOR_BY_ID = "SELECT * FROM " + Tabla.Autor + " WHERE id_autor = (?)";
    private static final String FIND_AUTOR_BY_NAME = "SELECT * FROM " + Tabla.Autor + " WHERE nombre_autor = ? AND apaterno_autor = ?";
    private static final String FIND_ALL_AUTOR = "SELECT * FROM " + Tabla.Autor;
    private static final String UPDATE_AUTOR = "UPDATE " + Tabla.Autor + " SET nombre_autor = ?, apaterno_autor = ? WHERE id_autor = ?";
    private static final String REMOVE_AUTOR = "DELETE FROM " + Tabla.Autor + " WHERE id_autor = ?";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Autor findById(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_AUTOR_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Autor autor = getAutor();

            if (autor != null) return autor;

            throw new Exception("No se encontró ningun autor con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in AutorDAO.findById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Autor> findAll() throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_ALL_AUTOR);
            resultSet = statement.executeQuery();

            List<Autor> autors = new ArrayList<>();

            while (resultSet.next()) {
                Autor autor = castAutor();
                autors.add(autor);
            }

            if (autors.size() != 0) return autors;

            throw new Exception("No se encontró ningun Autor");

        } catch (SQLException e) {
            System.out.println("SQLException in AutorDAO.findAll()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void save(Autor entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(SAVE_AUTOR);
            statement.setString(1, entity.getNombre());
            statement.setString(2, entity.getApellido());
            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se realizo persistencia del autor");
            }

        } catch (SQLException e) {
            System.out.println("SQLException in AutorDao.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public void update(Autor entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(UPDATE_AUTOR);
            statement.setString(1, entity.getNombre());
            statement.setString(2, entity.getApellido());
            statement.setInt(3, entity.getId());


            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No realizo ninguna modificacion en entidad Autor");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in AutorDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void remove(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(REMOVE_AUTOR);
            statement.setInt(1, id);

            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se pudo eliminar Entidad Autor");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in AutorDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Autor findByName(String name, String lastName) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_AUTOR_BY_NAME);
            statement.setString(1, name);
            statement.setString(2, lastName);
            resultSet = statement.executeQuery();

            Autor autor = getAutor();
            if (autor != null) return autor;

            throw new Exception("No se encontró ningun autor con ese nombre");

        } catch (SQLException e) {
            System.out.println("SQLException in AutorDAO.findByName()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Autor getAutor() throws SQLException {
        if (resultSet.next()) {
            return castAutor();
        }
        return null;
    }

    private Autor castAutor() throws SQLException {
        Autor autor = new Autor();
        autor.setNombre(resultSet.getString("nombre_autor"));
        autor.setApellido(resultSet.getString("apaterno_autor"));
        autor.setId(resultSet.getInt("id_autor"));
        return autor;
    }
}
