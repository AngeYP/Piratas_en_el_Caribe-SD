/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahoy_Mateys;
import java.io.Serializable;
/**
 *
 * @author DELL
 */
public class Tesoro implements Serializable{
    
    public String nombre;
    public int peso;
    public int valor;
    
    public Tesoro(String nombre, int peso, int valor){
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }
    
    
}
