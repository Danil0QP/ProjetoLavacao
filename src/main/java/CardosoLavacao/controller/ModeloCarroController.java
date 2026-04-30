package CardosoLavacao.controller;

import CardosoLavacao.dto.modelo.ModeloCarroRequestDTO;
import CardosoLavacao.dto.modelo.ModeloCarroResponseDTO;
import CardosoLavacao.model.ModeloCarro;
import CardosoLavacao.service.ModeloCarroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/modelos")
public class ModeloCarroController {

    private final ModeloCarroService modeloCarroService;

    public ModeloCarroController(ModeloCarroService modeloCarroService) {
        this.modeloCarroService = modeloCarroService;
    }

    @PostMapping
    public ResponseEntity<ModeloCarroResponseDTO> criar(@Valid @RequestBody ModeloCarroRequestDTO dto) {
        ModeloCarro modelo = modeloCarroService.criar(dto);
        return ResponseEntity.ok(new ModeloCarroResponseDTO(modelo));
    }

    @GetMapping
    public ResponseEntity<List<ModeloCarroResponseDTO>> listarPorMarca(@RequestParam UUID marcaId) {
        return ResponseEntity.ok(modeloCarroService.listarPorMarca(marcaId).stream().map(ModeloCarroResponseDTO::new).toList());
    }
}