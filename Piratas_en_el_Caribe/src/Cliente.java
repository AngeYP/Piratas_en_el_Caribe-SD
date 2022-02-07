
package piratas;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;
import piratas.Barco;

public class Cliente {
    static int puertoRMI=1022;
    
    
    public static void main(String args[]){
        String escogerServer;
        escogerServer = JOptionPane.showInputDialog("Ingrese el nombre del servidor al que se desea conectar\nservidor1\nservidor2\nservidor3");
        try{
            Registry registro = LocateRegistry.getRegistry("localhost",puertoRMI);
//            InterfazServidor h = (InterfazServidor)registro.lookup(Servidor.miNombre);
            InterfazServidor h = (InterfazServidor)registro.lookup(escogerServer);
//            System.out.println("Lookup for servidor1 completed "+Servidor.miNombre);
            System.out.println("***Buenviaje, " + " agent 007.");
            Vector listaNodos = new Vector();
            switch (escogerServer) {
                case "servidor1":
                   listaNodos.addElement("servidor1");
                    break;
                case "servidor2":
                    listaNodos.addElement("servidor2");
                    break;
                case "servidor3":
                    listaNodos.addElement("servidor3");
                    break;
                default:
                    break;
            }
            Agente a = new Agente("007",listaNodos,puertoRMI);
            h.recibe(a);
            //System.out.println(a.barco.getTripulacion());
            System.out.println("***Buen trabajo,007");
        }
        catch(Exception e){
            System.out.println("Excepción en main :"+e);
        }
    }//finmain
}