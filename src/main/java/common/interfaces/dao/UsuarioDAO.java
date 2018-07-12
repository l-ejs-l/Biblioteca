package common.interfaces.dao;

/**
 * Created by Papalapapiricoipi on 11-07-2018.
 */ 
 

import common.dominios.Usuario;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Usuario
 */
public interface UsuarioDAO extends DAO<Usuario> {

    /**
     * Método de verificacion si Usuario esta tomado
     *
     * @param Usuario
     * @return boolean
     * @throws Exception
     */
    public boolean isUsuarioTaken(Usuario Usuario) throws Exception;

    /**
     * Método de verificacion de login
     *
     * @param Usuario
     * @return boolean
     * @throws Exception
     */
    public boolean isValidLogin(Usuario Usuario) throws Exception;

}
