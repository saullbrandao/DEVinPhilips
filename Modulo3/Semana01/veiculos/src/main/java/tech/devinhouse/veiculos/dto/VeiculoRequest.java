package tech.devinhouse.veiculos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VeiculoRequest {
    @NotBlank(message = "Placa é obrigatória")
    private String placa;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotBlank(message = "Cor é obrigatória")
    private String cor;

    @NotNull(message = "Ano de fabricação é obrigatório")
    private Integer anoDeFabricacao;
}