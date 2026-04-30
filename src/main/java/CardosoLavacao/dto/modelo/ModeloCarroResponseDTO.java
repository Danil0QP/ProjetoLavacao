package CardosoLavacao.dto.modelo;

import CardosoLavacao.model.ModeloCarro;

import java.util.UUID;

public record ModeloCarroResponseDTO(
        UUID id,
        String nome,
        boolean ativo,
        UUID marcaId,
        String marcaNome
) {
    public ModeloCarroResponseDTO(ModeloCarro modelo) {
        this(modelo.getId(), modelo.getNome(), modelo.isAtivo(), modelo.getMarca().getId(), modelo.getMarca().getNome());
    }
}