package com.agenda.web.repository;

import com.agenda.web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paulo Ribeiro
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
