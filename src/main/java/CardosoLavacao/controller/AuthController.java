package CardosoLavacao.controller;

import CardosoLavacao.dto.auth.LoginRequestDTO;
import CardosoLavacao.dto.auth.LoginResponseDTO;
import CardosoLavacao.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.cpf(), request.senha())
            );

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String nomeCliente = usuario.getCliente() != null ? usuario.getCliente().getNome() : null;

            return ResponseEntity.ok(
                    new LoginResponseDTO(true, "Login realizado com sucesso ", usuario.getCpf(), nomeCliente)
            );
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                    body(new LoginResponseDTO(false, "CPF ou Senha inválidos", request.cpf(), null));
        }
    }
}
