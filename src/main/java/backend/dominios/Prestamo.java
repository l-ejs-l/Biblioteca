package backend.dominios;

import java.util.Date;
import lombok.Data;

@Data
public class Prestamo {

    private Usuario usuario;
    private Date inicio;
    private Date fin;
    private Date usoTotal;
    private Biblioteca bibliotecaOrigen;
    private Biblioteca bibliotecaDestino;

}
