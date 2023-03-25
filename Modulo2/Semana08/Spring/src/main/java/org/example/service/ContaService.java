package org.example.service;

import org.example.model.Conta;
import org.example.model.Conta;
import org.example.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Boolean createConta(Conta conta) {
        return contaRepository.saveConta(conta);
    }

    public List<Conta> listContas() {
        return contaRepository.getAllContas();
    }

    public Conta findContaById(Integer id) {
        return contaRepository.findContaById(id);
    }

    public Boolean deleteContaById(Integer id) {
        return contaRepository.deleteContaById(id);
    }

    public Boolean addToSaldo(Integer id, BigDecimal value) {
        return contaRepository.addToSaldo(id, value);
    }

    public Map<String, Object> transferir(Integer from_id, Integer to_id, BigDecimal value) {
        return contaRepository.transferir(from_id, to_id, value);
    }
}
