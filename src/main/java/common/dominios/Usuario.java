package common.dominios;

import common.dominios.enums.Rol;

import java.util.List;

public class Usuario {


    public Usuario(String usuario, String password, boolean es_miembro) {
        this.usuario = usuario;
        this.password = password;
    }

    private int id;

    public void id(int id) {
        this.id = id;
    }

    private String nombre;

    public String nombre() {
        return nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    private String apellido;

    public String apellido() {
        return apellido;
    }

    public void apellido(String apellido) {
        this.apellido = apellido;
    }

    private boolean activo;

    public boolean activo() {
        return activo;
    }

    public void activo(boolean activo) {
        this.activo = activo;
    }

    private List<Rol> roles;

    public List<Rol> roles() {
        return roles;
    }

    public void roles(List<Rol> roles) {
        this.roles = roles;
    }

    private String usuario;

    public String usuario() {
        return usuario;
    }

    public void usuario(String usuario) {
        this.usuario = usuario;
    }

    private String password;

    public String password() {
        return password;
    }

    public void password(String password) {
        this.password = password;
    }

    private boolean es_miembro;

    public boolean es_miembro() {
        return es_miembro;
    }

    public void es_miembro(boolean es_miembro) {
        this.es_miembro = es_miembro;
    }


}
