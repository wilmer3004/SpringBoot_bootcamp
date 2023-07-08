package com.sena.springboot.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.springboot.Model.enviarDinero;

@Controller
public class ver {
//         @GetMapping("/view/ver/{id}")
// public String ver1(@PathVariable int id, Model m){
//     m.addAttribute("id", "El id recibido es "+id);
//     return "view/ver";
// }
@GetMapping("/ver")
public String ver1(Model m){
    enviarDinero enviar = new enviarDinero();
    m.addAttribute("enviardinero",enviar);
return "view/ver";
}
@PostMapping("/add")
public String add(@Valid enviarDinero enviar,BindingResult res, Model m){
    if (res.hasErrors()){
        return "view/ver";
    }
m.addAttribute("enviardinero",enviar);
return "view/resultados";
}

}

