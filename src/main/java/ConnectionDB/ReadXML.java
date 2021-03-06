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
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import objetos.*;
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
            file_Chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo XML", "xml")); //solo se buscara archivos con extension .xml
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
            //creamos el documento que se pueda entender
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document =  documentBuilder.parse(archivo);
            
            document.getDocumentElement().normalize();//hacemos que el documento se comporte de una manera statica
            
            //System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            //lista de los objetos
            NodeList listaAdmins = document.getElementsByTagName("admin");
            NodeList listaDoctors = document.getElementsByTagName("doctor");
            NodeList listaLaboratoristas = document.getElementsByTagName("laboratorista");
            NodeList listaPacientes = document.getElementsByTagName("paciente");
            NodeList listaExamen = document.getElementsByTagName("examen");
            NodeList listaReportes = document.getElementsByTagName("reporte");
            NodeList listaResultados = document.getElementsByTagName("resultado");
            NodeList listaCitas = document.getElementsByTagName("cita");
            NodeList listaConsultas = document.getElementsByTagName("consulta");
            
            //los agregamos a la DB
            admins(listaAdmins);
            pacientes(listaPacientes);
            consultas(listaConsultas);
            doctors(listaDoctors);
            examens(listaExamen);      
            laboratoristas(listaLaboratoristas);
            informes(listaReportes);
            citas(listaCitas);            
            resultados(listaResultados);
            
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //usamos para agregar los adminis a la base de datos
    private void admins(NodeList listaAdmins){
        AdminModelo adminModelo = new AdminModelo();
        for(int i = 0 ; i < listaAdmins.getLength() ; i++) {
        
            try{                
                Node nodo = listaAdmins.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String dpi = element.getElementsByTagName("DPI").item(0).getTextContent();          
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();             
                    String password = element.getElementsByTagName("PASSWORD").item(0).getTextContent();
                    
                    //los llevamos a la DB
                    Admin admin = new Admin(codigo,nombre,dpi,password);
                    adminModelo.addAdmin(admin);
                }
            
            }catch(Exception e){
                
            }
        }
    }
    //se usa este metodo para llevar los doctores a la DB
    private void doctors(NodeList listaDoctors){
        MedicoModelo medicoModelo = new MedicoModelo();
        ConsultaModelo consultaModelo = new ConsultaModelo();
        MedicoEspecialidadModelo medicoEspecialidadModelo = new MedicoEspecialidadModelo();
        
       for(int i = 0 ; i < listaDoctors.getLength() ; i++) {
            try{
                Node nodo = listaDoctors.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element element = (Element) nodo;//recopilamos el elemto elegido en el index acutal
                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();                   
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();
                    String colegiado = element.getElementsByTagName("COLEGIADO").item(0).getTextContent();
                    String dpi = element.getElementsByTagName("DPI").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("TELEFONO").item(0).getTextContent();
                    String email = element.getElementsByTagName("CORREO").item(0).getTextContent();
                    String fechaInicio = element.getElementsByTagName("TRABAJO").item(0).getTextContent();
                    String password = element.getElementsByTagName("PASSWORD").item(0).getTextContent();
                    String horaInicio = element.getElementsByTagName("INICIO").item(0).getTextContent();
  
                    String horaFin = element.getElementsByTagName("FIN").item(0).getTextContent();
                    
                    Medico medico = new Medico(codigo,nombre,colegiado,dpi,telefono,email,horaInicio,horaFin,fechaInicio,password);
                    medicoModelo.addMedico(medico);
                    
                    
                    //usamos esot para llenar todas las espeicalidades que tiene un doctor y subirlo a la DB
                    NodeList listaEspecialidades = element.getElementsByTagName("ESPECIALIDAD"); 
                    try{
                        int cant = 0;
                        while(true){
                            Node nodo1 = listaEspecialidades.item(0);
                            
                            if (nodo1.getNodeType() == Node.ELEMENT_NODE) {
                                Element element1 = (Element) nodo1;
                                String especialidad = element1.getElementsByTagName("TITULO").item(cant).getTextContent();
                                int id = consultaModelo.buscarIdEspecialidad(especialidad);
                                
                                MedicoEspecialidad medicoEspecialidad = new MedicoEspecialidad(codigo,id);
                                medicoEspecialidadModelo.addMedicoEspecialidad(medicoEspecialidad);
                                
                            }
                            cant++;
                        }
                    }catch(Exception e){
                    }                     
                        
                        
                    }
            }catch(Exception e){
                System.out.println("add medico error: " + e.getMessage());
            }            
       }
    }
    //usamos esto para agregar los laboratoristas a la DB
    private void laboratoristas(NodeList listaLaboratoristas){
        
        LaboratoristaModelo laboristaModelo = new LaboratoristaModelo();
        ExamenModelo examenModelo =  new ExamenModelo();        
        DiaLabModelo diaLabModelo = new DiaLabModelo();
        
        
        for (int i = 0; i < listaLaboratoristas.getLength(); i++) {
            try{
                
                Node nodo = listaLaboratoristas.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element element = (Element) nodo;
                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();                   
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();
                    String registro = element.getElementsByTagName("REGISTRO").item(0).getTextContent();
                    String dpi = element.getElementsByTagName("DPI").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("TELEFONO").item(0).getTextContent();
                    String examen = element.getElementsByTagName("EXAMEN").item(0).getTextContent();
                    String email = element.getElementsByTagName("CORREO").item(0).getTextContent();
                    String fechaInicio = element.getElementsByTagName("TRABAJOF").item(0).getTextContent();
                    String password = element.getElementsByTagName("PASSWORD").item(0).getTextContent();
 
                    int idExamen = examenModelo.buscarIdExamen(examen);
                    
                    //agregamos al laboratorista a la DB
                    Laboratorista laboratorista = new Laboratorista(codigo,nombre,registro,dpi,telefono,email,fechaInicio,idExamen,password);
                    laboristaModelo.addLaboratorista(laboratorista);                    
                    
                    
                    NodeList listaDias = element.getElementsByTagName("TRABAJO"); 
                    try{
                        int cant = 0;
                        while(true){
                            Node nodo1 = listaDias.item(0);
                            
                            if (nodo1.getNodeType() == Node.ELEMENT_NODE) {
                                Element element1 = (Element) nodo1;
                                String dia = element1.getElementsByTagName("DIA").item(cant).getTextContent();
                                
                                
                                //unimos los dias con la laboratorista en la DB
                                DiaLab diaLab = new DiaLab(dia, codigo);
                                diaLabModelo.addDiaLab(diaLab);
                                
                            }
                            cant++;
                        }
                    }catch(Exception e){
                    }                     
                        
                        
                    }              
                
            }catch(Exception e){
                System.out.println("add laboratorista error: " + e.getMessage());
            }
        }
        
    }
