package org.example.controller;

import org.example.model.Cliente;
import org.example.service.ClienteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listClientes() {
        return clienteService.listClientes();
    }

    @GetMapping(params = "id")
    public Cliente findClienteById(@RequestParam Integer id) {
        return clienteService.findClienteById(id);
    }

    @PostMapping
    public Boolean createCliente(@RequestBody @Validated Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping
    public void updateCliente(@RequestParam Integer id, @RequestBody @Validated Cliente cliente ) {
        clienteService.updateClienteById(id, cliente);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCliente(@PathVariable Integer id) {
        return clienteService.deleteClienteById(id);
    }
}
