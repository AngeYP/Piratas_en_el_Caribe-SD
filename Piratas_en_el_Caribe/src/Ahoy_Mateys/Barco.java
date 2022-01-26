/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahoy_Mateys;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Barco {
    
    public int Cofre;
    public Tripulante tripulacion [];
    public int raciones;
    public int municion;
    
    
    public Barco(int tripulacion, int raciones, int municion){
        this.Cofre= 50;
        this.raciones = raciones;
        this.municion = municion;
        this.tripulacion = new Tripulante[tripulacion];
        
        for(int i = 0; i < tripulacion; i++){
            this.tripulacion[i] = new Tripulante(i);
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
    
    
    public String getTripulacion(){
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

    public void setCofre(int Cofre) {
        this.Cofre = Cofre;
    }

    public void setRaciones(int raciones) {
        this.raciones = raciones;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    
    public String getCofre(){
        return "Capacidad del barco: "+Cofre+" libras";
    }
    
    public String getComida(){
        return "Cantidad de raciones: "+raciones;
    }
    
    public String getMunicion(){
        return "Cantidad de municion: "+municion;
    }
}
