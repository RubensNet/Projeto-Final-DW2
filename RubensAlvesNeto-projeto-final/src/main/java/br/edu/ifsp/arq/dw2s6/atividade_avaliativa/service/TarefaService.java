package br.edu.ifsp.arq.dw2s6.atividade_avaliativa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Tarefa;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository TarefasRepository;

	public Tarefa atualizar(Long codigo, Tarefa Tarefa) {
		Tarefa TarefaSalva = buscarTarefaPeloCodigo(codigo);
		BeanUtils.copyProperties(Tarefa, TarefaSalva, "codigo");
		return TarefasRepository.save(TarefaSalva);
	}	
	
	private Tarefa buscarTarefaPeloCodigo(Long codigo) {
		Tarefa TarefaSalva = TarefasRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return TarefaSalva;
	}

}
