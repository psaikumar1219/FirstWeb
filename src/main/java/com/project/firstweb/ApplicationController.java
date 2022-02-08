package com.project.firstweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String home(){
        return "/index";
    }

    @GetMapping("/hr")
    public String hr() { return "/hr/index"; }

    @GetMapping("/accounts")
    public String accounts() { return "/accounts/index"; }

    @GetMapping("/helpdesk")
    public String helpdesk() { return "/helpdesk/index"; }

    @GetMapping("/parameters")
    public String parameters() { return "/parameters/index"; }

    @GetMapping("/payroll")
    public String payroll() { return "/payroll/index"; }

    @GetMapping("/vehicle")
    public String vehicle() { return "/vehicle/index"; }

}
