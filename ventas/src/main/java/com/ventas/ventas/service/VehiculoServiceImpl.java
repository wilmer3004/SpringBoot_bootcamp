package com.ventas.ventas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.IVehiculo;
import com.ventas.ventas.model.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
    @Autowired
    private IVehiculo vehiculoc;
    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoc.findAll();
    }

    @Override
    public void save(Vehiculo vehiculo) {
        vehiculoc.save(vehiculo);
    }

    @Override
    public Vehiculo findOne(Integer idVehiculo) {
        return vehiculoc.findById(idVehiculo).orElse(null);
    }

    @Override
    public void delete(Integer idVehiculo) {
        vehiculoc.deleteById(idVehiculo);
    }
    
}
