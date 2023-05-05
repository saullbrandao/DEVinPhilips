package tech.devinhouse.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.veiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
