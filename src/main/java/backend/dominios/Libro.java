package backend.dominios;

import backend.abstractos.dominios.BaseResource;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "libro")
public class Libro extends BaseResource implements Serializable {

    private static final long serialVersionUID = 9167247312760978145L;

    @Id
    @Column(name = "id_libro")
    private Integer id;
    private String isbn;
    private String lomo;
    private String portada;
    private String contraportada;
    
    @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Recurso recurso;

}
