package CardosoLavacao.controller;

import CardosoLavacao.service.ClienteService;
import CardosoLavacao.dto.cliente.ClienteRequestDTO;
import CardosoLavacao.dto.cliente.ClienteResponseDTO;
import CardosoLavacao.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = {"http://127.0.0.1:5500",
        "http://localhost:5500", "127.0.0.1:5500", "https://cardosolavacao.rf.gd"})
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping(value = "/criar-cliente")
    public ResponseEntity<ClienteResponseDTO> criarCliente (@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
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
        Cliente clienteDTO = clienteService.getClienteById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCliente (@PathVariable("id") UUID id){
        clienteService.apagarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
