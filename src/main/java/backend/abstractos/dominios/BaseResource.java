package backend.abstractos.dominios;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseResource {

    private String titulo;

    @Column(name = "total_paginas")
    private int totalPaginas;

}
