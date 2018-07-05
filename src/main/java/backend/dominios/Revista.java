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
@Entity(name = "Revista")
public class Revista extends BaseResource implements Serializable {

    private static final long serialVersionUID = -7282557000429342984L;

    @Id
    @Column(name = "id_revista")
    private Integer id;

    @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Recurso recurso;

}
