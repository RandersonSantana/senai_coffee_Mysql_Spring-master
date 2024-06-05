package br.com.senai.repositories;

import br.com.senai.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository   extends JpaRepository<Agenda,Long> {
}
