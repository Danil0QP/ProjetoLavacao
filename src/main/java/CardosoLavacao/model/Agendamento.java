package CardosoLavacao.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime dataHoraAgendamento;


    @Enumerated(EnumType.STRING)
    private Pagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    private Status statusAgendamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro", nullable = false)
    private Carro carro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico",  nullable = false)
    private Servico servico;

    public void setServico(UUID uuid) {
    }

    public void setCarro(UUID uuid) {
    }

    public void setCliente(UUID uuid) {
    }
}
