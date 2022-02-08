package com.project.firstweb.parameters.controllers;

import com.project.firstweb.parameters.models.Country;
import com.project.firstweb.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        model.addAttribute("countries", countryService.getAll());
        return "/parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String addCountry(){
        return "/parameters/countryAdd";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id, Model model){
        Country country = countryService.findById(id);
        model.addAttribute("country",country);
        return "/parameters/countryEdit";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countryDetails/{id}")
    public String details(@PathVariable Integer id, Model model){
        Country country = countryService.findById(id);
        model.addAttribute("country",country);
        return "/parameters/countryDetails";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String edit(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }
}
