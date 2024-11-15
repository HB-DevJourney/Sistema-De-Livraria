package org.livraria.util;

import static org.fusesource.jansi.Ansi.*;

public class ConsoleUtils {

    public static void exibirCarregamento(int progresso) {
        int tamanhoBarra = 20;  // Tamanho da barra de progresso
        int progressoAtual = (progresso * tamanhoBarra) / 100;
        StringBuilder barra = new StringBuilder("[");

        for (int i = 0; i < tamanhoBarra; i++) {
            if (i < progressoAtual) {
                barra.append("=");
            } else {
                barra.append(" ");
            }
        }
        barra.append("]");

        System.out.print(ansi().eraseScreen().cursor(0, 0));  // Limpa a tela e move o cursor para o início
    }

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // limpar no Linux/Mac
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }

    public static void carregarProgresso() throws InterruptedException {
        limparTela();
        Thread.sleep(200);
        String barra = "[                    ]";

        for (int i = 0; i <= 100; i++) {
            String progresso = barra.substring(0, i / 5) + "█" + barra.substring(i / 5 + 1);
            System.out.print("\r" + i + "% " + progresso);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nCarregamento concluído!");

        Thread.sleep(2000);

        System.out.print("\nInicializando o programa");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");
        }
        Thread.sleep(2000);
        System.out.println("\nPrograma inicializado!");
        Thread.sleep(2000);
    }


}
