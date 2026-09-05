package com.growthmap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner nextScanner = new Scanner(System.in);
        List<Cursinhos> listaCursinhos = new ArrayList<>();
        List<Logs> listaLogs = new ArrayList<>();

        menu();

        Integer opcao = scanner.nextInt();

        if (opcao < 0 || opcao > 3) {
            while (opcao < 0 || opcao > 3) {
                System.out.println("OPCAO INVALIDA!!! DIGITE NOVAMENTE!!!");
                menu();
                opcao = scanner.nextInt();
            }
        }

        while (opcao != 0) {
            switch (opcao) {
                case 0:
                    System.out.println("Volte sempre!");
                    break;
                case 1:
                    cadastrarCursinho(listaCursinhos, listaLogs);
                    System.out.println("Cursinho Cadastrado! Aperte ENTER para continuar...");
                    nextScanner.nextLine();
                    menu();
                    break;
                case 2:
                    System.out.println(listarCursinhos(listaCursinhos));
                    System.out.println("\nAperte ENTER para continuar...");
                    nextScanner.nextLine();
                    menu();
                    break;
                case 3:
                    System.out.println(listarLogs(listaLogs));
                    System.out.println("\nAperte ENTER para continuar...");
                    nextScanner.nextLine();
                    menu();
                    break;

            }

            opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 3) {
                while (opcao < 0 || opcao > 3) {
                    System.out.println("OPCAO INVALIDA!!! DIGITE NOVAMENTE!!!");
                    menu();
                    opcao = scanner.nextInt();
                }
            }

        }
    }

    public static void menu() {
        System.out.println("""
                Digite uma das opcoes abaixo:
                1 - Cadastrar novo cursinho
                2 - Ver todos os cursinhos
                3 - Ver todos os logs
                0 - Sair
                
                Digite aqui:""");
    }

    public static void cadastrarCursinho(List<Cursinhos> cursinhos, List<Logs> logs) {
        Cursinhos cursinho = new Cursinhos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cursinho: ");
        cursinho.nome = scanner.nextLine();

        System.out.println("Digite o CNPJ do cursinho: ");
        cursinho.cnpj = scanner.nextLine();

        System.out.println("""
                Digite a regiao do cursinho
                1 - Norte
                2 - Nordeste
                3 - Centro-Oeste
                4 - Sudeste
                5 - Sul
                
                Digite aqui:
                """);
        Integer nmrRegiao = scanner.nextInt();

        if (nmrRegiao < 1 || nmrRegiao > 5) {
            while (nmrRegiao < 1 || nmrRegiao > 5) {
                System.out.println("""
                        NUMERO INVALIDO!!!
                        Digite novamente a regiao do cursinho
                        1 - Norte
                        2 - Nordeste
                        3 - Centro-Oeste
                        4 - Sudeste
                        5 - Sul
                        
                        Digite aqui:
                        """);
                nmrRegiao = scanner.nextInt();
            }
        }

        switch (nmrRegiao) {
            case 1:
                cursinho.regiao = "Norte";
                break;
            case 2:
                cursinho.regiao = "Nordeste";
                break;
            case 3:
                cursinho.regiao = "Centro-Oeste";
                break;
            case 4:
                cursinho.regiao = "Sudeste";
                break;
            case 5:
                cursinho.regiao = "Sul";
                break;
        }

        cursinhos.add(cursinho);

        Logs log = new Logs();
        log.usuario = "Teste";
        log.acao = "Cadastrou um cursinho: " + cursinho.nome + ".";
        log.dataHora = LocalDateTime.now();
        logs.add(log);
    }

    public static List<String> listarCursinhos(List<Cursinhos> cursinhos) {
        List<String> listaCursinhos = new ArrayList<>();

        for (Cursinhos cursinho : cursinhos) {
            listaCursinhos.add("""
                    Nome: %s
                    CNPJ: %s
                    Regiao: %s
                    """.formatted(cursinho.nome, cursinho.cnpj, cursinho.regiao));
        }
        return listaCursinhos;
    }

    public static List<String> listarLogs(List<Logs> logs) {
        List<String> listaLogs = new ArrayList<>();

        for (Logs log : logs) {
            listaLogs.add("O usuario %s %s Em %s".formatted(log.usuario, log.acao, log.dataHora));
        }

        return listaLogs;
    }

}
