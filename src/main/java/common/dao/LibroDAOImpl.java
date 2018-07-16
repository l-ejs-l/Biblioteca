package common.dao;

import common.dominios.Libro;
import common.dominios.enums.Tabla;
import common.interfaces.dao.LibroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDAOImpl implements LibroDAO {

    private static final String FIND_LIBRO_BY_ID = "SELECT * FROM " + Tabla.Libro + " WHERE id_recurso = ?";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Libro findById(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_LIBRO_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Libro libro = getLibro();

            if (libro != null) return libro;

            throw new Exception("No se encontró ningun libro con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in LibroDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Libro getLibro() throws SQLException {
        if (resultSet.next()) {
            return castLibro();
        }
        return null;
    }

    private Libro castLibro() throws SQLException {
        Libro libro = new Libro();
        libro.setContraportada(resultSet.getString("contraportada"));
        libro.setIsbn(resultSet.getString("isbn"));
        libro.setLomo(resultSet.getString("lomo"));
        libro.setPortada(resultSet.getString("portada"));
        libro.setId(resultSet.getInt("id_recurso"));
        return libro;
    }
}
