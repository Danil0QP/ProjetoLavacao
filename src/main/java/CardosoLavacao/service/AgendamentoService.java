package CardosoLavacao.service;

import CardosoLavacao.dto.agendamento.AgendamentoDTO;
import CardosoLavacao.dto.agendamento.AgendamentoRequestDTO;
import CardosoLavacao.model.*;
import CardosoLavacao.repository.AgendamentoRepository;
import CardosoLavacao.repository.CarroRepository;
import CardosoLavacao.repository.ClienteRepository;
import CardosoLavacao.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ServicoRepository servicoRepository;

    //Método para validação onde não permite 2 agendamentos no mesmo horário.
    public void validaHorario(LocalDateTime dataHoraAgendamento){

        if (agendamentoRepository.existsByDataHoraAgendamento(dataHoraAgendamento)){
            throw new RuntimeException("Já existe um agendamento nesse horário!");
        }
    }

    //Método para criação de um agendamento
    public Agendamento criarAgendamento(AgendamentoRequestDTO data){
        //validação do horário para não permitir criar 2 agendamentos para a mesma hora.
        validaHorario(data.dataHoraAgendamento());
        //Criando um novo agendamento.
        Agendamento newAgendamento = new Agendamento();
        //Preencimento com os dados do agendamento.
        Carro carro = carroRepository.findCarroById(data.carroId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado!"));
        Cliente cliente = clienteRepository.findClienteById(data.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        Servico servico = servicoRepository.findById(data.servicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        newAgendamento.setDataHoraAgendamento(data.dataHoraAgendamento());
        newAgendamento.setCarro(carro.getId());
        newAgendamento.setCliente(cliente.getId());
        newAgendamento.setServico(servico.getId());

        return agendamentoRepository.save(newAgendamento);
    }

    public List<Agendamento> listarAgendamento(UUID id){
        return agendamentoRepository.findByClienteIdOrderByDataHoraAgendamentoAsc(id);
    }

    public Agendamento buscarAgendamento(UUID id){
        return agendamentoRepository.findAgendamentoById(id).
                orElseThrow (() -> new RuntimeException("Agendamento não encontrado."));
    }

    public Agendamento atualizarAgendamento(UUID id, AgendamentoRequestDTO agendamentoRequestDTO){
        Agendamento atualizaAgendamento = buscarAgendamento(id);
        atualizaAgendamento.setDataHoraAgendamento(agendamentoRequestDTO.dataHoraAgendamento());
        atualizaAgendamento.setServico(agendamentoRequestDTO.servicoId());
        atualizaAgendamento.setCarro(agendamentoRequestDTO.carroId());
        atualizaAgendamento.setCliente(agendamentoRequestDTO.clienteId());

        return agendamentoRepository.save(atualizaAgendamento);
    }

    public void apagarAgendamento(UUID id){
        Agendamento agendamento = buscarAgendamento(id);
        agendamentoRepository.delete(agendamento);
    }

    public void cancelarAgendamento(UUID id){
        Agendamento agendamento = buscarAgendamento(id);

        if (agendamento.getStatusAgendamento() != Status.PENDENTE) {
            throw new RuntimeException("Só é possível cancelar um agendamento com o status (PENDENTE)");
        }

        agendamento.setStatusAgendamento(Status.CANCELADO);
    }

    public void confirmarAgendamento(UUID id){
        Agendamento agendamento = buscarAgendamento(id);

        if (agendamento.getStatusAgendamento() != Status.PENDENTE) {
            throw new RuntimeException("Só é possível confirmar um agendamento com o status (PENDENTE)");
        }

        agendamento.setStatusAgendamento(Status.CONCLUIDO);
    }
}
