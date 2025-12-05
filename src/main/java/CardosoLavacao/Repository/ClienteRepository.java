package CardosoLavacao.Repository;

import CardosoLavacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Optional<Cliente> findClienteById (UUID id);

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Optional<Cliente> findClienteByCpf (@Param("cpf") String cpf);
}
