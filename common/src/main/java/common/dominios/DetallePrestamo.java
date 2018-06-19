package common.dominios;

import common.dominios.Biblioteca;
import common.dominios.CopiaRecurso;
import common.dominios.Prestamo;
import common.dominios.enums.EstadoPrestamo;
import lombok.Data;

@Data
public class DetallePrestamo {

    private int id;
    private Prestamo prestamo;
    private CopiaRecurso copiaRecurso;
    private EstadoPrestamo estadoPrestamo;
    private Biblioteca bibliotecaDevolucion;

}

