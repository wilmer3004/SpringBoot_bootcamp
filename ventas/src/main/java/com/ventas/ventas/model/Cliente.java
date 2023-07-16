package com.ventas.ventas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Cliente {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min=2,max=20)
    @Column(length = 50,nullable=false)
    private String nombre;
    @NotEmpty
    @Size(min=2,max=20)
    private String apellido;
    @NotEmpty
    @Email
    @Column(length=80, nullable=false)
    private String email;
    @NotNull
    @Column(length = 20)
    private Long telefono;
    @Column
    private Boolean estado;
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipodoc;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade =
    CascadeType.ALL)
    private List<Vehiculo> vehiculos;
    
    public Cliente() {
    }

    public Cliente(Integer id, @NotEmpty @Size(min = 2, max = 20) String nombre,
            @NotEmpty @Size(min = 2, max = 20) String apellido, @NotEmpty @Email String email, @NotNull Long telefono,
            Boolean estado, TipoDocumento tipodoc, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.tipodoc = tipodoc;
        this.vehiculos = vehiculos;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDocumento tipodoc) {
        this.tipodoc = tipodoc;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
}
