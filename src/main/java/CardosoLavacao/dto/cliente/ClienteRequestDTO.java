package CardosoLavacao.dto.cliente;

import java.time.LocalDate;

public record ClienteRequestDTO(String nome,
                                String telefone,
                                LocalDate dataNascimento,
                                String cpf,
                                String senha,
                                String confSenha,
                                String marca,
                                String nomeCarro,
                                Boolean mercosul,
                                String placa
                                ){

}
