package CardosoLavacao.dto.cliente;

import CardosoLavacao.model.Cliente;

import java.util.UUID;

public record ClienteResponseDTO(
        UUID id,
        String nome,
        String telefone,
        String cpf

) {

    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(),cliente.getNome(),cliente.getTelefone(),cliente.getCpf());
    }
}
