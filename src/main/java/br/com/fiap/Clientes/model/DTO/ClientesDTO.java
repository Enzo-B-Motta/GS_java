package br.com.fiap.Clientes.model.DTO;

import java.time.LocalDate;

public record ClientesDTO(
        String nome,
        int idade,
        Double peso,
        Double altura,
        LocalDate inicioDoTratamento
) {}
