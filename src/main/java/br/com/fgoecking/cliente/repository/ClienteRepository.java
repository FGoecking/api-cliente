package br.com.fgoecking.cliente.repository;

import br.com.fgoecking.cliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    Cliente findByEmail(String email);

    Cliente findByCpf(String cpf);
}
