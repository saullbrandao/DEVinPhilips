package tech.devinhouse.veiculos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import tech.devinhouse.veiculos.dto.VeiculoRequest;
import tech.devinhouse.veiculos.exception.ExclusaoVeiculoComMultasException;
import tech.devinhouse.veiculos.exception.RegistroExistenteException;
import tech.devinhouse.veiculos.exception.RegistroNaoEncontradoException;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.service.VeiculoService;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class VeiculoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final ModelMapper modelMapper = new ModelMapper();

    @MockBean
    private VeiculoService veiculoService;

    @Test
    @DisplayName("Quando adicionar veículo com uma placa ainda não cadastrada, deve retornar sucesso")
    void adicionar_sucesso() throws Exception {
        VeiculoRequest veiculoRequest = new VeiculoRequest("ABC-123", "carro", "preto", 2010);
        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);
        String requestJson = objectMapper.writeValueAsString(veiculoRequest);
        Mockito.when(veiculoService.criar(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        mockMvc.perform(post("/api/veiculos")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Quando adicionar veículo com uma placa já cadastrada, deve retornar erro")
    void adicionar_jaCadastrado() throws Exception {
        Mockito.when(veiculoService.criar(Mockito.any(Veiculo.class))).thenThrow(RegistroExistenteException.class);
        VeiculoRequest veiculoRequest = new VeiculoRequest("ABC-123", "carro", "preto", 2010);
        String requestJson = objectMapper.writeValueAsString(veiculoRequest);
        mockMvc.perform(post("/api/veiculos")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.erro", containsStringIgnoringCase("Registro já cadastrado!")));
    }

    @Test
    @DisplayName("Quando houver veículos cadastrados, deve retornar lista de veículos")
    void consultar() throws Exception {
        List<Veiculo> veiculos = List.of(
                Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).build(),
                Veiculo.builder().placa("CBA-321").tipo("caminhão").cor("branco").anoDeFabricacao(2015).build()
        );
        Mockito.when(veiculoService.listar()).thenReturn(veiculos);
        mockMvc.perform(get("/api/veiculos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("Quando não houver veículos cadastrados, deve retornar lista vazia")
    void consultar_vazio() throws Exception {
        mockMvc.perform(get("/api/veiculos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada, deve retornar o veículo")
    void consultarPorPlaca() throws Exception {
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).build();
        Mockito.when(veiculoService.obter(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(get("/api/veiculos/{placa}", veiculo.getPlaca())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve retornar erro")
    void consultarPorPlaca_naoEncontrada() throws Exception {
        Mockito.when(veiculoService.obter(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        mockMvc.perform(get("/api/veiculos/{placa}", "ABC123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada e sem multas, deve excluir veículo")
    void excluir() throws Exception {
        mockMvc.perform(delete(
                        "/api/veiculos/{placa}", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve retornar erro")
    void excluir_naoEncontrado() throws Exception {
        Mockito.doThrow(RegistroNaoEncontradoException.class).when(veiculoService).excluir(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada e com multas, deve retornar erro")
    void excluir_temMulta() throws Exception {
        Mockito.doThrow(ExclusaoVeiculoComMultasException.class).when(veiculoService).excluir(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada, deve retornar sucesso")
    void multar() throws Exception {
        Integer qtdMultas = 2;
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipo("carro").cor("preto").anoDeFabricacao(2010).qtdMultas(qtdMultas).build();
        Mockito.when(veiculoService.adicionarMulta(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(put("/api/veiculos/{placa}/multas", veiculo.getPlaca())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.qtdMultas", is(qtdMultas)));
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve retornar erro")
    void multar_naoEncontrado() throws Exception {
        Mockito.when(veiculoService.adicionarMulta(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        mockMvc.perform(put("/api/veiculos/{placa}/multas", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}