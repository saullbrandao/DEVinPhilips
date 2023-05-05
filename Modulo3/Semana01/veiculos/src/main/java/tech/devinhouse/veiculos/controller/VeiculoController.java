package tech.devinhouse.veiculos.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.veiculos.dto.VeiculoRequest;
import tech.devinhouse.veiculos.dto.VeiculoResponse;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.service.VeiculoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;
    ModelMapper modelMapper = new ModelMapper();

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> adicionar(@RequestBody @Valid VeiculoRequest veiculoRequest) {
        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);
        veiculo = veiculoService.criar(veiculo);
        VeiculoResponse response = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.created(URI.create(veiculo.getPlaca())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> consultar() {
        List<Veiculo> veiculos = veiculoService.listar();
        List<VeiculoResponse> veiculosResp = veiculos.stream()
                .map(v -> modelMapper.map(v, VeiculoResponse.class)).toList();
        return ResponseEntity.ok(veiculosResp);
    }

    @GetMapping("{placa}")
    public ResponseEntity<VeiculoResponse> consultar(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.obter(placa);
        VeiculoResponse veiculoResponse = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(veiculoResponse);
    }

    @DeleteMapping("{placa}")
    public ResponseEntity<Void> excluir(@PathVariable String placa) {
        veiculoService.excluir(placa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{placa}/multas")
    public ResponseEntity<VeiculoResponse> multar(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.adicionarMulta(placa);
        VeiculoResponse veiculoResponse = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(veiculoResponse);
    }
}
