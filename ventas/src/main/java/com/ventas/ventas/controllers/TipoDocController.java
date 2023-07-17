package com.ventas.ventas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ventas.ventas.model.TipoDocumento;
import com.ventas.ventas.service.ITipoDocService;

@Controller
public class TipoDocController {
    @Autowired
    private ITipoDocService tipodocc;

    @GetMapping("/tipodoc/vertipodoc")
    public String vertipodoc(Model m) {
        m.addAttribute("tiposdocs",tipodocc.findAll());
        return "view/vertipodoc";
    }
    @GetMapping("/tipodoc/form")
    public String formtipodoc(Model m){
        TipoDocumento tipodoc = new TipoDocumento();
        m.addAttribute("tipodoc",tipodoc);
        m.addAttribute("accion", "Registrar Tipo Documento");
        return "view/formtipodoc";
    }
    @GetMapping("/tipodoc/form2/{idtipodoc}")
    public String ver2tipodoc(@PathVariable int idtipodoc,Model m){
    TipoDocumento tipodoc=null;
            if(idtipodoc>0){
                tipodoc=tipodocc.findOne(idtipodoc);
            }
            else{
                return "redirect:/tipodoc/vertipodoc";
            }
            m.addAttribute("tipodoc", tipodoc);
            m.addAttribute("accion", "Actualizar Tipo De Documento");
            return "view/formtipodoc";
    }
    
    @PostMapping("/tipodoc/add")
        public String addtipodoc(@Valid TipoDocumento tipodoc, BindingResult res, Model m, SessionStatus status) {
            if(res.hasErrors()){
            m.addAttribute("tipodoc",tipodoc);
            m.addAttribute("accion", "Registrar Tipo documento");
                return "view/formtipodoc";
            }
            tipodocc.save(tipodoc);
            status.setComplete();
            return "redirect:/tipodoc/vertipodoc";
    }
    @GetMapping("/tipodoc/delete/{idtipodoc}")
        public String delete(@PathVariable Integer idtipodoc){
            if(idtipodoc>0){
                tipodocc.delete(idtipodoc);
            }
            return "redirect:/tipodoc/vertipodoc";
        }

    }
