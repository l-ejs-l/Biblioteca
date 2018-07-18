package common.dao;

import common.dominios.Revista;
import common.dominios.enums.Tabla;
import common.interfaces.dao.RevistaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase implementa la interfaz RevistalDAO y sus métodos para mantener la entidad Revista
 *
 * @author emilio
 */
public class RevistaDAOImpl implements RevistaDAO {

    private static final String FIND_REVISTA_BY_ID = "SELECT * FROM " + Tabla.Revista + " WHERE id_recurso = (?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Revista find(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_REVISTA_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Revista revista = getRevista();

            if (revista != null) return revista;

            throw new Exception("No se encontró ninguna revista con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in RevistaDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Revista getRevista() throws SQLException {
        if (resultSet.next()) {
            return castRevista();
        }
        return null;
    }

    private Revista castRevista() throws SQLException {
        Revista revista = new Revista();
        revista.setId(resultSet.getInt("id_recurso"));
        return revista;
    }
}
