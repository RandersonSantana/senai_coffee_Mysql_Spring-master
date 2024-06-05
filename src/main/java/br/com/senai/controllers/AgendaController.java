package br.com.senai.controllers;

import br.com.senai.models.Agenda;
import br.com.senai.repositories.AgendamentoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/agenda")
public class AgendaController {
    AgendamentoRepository agendamentoRepository;

    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agenda> getAllAgenda(){
        return agendamentoRepository.findAll();
    }

    @PostMapping(value="/createAgenda",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agenda createAgenda(@RequestBody Agenda agenda){
        Agenda newAgenda = new Agenda();
        newAgenda.setName(agenda.getName());
        newAgenda.setData(agenda.getData());
        newAgenda.setHora(agenda.getHora());
        newAgenda.setTelefone(agenda.getTelefone());
        return agendamentoRepository.save(newAgenda);
    }

    @PutMapping(value="/updateAgenda",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agenda updateAgenda(@RequestBody Agenda agenda){
        Agenda geAgenda = agendamentoRepository.findById(agenda.getId()).orElseThrow();
        Agenda updateAgenda = new Agenda();
        updateAgenda.setName(agenda.getName());
        updateAgenda.setData(agenda.getData());
        updateAgenda.setHora(agenda.getHora());
        updateAgenda.setTelefone(agenda.getTelefone());
        return agendamentoRepository.save(updateAgenda);
    }

    @DeleteMapping(value="/deleteAgenda/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Agenda deleteAgenda(@PathVariable Long id){
        Agenda getAgenda = agendamentoRepository.findById(id).orElseThrow();
        agendamentoRepository.delete(getAgenda);
        return getAgenda;
    }
}
