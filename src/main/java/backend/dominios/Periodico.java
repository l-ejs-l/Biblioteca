package backend.dominios;

import backend.abstractos.dominios.BaseResource;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class Periodico extends BaseResource implements Serializable {

    private static final long serialVersionUID = -7282825071000133222L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodico")
    private Integer id;
    private String portada;
    private String lema;

}
