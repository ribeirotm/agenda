package com.agenda.web.service;

import com.agenda.web.model.Contato;
import com.agenda.web.repository.ContatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paulo Ribeiro
 */
@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository repository;

    public List<Contato> findAll() {
	return repository.findAll();
    }
 
    public Contato findOne(Integer id) {
	return repository.findOne(id);
    }

    public Contato save(Contato contato) {
	return repository.saveAndFlush(contato);
    }

    public void delete(Integer id) {
	repository.delete(id);
    }
    
}
