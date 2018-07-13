package common.dao;

import common.dominios.ClubUsuario;
import common.dominios.FreeUsuario;
import common.dominios.Usuario;
import common.dominios.enums.Tabla;
import common.interfaces.dao.UsuarioDAO;

import java.sql.*;
import java.util.List;

/**
 * Esta clase implementa la interfaz UsuarioDAO y sus métodos para mantener la entidad Usuario
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private static final String INSERT_CUENTA = "INSERT INTO " + Tabla.Cuenta + "(usuario,clave,es_miembro,nombre,apellido,correo) values(?,?,?,?,?,?)";

    String a = "INSERT INTO biblioteca.Usuario(\n" +
        "   id_usuario\n" +
        "  ,nombre\n" +
        "  ,usuario\n" +
        "  ,clave\n" +
        "  ,es_miembro\n" +
        "  ,apellido\n" +
        "  ,correo\n" +
        "  ,cod_sucursal\n" +
        "  ,activo\n" +
        ") VALUES (\n" +
        "   NULL -- id_usuario - IN int(11)\n" +
        "  ,NULL -- nombre - IN varchar(30)\n" +
        "  ,NULL -- usuario - IN varchar(30)\n" +
        "  ,NULL -- clave - IN varchar(30)\n" +
        "  ,0   -- es_miembro - IN smallint(6)\n" +
        "  ,''  -- apellido - IN varchar(30)\n" +
        "  ,NULL -- correo - IN varchar(50)\n" +
        "  ,NULL -- cod_sucursal - IN int(11)\n" +
        "  ,NULL -- activo - IN smallint(6)\n" +
        ")";

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

        String username = entity.usuario();
        String password = entity.password();
        boolean member = entity.es_miembro();

        if (entity instanceof FreeUsuario) {
            FreeUsuario fa = (FreeUsuario) entity;
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
    public boolean isCuentaTaken(Usuario cuenta) throws Exception {
        String username = cuenta.usuario();
        String password = cuenta.password();

        PreparedStatement insertStatement;
        try {
            insertStatement = Database.getConnection()
                .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
            insertStatement.setString(1, username);
            ResultSet resultSet = insertStatement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("usuario");
                if (user.equals(cuenta.usuario())) {

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
                .prepareStatement("SELECT * FROM " + Tabla.Cuenta + " WHERE usuario=?");
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
