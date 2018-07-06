/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlar;

import controlDental.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mourad Daoudi
 */
public class TransaccionCliente {
    static int  dni;
    static String nombre;
    static String apellidos;
    static String sexo;
    static String fechaNacimiento;
    static String direccion;
    static String localidad;
    static int codigo_postal;
    static String alergias;
    static String descripcion;
    
    public static Cliente darCliente() {
        Cliente cliente = null;

        try {

            if (BaseDeDatos.resultado.next()) {
                dni = Integer.parseInt(BaseDeDatos.resultado.getString("DNI"));
                nombre = BaseDeDatos.resultado.getString("NOMBRE");
                apellidos = BaseDeDatos.resultado.getString("APELLIDOS");
                sexo = BaseDeDatos.resultado.getString("SEXO");
                fechaNacimiento = BaseDeDatos.resultado.getString("FECHA_NACIMIENTO");
                                if (fechaNacimiento != null) {
                    String[] tokens = fechaNacimiento.split(" ");
                    String[] tokens2 = tokens[0].split("-");
                    fechaNacimiento = tokens2[2] + "/" + tokens2[1] + "/" + tokens2[0];
                }
                direccion = BaseDeDatos.resultado.getString("DIRECCION");
                localidad = BaseDeDatos.resultado.getString("LOCALIDAD");
                codigo_postal = BaseDeDatos.resultado.getInt("CP");
                alergias = BaseDeDatos.resultado.getString("ALERGIAS");
                descripcion = BaseDeDatos.resultado.getString("DESCRIPCION");

                cliente = new Cliente(dni, nombre, apellidos,sexo, fechaNacimiento,
                        direccion, localidad, codigo_postal, alergias, descripcion);
            }
        } catch (SQLException e) {
            System.out.println("No se ha ejecutado, dame un cliente!!");
            e.printStackTrace();
        }
        return cliente;
    }
    
    public static Cliente primer() {
        Cliente cliente = null;

        try {

            if (BaseDeDatos.resultado.first()) {

                dni = Integer.parseInt(BaseDeDatos.resultado.getString("DNI"));
                nombre = BaseDeDatos.resultado.getString("NOMBRE");
                apellidos = BaseDeDatos.resultado.getString("APELLIDOS");
                sexo = BaseDeDatos.resultado.getString("SEXO");
                fechaNacimiento = BaseDeDatos.resultado.getString("FECHA_NACIMIENTO");
                direccion = BaseDeDatos.resultado.getString("DIRECCION");
                direccion = BaseDeDatos.resultado.getString("LOCALIDAD");
                codigo_postal = BaseDeDatos.resultado.getInt("CP");
                alergias = BaseDeDatos.resultado.getString("ALERGIAS");
                descripcion = BaseDeDatos.resultado.getString("DESCRIPCION");

                cliente = new Cliente(dni, nombre, apellidos,sexo, fechaNacimiento,
                        direccion, localidad, codigo_postal, alergias, descripcion);
            }
        } catch (SQLException e) {
            System.out.println("No se ha ejecutado, dame el primero");
            e.printStackTrace();
        }
        return cliente;
    }

    public static void insertarCliente(Cliente c) {
        String q = "INSERT INTO CLIENTES VALUES ('" + c.getDni() + "','" + c.getNombre() + "','" + c.getApellidos() + "','" + c.getSexo() + "','" + c.getFechaNacimiento() + "','" + c.getDireccion() + "','" + c.getLocalidad()+ "','" + c.getCodigo_postal()+ "','" + c.getAlergias()+ "','" + c.getDescripcion() + "')";
        BaseDeDatos.ejecutarUpdate(q);

    }

    public static void borrarCliente(int dni) {
        String q = "DELETE FROM CLIENTES WHERE DNI ='" + dni + "'";
        BaseDeDatos.ejecutarUpdate(q);
        //     JOptionPane.showMessageDialog(null, "Cliente Borrado");


    }

