package CardosoLavacao.service;

import CardosoLavacao.dto.carroCliente.CarroClienteRequestDTO;
import CardosoLavacao.repository.CarroRepository;
import CardosoLavacao.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro cadastrarCarro (CarroClienteRequestDTO data){

        Carro newCarro = new Carro();
        newCarro.setNomeCarro(data.nome());
        newCarro.setMarca(data.marca());
        newCarro.setPlaca(data.placa());
        newCarro.setMercosul(data.mercosul());
        return carroRepository.save(newCarro);
    }

    public Carro getCarroByID(UUID id){
        return carroRepository.findCarroById(id).orElseThrow
                (() -> new RuntimeException("Carro não encontrado"));
    }

    public Carro getCarroCliente(UUID clienteId, UUID carroId){
        return carroRepository.findCarroByIdAndCliente_id(carroId, clienteId)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado para o cliente!"));
    }

    public Carro atualizarCarro (UUID id, CarroClienteRequestDTO carroRequestDTO) {
        Carro atualizaCarro = getCarroByID(id);
        atualizaCarro.setNomeCarro(carroRequestDTO.nome());
        atualizaCarro.setMarca(carroRequestDTO.marca());
        atualizaCarro.setMercosul(carroRequestDTO.mercosul());

        return carroRepository.save(atualizaCarro);
    }

    public void apagarCarro (UUID id){
        Carro carro = getCarroByID(id);
        carroRepository.delete(carro);
    }
}
