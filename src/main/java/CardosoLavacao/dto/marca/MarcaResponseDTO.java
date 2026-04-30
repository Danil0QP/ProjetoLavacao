package CardosoLavacao.dto.marca;

import CardosoLavacao.model.Marca;

import java.util.UUID;

public record MarcaResponseDTO(
        UUID id,
        String nome,
        boolean ativo
) {
    public MarcaResponseDTO(Marca marca) {
        this(marca.getId(), marca.getNome(), marca.isAtivo());
    }
}