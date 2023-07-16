package com.ventas.ventas.service;

import com.ventas.ventas.model.TipoDocumento;
import java.util.List;
public interface ITipoDocService {
    public List<TipoDocumento> findAll();
    public void save (TipoDocumento tipodoc);
    public TipoDocumento findOne(Integer id);
    public void delete(Integer id);
}
