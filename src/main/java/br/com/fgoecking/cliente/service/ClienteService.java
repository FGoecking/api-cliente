package br.com.fgoecking.cliente.service;

import br.com.fgoecking.cliente.DTO.ClienteRequestDTO;
import br.com.fgoecking.cliente.DTO.ClienteResponseDTO;
import br.com.fgoecking.cliente.model.Cliente;
import br.com.fgoecking.cliente.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = modelMapper.map(clienteRequestDTO, Cliente.class);
        Cliente clientesalvo = clienteRepository.save(cliente);
        ClienteResponseDTO clienteResponseDTO = modelMapper.map(clientesalvo, ClienteResponseDTO.class);
        return clienteResponseDTO;
    }

    public List<ClienteResponseDTO> listarClientes(){
        List<Cliente> clienteList = (List<Cliente>) clienteRepository.findAll();
        List<ClienteResponseDTO> clienteResponseDTOList = new ArrayList<>();
        clienteList.forEach(cliente -> {
           ClienteResponseDTO clienteResponseDTO = modelMapper.map(cliente, ClienteResponseDTO.class);
            clienteResponseDTOList.add(clienteResponseDTO);
        });
        return clienteResponseDTOList;
    }

    public void deleterCliente(String email) throws Exception{
        Cliente cliente = clienteRepository.findByEmail(email);
        if(cliente != null){
            clienteRepository.deleteById(cliente.getId());
        } else {
            throw new Exception("Cliente não encontrado.");
        }
    }


    public ClienteResponseDTO consultarClienteEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO consultarClienteCPF(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public void atualizarCliente(ClienteRequestDTO clienteRequestDTO, String email) throws Exception {
        Cliente cliente = clienteRepository.findByEmail(email);

        if(cliente == null){
            throw new Exception("Cliente não encontrado.");
        }
        //Parse
        modelMapper.map(clienteRequestDTO, cliente);
        clienteRepository.save(cliente);
    }


}
