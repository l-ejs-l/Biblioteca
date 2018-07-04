package backend.dominios;

import backend.abstractos.dominios.BaseResource;
import backend.dominios.enums.TipoRecurso;
import backend.dominios.enums.TipoTexto;
import java.util.List;
import lombok.Data;

@Data
public class Recurso<T extends BaseResource> {

    private Integer id;
    private T recurso;
    private TipoRecurso tipoRecurso;
    private List<Autor> autores;
    private Editorial editorial;
    private TipoTexto tipoTexto;
    private List<Topico> topicos;

}
