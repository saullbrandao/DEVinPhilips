package org.example.repository;

import org.example.model.Conta;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Boolean addToSaldo(Integer id, BigDecimal value) {
        Conta conta = findContaById(id);
        BigDecimal novoSaldo = conta.getSaldo().add(value);

        if(novoSaldo.signum() == -1) {
            System.out.println("Saldo insuficiente");
            return false;
        }

        conta.setSaldo(novoSaldo);
        return true;
    }

    public Map<String, Object> transferir(Integer from_id, Integer to_id, BigDecimal value) {
        Conta from = findContaById(from_id);
        Conta to = findContaById(to_id);

        Boolean enoughBalance = addToSaldo(from_id, value.negate());

        if(enoughBalance) addToSaldo(to_id, value);

        Map<String, Object> map = new HashMap<>();
        map.put("conta_remetente", from);
        map.put("conta_destinataria", to);

        return map;

    }
}
