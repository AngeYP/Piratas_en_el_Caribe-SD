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
    public ArrayList<String> entrada = new ArrayList<String>();
    public Cofre cofre;
    
    public Isla(String nombre){
        this.nombre = nombre;
        this.cofre = new Cofre(50);
        setCofreIsla();
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
    
    public void setCofreIsla(){
        Tesoro treasure = new Tesoro(nombre,10,30);
        cofre.AgregarTesoro(treasure);
    }
    
    public void getTesorosIsla(){
        System.out.println("Tesoros encontrados: ");
        cofre.getTesoros();
    }
    
    public Tesoro TomarTesoros(){
        return cofre.EliminarTesoro();
    }
}
