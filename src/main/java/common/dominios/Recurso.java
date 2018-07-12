package common.dominios;

import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Recurso<T> implements Serializable {

    private static final long serialVersionUID = -7684949284722148086L;

    private Integer id;
    private String titulo;
    private int totalPaginas;
    private T recurso;
    private TipoRecurso tipoRecurso;
    private List<Autor> autores;
    private Editorial editorial;
    private TipoTexto tipoTexto;
    private List<Topico> topicos;

}
