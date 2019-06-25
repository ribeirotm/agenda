package com.agenda.web.controller;

import com.agenda.web.model.MeioContato;
import com.agenda.web.service.MeioContatoService;
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
public class MeioContatoController {
    
    @Autowired
    private MeioContatoService service;
    
    @GetMapping("/meioContato")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/meioContato");
        mv.addObject("meioContatos", service.findAll());
	
        return mv;
    }

    @GetMapping("/meioContato/add")
    public ModelAndView add(MeioContato meioContato) {

        ModelAndView mv = new ModelAndView("/meioContatoAdd");
        mv.addObject("meioContato", meioContato);

        return mv;
    }

    @GetMapping("/meioContato/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

        return add(service.findOne(id));
    }

    @GetMapping("/meioContato/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        service.delete(id);

        return findAll();
    }

    @PostMapping("/meioContato/save")
    public ModelAndView save(@Valid MeioContato meioContato, BindingResult result) {

        if (result.hasErrors()) {
            return add(meioContato);
        }

        service.save(meioContato);

        return findAll();
    }   
    
}
