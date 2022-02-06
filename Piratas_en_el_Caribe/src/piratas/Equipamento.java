package piratas;

import java.util.ArrayList;

public class Equipamento {
  private int tripulacion;
  private int cofre;
  private int municiones;
  private int raciones;
  ArrayList<Direccion> direServidores = new ArrayList();

  public Equipamento(int tripulacion, int cofre, int municiones, int raciones) {
    this.tripulacion = tripulacion;
    this.cofre = cofre;
    this.municiones = municiones;
    this.raciones = raciones;
  }

  public Equipamento() {
    this.tripulacion = 0;
    this.cofre = 0;
    this.municiones = 0;
    this.raciones = 0;
  }
  
  public int getTripulacion() {
    return tripulacion;
  }

  public void setTripulacion(int tripulacion) {
    this.tripulacion = tripulacion;
  }

  public int getCofre() {
    return cofre;
  }

  public void setCofre(int cofre) {
    this.cofre = cofre;
  }

  public int getMuniciones() {
    return municiones;
  }

  public void setMuniciones(int municiones) {
    this.municiones = municiones;
  }

  public int getRaciones() {
    return raciones;
  }

  public void setRaciones(int raciones) {
    this.raciones = raciones;
  }
  
  public ArrayList<Direccion> getDireServidores() {
    return direServidores;
  }

  public void setDireServidores(ArrayList<Direccion> direServidores) {
    this.direServidores = direServidores;
  }

}
