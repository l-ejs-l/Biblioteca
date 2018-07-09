package backend.dominios;

import backend.dominios.enums.Rol;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 3779276593963622412L;

    private int id;
    private String nombre;
    private String apellido;
    private boolean activo;
    private List<Rol> roles;

}
