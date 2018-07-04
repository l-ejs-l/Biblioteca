package backend.dominios;

import java.util.Set;
import lombok.Data;

@Data
public class DetalleFactura {

    private int id;
    private Factura factura;
    private Set<Pedido> pedidos;
    private int total;

}
