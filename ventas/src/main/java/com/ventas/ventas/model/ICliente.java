package com.ventas.ventas.model;
import java.util.List;

public interface ICliente {

    public List<Cliente> findAll();
    public void save (Cliente cliente);
    public Cliente findOne(int id);
    public void delete(Integer id);
}
