/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import controlDental.Usuario;
import java.sql.SQLException;
import java.util.ArrayList; 
import javax.swing.JOptionPane;
import controlar.BaseDeDatos;
import controlar.TransaccionUsuario;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mourad Daoudi
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        jTextField1.grabFocus();//aparezca el cursor directamente y no haya que pinchar en el cuadro de texto
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Dental");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono_diente.png")));
        setResizable(false);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jLabel1.setText("USUARIO:");

        jLabel3.setText("CONTRASEÑA:");

        jLabel2.setText("Inicio de Sesión en Gestión Dental");

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPasswordField1))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(1, 1, 1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.dispose();
            
            ArrayList<Usuario> u = new ArrayList();
            String usuario = jTextField1.getText();
            String password = jPasswordField1.getText();
            
            BaseDeDatos.conectar();
        try {
            u = TransaccionUsuario.buscarUser();
        } catch (SQLException ex) {
       //     Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
            int i=0;
            boolean found = false;
            
            for (i=0; i<u.size();i++){
               // System.out.println(u.get(i).getNombre());
                if (u.get(i).getNombre().compareTo(usuario)==0){
                    found = true;
                    break;
                }
            }
            
            if (!found){
                
                 String msg = "Este usuario no existe. Introduce usuario válido";
                 JOptionPane.showMessageDialog(null, msg, "Error", i);
                 new VentanaInicio().setVisible(true);
                                          
            }else{
                    
            if (u.get(i).getPassword().compareTo(password)!=0){
               String msg = "Contraseña incorrecta";
            JOptionPane.showMessageDialog(null, msg, "Error", i);
           new VentanaInicio().setVisible(true);
            }else{
                if (u.get(i).getDerechos() == 1){
                    menuAdmin menuAdmin = new menuAdmin();
                    menuAdmin.setExtendedState(MAXIMIZED_BOTH);
                    menuAdmin.setVisible(true);
                }else{
                //Cuando tenga los clientes descomento esto para los usuarios.
                    menuUsuario menuU = new menuUsuario();
                 menuU.setExtendedState(MAXIMIZED_BOTH);
                 menuU.setVisible(true);
                }
            }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String msg = "Para iniciar sesión en la aplicación, usted deberá introducir un usuario válido, previamente dado de alta en el sistema y con la contraseña que se le ha proporcionado.";
        JOptionPane.showMessageDialog(null,msg);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.dispose();

            ArrayList<Usuario> u = new ArrayList();
            String usuario = jTextField1.getText();
            String password = jPasswordField1.getText();

            BaseDeDatos.conectar();
            try {
                u = TransaccionUsuario.buscarUser();
            } catch (SQLException ex) {
                //     Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = 0;
            boolean found = false;

            for (i = 0; i < u.size(); i++) {
                // System.out.println(u.get(i).getNombre());
                if (u.get(i).getNombre().compareTo(usuario) == 0) {
                    found = true;
                    break;
                }
            }

            if (!found) {

                String msg = "Este usuario no existe. Introduce usuario válido";
                JOptionPane.showMessageDialog(null, msg, "Error", i);
                new VentanaInicio().setVisible(true);

            } else {

                if (u.get(i).getPassword().compareTo(password) != 0) {
                    String msg = "Contraseña incorrecta";
                    JOptionPane.showMessageDialog(null, msg, "Error", i);
                    new VentanaInicio().setVisible(true);
                } else {
                    if (u.get(i).getDerechos() == 1) {
                        menuAdmin menuR = new menuAdmin();
                        menuR.setExtendedState(MAXIMIZED_BOTH);
                        menuR.setVisible(true);
                    } else {
                        //Cuando tenga los clientes descomento esto para los usuarios.
                        menuUsuario menuU = new menuUsuario();
                        menuU.setExtendedState(MAXIMIZED_BOTH);
                        menuU.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
