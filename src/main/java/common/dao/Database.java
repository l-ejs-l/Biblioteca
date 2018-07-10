package common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Esta clase realiza devuelve la conexion a la base de datos usando un patron singleton.
 */
public class Database {

    private static Connection CONNECTION = null;

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USERNAME = "biblioteca";
    private static final String PASSWORD = "biblioteca";
    private static final String MAX_POOL = "250";

    private Database() {

    }

    public static Connection getConnection() throws Exception {
        try {
            if (CONNECTION == null) {
                Properties properties = new Properties();
                properties.setProperty("user", USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("MaxPooledStatements", MAX_POOL);
                Class.forName(DATABASE_DRIVER);
                CONNECTION = DriverManager.getConnection(DATABASE_URL, properties);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        CONNECTION.setAutoCommit(true);
        return CONNECTION;
    }


//    public void addAccount(Cuenta cuenta) throws SQLException {
//
//        String username = cuenta.getUsuario();
//        String password = cuenta.getClave();
//        boolean member = cuenta.isEs_miembro();
//
//        if (cuenta instanceof FreeCuenta) {
//            FreeCuenta fa = (FreeCuenta) cuenta;
//            String firstName = fa.getfName();
//            String lastName = fa.getlName();
//            String email = fa.getEmail();
//            /*
//             *
//             */
//            PreparedStatement insertStatement = connection
//                .prepareStatement("INSERT INTO " + Tabla.Cuenta + "(usuario,clave,es_miembro,nombre,apellido,correo) values(?,?,?,?,?,?)");
//            insertStatement.setString(1, username);
//            insertStatement.setString(2, password);
//            insertStatement.setBoolean(3, false);
//            insertStatement.setString(4, firstName);
//            insertStatement.setString(5, lastName);
//            insertStatement.setString(6, email);
//            insertStatement.executeUpdate();
//
//            insertStatement.close();
//        }
//
//        if (cuenta instanceof ClubCuenta) {
//
//        }
//
//
//    }

    /*
     * public int getAccountID(String userName){ int id=0; try {
     *
     * result.absolute(1); id = result.getInt("ID"); return id; } catch
     * (SQLException e) { System.out.println(e.getMessage());
     * e.printStackTrace(); }
     *
     * return id; }
     */
//    public boolean isAccountTaken(Cuenta cuenta) {
//
//        // * returns null if cuenta null else returns the Cuenta
//        if (connection != null) {
//            String username = cuenta.getUsuario();
//            String password = cuenta.getClave();
//
//            PreparedStatement insertStatement;
//            try {
//                insertStatement = connection
//                    .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
//                insertStatement.setString(1, username);
//                ResultSet resultSet = insertStatement.executeQuery();
//                if (resultSet.next()) {
//                    String user = resultSet.getString("usuario");
//                    if (user.equals(cuenta.getUsuario())) {
//
//                        return true;
//                    }
//                } else {
//                    return false;
//                }
//            } catch (SQLException e) {
//                System.out.println("SQL Exception in isAccountTaken()");
//                e.printStackTrace();
//            }
//        }
//
//        return false;
//    }
//
//    public boolean isValidLogin(Cuenta cuenta) {
//        if (connection != null) {
//
//            String username = cuenta.getUsuario();
//            String password = cuenta.getClave();
//
//            PreparedStatement insertStatement;
//            try {
//                insertStatement = connection
//                    .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
//                insertStatement.setString(1, username);
//                ResultSet resultSet = insertStatement.executeQuery();
//                if (resultSet.first()) {
//                    if (resultSet.getString("usuario").equals(
//                        cuenta.getUsuario())) {
//                        if (resultSet.getString("clave").equals(
//                            cuenta.getClave())) {
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    } else {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            } catch (SQLException e) {
//                System.out.println("SQL Exception in isAccountTaken()");
//                e.printStackTrace();
//            }
//
//        }
//        return false;
//    }

//    public void displayDB() {
//        if (connection != null) {
//            try {
//                Statement statement = connection.createStatement();
//                ResultSet result = statement
//                    .executeQuery("SELECT * FROM " + Tabla.Cuenta);
//                int numOfCol = result.getMetaData().getColumnCount();
//
//                while (result.next()) {
//                    System.out.println(result.getInt("ID") + '\t'
//                        + result.getString("Usuario") + '\t'
//                        + result.getString("Clave") + '\t'
//                        + result.getBoolean("Member"));
//                }
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        }
//    }

//    public void disconnect() {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//
//                e.printStackTrace();
//            }
//        }
//    }

    public void save() throws SQLException {

    }

    public void addPerson() {

    }

    public void removePerson(int index) {

    }

}
