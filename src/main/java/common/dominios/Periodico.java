package common.dominios;

import lombok.Data;

import java.io.Serializable;

@Data
public class Periodico implements Serializable {

    private static final long serialVersionUID = -7282825071000133222L;

    private Integer id;
    private String portada;
    private String lema;
    private Recurso recurso;

}
