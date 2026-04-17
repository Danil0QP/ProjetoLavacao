package CardosoLavacao.dto.agendamento;


import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO (UUID carroId,
                                     UUID servicoId,
                                     LocalDateTime dataHoraAgendamento){
}
