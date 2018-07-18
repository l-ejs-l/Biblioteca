package common.dao;

import common.dominios.ClubCuenta;
import common.dominios.Cuenta;
import common.dominios.FreeCuenta;
import common.dominios.enums.Tabla;
import common.interfaces.dao.CuentaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Esta clase implementa la interfaz CuentaDAO y sus métodos para mantener la entidad Cuenta
 */
public class CuentaDAOImpl implements CuentaDAO {

    private static final String INSERT_CUENTA = "INSERT INTO " + Tabla.Cuenta + "(usuario,clave,es_miembro,nombre,apellido,correo) values(?,?,?,?,?,?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Cuenta find(int id) throws Exception {
        return null;
    }

    @Override
    public Set<Cuenta> findAll() throws Exception {
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet result = statement
//                .executeQuery("SELECT * FROM " + Tabla.Cuenta);
//            int numOfCol = result.getMetaData().getColumnCount();
//
//            while (result.next()) {
//                System.out.println(result.getInt("ID") + '\t'
//                    + result.getString("Usuario") + '\t'
//                    + result.getString("Clave") + '\t'
//                    + result.getBoolean("Member"));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return null;

    }

    @Override
    public void save(Cuenta entity) throws Exception {

        String username = entity.getUsuario();
        String password = entity.getClave();
        boolean member = entity.isEs_miembro();

        if (entity instanceof FreeCuenta) {
            FreeCuenta fa = (FreeCuenta) entity;
            String firstName = fa.getfName();
            String lastName = fa.getlName();
            String email = fa.getEmail();
            /*
             *
             */
            try {
                connection = Database.getConnection();
                statement = connection
                    .prepareStatement(INSERT_CUENTA);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setBoolean(3, false);
                statement.setString(4, firstName);
                statement.setString(5, lastName);
                statement.setString(6, email);
                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("SQL Exception in save()");
                e.printStackTrace();
                throw new Exception(e.getMessage());
            }

        }

        if (entity instanceof ClubCuenta) {

        }

    }

    @Override
    public void update(Cuenta entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }


    @Override
    public boolean isCuentaTaken(Cuenta cuenta) throws Exception {
        String username = cuenta.getUsuario();
        String password = cuenta.getClave();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                if (user.equals(cuenta.getUsuario())) {

                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception in isAccountTaken()");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isValidLogin(Cuenta cuenta) throws Exception {
        String username = cuenta.getUsuario();
        String password = cuenta.getClave();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.first()) {
                if (resultSet.getString("usuario").equals(
                    cuenta.getUsuario())) {
                    if (resultSet.getString("clave").equals(
                        cuenta.getClave())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception in isAccountTaken()");
            e.printStackTrace();
        }

        return false;
    }


}
