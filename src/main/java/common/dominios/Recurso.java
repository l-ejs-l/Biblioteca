package common.dominios;

import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

@Data
public class Recurso<T> implements Serializable {

    private static final long serialVersionUID = -7684949284722148086L;

    @EqualsAndHashCode.Exclude
    private Integer id;
    private String titulo;
    private int totalPaginas;
    private T recurso;
    private TipoRecurso tipoRecurso;
    private Set<Autor> autores;
    private Editorial editorial;
    private TipoTexto tipoTexto;
    private Set<Topico> topicos;

}
