package CardosoLavacao.dto.agendamento;

import CardosoLavacao.model.Agendamento;
import CardosoLavacao.model.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(UUID id,
                                     LocalDateTime dataHoraAgendamento,
                                     Status statusAgendamento,
                                     UUID carroId,
                                     UUID servicoId) {

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this(
                agendamento.getId(),
                agendamento.getDataHoraAgendamento(),
                agendamento.getStatusAgendamento(),
                agendamento.getCarro().getId(),
                agendamento.getServico().getId());
    }

}