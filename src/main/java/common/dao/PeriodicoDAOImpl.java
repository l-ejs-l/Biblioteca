package common.dao;

import common.dominios.Periodico;
import common.dominios.enums.Tabla;
import common.interfaces.dao.PeriodicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase implementa la interfaz PeriodicoDAO y sus métodos para mantener la entidad Periódico
 *
 * @author emilio
 */
public class PeriodicoDAOImpl implements PeriodicoDAO {

    private static final String FIND_PERIODICO_BY_ID = "SELECT * FROM " + Tabla.Periodico + " WHERE id_recurso = (?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Periodico find(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_PERIODICO_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Periodico periodico = getPeriodico();

            if (periodico != null) return periodico;

            throw new Exception("No se encontró ningun periodico con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in PeriodicoDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Periodico getPeriodico() throws SQLException {
        if (resultSet.next()) {
            return castPeriodico();
        }
        return null;
    }

    private Periodico castPeriodico() throws SQLException {
        Periodico periodico = new Periodico();
        periodico.setFechaPublicacion(resultSet.getDate("fecha_publicacion"));
        periodico.setLema(resultSet.getString("lema"));
        periodico.setId(resultSet.getInt("id_recurso"));
        return periodico;
    }
}
