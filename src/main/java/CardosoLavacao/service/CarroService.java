package CardosoLavacao.service;

import CardosoLavacao.repository.CarroRepository;
import CardosoLavacao.dto.carro.CarroRequestDTO;
import CardosoLavacao.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro cadastrarCarro (CarroRequestDTO data){

        Carro newCarro = new Carro();
        newCarro.setNome(data.nome());
        newCarro.setMarca(data.marca());
        newCarro.setPlaca(data.placa());
        newCarro.setMercosul(data.mercosul());
        return carroRepository.save(newCarro);
    }

    public Carro getCarroByID(UUID id){
        return carroRepository.findCarroByID(id).orElseThrow
                (() -> new RuntimeException("Carro não encontrado"));
    }

    public Carro atualizarCarro (UUID id, CarroRequestDTO carroRequestDTO) {
        Carro atualizaCarro = getCarroByID(id);
        atualizaCarro.setNome(carroRequestDTO.nome());
        atualizaCarro.setMarca(carroRequestDTO.placa());
        atualizaCarro.setMercosul(carroRequestDTO.mercosul());

        return carroRepository.save(atualizaCarro);
    }

    public void apagarCarro (UUID id){
        Carro carro = getCarroByID(id);
        carroRepository.delete(carro);
    }
}
