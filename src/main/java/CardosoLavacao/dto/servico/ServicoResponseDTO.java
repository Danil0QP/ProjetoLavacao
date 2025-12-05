package CardosoLavacao.dto.servico;

import java.util.UUID;

public record ServicoResponseDTO(UUID id,
                                 String tipoServico,
                                 Float valor) {
}
