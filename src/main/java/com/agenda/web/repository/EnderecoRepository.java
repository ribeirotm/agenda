package com.agenda.web.repository;

import com.agenda.web.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paulo Ribeiro
 */
@Repository 
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {}
