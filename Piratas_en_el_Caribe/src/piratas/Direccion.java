package piratas;

public class Direccion {
  private int num;
  private String isla;
  private String puerto;
  
  public Direccion() {
    this.num = 0;
    this.isla = null;
    this.puerto = null;
  }

  public Direccion(int num, String isla, String puerto) {
    this.num = num;
    this.isla = isla;
    this.puerto = puerto;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getIsla() {
    return isla;
  }

  public void setIsla(String isla) {
    this.isla = isla;
  }

  public String getPuerto() {
    return puerto;
  }

  public void setPuerto(String puerto) {
    this.puerto = puerto;
  }
  
}
