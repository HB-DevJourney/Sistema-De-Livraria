package org.livraria.service;

import org.fusesource.jansi.Ansi;
import org.livraria.model.*;
import org.livraria.util.ConsoleUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaService {

    private static BibliotecaService bibliotecaService = new BibliotecaService();
    private static Biblioteca biblioteca = new Biblioteca();


    public void cadastrarLivro (Livro livro) {
        Autor autorExistente = biblioteca.getAutores().stream()
                .filter(autor -> autor.getNome().equalsIgnoreCase(livro.getAutor().getNome()))
                .findFirst()
                .orElse(null);

        if (autorExistente != null)
            livro.setAutor(autorExistente);
        else
            biblioteca.getAutores().add(livro.getAutor());

        biblioteca.getLivros().add(livro);
    }

    public void verLivrosDisponiveis () {
        ConsoleUtils.limparTela();
        System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| LIVROS DISPONÍVEIS ||||||||||\n").reset()));
        if (biblioteca.getLivros().isEmpty())
            System.out.println("Não há livros disponíveis.");
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.getDisponivel())
                System.out.println(livro.toString());
        }
    }

    public Livro findLivrosById (int id) {
        for (Livro livro : biblioteca.getLivros())
            if (livro.getId() == id)
                return livro;
        return null;
    }

    public void findAllLivros () {
        if (biblioteca.getLivros().isEmpty())
            System.out.println("Não há livros cadastrados.");
        for (Livro livro : biblioteca.getLivros())
            System.out.println(livro.toString());
    }

    public void pesquisarLivrosPorTitulo (String titulo) {
        List<Livro> livrosEncontrados = biblioteca.getLivros().stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());

        if (livrosEncontrados.isEmpty())
            System.out.println("Nenhum livro encontrado com o titulo: " + titulo);
        for (Livro livro : livrosEncontrados)
            System.out.println(livro.toString());
    }

    public void pesquisaPorAutor (String autor) {
        List<Livro> livrosDoAutor = biblioteca.getLivros().stream()
                .filter(livro -> livro.getAutor().getNome().equals(autor))
                .collect(Collectors.toList());

        if (livrosDoAutor.isEmpty())
            System.out.println("Nenhum livro encontrado para o autor: " + autor);
        for (Livro livro : livrosDoAutor)
            System.out.println(livro.toString());
    }

    public void cadastrarAutor (Autor autor) {
        biblioteca.getAutores().add(autor);
    }

    public void cadastrarEmprestimo (int livroID, int clienteID) {
        Livro livro = findLivrosById(livroID);
        Cliente cliente = findClienteById(clienteID);

        if (livro != null && cliente != null && livro.getDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            biblioteca.getEmprestimos().add(emprestimo);
            livro.setDisponivel(false);
            System.out.println(String.valueOf(Ansi.ansi().fgGreen().bold().a("\nEmprestimo realizado com sucesso.").reset()));
        } else {
            if (livro == null)
                System.out.println("Livro não encontrado.");
            else if (cliente == null)
                System.out.println("Cliente não encontrado.");
            else
                System.out.println("Livro não disponível para empréstimo.");
        }

    }

    public void findAllEmprestimos () {
        ConsoleUtils.limparTela();
        System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| HISTÓRICO DE EMPRÉSTIMOS ||||||||||\n").reset()));
        if (biblioteca.getEmprestimos().isEmpty())
            System.out.println("Nenhum empréstimo encontrado.");
        for (Emprestimo emprestimo : biblioteca.getEmprestimos())
            System.out.println(emprestimo.toString());
    }

    public void cadastrarCliente (Cliente cliente) {
        biblioteca.getClientes().add(cliente);
        System.out.println(String.valueOf(Ansi.ansi().fgGreen().bold().a("\nCadastrado com Sucesso.").reset()));
    }

    public void findAllClientes () {
        System.out.println(String.valueOf(Ansi.ansi().fgCyan().bold().a("\n|||||||||| LISTA DE CLIENTES ||||||||||\n").reset()));
        if (biblioteca.getClientes().isEmpty())
            System.out.println("Nenhum cliente encontrado.");
        for (Cliente cliente : biblioteca.getClientes())
            System.out.println(cliente.toString());
    }

    public Cliente findClienteById (int id) {
        for (Cliente cliente : biblioteca.getClientes())
            if (cliente.getId() == id)
                return cliente;
        return null;
    }

}
