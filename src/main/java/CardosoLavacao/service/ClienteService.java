package CardosoLavacao.service;

import CardosoLavacao.Exceptions.Cliente.ClienteException;
import CardosoLavacao.model.Role;
import CardosoLavacao.model.Usuario;
import CardosoLavacao.repository.ClienteRepository;
import CardosoLavacao.dto.cliente.ClienteRequestDTO;
import CardosoLavacao.model.Cliente;
import CardosoLavacao.repository.RoleRepository;
import CardosoLavacao.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private static final String ROLE_CLIENTE = "CLIENTE";

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Cliente criarCliente(ClienteRequestDTO data) {

        if(data.senha() == null || !data.senha().equals(data.confSenha())) {
            throw new ClienteException("Senha e confirmação de senha não são iguais!");
        }
        if (usuarioRepository.findByCpf(data.cpf()).isPresent()) {
            throw new ClienteException("Já existe um usuário cadastrado com este CPF.");
        }

        //Criando um novo cadastro de cliente.
        Cliente newCliente = new Cliente();
        //Preenchimento dos dados dos cliente.
        newCliente.setNome(data.nome());
        newCliente.setTelefone(data.telefone());
        newCliente.setDataNascimento(data.dataNascimento());

        //Cria um novo cadastro de carro
        Carro carro = new Carro();
        //Preenche as informações do carro
        carro.setNomeCarro(data.nomeCarro());
        carro.setMarca(data.marca());
        carro.setPlaca(data.placa());
        carro.setMercosul(Boolean.TRUE.equals(data.mercosul()));
        carro.setCliente(newCliente);
        carroRepository.save(carro);

        //Cria um novo cadastro de usuário
        Usuario usuario = new Usuario();
        //Preenche as informações do usuário
        usuario.setCpf(data.cpf());
        usuario.setSenha(passwordEncoder.encode(data.senha()));
        usuario.setConfSenha(passwordEncoder.encode(data.confSenha()));
        usuario.setCliente(newCliente);
        usuario.setRoles(List.of(
                getOrCreateRole("CLIENTE")
        ));
        usuarioRepository.save(usuario);

        return clienteRepository.save(newCliente);
    }

    private Role getOrCreateRole(String nomeRole) {
        return roleRepository.findByNome(nomeRole).orElseGet(() -> {
            Role novaRole = new Role();
            novaRole.setNome(nomeRole);
            return roleRepository.save(novaRole);
        });
    }

    public Cliente getClienteById(UUID id){
        return clienteRepository.findClienteById(id).orElseThrow
                (() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente atualizarCliente(UUID id, ClienteRequestDTO clienteRequestDTO) {
        Cliente atualizaCliente = getClienteById(id);
        atualizaCliente.setNome(clienteRequestDTO.nome());
        atualizaCliente.setTelefone(clienteRequestDTO.telefone());

        return clienteRepository.save(atualizaCliente);
    }

    public void apagarCliente(UUID id) {
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }




}
