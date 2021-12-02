package br.com.fgoecking.cliente.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
    private Long id;

    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private String ddd;

}
