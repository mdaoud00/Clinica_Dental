/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlar;

import controlDental.Cliente;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mourad Daoudi
 */
public class Imprimir {
   
    /**
     *
     * @param cliente
     */
    public void imprimir(ArrayList<Cliente> cliente) throws IOException, PrinterException{
       
    java.io.BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Impresion/" 
                 +"imprimir" + ".html"));
    
    bufferedWriter.append("<html> <head></head><body><table align=center border=0><tr align=center bgcolor=999999><td> &nbsp;DNI &nbsp; </td><td>"
            + " &nbsp; Nombre &nbsp; </td><td> &nbsp; Apellidos  &nbsp;</td><td> &nbsp; Sexo &nbsp; </td>"
            + "<td> &nbsp; Fecha de Nacimiento &nbsp; </td><td> &nbsp; Dirección &nbsp; </td><td> &nbsp; Localidad &nbsp; </td>"
            + "<td> &nbsp; Código Postal &nbsp; </td><td> &nbsp; Alergias &nbsp; </td><td> &nbsp; Descripción &nbsp; </td></tr>");
    bufferedWriter.flush();
   String color="cccccc";
                 
             for (int i=cliente.size()-1; i>=0; i--){
                 if (i%2 ==0)bufferedWriter.append("<tr>");
                 else bufferedWriter.append("<tr bgcolor="+color+">");
                  
                  bufferedWriter.flush();
               bufferedWriter.append("<td>" + cliente.get(i).getDni() + "</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" + cliente.get(i).getNombre() + "</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getApellidos() + "</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getSexo()+  "</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getFechaNacimiento() + "</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getDireccion() +"</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getLocalidad() +"</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getCodigo_postal() +"</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getAlergias() +"</td>"); 
                 bufferedWriter.flush();
                 bufferedWriter.append("<td>" +cliente.get(i).getDescripcion() +"</td>"); 
                 bufferedWriter.flush();
              
                 bufferedWriter.append("</tr>");
                  bufferedWriter.flush();
              }       
            bufferedWriter.append("</table></body></html>");
                  bufferedWriter.flush();
                  
      File f = new File("Impresion/imprimir.html");     


     java.awt.Desktop.getDesktop().open(f);

   
          
    }

}

