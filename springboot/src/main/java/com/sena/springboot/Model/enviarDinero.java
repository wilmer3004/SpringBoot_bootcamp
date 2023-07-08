package com.sena.springboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class enviarDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "saldo", length=30)
    private Integer saldo;
    @NotNull
    @Column
    private Integer enviarDinero;
    @NotNull
    @Column( length=20, nullable=false)
    private Integer valorDinero;
    @Column
    private Boolean estado;

   public enviarDinero(){
   }
   


public enviarDinero(Integer id, @NotNull Integer saldo, @NotNull Integer enviarDinero, @NotNull Integer valorDinero,
        Boolean estado) {
    this.id = id;
    this.saldo = saldo;
    this.enviarDinero = enviarDinero;
    this.valorDinero = valorDinero;
    this.estado = estado;
}


public Integer getId() {
    return id;
}


public void setId(Integer id) {
    this.id = id;
}


public Integer getSaldo() {
    return saldo;
}


public void setSaldo(Integer saldo) {
    this.saldo = saldo;
}


public Integer getEnviarDinero() {
    return enviarDinero;
}


public void setEnviarDinero(Integer enviarDinero) {
    this.enviarDinero = enviarDinero;
}


public Integer getValorDinero() {
    return valorDinero;
}


public void setValorDinero(Integer valorDinero) {
    this.valorDinero = valorDinero;
}


public Boolean getEstado() {
    return estado;
}


public void setEstado(Boolean estado) {
    this.estado = estado;
}


   
}
