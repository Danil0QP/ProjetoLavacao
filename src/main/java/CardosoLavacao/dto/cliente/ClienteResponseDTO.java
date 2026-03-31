package CardosoLavacao.dto.cliente;

import CardosoLavacao.model.Cliente;

import java.time.LocalDate;
import java.util.UUID;

public record ClienteResponseDTO(
        UUID id,
        String nome,
        String telefone,
        LocalDate dataNascimento
) {

    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getDataNascimento());
    }
}
