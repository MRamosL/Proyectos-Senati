/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import banco.nuevo.perú.Conexion;
import banco.nuevo.perú.MENÚ;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Historial extends javax.swing.JFrame {

    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        cbHistorial.addItem("Al día");
        cbHistorial.addItem("Deuda");
        mostrarHistorial();
    }

    
    public void mostrarHistorial(){
        try{
            Conexion cn = new Conexion();
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Historial_Crediticio");
            
            DefaultTableModel modelo = (DefaultTableModel)tblHistorial.getModel();
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            String[] columns = {"ID_Cliente", "Puntuacion_Credito", "Reportes_Credito", "Historial_Pagos"};
            
            for(String column: columns){
                modelo.addColumn(column);
}

            
            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("ID_Cliente")),
                    resultSet.getString("Puntuacion_Credito"),
                    resultSet.getString("Reportes_Credito"),                   
                    resultSet.getString("Historial_Pagos"),
                    
                };
                modelo.addRow(row);
        }
        tblHistorial.setModel(modelo);
        } catch(SQLException e){
            e.printStackTrace();           
        }
    }
    
    
    public void insertarHistorial(){
        try{
            int id = Integer.parseInt(txtIdCliente.getText());
            String Puntuacion = txtPuntuacion.getText();
            String Reportes= txtReportes.getText();
            String Historial = cbHistorial.getSelectedItem().toString();
                          
            Conexion cn = new Conexion();
            
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("INSERT INTO Historial_Crediticio VALUES(?, ?, ?, ? )");
             ps.setInt(1,id);
            ps.setString(2,Puntuacion);
            ps.setString(3,Reportes);
            ps.setString(4,Historial);
                                 
            int rows = ps.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Insert row succesfull");
                mostrarHistorial();
            } else {
                JOptionPane.showMessageDialog(null, "Insert row fail");
        } 
        } catch(SQLException e){
            e.printStackTrace();
}
        
}
    
        
    public void eliminarHistorial(){
        try{
            int Id_historial;
            Id_historial = Integer.parseInt(txtIdCliente.getText());        
            Conexion cn = new Conexion();
        
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Historial_Crediticio WHERE ID_Cliente = ?");
            preparedStatement.setInt(1, Id_historial); 
        
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Delete row succesfull");
                mostrarHistorial();
            } else {
                JOptionPane.showMessageDialog(null, "Delete row fail");
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
public void actualizarHistorial() {
    try {
        int id = Integer.parseInt(txtIdCliente.getText());
        String puntuacion = txtPuntuacion.getText();
        String reportes = txtReportes.getText();
        String historial = cbHistorial.getSelectedItem().toString();
       
        Conexion cn = new Conexion();
        Connection connection = cn.conectar();

        PreparedStatement ps = connection.prepareStatement("UPDATE Historial_Crediticio SET  Puntuacion_Credito = ?, Reportes_Credito = ?, Historial_Pagos = ? WHERE ID_Cliente = ?");

        ps.setString(1, puntuacion);
        ps.setString(2, reportes );
        ps.setString(3, historial);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Update row successful");
            mostrarHistorial();
        } else {
            JOptionPane.showMessageDialog(null, "Update row failed");
        }

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtReportes = new javax.swing.JTextField();
        txtPuntuacion = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnElimimar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbHistorial = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Historial Crediticio");

        jLabel2.setText("Id Cliente:");

        jLabel3.setText("Reportes:");

        jLabel4.setText("Puntuacion:");

        jLabel5.setText("Historial:");

        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnElimimar.setText("ELIMINAR");
        btnElimimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimimarActionPerformed(evt);
            }
        });

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Swis721 Lt BT", 0, 12)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnInsertar)
                                .addGap(48, 48, 48)
                                .addComponent(btnActualizar)
                                .addGap(52, 52, 52)
                                .addComponent(btnElimimar)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimimar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        insertarHistorial();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarHistorial();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnElimimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimimarActionPerformed
        // TODO add your handling code here:
        eliminarHistorial();
    }//GEN-LAST:event_btnElimimarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         MENÚ conexionFormularios = new MENÚ();
            conexionFormularios.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnElimimar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<String> cbHistorial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtPuntuacion;
    private javax.swing.JTextField txtReportes;
    // End of variables declaration//GEN-END:variables
}
