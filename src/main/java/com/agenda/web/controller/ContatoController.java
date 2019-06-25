package com.agenda.web.controller;

import com.agenda.web.model.Contato;
import com.agenda.web.service.ContatoService;
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
public class ContatoController {
    
    @Autowired
    private ContatoService service;
    
    @GetMapping("/contato")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/contato");
        mv.addObject("contatos", service.findAll());

        return mv;
    }

    @GetMapping("/contato/add")
    public ModelAndView add(Contato contato) {

        ModelAndView mv = new ModelAndView("/contatoAdd");
        mv.addObject("contato", contato);

        return mv;
    }

    @GetMapping("/contato/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

        return add(service.findOne(id));
    }

    @GetMapping("/contato/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        service.delete(id);

        return findAll();
    }

    @PostMapping("/contato/save")
    public ModelAndView save(@Valid Contato contato, BindingResult result) {

        if (result.hasErrors()) {
            return add(contato);
        }

        service.save(contato);

        return findAll();
    }   
    
}
