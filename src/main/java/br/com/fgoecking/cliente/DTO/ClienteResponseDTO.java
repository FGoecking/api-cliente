package br.com.fgoecking.cliente.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

        private String cpf;
        private String nome;
        private String email;
        private String telefone;
        private String ddd;
}
