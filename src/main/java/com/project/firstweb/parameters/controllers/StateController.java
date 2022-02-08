package com.project.firstweb.parameters.controllers;


import com.project.firstweb.parameters.models.State;
import com.project.firstweb.parameters.services.CountryService;
import com.project.firstweb.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("countries",countryService.findAll());
        model.addAttribute("states",stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    public String getAll(Model model){
        addModelAttribute(model);
        return "/parameters/stateList";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "/parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id,@PathVariable String op , Model model){
        addModelAttribute(model);
        model.addAttribute("state",stateService.findById(id));
        return "/parameters/state"+op;
    }

    @PostMapping("/parameters/states")
    public String save(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value = "/parameters/state/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value = "/parameters/state/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String edit(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }
}
