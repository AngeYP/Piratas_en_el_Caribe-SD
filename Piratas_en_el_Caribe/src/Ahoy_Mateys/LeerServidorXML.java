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
    
    ArrayList<Ubicacion> listUbicaciones = new ArrayList();
    String server = "C:\\Users\\angel\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\XMLFile\\Servidor1.xml";
    
    try {
      File archivoxml = new File(server);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document documentXML = builder.parse(archivoxml);

      documentXML.getDocumentElement().normalize();

      NodeList programas = documentXML.getElementsByTagName("puerto");

      for (int i = 0; i< programas.getLength(); i++) {
        Ubicacion ubicacion = new Ubicacion();
        Node programa = programas.item(i);
        if (programa.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) programa;
          ubicacion.setArea(element.getParentNode().getAttributes().getNamedItem("id").getTextContent());
          ubicacion.setPuerto(element.getAttribute("puerto"));
          ubicacion.setCantMapas(Integer.parseInt(element.getElementsByTagName("mapas").item(0).getTextContent())*5);
          ubicacion.setCantBarras_de_oro(Integer.parseInt(element.getElementsByTagName("barras_de_oro").item(0).getTextContent())*25);
          ubicacion.setCantBarras_de_plata(Integer.parseInt(element.getElementsByTagName("barras_de_plata").item(0).getTextContent())*50);
          ubicacion.setCantBolsas_de_perlas(Integer.parseInt(element.getElementsByTagName("bolsas_de_perlas").item(0).getTextContent())*10);
          ubicacion.setCantBolsas_moneda_de_oro(Integer.parseInt(element.getElementsByTagName("bolsas_moneda_de_oro").item(0).getTextContent())*15);
          ubicacion.setCantCofres_de_joyas(Integer.parseInt(element.getElementsByTagName("cofres_de_joyas").item(0).getTextContent())*15);
          ubicacion.setCantCofres_de_piedras_preciosas(Integer.parseInt(element.getElementsByTagName("cofres_de_piedras_preciosas").item(0).getTextContent())*15);
          ubicacion.setCantEl_corazon_de_la_princesa(Integer.parseInt(element.getElementsByTagName("el_corazon_de_la_princesa").item(0).getTextContent())*5);
        }
        listUbicaciones.add(ubicacion);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}

//          System.out.println("\nNuevo:\n"+element.getParentNode().getAttributes().getNamedItem("id").getTextContent());
//          System.out.println(element.getAttribute("puerto"));
//          System.out.println(element.getElementsByTagName("mapas").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("barras_de_oro").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("barras_de_plata").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("bolsas_de_perlas").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("bolsas_moneda_de_oro").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("cofres_de_joyas").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("cofres_de_piedras_preciosas").item(0).getTextContent());
//          System.out.println(element.getElementsByTagName("el_corazon_de_la_princesa").item(0).getTextContent());