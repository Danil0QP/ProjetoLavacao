package CardosoLavacao.dto.cliente;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {

    //Validação para quando o cliente deixa o nome em branco
    @NotBlank(message = "O nome é obrigatório!") //Se o nome estiver em branco apresenta a mensagem.
    @Size(min = 3, max = 100, message = "O nome não atende o tamanho permitido! (Entre 3 e 100 caracteres)") //Se o nome for menor que 3 ou maior que 100 apresenta a mensagem
    private String nome;

    @Pattern(regexp = "\\\\+?[0-9\\\\-\\\\(\\\\)\\\\s]{9,15}", //Validação para formatação dos números.
            message = "O número de telefone deve ter um formato válido!")
    private String telefone;

    @NotNull(message = "A data de nascimento é obrigatória!")
    private LocalDate dataNascimento;
}
