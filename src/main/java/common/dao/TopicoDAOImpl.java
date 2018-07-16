package common.dao;

import common.dominios.Topico;
import common.dominios.enums.Tabla;
import common.interfaces.dao.TopicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz TopicoDAO y sus métodos para mantener la entidad Topico
 */
public class TopicoDAOImpl implements TopicoDAO {

    private static final String SAVE_TOPICO = "INSERT INTO " + Tabla.Topico + " (topico) VALUES (?)";
    private static final String FIND_TOPICO_BY_NAME = "SELECT * FROM " + Tabla.Topico + " WHERE topico = (?)";
    private static final String FIND_TOPICO_BY_ID = "SELECT * FROM " + Tabla.Topico + " WHERE id_topico = (?)";
    private static final String FIND_ALL_TOPICO = "SELECT * FROM " + Tabla.Topico;
    private static final String FIND_ALL_TOPICO_BY_RECURSO_ID = "SELECT * FROM " + Tabla.Topico_Recurso +
        " tr JOIN biblioteca.Topico top ON(top.id_topico = tr.id_topico) WHERE id_recurso = ?";
    private static final String UPDATE_TOPICO = "UPDATE " + Tabla.Topico + " SET topico = ? WHERE id_topico = ?";
    private static final String REMOVE_TOPICO = "DELETE FROM " + Tabla.Topico + " WHERE id_topico = ?";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Topico findById(int id) throws Exception {

        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_TOPICO_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Topico topico = getTopico();

            if (topico != null) return topico;

            throw new Exception("No se encontró ningun topico con ese id");

        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<Topico> findAll() throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_ALL_TOPICO);
            resultSet = statement.executeQuery();

            List<Topico> topicos = new ArrayList<>();

            while (resultSet.next()) {
                Topico topico = castTopico();
                topicos.add(topico);
            }

            if (topicos.size() != 0) return topicos;

            throw new Exception("No se encontró ningun topico");

        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.findAll()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void save(Topico entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(SAVE_TOPICO);
            statement.setString(1, entity.getTopico());

            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No realizo ninguna inserción en entidad Topico");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.save()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(Topico entity) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(UPDATE_TOPICO);
            statement.setString(1, entity.getTopico());
            statement.setInt(2, entity.getId());


            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No realizo ninguna modificacion en entidad Topico");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void remove(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(REMOVE_TOPICO);
            statement.setInt(1, id);

            int update = statement.executeUpdate();

            if (update == 0) {
                throw new Exception("No se pudo eliminar Entidad Topico");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.update()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Topico findByName(String name) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_TOPICO_BY_NAME);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            Topico topico = getTopico();
            if (topico != null) return topico;

            throw new Exception("No se encontró ningun topico con ese nombre");

        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.findByName()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Topico> findListById(int id) throws Exception {
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(FIND_ALL_TOPICO_BY_RECURSO_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            List<Topico> topicos = new ArrayList<>();

            while (resultSet.next()) {
                Topico topico = castTopico();
                topicos.add(topico);
            }

            if (topicos.size() != 0) return topicos;

            throw new Exception("No se encontró ningun topico");

        } catch (SQLException e) {
            System.out.println("SQLException in TopicoDAO.findListById()");
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Topico getTopico() throws SQLException {
        if (resultSet.next()) {
            return castTopico();
        }
        return null;
    }

    private Topico castTopico() throws SQLException {
        Topico topico = new Topico();
        topico.setTopico(resultSet.getString("topico"));
        topico.setId(resultSet.getInt("id_topico"));
        return topico;
    }

}
