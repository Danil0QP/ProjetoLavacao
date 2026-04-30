package CardosoLavacao.repository;

import CardosoLavacao.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, UUID> {
    List<ModeloCarro> findByMarcaIdAndAtivoTrueOrderByNomeAsc(UUID marcaId);
}