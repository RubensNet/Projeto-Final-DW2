package br.edu.ifsp.arq.dw2s6.atividade_avaliativa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.atividade_avaliativa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariosRepository;

	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalva = buscarusuarioPeloCodigo(codigo);
		BeanUtils.copyProperties(usuario, usuarioSalva, "codigo");
		return usuariosRepository.save(usuarioSalva);
	}	
	
	private Usuario buscarusuarioPeloCodigo(Long codigo) {
		Usuario usuarioSalva = usuariosRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return usuarioSalva;
	}

}
