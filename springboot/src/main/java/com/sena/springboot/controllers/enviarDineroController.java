package com.sena.springboot.controllers;
import com.sena.springboot.Model.enviarDinero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class enviarDineroController {
    @GetMapping(value = ("/enviarDinero"))
    public String enviarDinero(Model m) {
        enviarDinero enviar = new  enviarDinero();
        enviar.setId(1);
        enviar.setSaldo(50000);
        enviar.setValorDinero(10000);
        enviar.setEnviarDinero(15000);
        enviar.setEstado(false);
        m.addAttribute("enviarD", enviar);
        return "view/enviardinero";
        
    }
}
