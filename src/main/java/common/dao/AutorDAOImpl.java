package common.dao;

import common.dominios.Autor;
import common.dominios.enums.Tabla;
import common.interfaces.dao.AutorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutorDAOImpl implements AutorDAO {

    private static final String SAVE_AUTOR = "INSERT INTO " + Tabla.Autor + "(nombre_autor, apaterno_autor) VALUES (?, ?)";
    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Autor find(int id) throws Exception {
        return null;
    }

    @Override
    public List<Autor> findAll() throws Exception {
        return null;
    }

    @Override
    public void save(Autor entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(SAVE_AUTOR);
            statement.setString(1, entity.getNombre());
            statement.setString(2, entity.getApellido());
            // TODO continuar
        } catch (SQLException e) {
            System.out.println("SQLException in LibroDAO.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public void update(Autor entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }
}
