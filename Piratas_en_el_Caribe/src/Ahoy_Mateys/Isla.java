/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahoy_Mateys;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Isla {
    String nombre;
    ArrayList<String> entrada = new ArrayList<String>();
    
    public Isla(String nombre){
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }
    
    public void agregar_entrada(String nombre_entrada){
        this.entrada.add(nombre_entrada);
    }
    
    public void mostrar_entrada(){
        if (entrada.size() > 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Esta isla tiene puerto/bahia/cueva ?a donde quieres ir?");
            for(int i = 0; i < entrada.size(); i++){
                System.out.println((i+1)+". "+entrada.get(i));
            }
            int opcion = sc.nextInt();
            if (opcion > 0 && opcion < entrada.size()+1)
                System.out.println("Navegando hacia "+entrada.get(opcion-1));
            
        }

    }
    
}
