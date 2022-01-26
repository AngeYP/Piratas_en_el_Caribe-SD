/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;

/**
 *
 * @author DELL
 */
public class Mapa {
    
    Isla isla[];
    
    public Mapa(int Cantidad_isla){
        isla = new Isla[Cantidad_isla];
        
        for (int i = 1; i < Cantidad_isla;i++){
            isla[i] = new Isla ("Isla " + i);
        }
       // System.out.println(isla[1]);
    }
    
    public String getIsla(int i){
        return "Llegando a "+isla[i].getNombre();
    }
    
    public void CrearIslaEntrada(){
        isla[1].agregar_entrada("Puerto 1");
        isla[1].agregar_entrada("Puerto 2");
        isla[1].agregar_entrada("Puerto 3");
        isla[2].agregar_entrada("Puerto 12");
        isla[3].agregar_entrada("Puerto 13");
    }
    
    public void MostrarIslaEntrada(int i){
        isla[i].mostrar_entrada();
    }
}
