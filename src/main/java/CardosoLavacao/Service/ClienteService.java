package CardosoLavacao.Service;

import CardosoLavacao.Repository.ClienteRepository;
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
        //Criando um novo cadastro de cliente.
        Cliente newCliente = new Cliente();
        //Preenchimento dos dados dos cliente.
        newCliente.setNome(data.nome());
        newCliente.setTelefone(data.telefone());
        newCliente.setCpf(data.cpf());
        clienteRepository.save(newCliente);
        return newCliente;
    }

    public Cliente getClienteByID(UUID id){
        return clienteRepository.findClienteById(id).orElseThrow
                (() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente atualizarCliente(UUID id, ClienteRequestDTO clienteRequestDTO) {
        Cliente atualizaCliente = getClienteByID(id);
        atualizaCliente.setNome(clienteRequestDTO.nome());
        atualizaCliente.setTelefone(clienteRequestDTO.telefone());
        atualizaCliente.setCpf(clienteRequestDTO.cpf());

        return clienteRepository.save(atualizaCliente);
    }

    public void apagarCliente(UUID id) {
        Cliente cliente = getClienteByID(id);
        clienteRepository.delete(cliente);
    }


}
