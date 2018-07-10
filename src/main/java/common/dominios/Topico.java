package common.dominios;

import java.io.Serializable;
import lombok.Data;

@Data

public class Topico implements Serializable {

    private static final long serialVersionUID = -4349204044778995255L;

    private int id;
    private String topico;

}
