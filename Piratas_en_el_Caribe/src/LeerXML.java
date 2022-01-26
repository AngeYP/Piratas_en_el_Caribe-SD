import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {
  public static void main(String[] args) {
    try {
      File archivoxml = new File("C:\\Users\\angel\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\XMLFile\\Servidor2.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document documentXML = builder.parse(archivoxml);

      documentXML.getDocumentElement().normalize();

//      System.out.println("Elemento raiz: " + documentXML.getDocumentElement().getNodeName());

      NodeList programas = documentXML.getElementsByTagName("ubicacion");

      for (int j = 0; j < programas.getLength(); j++) {
        Node program = programas.item(j);
        if (program.getNodeType() == Node.ELEMENT_NODE) {
          Element elemento = (Element) program;
          System.out.println("\n\nID: " + elemento.getAttribute("id"));
          
          NodeList programa = documentXML.getElementsByTagName("puerto");
          for (int i = 0; i < programa.getLength(); i++) {
            Node programs = programa.item(i);
            if (programs.getNodeType() == Node.ELEMENT_NODE) {
              Element element = (Element) programs;
              System.out.println("Puerto: " + element.getAttribute("puerto"));
              System.out.println("Mapas: " + element.getElementsByTagName("mapas").item(0).getTextContent()); 
              System.out.println("Barras de oro: " + element.getElementsByTagName("barras_de_oro").item(0).getTextContent());
              System.out.println("Barras de plata: " + element.getElementsByTagName("barras_de_plata").item(0).getTextContent());
              System.out.println("Bolsa de perlas: " + element.getElementsByTagName("bolsas_de_perlas").item(0).getTextContent());
              System.out.println("Bolsa de moneda de oro: " + element.getElementsByTagName("bolsas_moneda_de_oro").item(0).getTextContent());
              System.out.println("Cofres de joyas: " + element.getElementsByTagName("cofres_de_joyas").item(0).getTextContent());
              System.out.println("Cofres de piedras preciosas: " + element.getElementsByTagName("cofres_de_piedras_preciosas").item(0).getTextContent());
              System.out.println("El corazon de la princesa: " + element.getElementsByTagName("el_corazon_de_la_princesa").item(0).getTextContent()); 
            }
          }
          
          
          
          
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
