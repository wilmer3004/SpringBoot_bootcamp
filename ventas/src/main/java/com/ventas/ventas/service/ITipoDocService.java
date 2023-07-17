package com.ventas.ventas.service;
import java.util.List;

import com.ventas.ventas.model.TipoDocumento;

public interface ITipoDocService {
    public List<TipoDocumento> findAll();
    public void save (TipoDocumento tipodoc);
    public TipoDocumento findOne(Integer idtipodoc);
    public void delete(Integer idtipodoc);
}
