package com.growthmap;

import java.time.LocalDateTime;

public class RegistroSistema {
    private Integer id;
    private LocalDateTime dataCriacao;

    public RegistroSistema(Integer id) {
        this.id = id;
        this.dataCriacao = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
