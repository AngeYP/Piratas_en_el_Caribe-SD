
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
            num_puerto--;
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
                if (num_tesoro >= 1 && num_tesoro <=contador){

                    h.barco.cofre.AgregarTesoro
                                  (mapa.isla.get(num_isla).puerto.get(num_puerto).TomarTesoros(num_tesoro));
                    System.out.println("Deseas tomar otro tesoro? (y/n)");
                    char option = sc.next().charAt(0);
                    if (option == 'n')
                        break;
                    System.out.println();
                    contador = 0;
                    mapa.isla.get(num_isla).getTesoroIslaPuerto(num_puerto);
                }    
            }
        }
        else{
            while(opcion == 'y'){
                int num_tesoro;
                System.out.println("Escoge un tesoro ");
                num_tesoro = sc.nextInt();
                if (num_tesoro >= 1 && num_tesoro <=contador){
                    h.barco.cofre.AgregarTesoro
                                  (mapa.isla.get(num_isla).TomarTesoros(num_tesoro));
                    System.out.println("Deseas tomar otro tesoro? (y/n)");
                    char option = sc.next().charAt(0);
                    if (option == 'n')
                        break;
                    System.out.println();
                    contador = 0;
                    mapa.isla.get(num_isla).getTesorosIsla(); 
                }
            }
        }
        
    }
    
    public void recibe(Agente h) throws RemoteException{
        dormir(3);//pausa para poder visualizarlo
        System.out.println("*****La " + h.getNombre() + " ha llegado.*****" );
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
        ServidorXML servidor = null;
        switch (miNombre) {
            case "servidor1":
                servidor = new ServidorXML(1);
                mapa = servidor.listUbicaciones.get(0);
                puertoRMI = 1022;                
                break;
            case "servidor2":
                servidor = new ServidorXML(2);
                mapa = servidor.listUbicaciones.get(0);
                puertoRMI = 1023;                
                break;
            case "servidor3":
                servidor = new ServidorXML(3);
                mapa = servidor.listUbicaciones.get(0);
                puertoRMI = 1024;                
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
            System.out.println("Region "+miNombre+" listo.");
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
