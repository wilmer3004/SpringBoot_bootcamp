package com.ventas.ventas.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipodocs")
public class TipoDocumento {
    // Atributos
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idtipodoc;

    @NotEmpty
    @Size(min=2,max=20)
    @Column (length = 20,nullable = false)
        private String nombretipodoc;

    @NotEmpty
    @Size(min=2,max=5)
    @Column (length = 5, nullable = false)
        private String sigla;
        
    // Relaciones
    @OneToMany(mappedBy = "tipodoc", fetch = FetchType.LAZY, cascade =
    CascadeType.ALL)
        private List<Cliente> clientes;
    public TipoDocumento() {
    }
    public TipoDocumento(Integer idtipodoc, @NotEmpty @Size(min = 2, max = 20) String nombretipodoc,
            @NotEmpty @Size(min = 2, max = 5) String sigla, List<Cliente> clientes) {
        this.idtipodoc = idtipodoc;
        this.nombretipodoc = nombretipodoc;
        this.sigla = sigla;
        this.clientes = clientes;
    }
    public Integer getIdtipodoc() {
        return idtipodoc;
    }
    public void setIdtipodoc(Integer idtipodoc) {
        this.idtipodoc = idtipodoc;
    }
    public String getNombretipodoc() {
        return nombretipodoc;
    }
    public void setNombretipodoc(String nombretipodoc) {
        this.nombretipodoc = nombretipodoc;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
   
    
      
}
