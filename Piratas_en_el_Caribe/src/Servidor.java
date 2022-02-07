
package piratas;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Servidor extends UnicastRemoteObject implements InterfazServidor{
    static int puertoRMI = 1022;
    static int contador = 0;
    static Mapa mapa = new Mapa();
    public Servidor() throws RemoteException{
        super();

    }
    
    public void viaje(Agente h) throws RemoteException{
        System.out.println("Navegando.....");
        System.out.println("Obteniendo datos del mapa.....");
        System.out.println();
        mapa.getIslas();
        Scanner sc = new Scanner(System.in);
        int num_isla;
        while(true){
            System.out.println("A que isla deseas ir?");
            num_isla = sc.nextInt();
            if (num_isla >= 1 && num_isla <=contador)
                break;
        }
        contador = 0;
        num_isla--;
        System.out.println(mapa.getIsla(num_isla));
        System.out.println("Buscando puertos....." );
        mapa.isla.get(num_isla).mostrar_puerto();
        int num_puerto = 0;
        if (contador > 0){
            while(true){
                System.out.println("A que puerto deseas ir? ");
                num_puerto = sc.nextInt();
                if (num_puerto >= 1 && num_puerto <=contador)
                    break;
            }
            num_puerto --;
            System.out.println("Tesoros encontrados: ");
            contador = 0;
            mapa.isla.get(num_isla).getTesoroIslaPuerto(num_puerto);        
        }
        else
        {
            num_puerto --;
            System.out.println("Tesoros encontrados: ");
            contador = 0;
            mapa.isla.get(num_isla).getTesorosIsla();  
        }
        
        System.out.println("Deseas tomar algun tesoro? (y/n) ");
        char opcion = sc.next().charAt(0);
        if (num_puerto >= 0){
            while(opcion == 'y'){
                int num_tesoro;
                System.out.println("Escoge un tesoro ");
                num_tesoro = sc.nextInt();
                if (num_tesoro >= 1 && num_tesoro <=contador 
                        && h.barco.ComprobarCapacidad() >= mapa.isla.get(num_isla).puerto.get(num_puerto).cofre.tesoro.get(num_tesoro-1).peso){
//                      mapa.isla.get(num_isla).puerto.get(num_puerto).obtenerTesoroPuerto();
                    h.barco.setCofreCapacidad(mapa.isla.get(num_isla).puerto.get(num_puerto).cofre.tesoro.get(num_tesoro-1).peso);
                    h.barco.cofre.AgregarTesoro
                                  (mapa.isla.get(num_isla).puerto.get(num_puerto).TomarTesoros(num_tesoro));
                    
                    System.out.println("Deseas tomar otro tesoro? (y/n)");
                    char option = sc.next().charAt(0);
                    if (option == 'n')
                        break;
                    System.out.println();
                    contador = 0;
                    System.out.println("Tesoro obtenidos del barco");
                    System.out.println(h.barco.getCofreCapacidad());
                    System.out.println();
                    mapa.isla.get(num_isla).getTesoroIslaPuerto(num_puerto);
                    
                }
                else{
                    System.out.println("Cofre lleno..... dejando isla");
                    break;
                }
            }
        }
        else{
            while(opcion == 'y'){
                int num_tesoro;
                System.out.println("Escoge un tesoro ");
                num_tesoro = sc.nextInt();
                if (num_tesoro >= 1 && num_tesoro <=contador && 
                        h.barco.ComprobarCapacidad() >= mapa.isla.get(num_isla).cofre.tesoro.get(num_tesoro-1).peso){
                     h.barco.setCofreCapacidad(mapa.isla.get(num_isla).cofre.tesoro.get(num_tesoro-1).peso);
                    h.barco.cofre.AgregarTesoro
                                  (mapa.isla.get(num_isla).TomarTesoros(num_tesoro));
                    System.out.println("Deseas tomar otro tesoro? (y/n)");
                    char option = sc.next().charAt(0);
                    if (option == 'n')
                        break;
                    System.out.println();
                    contador = 0;
                    System.out.println("Tesoro obtenidos del barco");
                    System.out.println(h.barco.getCofreCapacidad());
                    System.out.println();
                    mapa.isla.get(num_isla).getTesorosIsla(); 
                    
                }
                else{
                    System.out.println("Cofre lleno..... dejando isla");
                    break;
                }
            }
        }
        
    }
    
    public void recibe(Agente h) throws RemoteException{
        dormir(3);//pausa para poder visualizarlo
        System.out.println("*****el Agente " + h.getNombre() + " ha llegado." );
        viaje(h);
        //mapa.mostrarTesoroIsla_Puerto();
        h.ejecuta();
        
    }
    
    public static void main(String args[]) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(is);
        String s;
        String miNombre;    
        miNombre = JOptionPane.showInputDialog("Ingrese el nombre del servidor\nservidor1\nservidor2\nservidor3");
        ServidorXML servidor = new ServidorXML();
        switch (miNombre) {
            case "servidor1":
                mapa = servidor.listUbicaciones.get(0);
                break;
            case "servidor2":
                mapa = servidor.listUbicaciones.get(1);
                break;
            case "servidor3":
                mapa = servidor.listUbicaciones.get(2);
                break;
            default:
                break;
        }
        //Nota:Los servidores se espera que se arranquen con los
        //argumentos 1, 2 y 3 de la linea de mandatos respectivamente,
        try{
            Servidor h = new Servidor();
            Registry registro = LocateRegistry.createRegistry(puertoRMI);
            registro.rebind( miNombre, h);
            System.out.println("*******************************");
            System.out.println("Agente "+miNombre+" listo.");
            System.out.println("*******************************");
            System.out.println();
            System.out.println();
        }//fintry
        catch(RemoteException re){
            System.out.println("Excepción en el main del Servidor:" + re);
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
