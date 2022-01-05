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

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 3)
    private String ddd;

}
