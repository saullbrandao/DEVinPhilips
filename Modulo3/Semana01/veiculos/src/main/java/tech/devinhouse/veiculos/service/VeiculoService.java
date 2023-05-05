package tech.devinhouse.veiculos.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.veiculos.exception.ExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo criar(Veiculo veiculo) {
        boolean existe = veiculoRepository.existsById(veiculo.getPlaca());
        if (existe) {
            throw new RegistroExistenteException();
        }

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo obter(String placa) {
        return veiculoRepository.findById(placa).orElseThrow(RegistroNaoEncontradoException::new);
    }

    public void excluir(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa).orElseThrow(RegistroNaoEncontradoException::new);
        if (veiculo.getQtdMultas() != 0) {
            throw new ExclusaoVeiculoComMultasException();
        }

        veiculoRepository.deleteById(placa);
    }

    public Veiculo adicionarMulta(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa).orElseThrow(RegistroNaoEncontradoException::new);
        int qtdMultas = veiculo.getQtdMultas() + 1;
        veiculo.setQtdMultas(qtdMultas);
        return veiculoRepository.save(veiculo);
    }
}
