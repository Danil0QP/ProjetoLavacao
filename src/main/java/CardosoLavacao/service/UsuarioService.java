package CardosoLavacao.service;

import CardosoLavacao.model.Role;
import CardosoLavacao.model.Usuario;
import CardosoLavacao.repository.RoleRepository;
import CardosoLavacao.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

   private final UsuarioRepository usuarioRepository;
   private final RoleRepository roleRepository;
   private final PasswordEncoder passwordEncoder;

   //Construtor criado para injetar os repositorios e o encoder.
   public UsuarioService (UsuarioRepository usuarioRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder encoder) {
       this.usuarioRepository = usuarioRepository;
       this.roleRepository = roleRepository;
       this.passwordEncoder = encoder;
   }

   public Usuario criarUsuario (String cpf, String senha){
       Role roleAdmin = roleRepository.findByNome("ADMIN")
               .orElseThrow(() -> new RuntimeException("Admin não encontrado!"));

       Usuario usuario = new Usuario();
       usuario.setCpf(cpf);
       usuario.setSenha(passwordEncoder.encode(senha));
       usuario.setConfSenha(passwordEncoder.encode(senha));
       usuario.setConfSenha(passwordEncoder.encode(senha));
       usuario.setRoles(List.of(roleAdmin));

       return usuarioRepository.save(usuario);

   }

}
