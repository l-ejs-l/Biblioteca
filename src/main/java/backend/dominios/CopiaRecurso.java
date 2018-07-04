package backend.dominios;

import backend.dominios.enums.EstadoCopia;
import lombok.Data;

@Data
public class CopiaRecurso {

    private int id;
    private Recurso recurso;
    private EstadoCopia estadoCopia;

}
