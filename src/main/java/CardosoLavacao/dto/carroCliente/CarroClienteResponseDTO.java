package CardosoLavacao.dto.carroCliente;

import CardosoLavacao.dto.agendamento.AgendamentoResponseDTO;
import CardosoLavacao.model.CarroCliente;

import java.util.List;
import java.util.UUID;

public record CarroClienteResponseDTO(
        UUID id,
        String placa,
        boolean mercosul,
        UUID clienteId,
        UUID modeloId,
        String modeloNome,
        String marcaNome,
        List<AgendamentoResponseDTO> agendamento
) {
    public CarroClienteResponseDTO(CarroCliente carro) {
        this(carro.getId(), carro.getPlaca(), carro.isMercosul(), carro.getCliente().getId(),
                carro.getModelo().getId(), carro.getModelo().getNome(),
                carro.getModelo().getMarca().getNome(),
                carro.getAgendamentos().stream().map(AgendamentoResponseDTO::new).toList());
    }
}



