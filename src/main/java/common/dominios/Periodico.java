package common.dominios;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Periodico implements Serializable {

    private static final long serialVersionUID = -7282825071000133222L;

    private Integer id;
    private String lema;
    private Date fechaPublicacion;

}
