package br.edu.ifsp.arq.dw2s6.atividade_avaliativa.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Tarefa;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository.TarefaRepository;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaRepository TarefaRepository;
	
	@Autowired
	private TarefaService TarefaService;
	
	@GetMapping
	public List<Tarefa> listar(){
		return TarefaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tarefa criar(@Valid @RequestBody Tarefa Tarefa, HttpServletResponse response) {
		return TarefaRepository.save(Tarefa);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Tarefa> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Tarefa> Tarefa = TarefaRepository.findById(codigo);
		if(Tarefa.isPresent()) {
			return ResponseEntity.ok(Tarefa.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		TarefaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Tarefa Tarefa){
		Tarefa TarefaSalva = TarefaService.atualizar(codigo, Tarefa);
		return ResponseEntity.ok(TarefaSalva);
	}		
}
