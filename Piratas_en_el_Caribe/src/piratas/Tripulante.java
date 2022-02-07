/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;
import java.io.Serializable;
/**
 *
 * @author DELL
 */
public class Tripulante implements Serializable{
    
    public String estado;
    public int numero_tripulante;
    
    public Tripulante(int numero_tripulante){
        this.estado = "Normal";
        this.numero_tripulante = numero_tripulante;
    }

    public int getNumero_tripulante() {
        return numero_tripulante;
    }
    
    
    
    public void setEstado(String nuevo_estado){
        this.estado = nuevo_estado;

    }
    public String getEstado(){
        return estado;
    }
}
