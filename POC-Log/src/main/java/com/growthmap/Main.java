
package com.growthmap;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaGrowthMap sistema = new SistemaGrowthMap();

        Usuario usuario = new Usuario(1, "Administrador");

        Integer opcao = -1;

        while (opcao != 0) {

            menu();

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarCursinho(scanner, sistema, usuario);
                    break;

                case 2:
                    System.out.println("========== CURSINHOS ==========");

                    List<Cursinhos> cursinhos = sistema.listarCursinhos();

                    if (cursinhos.isEmpty()) {
                        System.out.println("Nenhum cursinho cadastrado.");
                    }

                    for (Cursinhos cursinho : cursinhos) {
                        System.out.println(cursinho);
                    }

                    break;

                case 3:
                    System.out.println("========== LOGS ==========");

                    List<Logs> logs = sistema.listarLogs();

                    if (logs.isEmpty()) {
                        System.out.println("Nenhum log registrado.");
                    }

                    for (Logs log : logs) {
                        System.out.println(log);
                    }

                    break;

                case 0:
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        }

        scanner.close();
    }

    public static void menu() {

        System.out.println("""
                ========== GROWTHMAP ==========

                1 - Cadastrar novo cursinho
                2 - Ver todos os cursinhos
                3 - Ver todos os logs
                0 - Sair

                Digite uma opção:
                """);
    }

    public static void cadastrarCursinho(
            Scanner scanner,
            SistemaGrowthMap sistema,
            Usuario usuario) {

        System.out.println("Digite o nome da unidade:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CNPJ da unidade:");
        String cnpj = scanner.nextLine();

        System.out.println("""
                Digite a região da unidade:

                1 - Norte
                2 - Nordeste
                3 - Centro-Oeste
                4 - Sudeste
                5 - Sul

                Digite aqui:
                """);

        if (!scanner.hasNextInt()) {
            System.out.println("Número inválido!");
            scanner.nextLine();
            return;
        }

        Integer numeroRegiao = scanner.nextInt();
        scanner.nextLine();

        if (numeroRegiao < 1 || numeroRegiao > 5) {
            System.out.println("Região inválida!");
            return;
        }

        String[] regioes = {
                "Norte",
                "Nordeste",
                "Centro-Oeste",
                "Sudeste",
                "Sul"
        };

        String regiao = regioes[numeroRegiao - 1];

        try {
            sistema.cadastrarCursinho(
                    nome,
                    cnpj,
                    regiao,
                    usuario
            );

            System.out.println("Cursinho cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
