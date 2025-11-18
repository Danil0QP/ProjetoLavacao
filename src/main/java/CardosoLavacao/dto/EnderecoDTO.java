package CardosoLavacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;

    @NotBlank(message = "Obrigatório informar uma rua!") //Validação para caso o endereço esteja em branco
    @Size(min = 20, max = 250, message = "Tamanho de endereço não corresponde o máximo permitido!") //Validação para o tamanho que o usuário preencher no endereço.
    private String endereco;

    @NotBlank(message = "Obrigatório informar um número para o endereço!")
    private int numero;

    @NotBlank(message = "Obrigatório informar um bairro!") //Validação para caso o cliente deixe o bairro em branco.
    @Size(min = 3, max = 100, message = "Bairro informado não atende o tamanho permitido!") //Validação para caso o Bairro informado não tenha o tamanho mínimo ou o tamanho máximo.
    private String bairro;

    @Size(min = 5, max = 255, message = "Referência informada não atende os requisitos!")
    private String complemento;
}
