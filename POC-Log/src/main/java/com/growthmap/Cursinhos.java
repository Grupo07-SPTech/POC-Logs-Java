package com.growthmap;

import java.util.List;
import java.util.Scanner;

public class Cursinhos extends RegistroSistema {
    private String nome;
    private String cnpj;
    private String regiao;

    public Cursinhos(Integer id, String nome, String cnpj, String regiao) {
        super(id);
        this.nome = nome;
        this.cnpj = cnpj;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nNome: " + nome +
                "\nCNPJ: " + cnpj +
                "\nRegião: " + regiao +
                "\n-------------------------";
    }
}
