package piratas;

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
    ArrayList<Mapa> listUbicaciones = new ArrayList();
    String server = "C:\\Users\\Gustavo\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\piratas\\XMLFile\\Servidor1.xml";
    Mapa mapa = new Mapa();
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
            //System.out.println("\n\nNUEVA UBICACION");
            //System.out.println("Isla: "+element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent());
            //System.out.println("Puerto: "+element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent());
            mapa.setIsla(element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent());
            mapa.setIslaPuerto(element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent(),
                                element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent());
          }
          mapa.agregarTesoroIsla_Puerto(element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent(), 
                                        element.getAttribute("name"),
                                        Integer.parseInt(element.getTextContent()));
          //System.out.println("Tesoro: "+element.getAttribute("name"));
          //System.out.println("Valor: "+element.getTextContent());
          islaflag = element.getParentNode().getParentNode().getAttributes().getNamedItem("id").getTextContent();
          puertoflag = element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent();
        }
        
        listUbicaciones.add(mapa);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
//    mapa.getIslas();
//    mapa.getIslaPuerto();
     mapa.mostrarTesoroIsla_Puerto();
      //listUbicaciones.get(0).getIslaPuerto();
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