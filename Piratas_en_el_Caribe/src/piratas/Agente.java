package piratas;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import piratas.Barco;
import piratas.ClienteXML;

public class Agente implements InterfazAgente {

    int indiceNodo; //cuál es el siguiente ordenador a visitar
    String nombre;
    Vector listaNodos; //el itinerario
    int puertoRMI = 1022;
    boolean conecto1 = false;
    public Barco barco;
    ClienteXML cliente = new ClienteXML();

    public Agente(String miNombre, Vector laListaComputadoras, int elPuertoRMI) {
        nombre = miNombre;
        listaNodos = laListaComputadoras;
        indiceNodo = 0;
        puertoRMI = elPuertoRMI;
        barco = new Barco(cliente.tripulacion, cliente.raciones, cliente.municion);
    }

    public String getNombre() {
        return nombre;
    }

    //Este método define las tareas que realiza el agente
    //móvil una vez que llega a un servidor.
    public void ejecuta() {
        String actual, siguiente;
        dormir(2); //pausa para poder visualizarlo
        //System.out.println("Aquí el agente 007!");
        System.out.println("Datos del barco");
        System.out.println(barco.getTripulacionEstado());
        System.out.println(barco.getMunicion());
        System.out.println(barco.getRaciones());
        barco.cofre.getTesoros();

        for (int i = 0; i < 3; i++) {
            actual = (String) listaNodos.elementAt(indiceNodo);
            indiceNodo++;
            if (indiceNodo < listaNodos.size() && !conecto1) {
                //si hay más computadoras que visitar
                siguiente = (String) listaNodos.elementAt(indiceNodo);
                dormir(5);//pausa para poder visualizarlo
                try {
                    //Localiza el registro RMI en el siguiente nodo
                    this.puertoRMI++;
                    Registry registro = LocateRegistry.getRegistry("localhost", puertoRMI);

                    InterfazServidor h = (InterfazServidor) registro.lookup(siguiente);
                    System.out.println("Buscando " + siguiente + " en " + actual + " completado ");
                    dormir(5); //pausa para poder visualizarlo
                    //Pide al servidor del siguiente nodo que reciba a
                    //este agente.
                    h.recibe(this);
                    if (indiceNodo == 1) {
                        conecto1 = true;
                    }
                }//fintry
                catch (Exception e) {
                    System.out.println("Excepción en el ejecuta del Agente: " + e);
                }
            }//finif    
            else { //si se han hecho todas las paradas
                dormir(5);//pausa para poder visualizarlo
                System.out.println("La tripulacion de los Mugiwara ha regresado a casa");
                dormir(5);//pausa para poder visualizarlo
                break;
            }
        }
    }

    //El método dormir suspende la ejecución de este objeto
    //un número determinado de segundos.
    static void dormir(double time) {
        try {
            Thread.sleep((long) (time * 1000.0));
        } catch (InterruptedException e) {
            System.out.println("excepción en dormir");
        }
    }//findormir
}
