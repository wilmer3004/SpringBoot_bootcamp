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
    private Integer id;
    @NotEmpty
    @Size(max=20,min=2)
    @Column (length = 20, nullable=false)
    private String nombre;
    @NotEmpty
    @Size(min=2,max=5)
    private String sigla;
    // Relaciones
    @OneToMany(mappedBy = "tipodoc", fetch = FetchType.LAZY, cascade =
    CascadeType.ALL)
    private List<Cliente> clientes;
    public TipoDocumento() {
    }
    public TipoDocumento(Integer id, @NotEmpty @Size(max = 20, min = 2) String nombre,
            @NotEmpty @Size(min = 2, max = 5) String sigla, List<Cliente> clientes) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
        this.clientes = clientes;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
