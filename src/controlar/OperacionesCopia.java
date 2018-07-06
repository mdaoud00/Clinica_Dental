/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlar;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mourad Daoudi
 */
public class OperacionesCopia {
    static Copia copiaPasado;
    static int id;
    static String date;
    static String time;
    static String fecha;

    public static Copia copiaDeLaBaseDeDatos() {
        Copia r = null;
       
        try {
           
            if (BaseDeDatos.resultado.next()) {
                id = Integer.parseInt(BaseDeDatos.resultado.getString("ID"));
                fecha = BaseDeDatos.resultado.getString("FECHA");
                String[] tokens = fecha.split("_");
                date = tokens[0];
                time = tokens[1];
               
               r = new Copia(id, date,
                        time);
            }
        } catch (SQLException e) {
            System.out.println("NO LO EJEUCTO dame user!!");
            e.printStackTrace();
        }
        return r;
    }
    
    public static ArrayList<Copia> buscarCopia() throws SQLException {
        
       ArrayList<Copia> r = new ArrayList();     
       String q = "SELECT *  FROM COPIAS ORDER BY ID ";
       BaseDeDatos.ejecutarConsulta(q);
       if (BaseDeDatos.resultado.next()){
                BaseDeDatos.resultado.beforeFirst();
            while (!BaseDeDatos.resultado.isLast()) {
              r.add(copiaDeLaBaseDeDatos());
            }
       }else{
             String msg = "No hay copias actualmente";
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
       }    

        return r;
    }
    
     public static ArrayList<Copia> buscarCopia(int id) throws SQLException {
        
       ArrayList<Copia> r = new ArrayList();     
        String q = "SELECT *  FROM COPIAS  " + "WHERE ID ='" + id + "' ORDER BY ID ";
       BaseDeDatos.ejecutarConsulta(q);
       if (BaseDeDatos.resultado.next()){
                BaseDeDatos.resultado.beforeFirst();
            while (!BaseDeDatos.resultado.isLast()) {
              r.add(copiaDeLaBaseDeDatos());
            }
            }else{
           
             String msg = "La copia no existe";
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
          
       }

        return r;
    }
    
        public static void insertarCopia(Copia x) {
        
        String res=x.getDate() + "_" +
        x.getTime();
        String q = "INSERT INTO COPIAS VALUES ('" + x.getId() + "','" + res + "')";
        BaseDeDatos.ejecutarUpdate(q);
        String msg = "Copia realizada";
            JOptionPane.showMessageDialog(null, msg, "Confirmacion", 1);
//        JOptionPane.showMessageDialog(null, "Vaca Insertada");

    }
        
          public static void borrarCopia(int id) {
        String q = "DELETE FROM COPIAS WHERE ID ='" + id + "'";
        BaseDeDatos.ejecutarUpdate(q);
   //     JOptionPane.showMessageDialog(null, "Vaca Borrada");
         String msg = "Copia eliminada";
            JOptionPane.showMessageDialog(null, msg, "Confirmacion", 1);

    }
     
}

