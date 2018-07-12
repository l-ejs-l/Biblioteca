package common.dao;

/**
 * Created by Papalapapiricoipi on 11-07-2018.
 */

import common.dominios.Usuario;
import common.dominios.enums.Tabla;
import common.interfaces.dao.UsuarioDAO;

import java.sql.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase implementa la interfaz UsuarioDAO y sus métodos para mantener la entidad Usuario
 */
public class UsuarioDAOlmpl implements UsuarioDAO {

    private static final String INSERT_Usuario = "INSERT INTO " + Tabla.Usuario + "(usuario,clave,es_miembro,nombre,apellido,correo) values(?,?,?,?,?,?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Usuario find(int id) throws Exception {
        return null;
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement
                .executeQuery("SELECT * FROM " + Tabla.Usuario);
            int numOfCol = result.getMetaData().getColumnCount();

            while (result.next()) {
                System.out.println(result.getInt("ID") + '\t'
                    + result.getString("Usuario") + '\t'
                    + result.getString("Clave") + '\t'
                    + result.getBoolean("Member"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void save(Usuario entity) throws Exception {

        String username = entity.username();
        String password = entity.password();
        boolean es_miembro = entity.es_miembro();
/*
        if (entity instanceof FreeUsuario) {
            FreeUsuario fa = (FreeUsuario) entity;
            String firstName = fa.getfName();
            String lastName = fa.getlName();
            String email = fa.getEmail();

            try {
                connection = Database.getConnection();
                statement = connection
                    .prepareStatement(INSERT_Usuario);
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

        if (entity instanceof ClubUsuario) {

        }
*/
    }

    @Override
    public void update(Usuario entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }


    @Override
    public boolean isUsuarioTaken(Usuario Usuario) throws Exception {
        String username = Usuario.username();
        String password = Usuario.password();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Usuario + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                if (user.equals(Usuario.username())) {

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
    public boolean isValidLogin(Usuario Usuario) throws Exception {
        String username = Usuario.username();
        String password = Usuario.password();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Usuario + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.first()) {
                if (resultSet.getString("usuario").equals(
                    Usuario.username())) {
                    if (resultSet.getString("clave").equals(
                        Usuario.password())) {
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
