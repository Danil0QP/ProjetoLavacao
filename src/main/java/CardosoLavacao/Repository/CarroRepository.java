package CardosoLavacao.Repository;

import CardosoLavacao.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c WHERE c.id = :id")
    Optional<Carro> findCarroByID (UUID id);
}
