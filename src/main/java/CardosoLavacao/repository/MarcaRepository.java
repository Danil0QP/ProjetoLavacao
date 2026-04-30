package CardosoLavacao.repository;

import CardosoLavacao.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MarcaRepository extends JpaRepository<Marca, UUID> {
    Optional<Marca> findByNomeIgnoreCase(String nome);
    List<Marca> findByAtivoTrueOrderByNomeAsc();
}