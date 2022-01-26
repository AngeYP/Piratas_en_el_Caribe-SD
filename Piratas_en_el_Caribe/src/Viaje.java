/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;
import static java.lang.Thread.sleep;
import java.util.Random;
/**
 *
 * @author DELL
 */
public class Viaje {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Barco Holandesa = new Barco(20,30,20);
        System.out.println("Iniciando el viaje");
        Mapa mapa = new Mapa(4);
        mapa.CrearIslaEntrada();
        Random random = new Random();
        while (true){
           System.out.println("Navegando.....");
           int numero_isla = random.nextInt(3)+1;
           sleep(5000);
           System.out.println(numero_isla);
           System.out.println(mapa.getIsla(numero_isla));
           mapa.MostrarIslaEntrada(numero_isla);
           Holandesa.eventoTripulante();
           System.out.println("Resumen.....");
           System.out.println(Holandesa.getTripulacion());
           sleep(5000);
         
         
        }
    }
    
}
