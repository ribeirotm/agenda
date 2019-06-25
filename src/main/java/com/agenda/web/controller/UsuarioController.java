package com.agenda.web.controller;

import com.agenda.web.model.Usuario;
import com.agenda.web.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Paulo Ribeiro
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario")
    public ModelAndView findAll() {

	ModelAndView mv = new ModelAndView("/usuario");
	mv.addObject("usuarios", service.findAll());

	return mv;
    }

    @GetMapping("/usuario/add")
    public ModelAndView add(Usuario usuario) {

	ModelAndView mv = new ModelAndView("/usuarioAdd");
	mv.addObject("usuario", usuario);

	return mv;
    }

    //Vai para tela de edição (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/usuario/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

	return add(service.findOne(id));
    }

    //Exclue por seu ID e redireciona para a tela principal
    @GetMapping("/usuario/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

	service.delete(id);

	return findAll();
    }

    //Recebe um objeto preenchido do Thymeleaf e valida 
    //Se tudo estiver ok, salva e volta para tela principal
    //Se houver erro, retorna para tela atual exibindo as mensagens de erro
    @PostMapping("/usuario/save")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result) {

	if (result.hasErrors()) {
	    return add(usuario);
	}

	service.save(usuario);

	return findAll();
    }

}
