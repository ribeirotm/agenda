package com.agenda.web.controller;

import com.agenda.web.model.Endereco;
import com.agenda.web.service.EnderecoService;
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
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;
    
    @GetMapping("/endereco")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/endereco");
        mv.addObject("enderecos", service.findAll());
	
        return mv;
    }

    @GetMapping("/endereco/add")
    public ModelAndView add(Endereco endereco) {

        ModelAndView mv = new ModelAndView("/enderecoAdd");
        mv.addObject("endereco", endereco);

        return mv;
    }

    @GetMapping("/endereco/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

        return add(service.findOne(id));
    }

    @GetMapping("/endereco/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        service.delete(id);

        return findAll();
    }

    @PostMapping("/endereco/save")
    public ModelAndView save(@Valid Endereco endereco, BindingResult result) {

        if (result.hasErrors()) {
            return add(endereco);
        }

        service.save(endereco);

        return findAll();
    }   
    
}
