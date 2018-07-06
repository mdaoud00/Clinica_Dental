/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlar;

import controlDental.Usuario;
import java.sql.*;
import java.util.*;
import controlDental.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
*
* @author Mourad Daoudi
*/
public class TransaccionUsuario {

    static Usuario userPasado;
    static int id;
    static String nombre;
    static String password;
    static int derechos;

    public static Usuario dameUnUserDelaBD() {
        Usuario r = null;
       
        try {
           
            if (BaseDeDatos.resultado.next()) {
                id = Integer.parseInt(BaseDeDatos.resultado.getString("ID"));
                nombre = BaseDeDatos.resultado.getString("NOMBRE");
                derechos = Integer.parseInt(BaseDeDatos.resultado.getString("DERECHOS"));
                password = BaseDeDatos.resultado.getString("PASSWORD");
               
               r = new Usuario(id, nombre, derechos,
                        password);
            }
        } catch (SQLException e) {
            System.out.println("Introduce un usuario");
            e.printStackTrace();
        }
        return r;
    }
    
    public static ArrayList<Usuario> buscarUser() throws SQLException {
        
       ArrayList<Usuario> r = new ArrayList();     
       String q = "SELECT *  FROM USUARIOS ";
       BaseDeDatos.ejecutarConsulta(q);
       if (BaseDeDatos.resultado.next()){
                BaseDeDatos.resultado.beforeFirst();
            while (!BaseDeDatos.resultado.isLast()) {
              r.add(dameUnUserDelaBD());
            }
       }

        return r;
    }
    
     public static ArrayList<Usuario> buscarUser(int id) throws SQLException {
        
       ArrayList<Usuario> r = new ArrayList();     
        String q = "SELECT *  FROM USUARIOS  " + "WHERE ID ='" + id + "' ORDER BY ID ";
       BaseDeDatos.ejecutarConsulta(q);
       if (BaseDeDatos.resultado.next()){
                BaseDeDatos.resultado.beforeFirst();
            while (!BaseDeDatos.resultado.isLast()) {
              r.add(dameUnUserDelaBD());
            }
            }else{
             String msg = "El usuario no existe";
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
       }    

        return r;
    }
    
        public static void insertUser(Usuario x) {
        String q = "INSERT INTO USUARIOS VALUES ('" + x.getId() + "','" + x.getNombre() + "','" + x.getDerechos() + "','" + x.getPassword() + "')";
        BaseDeDatos.ejecutarUpdate(q);

    }
        
          public static void borrarUser(int id) {
        String q = "DELETE FROM USUARIOS WHERE ID ='" + id + "'";
        BaseDeDatos.ejecutarUpdate(q);
   

    }
          
             public static void modificarUser(Usuario x) {
        String q = "UPDATE USUARIOS SET NOMBRE = '" + x.getNombre() + "' ," +
                " DERECHOS ='" + x.getDerechos() + "' ," +
                " PASSWORD ='" + x.getPassword() + "'   " + "WHERE ID ='" + x.getId() + "'";
        BaseDeDatos.ejecutarUpdate(q);
      

    }
 
     
     
}