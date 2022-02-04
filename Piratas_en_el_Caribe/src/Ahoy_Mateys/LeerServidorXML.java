package Ahoy_Mateys;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerServidorXML {
  public static void main(String[] args) {
    
//    ArrayList<Ubicacion> listUbicaciones = new ArrayList();
    String server = "C:\\Users\\angel\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\XMLFile\\Servidor1.xml";
    
    try {
      File archivoxml = new File(server);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document documentXML = builder.parse(archivoxml);

      documentXML.getDocumentElement().normalize();

      NodeList programas = documentXML.getElementsByTagName("tesoro");
      String islaflag = "";
      String puertoflag = "";
      for (int j = 0; j< programas.getLength(); j++) {
//        Ubicacion ubicacion = new Ubicacion();
        Node programa = programas.item(j);
        
        if (programa.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) programa;
          if (!islaflag.equals(element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent()) 
              || !puertoflag.equals(element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent())) {
            System.out.println("\n\nNUEVA UBICACION");
            System.out.println("Isla: "+element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent());
            System.out.println("Puerto: "+element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent());
          }
          System.out.println("Tesoro: "+element.getAttribute("name"));
          System.out.println("Valor: "+element.getTextContent());
          islaflag = element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent();
          puertoflag = element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent();
        }
        
//        listUbicaciones.add(ubicacion);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}