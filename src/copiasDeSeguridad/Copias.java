/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copiasDeSeguridad;

import controlDental.Cliente;
import controlar.BaseDeDatos;
import controlar.Copia;
import controlar.OperacionesCopia;
import controlar.TransaccionCliente;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mourad Daoudi
 */
public class Copias {
    public void copiarDatos (String archivo){
        try {            
            java.io.BufferedReader bufferedReader = new BufferedReader(new FileReader("Copias_de_seguridad/" + archivo + ".txt"));
            String[] linea = bufferedReader.readLine().split(";");
            System.out.println(linea.length);
            for(int i =0; i< linea.length; i++){
               String[] tokens = linea[i].split("-");
                  String sexo = tokens[3];
                  if (sexo.compareTo("Hombre")==0){
                    sexo="H";
                   } else {
                    sexo="M";
                    }
                  for (int j=0; j<10; j++){
                      if (tokens[j].compareTo("null")==0){
                          tokens[j]="";
                      }
                  }
                 
                Cliente cliente = new Cliente(Integer.parseInt(tokens[0]), tokens[1], tokens[2], sexo, tokens[4], tokens[5],tokens[6],Integer.parseInt(tokens[7]),tokens[8],tokens[9]);
   
                 BaseDeDatos.conectar();
                TransaccionCliente.insertarCliente(cliente);
              
            }
        } catch (IOException ex) {
         //   Logger.getLogger(Copias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
      public void borrarTodo (){
          
        ArrayList <Cliente> clientes = new ArrayList();
        BaseDeDatos.conectar();
        clientes=TransaccionCliente.listarCliente();
           for (int i=0; i<clientes.size(); i++){
              TransaccionCliente.borrarCliente(clientes.get(i).getDni());
               
           }
          
      }
    
    public void hacerCopia (int ultimo){
    try {
        
        ArrayList <Cliente> clientes = new ArrayList();
        BaseDeDatos.conectar();
        clientes=TransaccionCliente.listarCliente();
        Date date = new Date();
   
        Calendar calendar = Calendar.getInstance();
        
        String dia = calendar.get(Calendar.DAY_OF_MONTH)  + "" + (calendar.get(Calendar.MONTH)+1) + calendar.get(Calendar.YEAR) ;
        String hora =date.getHours() + "." + date.getMinutes() +
                 "." + date.getSeconds() ; 
        
        Copia cp = new Copia (ultimo ,dia,hora);
        OperacionesCopia.insertarCopia(cp);
        
         java.io.BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Copias_de_seguridad/" 
                 + dia  + "_" + hora + ".txt"));
        for (int i=0; i<clientes.size(); i++){
                 bufferedWriter.append(clientes.get(i).getDni() + "-"); 
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getNombre() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getApellidos() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getSexo() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getFechaNacimiento() + "-" );
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getDireccion() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getLocalidad() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getCodigo_postal() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getAlergias() + "-");
                 bufferedWriter.flush();
                 bufferedWriter.append(clientes.get(i).getDescripcion());
                 bufferedWriter.flush();
                 bufferedWriter.append(";");
                 bufferedWriter.flush();
          
        }
     
    } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }   
}
