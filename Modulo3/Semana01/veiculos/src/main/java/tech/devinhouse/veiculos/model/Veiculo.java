package tech.devinhouse.veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    private String placa;
    private String tipo;
    private String cor;
    private Integer anoDeFabricacao;
    @Value("0")
    private Integer qtdMultas;
}
