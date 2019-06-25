package com.agenda.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Paulo Ribeiro
 */
@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView findAll() {

	ModelAndView mv = new ModelAndView("/index");
	
	return mv;
    }

}
