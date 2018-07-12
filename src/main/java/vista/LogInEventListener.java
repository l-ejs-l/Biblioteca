package vista;


import common.dominios.Cuenta;
import common.dominios.Usuario;

public interface LogInEventListener {

    public void loginEventOccurred(Cuenta cuenta);
    public void loginEventOccurred(Usuario usuario);
}
