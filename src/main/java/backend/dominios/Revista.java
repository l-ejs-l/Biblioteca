package backend.dominios;

import java.io.Serializable;
import lombok.Data;

@Data

public class Revista implements Serializable {

    private static final long serialVersionUID = -7282557000429342984L;

    private Integer id;
    private Recurso recurso;

}
