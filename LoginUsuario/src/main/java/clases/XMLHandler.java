/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLHandler {
    
    private static Document document;
    
    public static void loadXML(){
        try {
            File archivo = new File("src/main/java/resources/UsuariosXML.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = documentBuilder.parse(archivo);
        }catch (Exception e){
            e.printStackTrace();
        }// Fin de try-catch
    } // Fin método loadXML
    
    /*-- Método para guardar el archivo XML si ha sido modificado --*/
    public static void saveXML(){
        try{
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "4");
            Result output = new StreamResult(new File("src/main/java/resources/UsuariosXML.xml"));
            Source input = new DOMSource(document);
            transformer.transform(input, output);
        }catch (Exception e){
            e.printStackTrace();
        } //Fin de try-catch
    } // Fin metodo saveXML
    
    public static Usuarios comprobarExistencia(String nombre) {
        Usuarios user = new Usuarios();
        loadXML();
        NodeList nodeListUsuarios = document.getElementsByTagName("user");

        for (int i = 0; i < nodeListUsuarios.getLength(); i++) {
            Node nodeUsuario = nodeListUsuarios.item(i);

            if (nodeUsuario.getNodeType() == Node.ELEMENT_NODE) {
                Element eUsuario = (Element) nodeUsuario;

                if (eUsuario.getAttribute("name").equals(nombre)) {
                    user = new Usuarios(eUsuario.getAttribute("name"),
                            eUsuario.getAttribute("pass"),
                            eUsuario.getAttribute("role"),
                            eUsuario.getAttribute("email"));
      
                }//fin del if
            }//fin del if

        }//fin del bucle for
        return user;

    }
}
