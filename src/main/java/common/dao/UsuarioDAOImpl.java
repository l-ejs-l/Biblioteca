package common.dao;

import common.dominios.ClubUsuario;
import common.dominios.FreeUsuario;
import common.dominios.Usuario;
import common.dominios.enums.Tabla;
import common.interfaces.dao.UsuarioDAO;

import java.sql.*;
import java.util.List;
import java.util.Set;

/**
 * Esta clase implementa la interfaz UsuarioDAO y sus métodos para mantener la entidad Usuario
 */
public class UsuarioDAOImpl implements UsuarioDAO {

   // private static final String INSERT_CUENTA = "INSERT INTO " + Tabla.Cuenta + "(usuario,clave,es_miembro,nombre,apellido,correo) values(?,?,?,?,?,?)";

    private static final String INSERT_USUARIO = "INSERT INTO " + Tabla.Usuario + "(nombre,usuario,clave,es_miembro,apellido,correo,activo,cod_sucursal) VALUES (?,?,?,?,?,?,?,?)";

    private PreparedStatement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    @Override
    public Usuario find(int id) throws Exception {
        return null;
    }

    @Override
    public Set<Usuario> findAll() throws Exception {
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

        String usuario = entity.usuario();
        String password = entity.password();
        boolean es_miembro = entity.es_miembro();

        if (entity instanceof FreeUsuario) {
            FreeUsuario fa = (FreeUsuario) entity;
            String nombre = fa.getfName();
            String apellido = fa.getlName();
            String correo = fa.getEmail();
            boolean activo = true;
            /*
             *
             */
            try {
                connection = Database.getConnection();
                statement = connection
                    .prepareStatement(INSERT_USUARIO);
               /* statement.setString(1, usuario);
                statement.setString(2, password);
                statement.setBoolean(3, false);
                statement.setString(4, nombre);
                statement.setString(5, apellido);
                statement.setString(6, correo);*/

                statement.setString(1, nombre);
                statement.setString(2, usuario);
                statement.setString(3, password);
                statement.setBoolean(4, es_miembro);
                statement.setString(5, apellido);
                statement.setString(6, correo);
                statement.setBoolean(7, activo);
                statement.setInt(8, 12345);

                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("SQL Exception in save()");
                e.printStackTrace();
                throw new Exception(e.getMessage());
            }

        }

        if (entity instanceof ClubUsuario) {

        }

    }

    @Override
    public void update(Usuario entity) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }


    @Override
    public boolean isCuentaTaken(Usuario usuario) throws Exception {
        String username = usuario.usuario();
        String password = usuario.password();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Usuario + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                if (user.equals(usuario.usuario())) {

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
    public boolean isValidLogin(Usuario cuenta) throws Exception {
        String username = cuenta.usuario();
        String password = cuenta.password();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Usuario + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.first()) {
                if (resultSet.getString("usuario").equals(
                    cuenta.usuario())) {
                    if (resultSet.getString("clave").equals(
                        cuenta.password())) {
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
