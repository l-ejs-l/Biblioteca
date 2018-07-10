package common.interfaces.dao;

import common.dominios.Cuenta;

public interface CuentaDAO extends DAO<Cuenta> {

    public boolean isCuentaTaken(Cuenta cuenta) throws Exception;

    public boolean isValidLogin(Cuenta cuenta) throws Exception;

}
