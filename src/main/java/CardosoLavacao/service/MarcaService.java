package CardosoLavacao.service;

import CardosoLavacao.dto.marca.MarcaRequestDTO;
import CardosoLavacao.model.Marca;
import CardosoLavacao.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca criar(MarcaRequestDTO dto) {
        marcaRepository.findByNomeIgnoreCase(dto.nome()).ifPresent(m -> {
            throw new RuntimeException("Marca já cadastrada");
        });
        Marca marca = new Marca();
        marca.setNome(dto.nome());
        marca.setAtivo(dto.ativo());
        return marcaRepository.save(marca);
    }

    public List<Marca> listarAtivas() {
        return marcaRepository.findByAtivoTrueOrderByNomeAsc();
    }

    public Marca buscarPorId(UUID id) {
        return marcaRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }
}