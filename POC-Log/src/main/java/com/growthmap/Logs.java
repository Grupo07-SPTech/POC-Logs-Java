package com.growthmap;

import java.time.LocalDateTime;

public class Logs extends RegistroSistema {

    private Usuario usuario;
    private String acao;
    private LocalDateTime dataHora;
    private Cursinhos cursinho;

    public Logs(Integer id, Usuario usuario, String acao, Cursinhos cursinho) {
        super(id);
        this.usuario = usuario;
        this.acao = acao;
        this.cursinho = cursinho;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ID do log: " + getId() +
                "\nUsuário: " + usuario.getNome() +
                "\nAção: " + acao +
                "\nData e hora: " + dataHora +
                "\nCursinho relacionado: " + cursinho.getNome() +
                "\n-------------------------";
    }
}
