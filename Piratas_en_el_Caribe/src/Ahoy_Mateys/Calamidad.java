/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahoy_Mateys;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Calamidad {
    
    public String Nombre;
    public int vida;
    
    
    public Calamidad(String Nombre, int vida){
        this.Nombre =  Nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getVida() {
        return vida;
    }
            
    public void Aparicion(Barco barco){
        Random random = new Random();
        int aparece = random.nextInt(10);
        Scanner sc = new Scanner(System.in);
        if (aparece % 2 == 1){
            System.out.println("Ha aparecido la calamidad: "+Nombre);
            System.out.println("Deseas atacar ?(y/n)");
            char opcion = sc.nextLine().charAt(0);
            if (opcion == 'y'){
                if (vida > barco.municion){
                    int daño = random.nextInt(barco.tripulacion.length);
                    System.out.println("Se te ha acabado tu municion, recibiste "+daño+" tripulantes caido");
                    barco.AtaqueATripulacion(daño - barco.municion);
                    barco.setMunicion(0);
                }
                else{
                    System.out.println("Has acabdo con la calamidad "+Nombre);
                    barco.setMunicion(barco.municion - vida);
                }
            }
            else{
                int daño = random.nextInt(barco.tripulacion.length);
                if (daño % 2 == 1){
                    System.out.println("Has huido...... pero te has perdido"+(daño / 2)+" tripulante ");
                    barco.AtaqueATripulacion(daño/2);
                }
                else
                    System.out.println("Has huido exitosamente");
            }
               
        }
    }
            
}
