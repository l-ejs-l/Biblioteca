package common.dominios;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class Autor implements Serializable {

    private static final long serialVersionUID = -2259176087000439986L;

    @EqualsAndHashCode.Exclude
    private int id;
    private String nombre;
    private String apellido;

}
