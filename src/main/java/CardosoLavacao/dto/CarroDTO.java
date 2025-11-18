package CardosoLavacao.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CarroDTO {

    private Long id;

    @NotBlank(message = "Nome do carro é obrigatório!") //Validação para se o nome do carro estiver em branco.
    @Size(min = 3, max = 100, message = "Nome do carro não atende o tamanho permitido.") //Validação para tamanho do nome do carro, não pode ser menor que 3 e nem maior que 100.
    private String nome;

    @NotBlank(message = "Marca do carro obrigatória!")
    private String marca;

    @NotBlank(message = "Obrigatório informar a placa do veículo!")
    @Pattern(regexp = "^([A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2})$",
            message = "A placa informada está errada! (Mercosul ABC1A23 ou Antigo ABC-123)")
    private String placa;

    @NotBlank(message = "Informar o tipo de placa do seu veículo!")
    private boolean mercosul;

}
