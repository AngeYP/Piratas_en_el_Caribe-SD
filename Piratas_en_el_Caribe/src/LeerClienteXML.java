package piratas;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerClienteXML {
  

  
  public static void main(String[] args) {
    int raciones;
    int municion;
    int tripulacion;
    int cofre;
    Equipamento equipo = new Equipamento();
    String server = "C:\\Users\\sigra\\Documents\\NetBeansProjects\\Piratas\\src\\piratas\\XMLFile\\Cliente.xml";
    
    try {
      File archivoxml = new File(server);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document documentXML = builder.parse(archivoxml);

      documentXML.getDocumentElement().normalize();

      NodeList programas = documentXML.getElementsByTagName("Barco");
      Node programa = programas.item(0);
      Element element = (Element) programa;
      
      tripulacion = Integer.parseInt(element.getElementsByTagName("Tripulacion").item(0).getTextContent());
      raciones = Integer.parseInt(element.getElementsByTagName("Raciones").item(0).getTextContent());
      municion = Integer.parseInt(element.getElementsByTagName("Municiones").item(0).getTextContent());
      cofre = Integer.parseInt(element.getElementsByTagName("Cofre").item(0).getTextContent());
      Barco barco =  new Barco (cofre,tripulacion,raciones,municion);
   
//      equipo.setCofre(Integer.parseInt(element.getElementsByTagName("Cofre").item(0).getTextContent()));
//      equipo.setMuniciones(Integer.parseInt(element.getElementsByTagName("Municiones").item(0).getTextContent()));
//      equipo.setRaciones(Integer.parseInt(element.getElementsByTagName("Raciones").item(0).getTextContent()));
//      equipo.setTripulacion(Integer.parseInt(element.getElementsByTagName("Tripulacion").item(0).getTextContent()));

      
      NodeList direcciones = documentXML.getElementsByTagName("Servidor");
      for (int i = 0; i< direcciones.getLength(); i++) {
        Direccion direccion = new Direccion();
        Node dire = direcciones.item(i);
        if (dire.getNodeType() == Node.ELEMENT_NODE) {
          Element elemento = (Element) dire;
            System.out.println("0. "+elemento.getAttribute("id"));
            System.out.println("1. "+elemento.getElementsByTagName("Isla").item(0).getTextContent());
            System.out.println("2. "+elemento.getElementsByTagName("Puerto").item(0).getTextContent());
            System.out.println("-> "+barco.getCofreCapacidad());
            System.out.println("-> "+barco.getMunicion());
            System.out.println("-> "+barco.getRaciones());
            System.out.println("-> "+barco.getTripulacion());       
          direccion.setNum(Integer.parseInt(elemento.getAttribute("id")));
          direccion.setIsla(elemento.getElementsByTagName("Isla").item(0).getTextContent());
          direccion.setPuerto(elemento.getElementsByTagName("Puerto").item(0).getTextContent());
          
        }
        barco.direServidores.add(direccion);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}

//System.out.println("0. "+elemento.getAttribute("id"));
//System.out.println("1. "+elemento.getElementsByTagName("Isla").item(0).getTextContent());
//System.out.println("2. "+elemento.getElementsByTagName("Puerto").item(0).getTextContent());
//System.out.println("-> "+equipo.getCofre());
//System.out.println("-> "+equipo.getMuniciones());
//System.out.println("-> "+equipo.getRaciones());
//System.out.println("-> "+equipo.getTripulacion());
//for (int i = 0; i < equipo.direServidores.size(); i++) {
//  System.out.println("0. "+equipo.direServidores.get(i).getNum());
//  System.out.println("1. "+equipo.direServidores.get(i).getIsla());
//  System.out.println("2. "+equipo.direServidores.get(i).getPuerto());
//}