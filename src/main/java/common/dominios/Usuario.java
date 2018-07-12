package common.dominios;

import common.dominios.enums.Rol;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 3779276593963622412L;

    private int id;

    public int id() {
        return id;
    }

    public Usuario(String username, String password, boolean es_miembro) {
        this.username = username;
        this.password = password;
        this.es_miembro = es_miembro;
    }

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

    private String username;

    public String username() {
        return username;
    }

    public void username(String username) {
        this.username = username;
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
