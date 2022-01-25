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
public class Cliente {
    static int puertoRMI=1022;
    public static void main(String args[]){
        try{
            Registry registro = LocateRegistry.getRegistry("localhost",puertoRMI);
            InterfazServidor h = (InterfazServidor)registro.lookup("servidor1");
            System.out.println("Lookup for servidor1 completed");
            System.out.println("***Buenviaje, " + " agent 007.");
            Vector listaNodos = new Vector();
            listaNodos.addElement("servidor1");
            listaNodos.addElement("servidor2");
            listaNodos.addElement("servidor3");
            Agente a = new Agente("007",listaNodos,puertoRMI);
            h.recibe(a);
            System.out.println("***Buen trabajo,007");
        }
        catch(Exception e){
            System.out.println("Excepción en main :"+e);
        }
    }//finmain
}