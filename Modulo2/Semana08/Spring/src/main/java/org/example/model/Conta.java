package org.example.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @NotNull
    private Cliente cliente;

    @NotNull
    private BigDecimal saldo;
}