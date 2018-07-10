package common.dominios;

import java.io.Serializable;
import lombok.Data;

@Data
public class Autor implements Serializable {

    private static final long serialVersionUID = -2259176087000439986L;

    private int id;
    private String nombre;

}
