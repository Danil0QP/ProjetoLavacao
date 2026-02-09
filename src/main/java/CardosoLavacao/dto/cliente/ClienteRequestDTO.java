package CardosoLavacao.dto.cliente;

public record ClienteRequestDTO(String nome,
                                String telefone,
                                String nomeCarro,
                                String marca,
                                String placa,
                                Boolean mercosul) {
}
