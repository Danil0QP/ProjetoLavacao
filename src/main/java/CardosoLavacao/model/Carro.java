package CardosoLavacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeCarro;
    private String marca;
    private String placa;
    private boolean mercosul = true;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
