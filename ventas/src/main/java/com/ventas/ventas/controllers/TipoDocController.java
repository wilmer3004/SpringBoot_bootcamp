package com.ventas.ventas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ventas.ventas.model.TipoDocumento;
import com.ventas.ventas.service.ITipoDocService;

@Controller
@SessionAttributes("tipodoc")
public class TipoDocController {
    @Autowired
    private ITipoDocService tipoDoc1;


    @GetMapping("/tipodoc/vertipodoc")
    public String vertipdoc(Model m) {
        m.addAttribute("tiposdocs",tipoDoc1.findAll());
        return "view/vertipodoc";

    }
    @GetMapping("/tipodoc/form")
    public String formtipdoc(Model m) {
        TipoDocumento tipodoc = new TipoDocumento();
        m.addAttribute("tipodoc", tipodoc);
        m.addAttribute("accion", "Registrar Tipos de documentos");
        return("view/formtipodoc");
    }

    @GetMapping(value="/tipodoc/form2/{id}")
        public String vertip2(@PathVariable int id,Model m) {
            TipoDocumento tipodoc=null;
            if(id>0){
                tipodoc=tipoDoc1.findOne(id);
            }
            else{
                return "redirect:/tipodoc/vertipodoc";
            }
            m.addAttribute("tipodoc", tipodoc);
            m.addAttribute("accion", "Actualizar Tipo de documento");
            return ("view/formtipodoc");
        }

    @PostMapping("/tipodoc/add")
    public String addtipodoc(@Valid TipoDocumento tipodoc, BindingResult res, Model m, SessionStatus status) {
        if(res.hasErrors()){
            return "view/formtipodoc";
        }
        System.out.println(tipodoc);
        tipoDoc1.save(tipodoc);
        status.setComplete();
        return "redirect:/tipodoc/vertipodoc";
    }

    @GetMapping("/tipodoc/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id>0){
            tipoDoc1.delete(id);
        }
        return "redirect:/tipodoc/vertipodoc";
    }
}