package org.livraria;

import org.fusesource.jansi.Ansi;
import org.livraria.model.Autor;
import org.livraria.model.Cliente;
import org.livraria.model.Livro;
import org.livraria.service.BibliotecaService;
import org.livraria.util.ConsoleUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProgramaPrincipal {

    private static final Scanner input = new Scanner(System.in);
    private static final BibliotecaService bibliotecaService = new BibliotecaService();


    public static void main(String[] args) throws InterruptedException {
        ConsoleUtils.carregarProgresso();
        ConsoleUtils.limparTela();
        Menu.menuPrincipal();
    }

    private static class Menu {

        private static void menuPrincipal() {
            int opcao = 0;
            do {
                System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| MENU PRINCIPAL ||||||||||\n").reset()));
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("1").reset() + "] Gerenciar Livros");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("2").reset() + "] Gerenciar Clientes");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("3").reset() + "] Gerenciar Empréstimos");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("0").reset() + "] Sair");
                System.out.print("\nEscolha uma opção: ");

                try {
                    opcao = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    processarOpcaoPrincipal(opcao);
                } catch (Exception e) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }

            } while (opcao != 0);

            System.out.println("Saindo... Até logo!");
            ConsoleUtils.limparTela();
        }

        public static void processarOpcaoPrincipal(int opcao) throws InterruptedException {
            ConsoleUtils.limparTela();

            switch (opcao) {
                case 1 -> exibirMenuLivros();
                case 2 -> exibirMenuClientes();
                case 3 -> exibirMenuEmprestimos();
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                    Thread.sleep(3000);
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }


        public static void exibirMenuLivros() {
            ConsoleUtils.limparTela();

            int opcao = 0;

            do {
                System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| GERENCIAR LIVROS ||||||||||\n").reset()));
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("1").reset() + "] Cadastrar Livros");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("2").reset() + "] Ver Livros Disponíveis");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("3").reset() + "] Ver Todos os Livros");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("4").reset() + "] Pesquisar Livro por Título");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("5").reset() + "] Pesquisar Livros por Autor");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("0").reset() + "] Voltar ao Menu Principal");
                System.out.print("\nEscolha uma opção: ");

                try {
                    opcao = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    processarOpcaoLivros(opcao);
                } catch (Exception e) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }

            } while (opcao != 0);
        }

        public static void processarOpcaoLivros(int opcao) throws InterruptedException {
            switch (opcao) {
                case 1 -> OpcoesDoMenu.cadastrarLivro();
                case 2 -> bibliotecaService.verLivrosDisponiveis();
                case 3 -> bibliotecaService.findAllLivros();
                case 4 -> OpcoesDoMenu.pesquisarLivroPorTitulo();
                case 5 -> OpcoesDoMenu.pesquisarLivroPorAutor();
                case 0 -> {
                    ConsoleUtils.limparTela();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }


        public static void exibirMenuClientes() {
            ConsoleUtils.limparTela();

            int opcao = 0;
            do {
                System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| GERENCIAR CLIENTES ||||||||||\n").reset()));
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("1").reset() + "] Cadastrar Cliente");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("2").reset() + "] Ver todos os Clientes");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("0").reset() + "] Voltar ao Menu Principal");
                System.out.print("\nEscolha uma opção: ");

                try {
                    opcao = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    processarOpcaoClientes(opcao);
                } catch (Exception e) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }

            } while (opcao != 0);
        }

        public static void processarOpcaoClientes(int opcao) throws InterruptedException {
            switch (opcao) {
                case 1 -> OpcoesDoMenu.cadastrarCliente();
                case 2 -> bibliotecaService.findAllClientes();
                case 0 -> {
                    ConsoleUtils.limparTela();
                    return;
                }
                default -> System.out.println("Opcão inválida. Tente novamente.");
            }
        }


        public static void exibirMenuEmprestimos() {
            ConsoleUtils.limparTela();

            int opcao = 0;

            do {
                System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| GERENCIAR EMPRÉSTIMOS ||||||||||\n").reset()));
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("1").reset() + "] Realizar Empréstimo");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("2").reset() + "] Ver Histórico de Empréstimos");
                System.out.println("[" + Ansi.ansi().fgCyan().bold().a("0").reset() + "] Voltar ao Menu Principal");
                System.out.print("\nEscolha uma opção: ");

                try {
                    opcao = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    processarOpcaoEmprestimos(opcao);
                } catch (Exception e) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }

            } while (opcao != 0);
        }

        public static void processarOpcaoEmprestimos(int opcao) {
            switch (opcao) {
                case 1 -> OpcoesDoMenu.cadastrarEmprestimo();
                case 2 -> bibliotecaService.findAllEmprestimos();
                case 0 -> {
                    ConsoleUtils.limparTela();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

    private static class OpcoesDoMenu {

        public static void cadastrarLivro() throws InterruptedException {
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| CADASTRAR LIVRO ||||||||||\n").reset()));
            System.out.print("Digite o título do livro: ");
            String titulo = input.nextLine();
            System.out.print("Digite o autor do livro: ");
            String nomeAutor = input.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Digite a data de nascimento do autor, (dd/MM/yyyy): ");
            String dataNascimentoStr = input.nextLine();
            LocalDate dataNascimento;
            try {
                dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);
            } catch (Exception e) {
                System.out.println("Data inválida. Certifique-se de usar o formato dd/MM/yyyy.");
                return;
            }

            Autor autor = new Autor(nomeAutor, dataNascimento);
            Livro livro = new Livro(titulo, autor);
            bibliotecaService.cadastrarLivro(livro);
            bibliotecaService.cadastrarAutor(autor);

            System.out.println(String.valueOf(Ansi.ansi().fgGreen().bold().a("\nCadastrado com Sucesso.").reset()));

            Thread.sleep(2000);
            ConsoleUtils.limparTela();
        }

        public static void pesquisarLivroPorTitulo() {
            ConsoleUtils.limparTela();
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| PESQUISA ||||||||||\n").reset()));
            System.out.print("Digite o título do livro: ");
            String titulo = input.nextLine();
            bibliotecaService.pesquisarLivrosPorTitulo(titulo);
        }

        public static void pesquisarLivroPorAutor() {
            ConsoleUtils.limparTela();
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| LIVROS DO AUTOR ||||||||||\n").reset()));
            System.out.print("Digite o nome do autor: ");
            String autor = input.nextLine();
            bibliotecaService.pesquisaPorAutor(autor);
        }

        public static void cadastrarCliente() throws InterruptedException {
            ConsoleUtils.limparTela();
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| CADASTRAR CLIENTE ||||||||||\n").reset()));
            System.out.print("Digite o nome do cliente: ");
            String nome = input.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Digite a data de nascimento do cliente, (dd/MM/yyyy): ");
            String dataNascimentoStr = input.nextLine();
            LocalDate dataNascimento;
            try {
                dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);
            } catch (Exception e) {
                System.out.println("Data inválida. Certifique-se de usar o formato dd/MM/yyyy.");
                return;
            }
            System.out.print("Digite o email do cliente: ");
            String email = input.nextLine();
            Cliente cliente = new Cliente(nome, dataNascimento, email);
            bibliotecaService.cadastrarCliente(cliente);
            Thread.sleep(3000);
            ConsoleUtils.limparTela();
        }

        public static void cadastrarEmprestimo() {
            ConsoleUtils.limparTela();
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| REALIZAR EMPRÉSTIMO ||||||||||\n").reset()));

            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n--> LIVROS DISPONÍVEIS <--\n").reset()));
            bibliotecaService.findAllLivros();
            System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n--> LISTA DE CLIENTES <--\n").reset()));
            bibliotecaService.findAllClientes();

            System.out.print("Digite o ID do livro: ");
            int idLivro = input.nextInt();
            input.nextLine();
            System.out.print("Digite o ID do cliente: ");
            int idCliente = input.nextInt();

            Livro livro = bibliotecaService.findLivrosById(idLivro);
            Cliente cliente = bibliotecaService.findClienteById(idCliente);

            if (livro != null && cliente != null) {
                bibliotecaService.cadastrarEmprestimo(idLivro, idCliente);
            } else {
                System.out.println("Livro ou cliente não encontrado.");
            }
        }
    }

}
