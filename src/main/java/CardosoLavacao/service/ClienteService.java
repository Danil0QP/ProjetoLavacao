package CardosoLavacao.service;

import CardosoLavacao.Exceptions.Cliente.ClienteException;
import CardosoLavacao.model.Agendamento;
import CardosoLavacao.repository.ClienteRepository;
import CardosoLavacao.dto.cliente.ClienteRequestDTO;
import CardosoLavacao.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteRequestDTO data) {
        //Validação para o cadastro de CPF
        clienteRepository.findClienteByCpf(data.cpf()).ifPresent(c ->{
            throw new ClienteException("CPF já utilizado!");
        });
        //Criando um novo cadastro de cliente.
        Cliente newCliente = new Cliente();
        //Preenchimento dos dados dos cliente.
        newCliente.setNome(data.nome());
        newCliente.setTelefone(data.telefone());
        newCliente.setCpf(data.cpf());
        newCliente.setAdmin(data.admin());
        return clienteRepository.save(newCliente);
    }

    public Cliente getClienteById(UUID id){
        return clienteRepository.findClienteById(id).orElseThrow
                (() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente atualizarCliente(UUID id, ClienteRequestDTO clienteRequestDTO) {
        Cliente atualizaCliente = getClienteById(id);
        atualizaCliente.setNome(clienteRequestDTO.nome());
        atualizaCliente.setTelefone(clienteRequestDTO.telefone());
        atualizaCliente.setCpf(clienteRequestDTO.cpf());
        atualizaCliente.setAdmin(clienteRequestDTO.admin());

        return clienteRepository.save(atualizaCliente);
    }

    public void apagarCliente(UUID id) {
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }




}
