package common.interfaces.dao;

import common.dominios.Usuario;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Usuario
 */
public interface UsuarioDAO extends DAO<Usuario> {

    /**
     * Método de verificacion si una cuenta esta tomada
     *
     * @param cuenta Recibe una entidad tipo cuenta
     * @return boolean isCuentaTaken
     * @throws Exception Lanza una excepcion en caso de no poder recuperar el valor
     */
    public boolean isCuentaTaken(Usuario cuenta) throws Exception;

    /**
     * Método de verificacion de login
     *
     * @param cuenta Recibe una entidad cuenta
     * @return boolean 
     * @throws Exception
     */
    public boolean isValidLogin(Usuario cuenta) throws Exception;

}
