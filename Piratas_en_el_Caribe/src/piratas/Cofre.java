/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author DELL
 */
public class Cofre implements Serializable{
    
    public int capacidad ;
    public ArrayList<Tesoro> tesoro ;
    public int valor_total = 0;
    
    public Cofre(int capacidad){
        this.capacidad = capacidad;
        this.tesoro =  new ArrayList<Tesoro>();
    }

    public String getCapacidad() {
        int ocupado = 0;
        System.out.println();
        for (int i = 0; i < tesoro.size(); i++){
            System.out.println((i+1) +" Nombre: "+tesoro.get(i).getNombre() +
                               " Peso: " + tesoro.get(i).getPeso()+
                                " Valor: "+ tesoro.get(i).getValor());
            ocupado = ocupado + tesoro.get(i).getPeso();
        }
        return "Queda: " + (capacidad - ocupado) + " de espacio";
    }

    public int getValor_total() {
        return valor_total;
    }

    public void getTesoros() {
        valor_total = 0;
        for (int i = 0; i < tesoro.size(); i++){
            System.out.println((i+1) +" Nombre: "+tesoro.get(i).getNombre() +
                                " Peso: " + tesoro.get(i).getPeso()+
                                " Valor: "+ tesoro.get(i).getValor());
            valor_total = valor_total+tesoro.get(i).getValor();
            Servidor.contador ++;
        }
        if (valor_total != 0)
            System.out.println("Valor total del cofre: "+valor_total+"\n\n");
        else
            System.out.println("No posee tesoros");
    }
    
    public void AgregarTesoro(Tesoro treasure){
        tesoro.add(treasure);
    }
    
    public Tesoro EliminarTesoro(int opcion){
        //System.out.println(" Que tesoro deseas sacar?");
        //this.getTesoros();
//        Scanner sc = new Scanner(System.in);
//        int opcion = sc.nextInt();
        Tesoro treasure;
        treasure = tesoro.get(opcion-1);
        tesoro.remove(opcion-1);
        return treasure;
    }
}
