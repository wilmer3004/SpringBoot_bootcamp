package com.ventas.ventas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping(value={"/home","/index","/"})
    public String home() {
        return "index";
    }
}
