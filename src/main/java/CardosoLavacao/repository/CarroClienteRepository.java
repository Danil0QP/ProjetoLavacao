package CardosoLavacao.repository;

import CardosoLavacao.model.CarroCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarroClienteRepository extends JpaRepository<CarroCliente, UUID> {
    Optional<CarroCliente> findByPlaca(String placa);
    List<CarroCliente> findByClienteId(UUID clienteId);
}