package backend.dominios;

import backend.abstractos.dominios.BaseResource;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Revista")
public class Revista extends BaseResource implements Serializable {

    private static final long serialVersionUID = -7282557000429342984L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_revista")
    private Integer id;
}
