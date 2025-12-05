package CardosoLavacao.Controller;

import CardosoLavacao.Service.ClienteService;
import CardosoLavacao.dto.cliente.ClienteRequestDTO;
import CardosoLavacao.dto.cliente.ClienteResponseDTO;
import CardosoLavacao.model.Cliente;
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

    @PostMapping(value = "/criar-cliente")
    public ResponseEntity<ClienteResponseDTO> criarCliente (@RequestBody ClienteRequestDTO clienteRequestDTO){
        Cliente clienteCriado = clienteService.criarCliente(clienteRequestDTO);
        return ResponseEntity.ok(new ClienteResponseDTO(clienteCriado));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> atualizarCliente (@PathVariable UUID id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        Cliente clienteAtualizado = clienteService.atualizarCliente(id,clienteRequestDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findClienteById (@PathVariable UUID id){
        Cliente clienteDTO = clienteService.getClienteByID(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCliente (@PathVariable("id") UUID id){
        clienteService.apagarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/O")
    public String home(){
        return "Estou Ok";
    }
}
