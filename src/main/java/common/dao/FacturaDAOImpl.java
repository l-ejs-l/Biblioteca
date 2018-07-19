package common.dao;

import common.dao.Database;
import common.dominios.Factura;
import common.dominios.enums.TipoFactura;
import common.interfaces.dao.FacturaDAO;
import common.dominios.enums.Tabla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Esta clase implementa la interfaz CuentaDAO y sus métodos para mantener la entidad Cuenta
 */
public class FacturaDAOImpl implements FacturaDAO {

    private static final String INSERT_FACTURA = "INSERT INTO " + Tabla.Factura + "(id_factura,tipo_factura,sucursal_origen,sucursal_destino,sucursal,usuario,proveedor,comuna,region) values(?,?,?,?,?,?,?,?,?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Factura find(int id) throws Exception {
        return null;
    }

    @Override
    public List<Factura> findAll() throws Exception {
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
    public void save(Factura entity) throws Exception {

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
                    .prepareStatement(INSERT_FACTURA);
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
    public void update(Factura entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }


    @Override
    public boolean isFacturaTaken(Factura factura) throws Exception {
        String username = factura.getUsuario();
        String password = factura.getClave();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Factura + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                if (user.equals(factura.getUsuario())) {

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
    public boolean isValidLogin(Factura factura) throws Exception {
        String username = factura.getUsuario();
        String password = factura.getClave();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Factura + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.first()) {
                if (resultSet.getString("usuario").equals(
                    factura.getUsuario())) {
                    if (resultSet.getString("clave").equals(
                        factura.getClave())) {
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

    @Override
    public void update(Factura entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCuentaTaken(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
