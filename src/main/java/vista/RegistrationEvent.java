package vista;

import java.util.EventObject;

public class RegistrationEvent extends EventObject {

    private String username;
    private String password;
    private boolean es_miembro;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean activo;

    public RegistrationEvent(Object source) {
        super(source);

    }

    public RegistrationEvent(Object source, String username, String password) {
        super(source);
        this.username = username;
        this.password = password;
        nombre = null;
        apellido = null;
        correo = null;
    }

    public RegistrationEvent(Object source, String username, String password, String nombre, String apellido, String correo, boolean activo) {
        super(source);
        this.username = username;
        this.password = password;
        this.es_miembro = false;//Free account
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.activo = activo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEs_miembro() {
        return es_miembro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "RegistrationEvent [usuario=" + username + ", clave="
            + password + ", es_miembro=" + es_miembro + ", nombre=" + nombre
            + ", apellido=" + apellido + ", correo=" + correo + "]";
    }

}
