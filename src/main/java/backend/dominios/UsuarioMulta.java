package backend.dominios;;

import lombok.Data;

@Data
public class UsuarioMulta {

    private int id;
    private Usuario usuario;
    private Multa multa;
    private boolean activo;
    private DetallePrestamo detallePrestamo;

}
