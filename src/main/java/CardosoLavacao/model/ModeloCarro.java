package CardosoLavacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "modelo_carro", uniqueConstraints = @UniqueConstraint(name = "uk_modelo_marca_nome", columnNames = {"marca_id", "nome"}))
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private boolean ativo = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
}