    public static void modificarCliente(Cliente c) {
        String q = "UPDATE CLIENTES SET NOMBRE = '" + c.getNombre() + "' ,"
                + " APELLIDOS ='" + c.getApellidos() + "' ,"
                + " SEXO ='" + c.getSexo() + "' ,"
                + " FECHA_NACIMIENTO ='" + c.getFechaNacimiento() + "' ,"
                + " DIRECCION ='" + c.getDireccion() + "' ,"
                + " LOCALIDAD ='" + c.getLocalidad() + "' ,"
                + " CP ='" + c.getCodigo_postal() + "' ,"
                + " ALERGIAS ='" + c.getAlergias() + "' ,"
                + " DESCRIPCION ='" + c.getDescripcion() + "'   " + "WHERE DNI ='" + c.getDni() + "'";
        BaseDeDatos.ejecutarUpdate(q);
        //  JOptionPane.showMessageDialog(null, "Vaca Actualizada");
        String msg = "Cliente Modificado correctamente";
        JOptionPane.showMessageDialog(null, msg, "Confirmacion", 1);

    }

    public static ArrayList<Cliente> buscarClientePorNombre(String nombre, String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE NOMBRE ='" + nombre + "'ORDER BY " + ordenado;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;
    }

    public static ArrayList<Cliente> buscarClientePorDni(int dni, String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE DNI ='" + dni + "' ORDER BY " + ordenado ;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;

    }

    public static ArrayList<Cliente> buscarClientePorFechaNacimiento(String fechaNacimiento, String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE FECHA_NACIMIENTO ='" + fechaNacimiento + "' ORDER BY " + ordenado ;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;

    }

    public static ArrayList<Cliente> buscarClientePorApellidos(String apellidos, String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE APELLIDOS ='" + apellidos + "' ORDER BY " + ordenado ;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;

    }

    public static ArrayList<Cliente> buscarClientePorSexo(String sexo, String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE SEXO ='" + sexo + "' ORDER BY " + ordenado ;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;

    }

    public static ArrayList<Cliente> buscarClientePorCodigoPostal(int codigo_postal, String ordenado) {
               ArrayList<Cliente> clientes = new ArrayList();
        try {
            String consulta = "SELECT *  FROM CLIENTES  " + "WHERE CP ='" + codigo_postal + "' ORDER BY " + ordenado ;
            BaseDeDatos.ejecutarConsulta(consulta);
            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "El cliente no existe";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
        } catch (SQLException ex) {
        }
        return clientes;

    }

    public static ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> clientes = new ArrayList();
        try {

            Cliente c = null;
            String q = "SELECT *  FROM CLIENTES ORDER BY DNI ";
            BaseDeDatos.ejecutarConsulta(q);
            //System.out.println(ServiciosBD.resultado.getRow());
            // if (ServiciosBD.resultado.getRow()!=0){

            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "Actualmente no hay clientes en la base de datos ";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
            /*   }else{
             System.out.println("vacio");
             }*/

        } catch (SQLException ex) {
        }
        return clientes;
    }

    public static ArrayList<Cliente> listarCliente(String ordenado) {
        ArrayList<Cliente> clientes = new ArrayList();
        try {

            Cliente c = null;
            String q = "SELECT *  FROM CLIENTES ORDER BY " + ordenado;
            BaseDeDatos.ejecutarConsulta(q);
            //System.out.println(ServiciosBD.resultado.getRow());
            // if (ServiciosBD.resultado.getRow()!=0){

            if (BaseDeDatos.resultado.next()) {
                BaseDeDatos.resultado.beforeFirst();
                while (!BaseDeDatos.resultado.isLast()) {
                    clientes.add(darCliente());
                }
            } else {
                String msg = "Actualmente no hay clientes en la base de datos ";
                JOptionPane.showMessageDialog(null, msg, "Error", 0);
            }
            /*   }else{
             System.out.println("vacio");
             }*/

        } catch (SQLException ex) {
        }
        return clientes;
    }
}
