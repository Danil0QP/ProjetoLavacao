package CardosoLavacao.dto.carroCliente;

import CardosoLavacao.model.CarroCliente;

import java.util.UUID;

public record CarroClienteResponseDTO(
        UUID id,
        String placa,
        boolean mercosul,
        Integer anoFabricacao,
        String cor,
        UUID clienteId,
        UUID modeloId,
        String modeloNome,
        String marcaNome
) {
    public CarroClienteResponseDTO(CarroCliente carro) {
        this(carro.getId(), carro.getPlaca(), carro.isMercosul(), carro.getAnoFabricacao(), carro.getCor(),
                carro.getCliente().getId(), carro.getModelo().getId(), carro.getModelo().getNome(), carro.getModelo().getMarca().getNome());
    }
}