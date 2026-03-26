package CardosoLavacao.dto.cliente;

import CardosoLavacao.dto.carro.CarroDTO;
import CardosoLavacao.dto.carro.CarroRequestDTO;
import CardosoLavacao.dto.usuario.UsuarioDTO;
import CardosoLavacao.dto.usuario.UsuarioRequestDTO;

import java.time.LocalDateTime;

public record ClienteRequestDTO(String nome,
                                String telefone,
                                LocalDateTime dataNascimento,
                                UsuarioDTO usuario,
                                CarroDTO carro){

}
