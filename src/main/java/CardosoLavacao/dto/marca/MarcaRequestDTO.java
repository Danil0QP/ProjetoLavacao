package CardosoLavacao.dto.marca;

import jakarta.validation.constraints.NotBlank;

public record MarcaRequestDTO(
        @NotBlank String nome,
        boolean ativo
) {}