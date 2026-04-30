package CardosoLavacao.controller;

import CardosoLavacao.dto.agendamento.AgendamentoRequestDTO;
import CardosoLavacao.dto.agendamento.AgendamentoResponseDTO;
import CardosoLavacao.model.Agendamento;
import CardosoLavacao.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendamento")
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

    @PreAuthorize("hasRole('CLIENTE')")
    @GetMapping(value = "/{clienteId}/agendamento")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAgendamentos(@PathVariable UUID clienteId){
        List<AgendamentoResponseDTO> lista = agendamentoService.listarAgendamento(clienteId);
        return  ResponseEntity.ok(lista);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/listaAgendamentos")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodosAgendamentos(UUID id){
        List<AgendamentoResponseDTO> listaTodos = agendamentoService.listarAgendamento(id);
        return ResponseEntity.ok(listaTodos);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarAgendamento(@PathVariable("id") UUID id){
        agendamentoService.apagarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
