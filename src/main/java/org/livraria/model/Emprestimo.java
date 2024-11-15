package org.livraria.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    @Getter
    private final String id = UUID.randomUUID().toString();

    @Getter @Setter
    private Livro livro;

    @Getter @Setter
    private Cliente cliente;

    DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Getter @Setter
    private LocalDate dataEmprestimo = LocalDate.now();

    @Getter @Setter
    private LocalDate dataDevolucao = dataEmprestimo.plusDays(15);

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("ID: ").append(id).append("\n");
        sb.append("Livro: ").append(livro.getTitulo()).append(" | ");
        sb.append("Autor: ").append(livro.getAutor()).append("\n");
        sb.append("Cliente - \n").append(cliente).append("\n");
        sb.append("Data de Emprestimo: ").append(dataEmprestimo.format(dataFormat)).append("\n");
        sb.append("Data de Devolução Prevista: ").append(dataDevolucao.format(dataFormat)).append("\n");

        return sb.toString();
    }

}
