package com.sena.springboot.Model;



public class enviarDinero {
   private int id;
   private int saldo;
   private int enviarDinero;
   private int valorDinero;
   private boolean estado;

   public enviarDinero(){
   }
   public enviarDinero(int id, int saldo, int enviarDinero, int valorDinero, boolean estado){
    this.id=id;
    this.saldo = saldo;
    this.enviarDinero = enviarDinero;
    this.valorDinero = valorDinero;
    this.estado = estado;
   }
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getSaldo() {
    return saldo;
}
public void setSaldo(int saldo) {
    this.saldo = saldo;
}
public int getEnviarDinero() {
    return enviarDinero;
}
public void setEnviarDinero(int enviarDinero) {
    this.enviarDinero = enviarDinero;
}
public int getValorDinero() {
    return valorDinero;
}
public void setValorDinero(int valorDinero) {
    this.valorDinero = valorDinero;
}
public void setEstado(boolean estado) {
    this.estado = estado;
}
public boolean getEstado() {
    return estado;
}
   
}
