package common.interfaces.dao;

import common.dominios.Editorial;

public interface EditorialDAO extends DAO<Editorial> {

    public Editorial findByName(String name) throws Exception;

}
