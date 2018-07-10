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

}
