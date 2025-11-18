package br.com.fiap.Clientes.model.DTO;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record ClientesDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String estatus,
        @Past
        LocalDate dataDeNascimento

       
) {}
