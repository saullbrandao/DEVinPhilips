package org.example.controller;

import org.example.model.Cliente;
import org.example.model.Conta;
import org.example.service.ClienteService;
import org.example.service.ContaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequestMapping("/conta")
@RestController
public class ContaController {
    private final ContaService contaService;
    private final ClienteService clienteService;

    public ContaController(ContaService contaService, ClienteService clienteService) {
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Conta> listContas() {
        return contaService.listContas();
    }

    @GetMapping(params = "id")
    public Conta findContaById(@RequestParam Integer id) {
        return contaService.findContaById(id);
    }

    @PostMapping(params = "cliente_id")
    public Boolean createConta(@RequestParam Integer cliente_id) {
        Cliente cliente = clienteService.findClienteById(cliente_id);
        Conta conta = new Conta();
        conta.setCliente(cliente);
        return contaService.createConta(conta);
    }


    @DeleteMapping("/{id}")
    public Boolean deleteConta(@PathVariable Integer id) {
        return contaService.deleteContaById(id);
    }

    @PutMapping
    public Boolean addToSaldo(@RequestBody Map<String, Object> body) {
        Integer conta_id = (Integer) body.get("conta_id");
        BigDecimal valor = BigDecimal.valueOf((Double) body.get("valor"));
        return contaService.addToSaldo(conta_id, valor);
    }

    @PutMapping("/transfere")
    @ResponseBody
    public Map<String, Object> transferir(@RequestBody Map<String, Object> body) {
        Integer from_conta_id = (Integer) body.get("from");
        Integer to_conta_id = (Integer) body.get("to");
        BigDecimal valor = BigDecimal.valueOf((Double) body.get("valor"));

        return contaService.transferir(from_conta_id, to_conta_id, valor);
    }
}

