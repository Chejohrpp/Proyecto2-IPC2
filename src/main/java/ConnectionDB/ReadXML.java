/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.awt.HeadlessException;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sergi
 */
public class ReadXML {
    private String path;
    
    public ReadXML(){
        
    }
    public void buscarDato(){
         // TODO add your handling code here:
        try {
            JFileChooser file_Chooser = new JFileChooser();
            file_Chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo XML", "xml")); //solo se buscara archivos con extension .txt
            file_Chooser.setAcceptAllFileFilterUsed(false);
            int seleccion = file_Chooser.showOpenDialog(null);
            
            if (seleccion == APPROVE_OPTION) {
                //System.out.println("Path: " + fileChooser.getSelectedFile().getPath());
                path = file_Chooser.getSelectedFile().getPath();
                leerXML();
            } 
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());
            
        }
    }
    private void leerXML(){
         try {
            File archivo = new File(path);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document =  documentBuilder.parse(archivo);
            
            document.getDocumentElement().normalize();
            
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            NodeList listaUsuarios = document.getElementsByTagName("USUARIO");
            
            for(int i = 0 ; i < listaUsuarios.getLength() ; i++) {
                Node nodo = listaUsuarios.item(i);
                System.out.println("Elemento: " + nodo.getNodeName());
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("ID: " + element.getElementsByTagName("ID").item(0).getTextContent());
                    System.out.println("Nombre: " + element.getElementsByTagName("NOMBRE").item(0).getTextContent());
                    System.out.println("Telefono: " + element.getElementsByTagName("TELEFONO").item(0).getTextContent());                    
                    System.out.println("");
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
