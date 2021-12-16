package br.com.fgoecking.cliente.controller;

import br.com.fgoecking.cliente.DTO.ClienteRequestDTO;
import br.com.fgoecking.cliente.DTO.ClienteResponseDTO;
import br.com.fgoecking.cliente.model.Cliente;
import br.com.fgoecking.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ControllerCliente {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteResponseDTO criarCliente(@Validated @RequestBody ClienteRequestDTO cliente){
        ClienteResponseDTO clienteSalvo = clienteService.criarCliente(cliente);
        return clienteSalvo;}

    @GetMapping
    public List<ClienteResponseDTO> listarClientes() { return clienteService.listarClientes();}

    @GetMapping("/{email}/email")
    public ClienteResponseDTO consultarClienteEmail(@PathVariable String email){ return clienteService.consultarClienteEmail(email);}

    @GetMapping("/{cpf}/cpf")
    public ClienteResponseDTO consultarClienteCPF(@PathVariable String cpf){ return clienteService.consultarClienteCPF(cpf);}

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarClientePorEmail(@PathVariable String email) throws Exception { clienteService.deleterCliente(email);}

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable String email, @RequestBody ClienteRequestDTO clienteRequestDTO) throws Exception { clienteService.atualizarCliente(clienteRequestDTO, email);}
}
