package CardosoLavacao.dto.endereco;

import java.util.UUID;

public record EnderecoResponseDTO(UUID id,
                                  String endereco,
                                  int numero,
                                  String bairro,
                                  String complemento) {
}
