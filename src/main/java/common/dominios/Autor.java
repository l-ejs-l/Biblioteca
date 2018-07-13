package common.dominios;

import lombok.Data;

import java.io.Serializable;

@Data
public class Autor implements Serializable {

    private static final long serialVersionUID = -2259176087000439986L;

    private int id;
    private String nombre;

}
