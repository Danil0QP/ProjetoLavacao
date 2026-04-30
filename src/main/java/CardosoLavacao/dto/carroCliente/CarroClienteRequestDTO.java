package CardosoLavacao.dto.carroCliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CarroClienteRequestDTO(
        @NotBlank String placa,
        boolean mercosul,
        String marca,
        String nome,
        @NotNull UUID modeloId
) {}