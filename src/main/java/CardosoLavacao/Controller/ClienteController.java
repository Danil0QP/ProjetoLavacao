package CardosoLavacao.Controller;

import CardosoLavacao.Service.ClienteService;
import CardosoLavacao.dto.cliente.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/criar-usuario")
    public ResponseEntity<ClienteDTO> criarCliente (@RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteDTOcriado = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.ok(clienteDTOcriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente (@PathVariable UUID id, @RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteDTOatualizado = clienteService.atualizarCliente(id,clienteDTO);
        return ResponseEntity.ok(clienteDTOatualizado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findClienteById (@PathVariable UUID id){
        ClienteDTO clienteDTO = clienteService.getClienteByID(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCliente (@PathVariable Long id){
        clienteService.apagarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
