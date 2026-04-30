package CardosoLavacao.service;

import CardosoLavacao.dto.modelo.ModeloCarroRequestDTO;
import CardosoLavacao.model.Marca;
import CardosoLavacao.model.ModeloCarro;
import CardosoLavacao.repository.ModeloCarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModeloCarroService {

    private final ModeloCarroRepository modeloCarroRepository;
    private final MarcaService marcaService;

    public ModeloCarroService(ModeloCarroRepository modeloCarroRepository, MarcaService marcaService) {
        this.modeloCarroRepository = modeloCarroRepository;
        this.marcaService = marcaService;
    }

    public ModeloCarro criar(ModeloCarroRequestDTO dto) {
        Marca marca = marcaService.buscarPorId(dto.marcaId());
        ModeloCarro modelo = new ModeloCarro();
        modelo.setNome(dto.nome());
        modelo.setAtivo(dto.ativo());
        modelo.setMarca(marca);
        return modeloCarroRepository.save(modelo);
    }

    public List<ModeloCarro> listarPorMarca(UUID marcaId) {
        return modeloCarroRepository.findByMarcaIdAndAtivoTrueOrderByNomeAsc(marcaId);
    }

    public ModeloCarro buscarPorId(UUID id) {
        return modeloCarroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));
    }
}