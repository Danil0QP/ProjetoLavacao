package CardosoLavacao.Controller;

import CardosoLavacao.Repository.CarroRepository;
import CardosoLavacao.Service.CarroService;
import CardosoLavacao.dto.carro.CarroRequestDTO;
import CardosoLavacao.dto.carro.CarroResponseDTO;
import CardosoLavacao.model.Carro;
import org.apache.coyote.Response;
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
    public ResponseEntity<CarroResponseDTO> cadastrarCarro (@RequestBody CarroRequestDTO carroRequestDTO){
        Carro carroCadastrado = carroService.cadastrarCarro(carroRequestDTO);
        return ResponseEntity.ok(new CarroResponseDTO(carroCadastrado));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Carro> atualizarCarro (@PathVariable UUID id,@RequestBody CarroRequestDTO carroRequestDTO){
        Carro carroAtualizado = carroService.atualizarCarro(id,carroRequestDTO);
        return ResponseEntity.ok(carroAtualizado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro> findCarroById (@PathVariable UUID id){
        Carro carroDTO = carroService.getCarroByID(id);
        return ResponseEntity.ok(carroDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCarro (@PathVariable("id") UUID id){
        carroService.apagarCarro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/0")
    public String home(){return "I'm OK";}
}
