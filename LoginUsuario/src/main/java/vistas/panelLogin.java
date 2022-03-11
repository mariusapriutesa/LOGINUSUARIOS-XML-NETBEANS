/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;


import Clases.Usuarios;
import Clases.XMLHandler;



import clases.validation;



public class panelLogin extends javax.swing.JPanel {

    /**
     * Creates new form panel1
     */
    
  //  MainWindows mainWindows;
    
    public panelLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        txContrasena = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbRecordarme = new javax.swing.JCheckBox();
        txError = new javax.swing.JLabel();

        jLabel1.setText("USUARIO:");

        jLabel2.setText("CONTRASEÑA:");

        txUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUsuarioActionPerformed(evt);
            }
        });

        jButton2.setText("Acceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("LOGIN");

        cbRecordarme.setText("Recordarme");
        cbRecordarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRecordarmeActionPerformed(evt);
            }
        });

        txError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txError.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel3)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txError, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbRecordarme)
                        .addComponent(txUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addComponent(txContrasena)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txError, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRecordarme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    
    private void txUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUsuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     //Buton Acceptar
      String mensajeValidacion = validation.validarCamposVacios(txUsuario.getText(), txContrasena.getText());
        
        if(mensajeValidacion.equals(""))
        {   
            Usuarios user = XMLHandler.comprobarExistencia(txUsuario.getText());
            if(!txUsuario.getText().equals(user.getNombre()))
            {
                txError.setText("El usuario no existe");
            }
            else if(!txContrasena.getText().equalsIgnoreCase(user.getContrasena()))
            {
                txError.setText("Contraseña incorrecta");

            }
            else if(txUsuario.getText().equals(user.getNombre()) && txContrasena.getText().equalsIgnoreCase(user.getContrasena()))
            {
                MainWindows.btLogin.setText("Logout");
                MainWindows.txtUsuarioActivo.setText(user.getNombre());
                MainWindows.txtCorreo.setText(user.getCorreo());
                if(user.getRol().equals("admin"))
                {
                    MainWindows.navegar("pAdmin");
                }
                else if(user.getRol().equals("user"))
                {
                    MainWindows.navegar("pUsuario");
                }
            }
        }
        else
        {
            txError.setText(mensajeValidacion);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbRecordarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRecordarmeActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_cbRecordarmeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox cbRecordarme;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JTextField txContrasena;
    public static javax.swing.JLabel txError;
    public static javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
