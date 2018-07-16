package common.dao;

import common.dominios.Editorial;
import common.dominios.enums.Tabla;
import common.interfaces.dao.EditorialDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz EditorialDAO y sus métodos para mantener la entidad Editorial
 */
public class EditorialDAOImpl implements EditorialDAO {

    private static final String SAVE_EDITORIAL = "INSERT INTO " + Tabla.Editorial + " (editorial) VALUES (?)";
    private static final String FIND_EDITORIAL_BY_NAME = "SELECT * FROM " + Tabla.Editorial + " WHERE editorial = (?)";
    private static final String FIND_EDITORIAL_BY_ID = "SELECT * FROM " + Tabla.Editorial + " WHERE id_editorial = (?)";
    private static final String FIND_ALL_EDITORIAL = "SELECT * FROM " + Tabla.Editorial;
    private static final String UPDATE_EDITORIAL = "UPDATE " + Tabla.Editorial + " SET editorial = ? WHERE id_editorial = ?";
    private static final String REMOVE_EDITORIAL = "DELETE FROM " + Tabla.Editorial + " WHERE id_editorial = ?";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Editorial findById(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_EDITORIAL_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Editorial editorial = getEditorial();

            if (editorial != null) return editorial;

            throw new Exception("No se encontró ninguna editorial con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Editorial> findAll() throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_ALL_EDITORIAL);
            resultSet = statement.executeQuery();

            List<Editorial> editorials = new ArrayList<>();

            while (resultSet.next()) {
                Editorial topico = castEditorial();
                editorials.add(topico);
            }

            if (editorials.size() != 0) return editorials;

            throw new Exception("No se encontró ningun Editorial");

        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.findAll()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void save(Editorial entity) throws Exception {

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(SAVE_EDITORIAL);
            statement.setString(1, entity.getEditorial());
            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se realizo la persistencia de la editorial");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Editorial entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(UPDATE_EDITORIAL);
            statement.setString(1, entity.getEditorial());
            statement.setInt(2, entity.getId());

            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No realizo ninguna modificacion en entidad Editorial");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void remove(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(REMOVE_EDITORIAL);
            statement.setInt(1, id);

            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se pudo eliminar Entidad Editorial");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Editorial findByName(String name) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_EDITORIAL_BY_NAME);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            Editorial editorial = getEditorial();

            if (editorial != null) return editorial;

            throw new Exception("No se encontró una Editorial con el nombre indicado");

        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Editorial getEditorial() throws SQLException {
        if (resultSet.next()) {
            return castEditorial();
        }
        return null;
    }

    private Editorial castEditorial() throws SQLException {
        Editorial editorial = new Editorial();
        editorial.setEditorial(resultSet.getString("editorial"));
        editorial.setId(resultSet.getInt("id_editorial"));
        return editorial;
    }
}
