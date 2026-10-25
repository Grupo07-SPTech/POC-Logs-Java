
package com.growthmap;

import java.util.ArrayList;
import java.util.List;

public class SistemaGrowthMap {

    private List<Cursinhos> cursinhos = new ArrayList<>();
    private List<Logs> logs = new ArrayList<>();

    private Integer proximoIdCursinho = 1;
    private Integer proximoIdLog = 1;

    public List<Cursinhos> getCursinhos() {
        return cursinhos;
    }

    public void setCursinhos(List<Cursinhos> cursinhos) {
        this.cursinhos = cursinhos;
    }

    public List<Logs> getLogs() {
        return logs;
    }

    public void setLogs(List<Logs> logs) {
        this.logs = logs;
    }

    public void cadastrarCursinho(
            String nome,
            String cnpj,
            String regiao,
            Usuario usuario) {

        if (nome == null || nome.trim().isEmpty()) {
            return;
        }

        if (cnpj == null || cnpj.trim().isEmpty()) {
            return;
        }

        if (regiao == null || regiao.trim().isEmpty()) {
            return;
        }

        if (buscarCursinhoPorCnpj(cnpj) != null) {
            System.out.println("Já existe um cursinho com esse CNPJ!");
            return;
        }

        Cursinhos cursinho = new Cursinhos(
                proximoIdCursinho,
                nome,
                cnpj,
                regiao
        );

        cursinhos.add(cursinho);
        proximoIdCursinho++;

        Logs log = new Logs(
                proximoIdLog,
                usuario,
                "Cadastrou uma nova unidade do cursinho: " + nome,
                cursinho
        );

        logs.add(log);
        proximoIdLog++;
    }

    public List<Cursinhos> listarCursinhos() {
        return new ArrayList<>(cursinhos);
    }

    public List<Logs> listarLogs() {
        return new ArrayList<>(logs);
    }

    public Cursinhos buscarCursinhoPorCnpj(String cnpj) {

        if (cnpj == null) {
            return null;
        }

        for (int i = 0; i < cursinhos.size(); i++) {
            if (cursinhos.get(i).getCnpj().equalsIgnoreCase(cnpj)) {
                return cursinhos.get(i);
            }
        }

        return null;
    }

    public void removerCursinho(String cnpj) {

        if (cnpj == null) {
            return;
        }

        for (int i = cursinhos.size() - 1; i >= 0; i--) {
            if (cursinhos.get(i).getCnpj().equalsIgnoreCase(cnpj)) {

                Cursinhos cursinho = cursinhos.get(i);

                cursinhos.remove(i);

                Logs log = new Logs(
                        proximoIdLog,
                        new Usuario(1, "Administrador"),
                        "Removeu a unidade do cursinho: " + cursinho.getNome(),
                        cursinho
                );

                logs.add(log);
                proximoIdLog++;
            }
        }
    }
}
