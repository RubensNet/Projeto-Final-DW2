package br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
