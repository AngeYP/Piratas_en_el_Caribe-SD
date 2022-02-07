/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piratas;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author DELL
 */
public class ServidorXML {
    
    
    public ArrayList<Mapa> listUbicaciones = new ArrayList();
    String server1 = "C:\\Users\\Gustavo\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\piratas\\XMLFile\\Servidor1.xml";
    String server2 = "C:\\Users\\Gustavo\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\piratas\\XMLFile\\Servidor2.xml";
    String server3 = "C:\\Users\\Gustavo\\Documents\\GitHub\\Piratas_en_el_Caribe-SD\\Piratas_en_el_Caribe\\src\\piratas\\XMLFile\\Servidor3.xml";
    
    public ServidorXML(int numServer){
        Mapa mapa = new Mapa();
        try {
                File archivoxml = null;
              switch(numServer){
                  case 1:
                      archivoxml = new File(server1);
                      break;
                  case 2:
                      archivoxml = new File(server2);
                      break;
                  case 3:
                      archivoxml = new File(server3);
                      break;
              }
              
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
                      || 
                      !puertoflag.equals(element.getParentNode().getAttributes().getNamedItem("puerto").getTextContent())) {
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
    }
}
