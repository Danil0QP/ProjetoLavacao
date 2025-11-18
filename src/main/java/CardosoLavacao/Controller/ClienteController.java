package CardosoLavacao.Controller;

import CardosoLavacao.Service.ClienteService;
import CardosoLavacao.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/criar-usuario")
    public ResponseEntity<ClienteDTO> criarCliente (@RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteDTOcriado = clienteService.criarUsuario(clienteDTO);
        return ResponseEntity.ok(clienteDTOcriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente (@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteDTOatualizado = clienteService.atualizarCliente(id,clienteDTO);
        return ResponseEntity.ok(clienteDTOatualizado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findClienteById (@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.findClienteById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCliente (@PathVariable Long id){
        clienteService.apagarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
