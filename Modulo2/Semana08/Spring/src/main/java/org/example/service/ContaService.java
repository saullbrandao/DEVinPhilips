package org.example.service;

import org.example.model.Conta;
import org.example.model.Conta;
import org.example.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    public void updateContaById(Integer id, Conta conta) {
        contaRepository.updateContaById(id, conta);
    }

    public void addToSaldo(Integer id, BigDecimal value) {
        contaRepository.addToSaldo(id, value);
    }
}
