package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Boolean createCliente(Cliente cliente){
            return clienteRepository.saveCliente(cliente);
    }

    public List<Cliente> listClientes(){
        return clienteRepository.getAllClientes();
    }

    public Cliente findClienteById(Integer id){
            return clienteRepository.findClienteById(id);
    }

    public Boolean deleteClienteById(Integer id){
        return clienteRepository.deleteClienteById(id);
    }

    public void updateClienteById(Integer id, Cliente cliente){
        clienteRepository.updateClienteById(id, cliente);
    }
}
