package org.livraria.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Livro {

    private static int contadorID = 1;

    @Getter
    private final int id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private Autor autor;

    @Getter @Setter
    private Boolean disponivel = true;

    DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Getter @Setter
    private LocalDate dataCadastro = LocalDate.now();

    @Getter @Setter
    private LocalDate dataAtualizacao = LocalDate.now();

    public Livro(String titulo, Autor autor) {
        this.id = contadorID++;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("ID: ").append(id).append(" | ");
        sb.append("Livro: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor.getNome()).append("\n");
        sb.append("Disp.: ").append(disponivel ? "Sim" : "Não").append("\n");
        sb.append("Cadastro: ").append(dataCadastro.format(dataFormat)).append(" | ");
        sb.append("Ùltima Atual.: ").append(dataAtualizacao.format(dataFormat)).append("\n");

        return sb.toString();
    }

}
