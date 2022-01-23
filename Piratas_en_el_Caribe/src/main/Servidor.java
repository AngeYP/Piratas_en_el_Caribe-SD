/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

/**
 *
 * @author angel
 */
public class Servidor extends RemoteException implements InterfazServidor{
    static int puertoRMI = 12345;
    public Servidor() throws RemoteException{
        super();
    }
    
    public void recibe(Agente h) throws RemoteException{
        dormir(3);//pausa para poder visualizarlo
        System.out.println("*****ei Agente " + h.nombre + " ha llegado." );
            h.ejecuta();
    }
    
    public static void main(String args[]) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(is);
        String s;
        String miNombre = "servidor" + args[0];
        //Nota:Los servidores se espera que se arranquen con los
        //argumentos 1, 2 y 3 de la linea de mandatos respectivamente,
        try{
            System.setSecurityManager(new RMISecurityManager());
            Servidor h = new Servidor();
            Registry registro =
                LocateRegistry.getRegistry(puertoRMI);
            registro.rebind( miNombre, h);
            System.out.println("*******************************");
            System.out.println("Agente"+miNombre+"listo.");
            System.out.println("*******************************");
        }//fintry
        catch(RemoteException re){
            System.out.println("ExcepciónenelmaindelServidor:" + re);
        }//fincatch
    }//finmain
    
    //El método dormir suspende la ejecución de este objeto
    //un número determinado de segundos.
    static void dormir(double time){
        try{
         Thread.sleep((long)(time*1000.0));
        }
        catch(InterruptedException e){
            System.out.println("excepción en dormir");
        }
    }//findormir
}//finclass
