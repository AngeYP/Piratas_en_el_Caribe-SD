/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author angel
 */
public class Agente implements InterfazAgente{
    int indiceNodo; //cuál es el siguiente ordenador a visitar
    String nombre;
    Vector listaNodos; //el itinerario
    int puertoRMI = 12345;
    
    public Agente(String miNombre, Vector laListaComputadoras, int elPuertoRMI) {
        nombre = miNombre;
        listaNodos = laListaComputadoras;
        indiceNodo = 0;
        puertoRMI = elPuertoRMI;
    }
    
    //Este método define las tareas que realiza el agente
    //móvil una vez que llega a un servidor.
    public void ejecuta(){
        String actual, siguiente;
        dormir(2); //pausa para poder visualizarlo
        System.out.println("Aquí el agente 007!");
        actual = (String) listaNodos.elementAt(indiceNodo);
        indiceNodo++;
        if(indiceNodo < listaNodos.size()){
            //si hay más computadoras que visitar
            siguiente = (String) listaNodos.elementAt(indiceNodo);
            dormir(5);//pausa para poder visualizarlo
            try{
                //Localiza el registro RMI en el siguiente nodo
                Registry registro = LocateRegistry.getRegistry("localhost",puertoRMI);
                InterfazServidor h = (InterfazServidor) registro.lookup(siguiente);
                System.out.println("Buscando " + siguiente + " en " + actual + " completado ");
                dormir(5); //pausa para poder visualizarlo
                //Pide al servidor del siguiente nodo que reciba a
                //este agente.
                h.recibe(this);
            }//fintry
            catch(Exception e){
                System.out.println("Excepción en el ejecuta del Agente: " + e);
            }
        }//finif    
        else{ //si se han hecho todas las paradas
            dormir(5);//pausa para poder visualizarlo
            System.out.println("El Agente 007 ha regresado a casa");
            dormir(5);//pausa para poder visualizarlo
        }
    }
            
        //El método dormir suspende la ejecución de este objeto
        //un número determinado de segundos.
        static void dormir (double time){
            try{
                Thread.sleep((long)(time*1000.0));
            }
            catch(InterruptedException e){
                System.out.println("excepción en dormir");
            }
        }//findormir
}
        


    





