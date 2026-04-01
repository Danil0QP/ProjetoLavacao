package CardosoLavacao.dto.auth;

public record LoginResponseDTO(Boolean autenticado,
                               String mensagem,
                               String cpf,
                               String nomeCliente) {
}
