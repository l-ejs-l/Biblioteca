package common.dominios;

import java.io.Serializable;
import lombok.Data;

@Data
public class Libro implements Serializable {

    private static final long serialVersionUID = 9167247312760978145L;

    private Integer id;
    private String isbn;
    private String lomo;
    private String portada;
    private String contraportada;
    private Recurso recurso;

}
