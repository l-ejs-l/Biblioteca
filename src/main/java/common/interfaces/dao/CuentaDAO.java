package common.interfaces.dao;

import common.dominios.Cuenta;
import common.interfaces.dao.base.DAO;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Cuenta
 */
public interface CuentaDAO extends DAO<Cuenta> {

    /**
     * Método de verificacion si una cuenta esta tomada
     *
     * @param cuenta Recibe una entidad tipo cuenta
     * @return boolean isCuentaTaken
     * @throws Exception Lanza una excepcion en caso de no poder recuperar el valor
     */
    public boolean isCuentaTaken(Cuenta cuenta) throws Exception;

    /**
     * Método de verificacion de login
     *
     * @param cuenta Recibe una entidad cuenta
     * @return boolean 
     * @throws Exception
     */
    public boolean isValidLogin(Cuenta cuenta) throws Exception;

}
