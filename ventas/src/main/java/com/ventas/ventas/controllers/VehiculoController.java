package com.ventas.ventas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.model.Vehiculo;
import com.ventas.ventas.service.IClienteService;
import com.ventas.ventas.service.IVehiculoService;

@Controller
public class VehiculoController {
    @Autowired
    private IClienteService clienteds;
    @Autowired
    private IVehiculoService vehiculoc;

    @GetMapping("/vehiculo/vervehiculo")
    public String verVeh(Model m) {
        m.addAttribute("vehiculos",vehiculoc.findAll());
        return "view/vervehiculo";
    }
    @GetMapping("/vehiculo/formvehiculo")
    public String formvehiculo(Model m){
        Vehiculo vehiculo = new Vehiculo();
        List<Cliente> listacl = clienteds.findAll();
        m.addAttribute("vehiculo",vehiculo);
        m.addAttribute("clientesreg", listacl);
        m.addAttribute("accion", "Registrar Vehiculo");
        return "view/formvehiculo";
    }
    @GetMapping("/vehiculo/form2/{idVehiculo}")
    public String ver2vh(@PathVariable int idVehiculo,Model m){
    Vehiculo vehiculo=null;
            if(idVehiculo>0){
                vehiculo=vehiculoc.findOne(idVehiculo);
            }
            else{
                return "redirect:/vehiculo/vervehiculo";
            }
            List<Cliente> listacl = clienteds.findAll();
            m.addAttribute("vehiculo", vehiculo);
            m.addAttribute("clientesreg", listacl);
            m.addAttribute("accion", "Actualizar Vehiculo");
            return ("view/formvehiculo");
    }

@PostMapping("/vehiculo/add")
    public String addvh(@Valid Vehiculo vehiculo, BindingResult res, Model m, SessionStatus status) {
        if(res.hasErrors()){
            return "view/formvehiculo";
        }
        vehiculoc.save(vehiculo);
        status.setComplete();
        return "redirect:/vehiculo/vervehiculo";
}
@GetMapping("/vehiculo/delete/{idVehiculo}")
public String delete(@PathVariable Integer idVehiculo){
    if(idVehiculo>0){
        vehiculoc.delete(idVehiculo);
    }
    return "redirect:/vehiculo/vervehiculo";
}
}