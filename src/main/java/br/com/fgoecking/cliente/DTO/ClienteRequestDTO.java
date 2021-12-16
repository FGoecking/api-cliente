package br.com.fgoecking.cliente.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {


    @CPF
    private String cpf;

    @Length(min = 3)
    private String nome;

    @Email
    private String email;

    @Length(min = 8, max = 30)
    private String telefone;

    @Length(min = 2, max = 3)
    private String ddd;
}
