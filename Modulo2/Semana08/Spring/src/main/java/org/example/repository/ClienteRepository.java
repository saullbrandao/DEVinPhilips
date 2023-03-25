package org.example.repository;

import org.example.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private static List<Cliente> clienteList = new ArrayList<Cliente>();

    public Boolean saveCliente(Cliente cliente){
        return clienteList.add(cliente);
    }

    public List<Cliente> getAllClientes(){
        return clienteList;
    }

    public Boolean deleteClienteById(Integer id){
        return clienteList.remove(findClienteById(id));
    }

    public void updateClienteById(Integer id, Cliente cliente){
        clienteList.set(id,cliente);
    }

    public Cliente findClienteById(Integer id){
        return clienteList.get(id);
    }
}
