package br.com.fiap.Clientes.model.DTO;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record ClientesDTO(
        @NotBlank
        String nome,
        @NotNull
        @Positive
        int idade,
        @NotNull
        @Positive
        Double peso,
        @NotNull
        @Positive
        Double altura,
        @PastOrPresent
        LocalDate inicioDoTratamento
) {}
