package CardosoLavacao.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    @NotBlank
    @Size(min = 11, max = 11, message = "O CPF informado é inválido, deve conter 11 digitos!")
    private String cpf;

    @NotBlank
    @Size(min = 8, max = 50)
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
