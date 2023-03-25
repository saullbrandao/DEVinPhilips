package org.example;

import org.example.config.AppConfig;
import org.example.model.Cliente;
import org.example.model.Conta;
import org.example.service.ClienteService;
import org.example.service.ContaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ClienteService clienteService = applicationContext.getBean(ClienteService.class);
        ContaService contaService = applicationContext.getBean(ContaService.class);

        clienteService.createCliente(new Cliente("José", "91913541029"));
        clienteService.createCliente(new Cliente("João", "19454415000"));

        System.out.println(clienteService.listClientes());

        System.out.println(clienteService.findClienteById(0));

        clienteService.updateClienteById(0, new Cliente("Paulo", "43924881014"));
        System.out.println(clienteService.listClientes());

        clienteService.deleteClienteById(0);
        System.out.println(clienteService.listClientes());

        contaService.createConta(new Conta(clienteService.findClienteById(0), new BigDecimal(0)));
        System.out.println(contaService.listContas());

        contaService.addToSaldo(0, new BigDecimal(-10));
        System.out.println(contaService.findContaById(0));

        contaService.deleteContaById(0);

        System.out.println(contaService.listContas());
    }
}
