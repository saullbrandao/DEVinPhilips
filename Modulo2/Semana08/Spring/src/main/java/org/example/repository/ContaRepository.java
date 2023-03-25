package org.example.repository;

import org.example.model.Conta;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository {
    private static List<Conta> contaList = new ArrayList<Conta>();

    public Boolean saveConta(Conta conta){
        return contaList.add(conta);
    }

    public List<Conta> getAllContas(){
        return contaList;
    }

    public Boolean deleteContaById(Integer id){
        return contaList.remove(findContaById(id));
    }

    public Conta findContaById(Integer id){
        return contaList.get(id);
    }

    public void addToSaldo(Integer id, BigDecimal value) {
        Conta conta = findContaById(id);
        BigDecimal novoSaldo = conta.getSaldo().add(value);

        if(novoSaldo.signum() == -1) {
            System.out.println("Saldo insuficiente");
            return;
        }

        conta.setSaldo(novoSaldo);
    }
}
