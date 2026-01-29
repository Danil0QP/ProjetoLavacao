package CardosoLavacao.dto.agendamento;

import CardosoLavacao.model.Agendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(UUID id,
                                     LocalDateTime dataHoraAgendamento) {

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this(agendamento.getId(), agendamento.getDataHoraAgendamento());
    }

}