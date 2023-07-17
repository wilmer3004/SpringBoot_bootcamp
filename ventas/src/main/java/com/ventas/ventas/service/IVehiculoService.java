package com.ventas.ventas.service;

import com.ventas.ventas.model.Vehiculo;

public interface IVehiculoService {
    public java.util.List<Vehiculo> findAll();
    public void save(Vehiculo vehiculo);
    public Vehiculo findOne(Integer idVehiculo);
    public void delete(Integer idVehiculo);
}
