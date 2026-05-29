package CardosoLavacao.service;

import CardosoLavacao.dto.carroCliente.CarroClienteRequestDTO;
import CardosoLavacao.dto.carroCliente.CarroClienteResponseDTO;
import CardosoLavacao.model.CarroCliente;
import CardosoLavacao.model.Cliente;
import CardosoLavacao.model.ModeloCarro;
import CardosoLavacao.repository.CarroClienteRepository;
import CardosoLavacao.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarroClienteService {

    private final CarroClienteRepository carroClienteRepository;
    private final ClienteRepository clienteRepository;
    private final ModeloCarroService modeloCarroService;

    public CarroClienteService(CarroClienteRepository carroClienteRepository, ClienteRepository clienteRepository, ModeloCarroService modeloCarroService) {
        this.carroClienteRepository = carroClienteRepository;
        this.clienteRepository = clienteRepository;
        this.modeloCarroService = modeloCarroService;
    }

    public CarroCliente criar(UUID clienteId, @Valid CarroClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ModeloCarro modelo = modeloCarroService.buscarPorId(dto.modeloId());
        if (!modelo.isAtivo()) {
            throw new RuntimeException("Carro inativo");
        }

        carroClienteRepository.findByPlaca(dto.placa()).ifPresent(c -> {
            throw new RuntimeException("Placa já cadastrada");
        });

        CarroCliente carro = new CarroCliente();
        carro.setCliente(cliente);
        carro.setModelo(modelo);
        carro.setPlaca(dto.placa().toUpperCase());
        carro.setMercosul(dto.mercosul());
        return carroClienteRepository.save(carro);
    }

    public List<CarroClienteResponseDTO> listarPorCliente(UUID clienteId, String placa) {
        CarroCliente carroCliente = carroClienteRepository.findByPlacaAndClienteId(placa, clienteId)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

        return List.of (new CarroClienteResponseDTO(carroCliente));
    }
}








