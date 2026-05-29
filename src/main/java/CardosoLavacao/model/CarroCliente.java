package CardosoLavacao.model;

import CardosoLavacao.dto.carroCliente.CarroClienteResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "carro_cliente", uniqueConstraints = @UniqueConstraint(name = "uk_carro_cliente_placa", columnNames = "placa"))
public class CarroCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(nullable = false)
    private boolean mercosul = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    private ModeloCarro modelo;

    @OneToMany(mappedBy = "carro")
    private List<Agendamento> agendamentos;


}