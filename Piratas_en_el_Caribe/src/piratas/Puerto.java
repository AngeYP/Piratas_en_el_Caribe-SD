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
public class Puerto {
    
    public String nombre;
    public Cofre cofre;
    
    public Puerto(String nombre){
        this.nombre = nombre;
        cofre = new Cofre(1000);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void agregarTesoroPuerto(String nombre, int peso){
        Tesoro treasure = new Tesoro (nombre,peso,10);
        cofre.AgregarTesoro(treasure);
    }
    
    public void obtenerTesoroPuerto(){
        cofre.getTesoros();
    }
    
    public Tesoro TomarTesoros(int opcion){
        return cofre.EliminarTesoro(opcion);
    }
}
