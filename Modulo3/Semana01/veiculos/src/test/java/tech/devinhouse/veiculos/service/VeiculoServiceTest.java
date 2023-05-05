package tech.devinhouse.veiculos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.devinhouse.veiculos.exception.ExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {
    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    @Test
    @DisplayName("Quando placa já foi cadastrada, deve retornar erro")
    void criar_erro() {
        var veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(true);
        assertThrows(RegistroExistenteException.class, () -> veiculoService.criar(veiculo));
    }

    @Test
    @DisplayName("Quando placa ainda não foi cadastrada, deve retornar veiculo cadastrado")
    void criar_sucesso() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(false);
        Mockito.when(veiculoRepository.save(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        Veiculo veiculoCadastrado = veiculoService.criar(veiculo);
        assertNotNull(veiculoCadastrado);
    }

    @Test
    @DisplayName("Quando houver veículos cadastrados, deve retornar lista com veículos")
    void listar() {
        List<Veiculo> veiculos = List.of(
                Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).build(),
                Veiculo.builder().placa("CBA-321").tipo("caminhão").cor("branco").anoDeFabricacao(2015).build()
        );
        Mockito.when(veiculoRepository.findAll()).thenReturn(veiculos);
        List<Veiculo> resultado = veiculoService.listar();
        assertFalse(resultado.isEmpty());
        assertEquals(veiculos.size(), resultado.size());
    }

    @Test
    @DisplayName("Quando não houver veículos cadastrados, deve retornar lista vazia")
    void listar_vazio() {
        List<Veiculo> veiculos = veiculoService.listar();
        assertTrue(veiculos.isEmpty());
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada, deve retornar o respectivo veículo")
    void obter() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(new Veiculo()));
        Veiculo veiculo = veiculoService.obter("ABC-123");
        assertNotNull(veiculo);
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve lançar exceção")
    void obter_erro() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> veiculoService.obter("ABC-123"));
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada e sem multas, deve excluir veículo")
    void excluir() {
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").qtdMultas(0).anoDeFabricacao(2010).build();
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertDoesNotThrow(() -> veiculoService.excluir(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve lançar exceção")
    void excluir_naoExistente() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> veiculoService.excluir("ABC-123"));
    }

    @Test
    @DisplayName("Quando tentar excluir veículo que possui multas, deve lançar exceção")
    void excluir_multas() {
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).qtdMultas(1).build();
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertThrows(ExclusaoVeiculoComMultasException.class, () -> veiculoService.excluir(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve lançar exceção")
    void adicionarMulta_naoExistente() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> veiculoService.adicionarMulta("ABC-123"));
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada, deve incrementar a quantidade de multas")
    void adicionarMulta() {
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).qtdMultas(0).build();
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        veiculoService.adicionarMulta(veiculo.getPlaca());
        assertEquals(1, veiculo.getQtdMultas());
    }
}