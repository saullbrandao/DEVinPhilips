package tech.devinhouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FolhaDePagamentoTest {
    private FolhaDePagamento folhaDePagamento;

    @BeforeEach
    public void setup() {
        folhaDePagamento = new FolhaDePagamento();
    }

    @Test
    @DisplayName("Quando não houver gratificação e não for gerente, deve retornar salário base")
    void calcularSalarioBruto_salarioBase() {
        String funcao = "empregado";
        Double salarioBase = 1000.0, gratificacao = null;
        Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        assertEquals(salarioBase, salarioBruto);
    }

    @Test
    @DisplayName("Quando houver gratificação, deve retornar salário base acrescido do valor da gratificação")
    void calcularSalarioBruto_gratificacao() {
        String funcao = "empregado";
        Double salarioBase = 1000.0, gratificacao = 250.0;
        Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        assertTrue(salarioBase < salarioBruto);
        assertEquals(salarioBase + gratificacao, salarioBruto);
    }

    @Test
    @DisplayName("Quando for gerente, deve retornar salário acrescido do percentual previsto")
    void calcularSalarioBruto_funcao() {
        String funcao = "gerente";
        Double salarioBase = 1000.0, gratificacao = null;
        Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        assertTrue(salarioBase < salarioBruto);
        assertEquals(salarioBase * 1.30, salarioBruto);
    }

    @Test
    @DisplayName("Quando for gerente e houver gratificação, deve retornar salário acrescido dos valores")
    void calcularSalarioBruto_tudo() {
        String funcao = "gerente";
        Double salarioBase = 1000.0, gratificacao = 200.0;
        Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        assertTrue(salarioBase < salarioBruto);
        assertEquals((salarioBase + gratificacao) * 1.30, salarioBruto);
    }

    @Test
    @DisplayName("Quando não houver descontos, deve retornar o salário")
    void calcularSalarioLiquido_semDescontos() {
        Double salario = 1000.0;
        List<Double> descontos = new ArrayList<>();
        Double salarioLiquido = folhaDePagamento.calcularSalarioLiquido(salario, descontos);
        assertEquals(salario, salarioLiquido);
    }

    @Test
    @DisplayName("Quando houver descontos, deve retornar o salário reduzido dos descontos")
    void calcularSalarioLiquido_comDescontos() {
        Double salario = 1000.0;
        List<Double> descontos = List.of(250.0, 200.0);
        Double somaDeDescontos = descontos.stream().reduce(Double::sum).get();
        Double salarioLiquido = folhaDePagamento.calcularSalarioLiquido(salario, descontos);
        assertEquals(salario - somaDeDescontos, salarioLiquido);
    }

    @Test
    @DisplayName("Quando o valor dos descontos for superior ao valor do salário, deve lançar exceção")
    void calcularSalarioLiquido_salarioNegativo() {
        Double salario = 1000.0;
        List<Double> descontos = List.of(500.0, 200.0, 750.0);
        assertThrows(IllegalStateException.class, () ->
                folhaDePagamento.calcularSalarioLiquido(salario, descontos));
    }

}