package common.dominios;

import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Recurso implements Serializable {

    private static final long serialVersionUID = -7684949284722148086L;

    private Integer id;
    private String titulo;
    private int totalPaginas;
    private Libro libro;
    private Periodico periodico;
    private Revista revista;
    private TipoRecurso tipoRecurso;
    private List<Autor> autores;
    private Editorial editorial;
    private TipoTexto tipoTexto;
    private List<Topico> topicos;

}
