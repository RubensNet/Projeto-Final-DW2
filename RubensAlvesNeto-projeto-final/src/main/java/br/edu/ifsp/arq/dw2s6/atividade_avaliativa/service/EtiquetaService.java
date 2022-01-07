package br.edu.ifsp.arq.dw2s6.atividade_avaliativa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Etiqueta;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository.EtiquetaRepository;

@Service
public class EtiquetaService {
	
	@Autowired
	private EtiquetaRepository EtiquetasRepository;

	public Etiqueta atualizar(Long codigo, Etiqueta Etiqueta) {
		Etiqueta EtiquetaSalva = buscarEtiquetaPeloCodigo(codigo);
		BeanUtils.copyProperties(Etiqueta, EtiquetaSalva, "codigo");
		return EtiquetasRepository.save(EtiquetaSalva);
	}	
	
	private Etiqueta buscarEtiquetaPeloCodigo(Long codigo) {
		Etiqueta EtiquetaSalva = EtiquetasRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return EtiquetaSalva;
	}

}
