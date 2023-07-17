package com.ventas.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ventas.ventas.model.ITipoDoc;
import com.ventas.ventas.model.TipoDocumento;

@Service
public class TipoDocServiceImpl implements ITipoDocService {
    @Autowired
    private ITipoDoc tipodocc;
    @Override
    public List<TipoDocumento> findAll() {
        return (List<TipoDocumento>) tipodocc.findAll();
    }
    @Override
    public TipoDocumento findOne(Integer idtipodoc) {
        return tipodocc.findById(idtipodoc).orElse(null);
    }
    @Override
    public void save(TipoDocumento tipodoc) {
        tipodocc.save(tipodoc);
    }

    @Override
    public void delete(Integer idtipodoc) {
        tipodocc.deleteById(idtipodoc);
    }
    
}
