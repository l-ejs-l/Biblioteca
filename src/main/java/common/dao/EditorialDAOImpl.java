package common.dao;

import common.dominios.Editorial;
import common.dominios.enums.Tabla;
import common.interfaces.dao.EditorialDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EditorialDAOImpl implements EditorialDAO {

    private static final String SAVE_EDITORIAL = "INSERT INTO " + Tabla.Editorial + " (editorial) VALUES (?)";
    private static final String FIND_EDITORIAL_BY_NAME = "SELECT * FROM " + Tabla.Editorial + " WHERE editorial = (?)";
    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Editorial find(int id) throws Exception {
        return null;
    }

    @Override
    public List<Editorial> findAll() throws Exception {
        return null;
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

    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public Editorial findByName(String name) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_EDITORIAL_BY_NAME);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            Editorial editorial;
            if (resultSet.next()) {
                editorial = new Editorial();
                editorial.setEditorial(resultSet.getString("editorial"));
                editorial.setId(resultSet.getInt("id_editorial"));
                return editorial;
            }

            throw new Exception("No se encontró una Editorial con el nombre indicado");

        } catch (SQLException e) {
            System.out.println("SQLException in EditorialDAO.find()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
