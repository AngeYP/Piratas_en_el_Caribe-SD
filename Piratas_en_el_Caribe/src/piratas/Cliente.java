
package piratas;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import piratas.Barco;

public class Cliente {
    static int puertoRMI=1022;

    
    public static void main(String args[]){
        try{
            Registry registro = LocateRegistry.getRegistry("localhost",puertoRMI);
            InterfazServidor h = (InterfazServidor)registro.lookup("servidor1");
            System.out.println("Lookup for servidor1 completed");
            System.out.println("***Buenviaje, " + " Mugiwara.");
            Vector listaNodos = new Vector();
            listaNodos.addElement("servidor1");
            listaNodos.addElement("servidor2");
            listaNodos.addElement("servidor3");
            Agente a = new Agente("Tripulacion de los Mugiwara",listaNodos,puertoRMI);
            h.recibe(a);
            //System.out.println(a.barco.getTripulacion());
            System.out.println("***Buen trabajo, Mugiwara");
        }
        catch(Exception e){
            System.out.println("Excepción en main :"+e);
        }
    }//finmain
}