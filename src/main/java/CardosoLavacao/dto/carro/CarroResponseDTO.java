package CardosoLavacao.dto.carro;

import CardosoLavacao.model.Carro;

import java.util.UUID;

public record CarroResponseDTO(UUID id,
                               String nome,
                               String marca,
                               String placa,
                               boolean mercosul) {

    public CarroResponseDTO(Carro carro) {
        this(carro.getId(), carro.getNome(), carro.getMarca(), carro.getPlaca(), carro.isMercosul());
    }
}
