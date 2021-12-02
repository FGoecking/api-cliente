package br.com.fgoecking.cliente.controller;

import br.com.fgoecking.cliente.model.Cliente;
import br.com.fgoecking.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ControllerCliente {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){ return clienteService.criarCliente(cliente);}

    @GetMapping
    public List<Cliente> listarClientes() { return clienteService.listarClientes();}

    @GetMapping("/{id}")
    public Cliente consultarCliente(@PathVariable Long id){ return clienteService.consultarCliente(id);}

    @GetMapping("/email/{email}")
    public Cliente consultarClienteEmail(@PathVariable String email){ return clienteService.consultarClienteEmail(email);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Long id){ clienteService.deleterCliente(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception { clienteService.atualizarCliente(cliente, id);}
}
