package common.dominios;

import lombok.Data;

import java.io.Serializable;

@Data
public class Editorial implements Serializable {

    private static final long serialVersionUID = -2894879239188072186L;

    private int id;
    private String editorial;

}
