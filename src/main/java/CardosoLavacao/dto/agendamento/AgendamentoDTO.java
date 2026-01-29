package CardosoLavacao.dto.agendamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    @NotNull(message = "Preencha a data e a hora do agendamento!")
    private LocalDateTime dataHoraAgendamento;
}
