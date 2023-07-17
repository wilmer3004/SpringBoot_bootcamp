package com.ventas.ventas.controllers;

import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

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

import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.model.TipoDocumento;
// import com.ventas.ventas.model.ICliente;
// import org.springframework.web.bind.annotation.RequestParam;
import com.ventas.ventas.service.IClienteService;
import com.ventas.ventas.service.ITipoDocService;




@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private IClienteService cliented;
    @Autowired
    private ITipoDocService tipodoc;

    @GetMapping("/cliente/verc")
    public String verc(Model m) {
        // List<Cliente> clientes = new ArrayList<>();
        // clientes.add(new Cliente(1, "Sandra", "Rueda", "srueda@misena.edu.co", 300765432,false));
        // clientes.add(new Cliente(2, "Wilmer", "Capera", "wilmer.capera@misena.edu.co", 300765432,false));
        // m.addAttribute("clientes", clientes);
        m.addAttribute("clientes",cliented.findAll());
        return "view/verc";

    }
    @GetMapping("/cliente/form")
    public String form(Model m){
        Cliente cliente = new Cliente();
        List<TipoDocumento> listatd = tipodoc.findAll();
        m.addAttribute("cliente",cliente);
        m.addAttribute("tiposdoc", listatd);
        m.addAttribute("accion", "Registrar Cliente");
        return "view/form";
        }
    @GetMapping(value="/cliente/form2/{id}")
        public String ver2(@PathVariable int id,Model m  ) {
            Cliente cliente=null;
            if(id>0){
                cliente=cliented.findOne(id);
            }
            else{
                return "redirect:/cliente/verc";
            }
            List<TipoDocumento> listatd = tipodoc.findAll();
            m.addAttribute("cliente", cliente);
            m.addAttribute("tiposdoc", listatd);
            m.addAttribute("accion", "Actualizar Cliente");
            return ("view/form");
        }
    @PostMapping("/add")
    public String add(@Valid Cliente cliente, BindingResult res, Model m, SessionStatus status) {
        if(res.hasErrors()){
            List<TipoDocumento> listatd = tipodoc.findAll();
            m.addAttribute("cliente", cliente);
            m.addAttribute("tiposdoc", listatd);
            m.addAttribute("accion", "Actualizar Cliente");
            return "view/form";
        }
        cliented.save(cliente);
        status.setComplete();
        return "redirect:/cliente/verc";
    }
    @GetMapping("/cliente/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id>0){
            cliented.delete(id);
        }
        return "redirect:/cliente/verc";
    }
    
    




}
