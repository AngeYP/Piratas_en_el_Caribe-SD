/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author DELL
 */
public class Barco implements Serializable{
    
    public Cofre cofre;
    public Tripulante tripulacion [];
    public int raciones;
    public int municion;
    public ArrayList<Direccion> direServidores = new ArrayList();    

    
    public Barco(int tripulacion, int raciones, int municion){
        this.cofre= new Cofre(50);
        this.raciones = raciones;
        this.municion = municion;
        this.tripulacion = new Tripulante[tripulacion];
        
        for(int i = 0; i < tripulacion; i++){
            this.tripulacion[i] = new Tripulante(i);
        }
    }

    public void AtaqueATripulacion(int tripulantes_caidos) {
        Random random = new Random();
        while(tripulantes_caidos > 0){
            int numero_tripulante  = random.nextInt(tripulacion.length);
            if (tripulacion[numero_tripulante].getEstado() != "Muerto"){
                tripulacion[numero_tripulante].setEstado("Muerto");
                tripulantes_caidos --;
            }                       
        }
    }
    
    
    public void eventoTripulante(){
        Random random = new Random();
        int numero_evento  = random.nextInt(10);
        //System.out.println(numero_evento);
        if (numero_evento % 2 == 1){
            int condicion = random.nextInt(3);
            int numero_tripulante = random.nextInt(tripulacion.length);
            if (condicion == 0){
                tripulacion[numero_tripulante].setEstado("Cansado");
            }
            if (condicion == 1){
                tripulacion[numero_tripulante].setEstado("Mal");
            }
            if (condicion == 2){
                tripulacion[numero_tripulante].setEstado("Muerto");
            }
        }
        
    }
    
    
    public String getTripulacionEstado(){
        int tripulantes_vivo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas ver el estado de tu tripulacion? (y/n)");
        char opcion = sc.next().charAt(0);
        
        for(int i = 0; i < tripulacion.length; i++){
            if (opcion == 'y')
                System.out.println("Tripulante: "+tripulacion[i].getNumero_tripulante()+
                                  " Estado: "+tripulacion[i].getEstado());
            if(tripulacion[i].getEstado() != "Muerto")
                tripulantes_vivo++;
        }
        String respuesta = "Tienes "+tripulantes_vivo+" tripulantes";
        return respuesta;
    }

    public String  getTripulacion() {
        return "Tienes "+tripulacion.length+" tripulantes";
    }

    
    public void setRaciones(int raciones) {
        this.raciones = raciones;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    
    public String getCofreCapacidad(){
        return cofre.getCapacidad();
    }
    
    public void mostrarCofre(){
        cofre.getTesoros();
    }
    
    
    public String getRaciones(){
        return "Cantidad de raciones: "+raciones;
    }
    
    public String getMunicion(){
        return "Cantidad de municion: "+municion;
    }
    
    public ArrayList<Direccion> getDireServidores() {
        return direServidores;
    }

    public void setDireServidores(ArrayList<Direccion> direServidores) {
        this.direServidores = direServidores;
    }
}