//usamos este metodo para llevar a los pacientes a la DB
    private void pacientes(NodeList listaPacientes) {
        PacienteModelo pacienteModelo = new PacienteModelo();
        
        for (int i = 0; i < listaPacientes.getLength(); i++) {
            try{
                
                Node nodo = listaPacientes.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();          
                    String sexo = element.getElementsByTagName("SEXO").item(0).getTextContent();             
                    String fecha = element.getElementsByTagName("BIRTH").item(0).getTextContent();
                    String dpi = element.getElementsByTagName("DPI").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("TELEFONO").item(0).getTextContent();
                    String peso = element.getElementsByTagName("PESO").item(0).getTextContent();
                    String sangre = element.getElementsByTagName("SANGRE").item(0).getTextContent();
                    String email = element.getElementsByTagName("CORREO").item(0).getTextContent();
                    String password = element.getElementsByTagName("PASSWORD").item(0).getTextContent();
                    
                    //los llevamos a la DB
                    Paciente paciente = new Paciente(Integer.valueOf(codigo),nombre,sexo,fecha,dpi,telefono,Integer.valueOf(peso),sangre,email,password);
                    pacienteModelo.addPaciente(paciente);
                }
                
            }catch(Exception e){}
        }
        
    }
//usamos este metodo para llevar todos los examenes a la DB
    private void examens(NodeList listaExamen) {
        ExamenModelo examenModelo = new ExamenModelo();
        
        for (int i = 0; i < listaExamen.getLength(); i++) {
            try{
                
                Node nodo = listaExamen.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();          
                    String orden = element.getElementsByTagName("ORDEN").item(0).getTextContent();             
                    String descripcion = element.getElementsByTagName("DESCRIPCION").item(0).getTextContent();
                    String costo = element.getElementsByTagName("COSTO").item(0).getTextContent();
                    String tipo = element.getElementsByTagName("INFORME").item(0).getTextContent();
                    
                    //los llevamos a la DB
                    Examen examen = new Examen(Integer.valueOf(codigo),nombre,tipo,Boolean.parseBoolean(orden),Double.valueOf(costo),descripcion);
                    examenModelo.addExamen(examen);
                    
                }
                
            }catch(Exception e){
                System.out.println("add Examenes error: " + e.getMessage());
            }
        }
       
    }

    private void informes(NodeList listaReportes) {
        InformeModelo informeModelo = new InformeModelo();
        
        for (int i = 0; i < listaReportes.getLength(); i++) {
            try{
                
                Node nodo = listaReportes.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String paciente = element.getElementsByTagName("PACIENTE").item(0).getTextContent();          
                    String medico = element.getElementsByTagName("MEDICO").item(0).getTextContent();             
                    String descripcion = element.getElementsByTagName("INFORME").item(0).getTextContent();
                    String fecha = element.getElementsByTagName("FECHA").item(0).getTextContent();
                    String hora = element.getElementsByTagName("HORA").item(0).getTextContent();
                    
                    //los llevamos a la DB
                    Informe informe = new Informe(Integer.valueOf(codigo),descripcion,hora,fecha,0,Integer.valueOf(paciente),medico);
                    informeModelo.addInforme(informe);
                    
                }
                
                
            }catch(Exception e){
                System.out.println("add informes error: " + e.getMessage());
            }
        }
        
    }

    private void resultados(NodeList listaResultados) {
        ResultadoModelo resultadoModelo = new ResultadoModelo();
        
        for (int i = 0; i < listaResultados.getLength(); i++) {
            try{
                
                Node nodo = listaResultados.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String paciente = element.getElementsByTagName("PACIENTE").item(0).getTextContent();
                    
                    String medico = null;
                    try{
                        medico = element.getElementsByTagName("MEDICO").item(0).getTextContent(); 
                    }catch(Exception e){
                        medico = null;
                    }
                    
                    String laboratorista = element.getElementsByTagName("LABORATORISTA").item(0).getTextContent();
                    String ordenPath = element.getElementsByTagName("ORDEN").item(0).getTextContent();
                    String informePath = element.getElementsByTagName("INFORME").item(0).getTextContent();
                    String fecha = element.getElementsByTagName("FECHA").item(0).getTextContent();
                    String hora = element.getElementsByTagName("HORA").item(0).getTextContent();
                    String examen = element.getElementsByTagName("EXAMEN").item(0).getTextContent();                    
                    boolean verificado=true;
                    
                    FileInputStream ordenFile = null;
                    FileInputStream informeFile = null;
                   
                    //cambiamos el ordenPath
                    try{
                        File fileOrden = new File(ordenPath);
                        ordenFile = new FileInputStream(fileOrden);                       
                    }catch(Exception e){                    
                        
                    }
                    //cambiamos el informePath
                    try{
                        File fileInforme = new File(informePath);
                        informeFile = new FileInputStream(fileInforme);                       
                    }catch(Exception e){                    
                        
                    }
                    
                    //los llevamos a la DB
                    Resultado resultado = new Resultado(Integer.valueOf(codigo),fecha,hora,verificado,informeFile,ordenFile,Integer.valueOf(paciente),medico,Integer.valueOf(examen),laboratorista);
                    resultadoModelo.addResultado(resultado);
                    
                }
                
                
                
            }catch(Exception e){
                System.out.println("add resultados error: " + e.getMessage());
            }
        }
        
    }
