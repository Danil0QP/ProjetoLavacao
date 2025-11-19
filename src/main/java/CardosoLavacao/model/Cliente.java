package CardosoLavacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Cliente {

    @Id
    private UUID id;
    private String nome;
    private Float telefone;
    @Column(unique = true)
    private String cpf;

}
