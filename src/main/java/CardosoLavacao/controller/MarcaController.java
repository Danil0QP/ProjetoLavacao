package CardosoLavacao.controller;

import CardosoLavacao.dto.marca.MarcaRequestDTO;
import CardosoLavacao.dto.marca.MarcaResponseDTO;
import CardosoLavacao.dto.modelo.ModeloCarroResponseDTO;
import CardosoLavacao.model.Marca;
import CardosoLavacao.service.MarcaService;
import CardosoLavacao.service.ModeloCarroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;
    private final ModeloCarroService modeloCarroService;

    public MarcaController(MarcaService marcaService, ModeloCarroService modeloCarroService) {
        this.marcaService = marcaService;
        this.modeloCarroService = modeloCarroService;
    }

    @PostMapping
    public ResponseEntity<MarcaResponseDTO> criar(@Valid @RequestBody MarcaRequestDTO dto) {
        Marca marca = marcaService.criar(dto);
        return ResponseEntity.ok(new MarcaResponseDTO(marca));
    }

    @GetMapping
    public ResponseEntity<List<MarcaResponseDTO>> listarAtivas() {
        return ResponseEntity.ok(marcaService.listarAtivas().stream().map(MarcaResponseDTO::new).toList());
    }

    @GetMapping(value = "/{marcaId}/modelos")
    public ResponseEntity<List<ModeloCarroResponseDTO>> listarModelosPorMarca(@PathVariable UUID marcaId) {
        return ResponseEntity.ok(modeloCarroService.listarPorMarca(marcaId).stream().map(ModeloCarroResponseDTO::new).toList());
    }
}
