package org.livraria.model;

import lombok.*;

import java.util.*;
import java.time.LocalDate;

public class Biblioteca {

    @Getter @Setter
    private List<Livro> livros = new ArrayList<>();

    @Getter @Setter
    private List<Autor> autores = new ArrayList<>();

    @Getter @Setter
    private List<Cliente> clientes = new ArrayList<>();

    @Getter @Setter
    private List<Emprestimo> emprestimos = new ArrayList<>();

    {
        // Criando autores
        Autor autor1 = new Autor("Charles Darwin", LocalDate.of(1809, 2, 12));
        Autor autor2 = new Autor("Miguel de Cervantes", LocalDate.of(1547, 9, 29));
        Autor autor3 = new Autor("Jane Austen", LocalDate.of(1775, 12, 16));
        Autor autor4 = new Autor("George Orwell", LocalDate.of(1903, 6, 25));
        Autor autor5 = new Autor("F. Scott Fitzgerald", LocalDate.of(1896, 9, 24));

        // Adicionando autores à lista
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        // Criando livros e associando aos autores
        livros.add(new Livro("A Origem das Espécies", autor1));
        livros.add(new Livro("Dom Quixote", autor2));
        livros.add(new Livro("Orgulho e Preconceito", autor3));
        livros.add(new Livro("1984", autor4));
        livros.add(new Livro("O Grande Gatsby", autor5));
        livros.add(new Livro("A Revolução dos Bichos", autor4));
    }

}
