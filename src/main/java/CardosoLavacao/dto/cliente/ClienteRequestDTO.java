package CardosoLavacao.dto.cliente;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
        String cpf,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, max = 72, message = "Senha deve conter entre 8 e 72 caracteres")
        String senha,

        @NotBlank(message = "Confirmação de senha é obrigatória")
        String confSenha,

        @NotBlank(message = "Marca é obrigatória")
        String marca,

        @NotBlank(message = "Nome do carro é obrigatório")
        String nomeCarro,

        @NotNull(message = "Informação mercosul é obrigatória")
        Boolean mercosul,

        @NotBlank(message = "Placa é obrigatória")
        String placa
) {

}
