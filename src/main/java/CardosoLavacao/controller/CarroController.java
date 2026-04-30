package CardosoLavacao.controller;

import CardosoLavacao.service.CarroService;
import CardosoLavacao.dto.carroCliente.CarroClienteRequestDTO;
import CardosoLavacao.dto.carroCliente.CarroClienteResponseDTO;
import CardosoLavacao.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/carro")
@Controller
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<CarroClienteResponseDTO> cadastrarCarro (@RequestBody CarroClienteRequestDTO carroRequestDTO){
        Carro carroCadastrado = carroService.cadastrarCarro(carroRequestDTO);
        return ResponseEntity.ok(new CarroClienteResponseDTO(carroCadastrado));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Carro> atualizarCarro (@PathVariable UUID id,@RequestBody CarroClienteRequestDTO carroRequestDTO){
        Carro carroAtualizado = carroService.atualizarCarro(id,carroRequestDTO);
        return ResponseEntity.ok(carroAtualizado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro> findCarroById (@PathVariable UUID id){
        Carro carroDTO = carroService.getCarroByID(id);
        return ResponseEntity.ok(carroDTO);
    }

    @GetMapping(value="/cliente/{clienteId}/carro/{carroId}")
    public ResponseEntity<Carro> buscaCarroCliente (@PathVariable UUID clienteId,@PathVariable UUID carroId){
        Carro carroDTO = carroService.getCarroCliente(clienteId, carroId);
        return ResponseEntity.ok(carroDTO);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCarro (@PathVariable("id") UUID id){
        carroService.apagarCarro(id);
        return ResponseEntity.noContent().build();
    }
}
