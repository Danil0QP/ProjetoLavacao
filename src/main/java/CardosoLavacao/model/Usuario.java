package CardosoLavacao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @JsonIgnore
    @Column(nullable = false)
    private String senha;

    @JsonIgnore
    @Column(nullable = false, name = "conf_senha")
    private String confSenha;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if (roles == null) {
            return Collections.emptyList();
        }
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getNome()))
                .toList();
    }

    @Override public String getUsername() {return cpf;}
    @Override public String getPassword() {return senha;}

    @Override public boolean isAccountNonExpired(){return true;}
    @Override public boolean isAccountNonLocked(){return true;}
    @Override public boolean isCredentialsNonExpired(){return true;}
    @Override public boolean isEnabled(){return true;}

}
