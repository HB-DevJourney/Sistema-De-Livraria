package org.livraria.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Autor {

    private static int contadorID = 1;

    @Getter
    private final int id;

    @Getter @Setter
    private String nome;

    DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Getter @Setter
    private LocalDate dataNascimento;

    public Autor(String nome, LocalDate dataNascimento) {
        this.id = contadorID++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome;
    }
}
