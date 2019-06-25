package com.agenda.web.service;

import com.agenda.web.model.Endereco;
import com.agenda.web.repository.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paulo Ribeiro
 */
@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll() {
	return repository.findAll();
    }
 
    public Endereco findOne(Integer id) {
	return repository.findOne(id);
    }

    public Endereco save(Endereco endereco) {
	return repository.saveAndFlush(endereco);
    }

    public void delete(Integer id) {
	repository.delete(id);
    }
    
}
