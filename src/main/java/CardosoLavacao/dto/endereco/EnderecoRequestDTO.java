package CardosoLavacao.dto.endereco;

public record EnderecoRequestDTO(String endereco,
                                 int numero,
                                 String bairro,
                                 String complemento) {
}
