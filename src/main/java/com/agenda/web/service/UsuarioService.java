package com.agenda.web.service;

import com.agenda.web.model.Usuario;
import com.agenda.web.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
/**
 *
 * @author Paulo Ribeiro
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
	return repository.findAll();
    }

    public Usuario findOne(Integer id) {
	return repository.findOne(id);
    }

    public Usuario save(Usuario usuario) {
	return repository.saveAndFlush(usuario);
    }

    public void delete(Integer id) {
	repository.delete(id);
    }

}
