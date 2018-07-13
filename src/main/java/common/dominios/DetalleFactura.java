package common.dominios;

import java.util.Set;
import lombok.Data;

@Data
public class DetalleFactura {

    private int id;
    private int total;
    private Factura factura;
    private Set<Pedido> pedidos;

}
