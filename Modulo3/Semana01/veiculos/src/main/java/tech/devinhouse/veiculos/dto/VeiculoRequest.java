package tech.devinhouse.veiculos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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