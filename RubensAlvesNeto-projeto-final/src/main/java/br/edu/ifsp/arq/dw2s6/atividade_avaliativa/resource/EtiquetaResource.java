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

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Etiqueta;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository.EtiquetaRepository;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.service.EtiquetaService;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaResource {
	
	@Autowired
	private EtiquetaRepository EtiquetaRepository;
	
	@Autowired
	private EtiquetaService EtiquetaService;
	
	@GetMapping
	public List<Etiqueta> listar(){
		return EtiquetaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Etiqueta criar(@Valid @RequestBody Etiqueta Etiqueta, HttpServletResponse response) {
		return EtiquetaRepository.save(Etiqueta);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Etiqueta> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Etiqueta> Etiqueta = EtiquetaRepository.findById(codigo);
		if(Etiqueta.isPresent()) {
			return ResponseEntity.ok(Etiqueta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		EtiquetaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Etiqueta> atualizar(@PathVariable Long codigo, @Valid @RequestBody Etiqueta Etiqueta){
		Etiqueta EtiquetaSalva = EtiquetaService.atualizar(codigo, Etiqueta);
		return ResponseEntity.ok(EtiquetaSalva);
	}		
}
