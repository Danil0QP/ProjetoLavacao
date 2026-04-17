package CardosoLavacao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tipoServico;
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

}
