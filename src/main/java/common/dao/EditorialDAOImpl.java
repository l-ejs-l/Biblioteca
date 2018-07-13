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

    private static final String SAVE_EDITORIAL = "INSERT INTO " + Tabla.Editorial + "(editorial) VALUES (?)";
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
}
