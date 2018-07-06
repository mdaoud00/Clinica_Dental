/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlar;


public class Copia {
    
    int id;
    String date;
    String time;

    public Copia(int id, String date, String time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
