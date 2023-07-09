package com.ventas.ventas.model;
import java.util.List;

public interface ICliente {

    public List<Cliente> findAll();
    public void save (Cliente cliente);
}
