package common.interfaces.dao;

import common.dominios.Cuenta;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Cuenta
 */
public interface CuentaDAO extends DAO<Cuenta> {

    /**
     * Método de verificacion si una cuenta esta tomada
     *
     * @param cuenta
     * @return boolean
     * @throws Exception
     */
    public boolean isCuentaTaken(Cuenta cuenta) throws Exception;

    /**
     * Método de verificacion de login
     *
     * @param cuenta
     * @return boolean
     * @throws Exception
     */
    public boolean isValidLogin(Cuenta cuenta) throws Exception;

}
