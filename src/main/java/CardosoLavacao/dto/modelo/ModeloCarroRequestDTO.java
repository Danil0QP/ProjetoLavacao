package CardosoLavacao.dto.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ModeloCarroRequestDTO(
        @NotBlank String nome,
        @NotNull UUID marcaId,
        boolean ativo
) {}