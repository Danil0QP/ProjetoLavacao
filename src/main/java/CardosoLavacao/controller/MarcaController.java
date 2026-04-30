package CardosoLavacao.controller;

import CardosoLavacao.dto.marca.MarcaRequestDTO;
import CardosoLavacao.dto.marca.MarcaResponseDTO;
import CardosoLavacao.model.Marca;
import CardosoLavacao.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
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
}