package CardosoLavacao.Service;

import CardosoLavacao.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public ClienteDTO criarUsuario(ClienteDTO clienteDTO) {
        return clienteDTO;
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        return clienteDTO;
    }

    public ClienteDTO findClienteById(Long id) {
        return null;
    }

    public void apagarCliente(Long id) {
    }
}
