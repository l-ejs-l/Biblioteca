package common.interfaces.dao;

import common.dominios.Usuario;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Usuario
 */
public interface UsuarioDAO extends DAO<Usuario> {

    /**
     * Método de verificacion si una cuenta esta tomada
     *
     * @param cuenta
     * @return boolean
     * @throws Exception
     */
    public boolean isCuentaTaken(Usuario cuenta) throws Exception;

    /**
     * Método de verificacion de login
     *
     * @param cuenta
     * @return boolean
     * @throws Exception
     */
    public boolean isValidLogin(Usuario cuenta) throws Exception;

}
