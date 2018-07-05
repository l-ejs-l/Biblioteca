package backend.dominios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class Periodico implements Serializable {

    private static final long serialVersionUID = -7282825071000133222L;

    @Id
    @Column(name = "id_periodico")
    private Integer id;
    private String portada;
    private String lema;

    @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Recurso recurso;

}
