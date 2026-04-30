package CardosoLavacao.controller;

import CardosoLavacao.dto.carroCliente.CarroClienteRequestDTO;
import CardosoLavacao.dto.carroCliente.CarroClienteResponseDTO;
import CardosoLavacao.model.CarroCliente;
import CardosoLavacao.service.CarroClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes/{clienteId}/carros")
public class CarroClienteController {

    private final CarroClienteService carroClienteService;

    public CarroClienteController(CarroClienteService carroClienteService) {
        this.carroClienteService = carroClienteService;
    }

    @PostMapping
    public ResponseEntity<CarroClienteResponseDTO> criar(@PathVariable UUID clienteId,
                                                         @Valid @RequestBody CarroClienteRequestDTO dto) {
        CarroCliente carro = carroClienteService.criar(clienteId, dto);
        return ResponseEntity.ok(new CarroClienteResponseDTO(carro));
    }

    @GetMapping
    public ResponseEntity<List<CarroClienteResponseDTO>> listarPorCliente(@PathVariable UUID clienteId) {
        return ResponseEntity.ok(carroClienteService.listarPorCliente(clienteId).stream().map(CarroClienteResponseDTO::new).toList());
    }
}