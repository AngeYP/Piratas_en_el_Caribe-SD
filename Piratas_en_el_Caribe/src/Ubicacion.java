package piratas;

public class Ubicacion {
  private String area;
  private String puerto;
  private int CantMapas;
  private int CantBarras_de_oro;
  private int CantBarras_de_plata;
  private int CantBolsas_de_perlas;
  private int CantBolsas_moneda_de_oro;
  private int CantCofres_de_joyas;
  private int CantCofres_de_piedras_preciosas;
  private int CantEl_corazon_de_la_princesa;
  
  public Ubicacion() {
    this.area = null;
    this.puerto = null;
    this.CantMapas = 0;
    this.CantBarras_de_oro = 0;
    this.CantBarras_de_plata = 0;
    this.CantBolsas_de_perlas = 0;
    this.CantBolsas_moneda_de_oro = 0;
    this.CantCofres_de_joyas = 0;
    this.CantCofres_de_piedras_preciosas = 0;
    this.CantEl_corazon_de_la_princesa = 0;
  }

  public Ubicacion(String area, String puerto, int CantMapas, int CantBarras_de_oro, int CantBarras_de_plata, int CantBolsas_de_perlas, int CantBolsas_moneda_de_oro, int CantCofres_de_joyas, int CantCofres_de_piedras_preciosas, int CantEl_corazon_de_la_princesa) {
    this.area = area;
    this.puerto = puerto;
    this.CantMapas = CantMapas;
    this.CantBarras_de_oro = CantBarras_de_oro;
    this.CantBarras_de_plata = CantBarras_de_plata;
    this.CantBolsas_de_perlas = CantBolsas_de_perlas;
    this.CantBolsas_moneda_de_oro = CantBolsas_moneda_de_oro;
    this.CantCofres_de_joyas = CantCofres_de_joyas;
    this.CantCofres_de_piedras_preciosas = CantCofres_de_piedras_preciosas;
    this.CantEl_corazon_de_la_princesa = CantEl_corazon_de_la_princesa;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getPuerto() {
    return puerto;
  }

  public void setPuerto(String puerto) {
    this.puerto = puerto;
  }

  public int getCantMapas() {
    return CantMapas;
  }

  public void setCantMapas(int CantMapas) {
    this.CantMapas = CantMapas;
  }

  public int getCantBarras_de_oro() {
    return CantBarras_de_oro;
  }

  public void setCantBarras_de_oro(int CantBarras_de_oro) {
    this.CantBarras_de_oro = CantBarras_de_oro;
  }

  public int getCantBarras_de_plata() {
    return CantBarras_de_plata;
  }

  public void setCantBarras_de_plata(int CantBarras_de_plata) {
    this.CantBarras_de_plata = CantBarras_de_plata;
  }

  public int getCantBolsas_de_perlas() {
    return CantBolsas_de_perlas;
  }

  public void setCantBolsas_de_perlas(int CantBolsas_de_perlas) {
    this.CantBolsas_de_perlas = CantBolsas_de_perlas;
  }

  public int getCantBolsas_moneda_de_oro() {
    return CantBolsas_moneda_de_oro;
  }

  public void setCantBolsas_moneda_de_oro(int CantBolsas_moneda_de_oro) {
    this.CantBolsas_moneda_de_oro = CantBolsas_moneda_de_oro;
  }

  public int getCantCofres_de_joyas() {
    return CantCofres_de_joyas;
  }

  public void setCantCofres_de_joyas(int CantCofres_de_joyas) {
    this.CantCofres_de_joyas = CantCofres_de_joyas;
  }

  public int getCantCofres_de_piedras_preciosas() {
    return CantCofres_de_piedras_preciosas;
  }

  public void setCantCofres_de_piedras_preciosas(int CantCofres_de_piedras_preciosas) {
    this.CantCofres_de_piedras_preciosas = CantCofres_de_piedras_preciosas;
  }

  public int getCantEl_corazon_de_la_princesa() {
    return CantEl_corazon_de_la_princesa;
  }

  public void setCantEl_corazon_de_la_princesa(int CantEl_corazon_de_la_princesa) {
    this.CantEl_corazon_de_la_princesa = CantEl_corazon_de_la_princesa;
  }
  
}
