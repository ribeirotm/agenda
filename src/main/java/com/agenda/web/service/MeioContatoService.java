package com.agenda.web.service;

import com.agenda.web.model.MeioContato;
import com.agenda.web.repository.MeioContatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paulo Ribeiro
 */
@Service
public class MeioContatoService {
    
    @Autowired
    private MeioContatoRepository repository;

    public List<MeioContato> findAll() {
	return repository.findAll();
    }
 
    public MeioContato findOne(Integer id) {
	return repository.findOne(id);
    }

    public MeioContato save(MeioContato meioContato) {
	return repository.saveAndFlush(meioContato);
    }

    public void delete(Integer id) {
	repository.delete(id);
    }
    
}
