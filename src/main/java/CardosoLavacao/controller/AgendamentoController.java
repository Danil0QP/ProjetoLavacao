package CardosoLavacao.controller;

import CardosoLavacao.dto.agendamento.AgendamentoRequestDTO;
import CardosoLavacao.dto.agendamento.AgendamentoResponseDTO;
import CardosoLavacao.model.Agendamento;
import CardosoLavacao.repository.AgendamentoRepository;
import CardosoLavacao.repository.ClienteRepository;
import CardosoLavacao.service.AgendamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Agendamento")
@Controller
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping(value = "/agendar")
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO){
        Agendamento agendamentoCriado = agendamentoService.criarAgendamento(agendamentoRequestDTO);
        return ResponseEntity.ok(agendamentoCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable UUID id , @RequestBody AgendamentoRequestDTO agendamentoRequestDTO){
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamentoRequestDTO);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @GetMapping(value = "/{clientId}/agendamentos")
    public ResponseEntity<List<Agendamento>> listarAgendamentos(@PathVariable UUID clienteId){
        List<Agendamento> lista = agendamentoService.listarAgendamento(clienteId);
        return  ResponseEntity.ok(lista);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodosAgendamentos(UUID id){
        List<Agendamento> listaTodos = agendamentoService.listarAgendamento(id);
        return ResponseEntity.ok(listaTodos);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarAgendamento(@PathVariable("id") UUID id){
        agendamentoService.apagarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
