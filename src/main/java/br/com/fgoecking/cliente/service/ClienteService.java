package br.com.fgoecking.cliente.service;

import br.com.fgoecking.cliente.model.Cliente;
import br.com.fgoecking.cliente.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public void deleterCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente consultarCliente(Long id) {
       return clienteRepository.findById(id).orElse(null);
    }

    public Cliente consultarClienteEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public void atualizarCliente(Cliente cliente, Long id) throws Exception {
        Cliente clienteBase = consultarCliente(id);

        if(clienteBase == null){
            throw new Exception("Cliente não encontrado.");
        }
        //Parse
        modelMapper.map(cliente, clienteBase);

        clienteRepository.save(clienteBase);
    }
}
