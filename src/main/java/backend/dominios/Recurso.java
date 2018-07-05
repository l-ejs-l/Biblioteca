package backend.dominios;

import backend.dominios.enums.TipoRecurso;
import backend.dominios.enums.TipoTexto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Recurso implements Serializable {

    private static final long serialVersionUID = -7684949284722148086L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Integer id;

    private String titulo;

    @Column(name = "total_paginas")
    private int totalPaginas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recurso")
    private Libro libro;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recurso")
    private Periodico periodico;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recurso")
    private Revista revista;

    @Enumerated
    private TipoRecurso tipoRecurso;

    @ManyToMany
    @JoinTable(name = "Recurso_Autor",
            joinColumns = @JoinColumn(name = "id_recurso"),
            inverseJoinColumns = @JoinColumn(name = "id_autor"))
    private List<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial", nullable = false)
    private Editorial editorial;

    @Enumerated
    private TipoTexto tipoTexto;

    @ManyToMany
    @JoinTable(name = "Topico_Recurso",
            joinColumns = @JoinColumn(name = "id_recurso"),
            inverseJoinColumns = @JoinColumn(name = "id_topico"))
    private List<Topico> topicos;

}
