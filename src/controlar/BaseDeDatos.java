package controlar;

import java.sql.*;

public class BaseDeDatos {

    static Connection conexion;
    static Statement sentencia;
    static ResultSet resultado;
    static String query = "";

    public static void conectar() {
        String ruta = "jdbc:oracle:thin:@localhost:1521:xe";
            String usuario = "GESTIONDENTAL";
           
        String password = "12345";
            
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(ruta, usuario, password);
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        //    System.out.println("CONECTO BIEN!!!");
        } catch (InstantiationException e) {
          //  System.out.println("NO CONECTO InstantiationException!!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
          //  System.out.println("NO CONECTO IllegalAccessException!!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           // System.out.println("NO CONECTO ClassNotFoundException!!");
            e.printStackTrace();
        } catch (SQLException e) {
            //System.out.println("NO CONECTO SQLException!!");
            e.printStackTrace();
        }
    }

    public static void ejecutarConsulta(String q) {
        
    
        query = q;

        try {


            resultado = sentencia.executeQuery(query);
            //System.out.println("se ejecuto consultar");
          //  System.out.println(resultado.);

        } catch (SQLException e) {
            //System.out.println("NO LO EJEUCTO consultar!!");
            e.printStackTrace();
        }
    }

    public static void ejecutarUpdate(String q) {
        query = q;

        try {

             //System.out.println(query);
            sentencia.executeUpdate(query);


        } catch (SQLException e) {
            //System.out.println("NO LO EJEUCTO update!!");
            e.printStackTrace();
        }
    }
}