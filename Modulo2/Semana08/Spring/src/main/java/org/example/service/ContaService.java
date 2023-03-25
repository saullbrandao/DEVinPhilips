package org.example.service;

import org.example.model.Conta;
import org.example.model.Conta;
import org.example.repository.ContaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

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
        try {
        return contaRepository.saveConta(conta);
        } catch (Exception e) {
            throw new ServerErrorException("ContaService", e);
        }
    }

    public List<Conta> listContas() {
        return contaRepository.getAllContas();
    }

    public Conta findContaById(Integer id) {
        try {
        return contaRepository.findContaById(id);
        } catch (Exception e) {
            throw new ServerErrorException("ContaService", e);
        }
    }

    public Boolean deleteContaById(Integer id) {
        return contaRepository.deleteContaById(id);
    }

    public void addToSaldo(Integer id, BigDecimal value) {
//        try {
        contaRepository.addToSaldo(id, value);
//        }
//        catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            throw new ServerErrorException(e.getMessage(), e);
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new ServerErrorException("ContaService", e);
//        }
    }

    public Map<String, Object> transferir(Integer from_id, Integer to_id, BigDecimal value) {
//        try {
        return contaRepository.transferir(from_id, to_id, value);
//        } catch (Exception e) {
//            throw new ServerErrorException("ContaService", e);
//        }
    }
}