//usamos este bloque de codigo para llevar a las citas a la DB
    private void citas(NodeList listaCitas) {
        CitaModelo citaModelo = new CitaModelo();
        
        for (int i = 0; i < listaCitas.getLength(); i++) {
            try{
                
                Node nodo = listaCitas.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String codigo = element.getElementsByTagName("CODIGO").item(0).getTextContent();
                    String paciente = element.getElementsByTagName("PACIENTE").item(0).getTextContent();          
                    String medico = element.getElementsByTagName("MEDICO").item(0).getTextContent();
                    String fecha = element.getElementsByTagName("FECHA").item(0).getTextContent();
                    String hora = element.getElementsByTagName("HORA").item(0).getTextContent();
                    
                    //los llevamos a la DB
                    Cita cita = new Cita(Integer.valueOf(codigo),fecha,hora,Integer.valueOf(paciente),medico);
                    citaModelo.addCita(cita);
                    
                }
                
                
            }catch(Exception e){
                System.out.println("add citas error: " + e.getMessage());
            }
        }
        
    }
//usamos este metodo para llevar la consutlas a la DB
    private void consultas(NodeList listaConsultas) {
        ConsultaModelo consulta = new ConsultaModelo();
        
        for (int i = 0; i < listaConsultas.getLength(); i++) {
            try{
                
                Node nodo = listaConsultas.item(i);

                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    String tipo = element.getElementsByTagName("TIPO").item(0).getTextContent();
                    String costo = element.getElementsByTagName("COSTO").item(0).getTextContent();                   
                    
                    //los llevamos a la DB
                    Especialidad especialidad = new Especialidad(tipo,Double.valueOf(costo));
                    consulta.addConsulta(especialidad);
                }                
                
            }catch(Exception e){
                System.out.println("add consultas error: " + e.getMessage());
            }
        }
    }
    
    
}
