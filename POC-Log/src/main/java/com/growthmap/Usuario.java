package com.growthmap;

public class Usuario extends RegistroSistema {

    private String nome;

    public Usuario(Integer id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
