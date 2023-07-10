package com.ventas.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.model.ICliente;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private ICliente cliented;
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) cliented.findAll();
    }
    @Override
        public Cliente findOne(Integer id) {
        return cliented.findById(id).orElse(null);
    }
    public void save(Cliente cliente) {
        cliented.save(cliente);
    }
    @Override
    public void delete(Integer id) {
    cliented.deleteById(id);

    }
}