package org.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Cliente {

    private static int contadorID = 1;

    @Getter
    private final int id;

    @Getter @Setter
    private String nome;

    DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Getter @Setter
    private LocalDate dataNascimento;

    @Getter @Setter
    private String email;

    public Cliente(String nome, LocalDate dataNascimento, String email) {
        this.id = contadorID++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Email: ").append(email).append("\n");

        return sb.toString();
    }

}
