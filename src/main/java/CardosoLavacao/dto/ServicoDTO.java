package CardosoLavacao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServicoDTO {
    private Long id;

    @NotBlank(message = "Selecione um tipo de serviço!") //Validação criada para caso não seja selecionado um serviço dentre as opções.
    private String tipoServico;

    @NotBlank(message = "Informe um valor do serviço!") //Validação criada para caso um serviço esteja com o valor informado.
    private Float valor;
}
