package CardosoLavacao.repository;

import CardosoLavacao.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, UUID> {

    @Query("SELECT s FROM Servico s WHERE s.id = :id")
    Optional<Servico> findById (UUID id);
}
