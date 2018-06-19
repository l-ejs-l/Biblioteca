package common.dominios;

import common.dominios.Biblioteca;
import common.dominios.Usuario;
import lombok.Data;

import java.util.Date;

@Data
public class Prestamo {

    private Usuario usuario;
    private Date inicio;
    private Date fin;
    private Date usoTotal;
    private Biblioteca bibliotecaOrigen;
    private Biblioteca bibliotecaDestino;

}
