package common.dominios;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import java.io.Serializable;

@Data

public class Topico implements Serializable {

    private static final long serialVersionUID = -4349204044778995255L;

    @EqualsAndHashCode.Exclude
    private int id;
    private String topico;

}
