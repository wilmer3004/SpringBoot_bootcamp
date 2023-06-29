package com.sena.springboot.controllers;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class indexController {
    @GetMapping(path={"/index","/home"})
   /*public String index(){
        return "index";
    }*/
    public ModelAndView index2(ModelAndView mv){
        mv.addObject("msn","Este mensaje viene del controlador ");
        mv.setViewName("index");
        return mv;
    }
//     public String index(Model m){
//     m.addAttribute("msn", "Este mensaje viene del controlador ");
//     return "index";
// }

    

}
