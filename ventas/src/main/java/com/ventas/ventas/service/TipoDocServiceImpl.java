package com.ventas.ventas.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.ITipoDoc;
import com.ventas.ventas.model.TipoDocumento;

@Service
public class TipoDocServiceImpl implements ITipoDocService {
    @Autowired
    private ITipoDoc tipoDoc1;
   @Override
    public List<TipoDocumento> findAll() {
    return (List<TipoDocumento>) tipoDoc1.findAll();
    }
    @Override
    public TipoDocumento findOne(Integer id) {
        return tipoDoc1.findById(id).orElse(null);
    }
    @Override
    public void save(TipoDocumento tipodoc) {
        tipoDoc1.save(tipodoc);
    }

    @Override
    public void delete(Integer id) {
        tipoDoc1.deleteById(id);
    }
    
 
    
}
