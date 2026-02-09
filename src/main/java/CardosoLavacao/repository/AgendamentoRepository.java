package CardosoLavacao.repository;

import CardosoLavacao.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    @Query("SELECT a FROM Agendamento a WHERE a.cliente.id = :clienteId ORDER BY a.dataHoraAgendamento ASC")
    List<Agendamento> findByClienteIdOrderByDataHoraAgendamentoAsc (@Param("clienteId")UUID clienteId);

    Optional<Agendamento> findAgendamentoById(UUID id);

    boolean existsByDataHoraAgendamento(LocalDateTime dataHoraAgendamento);
}
