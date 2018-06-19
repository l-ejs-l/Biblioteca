package common.dominios;

import common.abstractos.dominios.BaseResource;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class Periodico extends BaseResource {

    private String portada;
    private String lema;

}
