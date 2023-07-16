package com.ventas.ventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;
    @NotEmpty
    @Size(min=2, max=20)
    @Column(length=20,nullable=false)
    private String nombreVehiculo;
    @NotEmpty
    @Size(min=2,max=12)
    @Column(length = 12, nullable = false)
    private String placa;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    public Vehiculo() {
    }
    public Vehiculo(Integer idVehiculo, @NotEmpty @Size(min = 2, max = 20) String nombreVehiculo,
            @NotEmpty @Size(min = 2, max = 12) String placa, Cliente cliente) {
        this.idVehiculo = idVehiculo;
        this.nombreVehiculo = nombreVehiculo;
        this.placa = placa;
        this.cliente = cliente;
    }
    public Integer getIdVehiculo() {
        return idVehiculo;
    }
    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    public String getNombreVehiculo() {
        return nombreVehiculo;
    }
    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    




}
