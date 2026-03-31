package CardosoLavacao.dto.usuario;

import CardosoLavacao.model.Usuario;

import java.util.UUID;

public record UsuarioResponseDTO(UUID id,
                                 String cpf,
                                 String senha,
                                 String confSenha) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.getConfSenha());
    }
}