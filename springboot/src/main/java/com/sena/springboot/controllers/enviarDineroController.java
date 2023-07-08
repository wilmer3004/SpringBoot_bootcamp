package com.sena.springboot.controllers;
import com.sena.springboot.Model.enviarDinero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class enviarDineroController {
    @GetMapping(value = ("/enviardinero"))
    public String enviarDinero(Model m) {
        List<enviarDinero> enviar=new ArrayList<>();
        enviar.add(new enviarDinero(1, 15000, 1000, 5000, true));
        enviar.add(new enviarDinero(2, 20000, 1000, 7000, true));
        enviar.add(new enviarDinero(3, 30000, 1000, 8000, true));
        enviar.add(new enviarDinero(4, 10000, 1000, 9000, false));

        m.addAttribute("enviarD", enviar);
        
        return "view/enviardinero";
        
    }

}
