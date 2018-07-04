package backend.dominios;

import backend.dominios.enums.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity()
public class Usuario implements Serializable {

    private static final long serialVersionUID = 3779276593963622412L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    private String nombre;
    private String apellido;
    private boolean activo;

    @ElementCollection(targetClass = Rol.class)
    @CollectionTable(name = "Usuario_Rol", joinColumns = @JoinColumn(name = "id_usuario"))
    @Column(name = "rol")
    @Enumerated
    private List<Rol> roles;

}
