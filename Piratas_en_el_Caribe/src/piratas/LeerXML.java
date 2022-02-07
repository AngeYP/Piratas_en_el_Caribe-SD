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
      File archivoxml = new File("C:\\Users\\angel\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\XMLFile\\Ejemplo.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbFactory.newDocumentBuilder();
      Document documentXML = builder.parse(archivoxml);

      documentXML.getDocumentElement().normalize();

      System.out.println("Elemento raiz: " + documentXML.getDocumentElement().getNodeName());

      NodeList programas = documentXML.getElementsByTagName("programa");

      System.out.println("Contenido del documento:\n");

      for (int i = 0; i < programas.getLength(); i++) {
        Node programa = programas.item(i);
        System.out.println("Nombre elemento actual: " + programa.getNodeName());

        if (programa.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) programa;
          System.out.println("ID: " + element.getAttribute("id"));
          System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
          System.out.println("Version: " + element.getElementsByTagName("version").item(0).getTextContent());
          System.out.println("Desarrollador: " + element.getElementsByTagName("desarrollador").item(0).getTextContent());                    
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
