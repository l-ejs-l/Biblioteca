package common.dao;

import common.dominios.FreeCuenta;
import common.interfaces.dao.CuentaDAO;

public class DatabaseTest {


    public static void main(String[] args) {

        CuentaDAOImpl cuentaDAO = new CuentaDAOImpl();

		String username = "user1";
		String password = "pass1";
		String firstName = "Susan";
		String lastName = "Jaicks";
		String email = "ak12ka@hotmail.com";
		
		FreeCuenta fa = new FreeCuenta(username,password,firstName,lastName,email);
		FreeCuenta fa1= new FreeCuenta("user2","pass2","David","Natta","1u3u32@hotmail.com");
		FreeCuenta fa2= new FreeCuenta("user3","pass3","Mark","Jue","dfads@hotmail.com");
		try {

			//db.addFreeAccount(fa);
            cuentaDAO.save(fa);
            cuentaDAO.save(fa1);
            cuentaDAO.save(fa2);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
