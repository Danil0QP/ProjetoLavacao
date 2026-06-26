package CardosoLavacao.repository;

import CardosoLavacao.model.Marca;
import CardosoLavacao.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, UUID> {
    List<ModeloCarro> findByMarcaIdAndAtivoTrueOrderByNomeAsc(UUID marcaId);
    List<ModeloCarro> findByNomeTrueOrderByNomeAsc();
    List<ModeloCarro> findByAtivoTrueOrderByNomeAsc();
    Optional<ModeloCarro> findByMarcaNomeIgnoreCaseAndNomeIgnoreCase(String marcaNome, String nome);
}