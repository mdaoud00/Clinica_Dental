/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlDental;

/**
*
* @author Mourad Daoudi
*/
public class Usuario {
    
    int id;
    String nombre;
    String password;
    int derechos;

    public Usuario(int id, String nombre, int derechos, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.derechos = derechos;
    }

    public int getDerechos() {
        return derechos;
    }

    public void setDerechos(int derechos) {
        this.derechos = derechos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
