package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Boolean createCliente(Cliente cliente){
        try {
            return clienteRepository.saveCliente(cliente);
        } catch (Exception e) {
            throw new ServerErrorException("ClienteService", e);
        }
    }

    public List<Cliente> listClientes(){
        return clienteRepository.getAllClientes();
    }

    public Cliente findClienteById(Integer id){
        try {
            return clienteRepository.findClienteById(id);
        } catch (Exception e) {
            throw new ServerErrorException("ClienteService", e);
        }
    }

    public Boolean deleteClienteById(Integer id){
        return clienteRepository.deleteClienteById(id);
    }

    public void updateClienteById(Integer id, Cliente cliente){
        try {
        clienteRepository.updateClienteById(id, cliente);
        } catch (Exception e) {
            throw new ServerErrorException("ClienteService", e);
        }
    }
}
