/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahoy_Mateys;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Mapa {
    
    public ArrayList<Isla> isla;
    public Calamidad calamidad;
    
    public Mapa(){
        isla = new ArrayList<Isla>();
        calamidad = new Calamidad("Leviatan",20);
//        for (int i = 1; i < Cantidad_isla;i++){
//            isla[i] = new Isla ("Isla " + i);
//        }
        //CrearIslaEntrada();
       // System.out.println(isla[1]);
    }
    
    public void setIsla(String nombre){
        int i;
        Isla isla = new Isla(nombre);
        for (i = 0; i < this.isla.size(); i++){
            if (this.isla.get(i).getNombre() == nombre)
                break;
        }
        if (i == this.isla.size())
            this.isla.add(isla);
    }
    
    public void setIslaPuerto(String nombre_isla, String nombre_puerto){
        for(int i = 0; i < isla.size();i++){
            if (isla.get(i).getNombre() == nombre_isla && nombre_puerto != ""){
                //System.out.println("Isla: "+nombre_isla);
                isla.get(i).agregar_entrada(nombre_puerto);
            }
        }
    }
    public String getIsla(int i){
        return "Llegando a "+isla.get(i).getNombre();
    }
    
    public void getIslas(){
        for(int i = 0; i <isla.size();i++){
            System.out.println((i+1)+" Isla: "+isla.get(i).getNombre());
            Servidor.contador ++;
        }
        
    }
    
    public void getIslaPuerto(){
        for(int i = 0; i <isla.size();i++){
            System.out.println("Isla: "+isla.get(i).getNombre());
            isla.get(i).mostrar_puerto();
        }
    }
//    public void CrearIslaEntrada(){
//        isla[1].agregar_entrada("Puerto 1");
//        isla[1].agregar_entrada("Puerto 2");
//        isla[1].agregar_entrada("Puerto 3");
//        isla[2].agregar_entrada("Puerto 12");
//        isla[3].agregar_entrada("Puerto 13");
//    }
    
    public void MostrarIslaEntradaBarco(int i){
        isla.get(i).mostrar_entrada_barco();
    }
    
    public void agregarTesoroIsla_Puerto(String nombre_puerto, String nombre_tesoro, int peso){

        isla.get(isla.size()-1).agregar_cofre_puerto(nombre_puerto, nombre_tesoro, peso);

    }
    
    public void mostrarTesoroIsla_Puerto(){
        for(int i = 0; i <isla.size();i++){
            System.out.println("Isla: "+isla.get(i).getNombre());
            //isla.get(i).mostrar_puerto();
            isla.get(i).getTesorosIsla();
        }
    }
}
