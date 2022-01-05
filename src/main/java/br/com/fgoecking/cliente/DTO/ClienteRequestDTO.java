package br.com.fgoecking.cliente.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    @NotNull(message = "O CPF é obrigatório.")
    @CPF(message = "O CPF é inválido.")
    private String cpf;

    @NotEmpty(message = "O nome não pode ser vazio")
    @NotNull(message = "O nome é obrigatório.")
    @Length(min = 3, max = 126)
    private String nome;

    @NotNull(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail é inválido.")
    private String email;

    @Length(min = 8, max = 30)
    private String telefone;

    @Length(min = 2, max = 3)
    private String ddd;
}
