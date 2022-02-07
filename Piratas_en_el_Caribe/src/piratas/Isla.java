/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Isla {
    public String nombre;
    public ArrayList<Puerto> puerto ;
    public Cofre cofre;
    
    public Isla(String nombre){
        this.nombre = nombre;
        this.cofre = new Cofre(50);
        this.puerto = new ArrayList<Puerto>();
        //setCofreIsla();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void agregar_entrada(String nombre_entrada){
        if (nombre_entrada !=""){
            Puerto puerto = new Puerto(nombre_entrada);
            this.puerto.add(puerto);
        }
    }
    
    public void mostrar_entrada_barco(){
        if (puerto.size() > 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Esta isla tiene puerto/bahia/cueva ?a donde quieres ir?");
            for(int i = 0; i < puerto.size(); i++){
                System.out.println((i+1)+". "+puerto.get(i).getNombre());
            }
            int opcion = sc.nextInt();
            if (opcion > 0 && opcion < puerto.size()+1)
                System.out.println("Navegando hacia "+puerto.get(opcion-1).getNombre());
            
        }
    }
    
    public void mostrar_puerto(){
        if (puerto.size() > 0){
            for(int i = 0; i < puerto.size(); i++){
                System.out.println((i+1)+". "+puerto.get(i).getNombre());
                Servidor.contador ++;
            }   
        }
        else{
            System.out.println("No hay puertos");
        }
    }
    
    public void agregar_cofre_puerto(String nombre_puerto, String nombre_tesoro, int peso){
//        int var1 = 0;
//        int var2 = 0;
        if (puerto.size() >0){
            for(int i = 0; i < puerto.size(); i++){
                if (puerto.get(i).getNombre() == nombre_puerto){
                    puerto.get(i).agregarTesoroPuerto(nombre_tesoro, peso);
                }
//                var1++;
            }
        }
        else{
            setCofreIsla(nombre_tesoro,peso);
//            var2++;
        }
//        System.out.println("isla "+getNombre()+" Pueerto: "+puerto.size());
//        System.out.println("Var1: "+var1+"Var2: "+var2);
    }
    
    public void setCofreIsla(String nombre, int peso){
        Tesoro treasure = new Tesoro(nombre,peso,10);
        cofre.AgregarTesoro(treasure);
    }
    
    public void getTesorosIsla(){
        System.out.println("Tesoros encontrados: ");
        if (puerto.size() >0){
            for(int i = 0; i < puerto.size(); i++){
                System.out.println(puerto.get(i).getNombre());
                puerto.get(i).obtenerTesoroPuerto();
            }
        }
        else
            cofre.getTesoros();
        
    }
    
    public void getTesoroIslaPuerto(int i){
        puerto.get(i).obtenerTesoroPuerto();
    }
    
    public Tesoro TomarTesoros(int opcion){
        return cofre.EliminarTesoro(opcion);
    }
}
