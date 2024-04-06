
package Formularios;

import banco.nuevo.perú.Conexion;
import banco.nuevo.perú.MENÚ;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Prestamos extends javax.swing.JFrame {

    /**
     * Creates new form Prestamos
     */
    public Prestamos() {
        initComponents();
        cbTipo.addItem("Hipotecario");
        cbTipo.addItem("Personal");
        cbTipo.addItem("Educacional");
        mostrarPrestamos();
    }
    
 
    public void mostrarPrestamos(){
        try{
            Conexion cn = new Conexion();
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Prestamos");
            
            DefaultTableModel modelo = (DefaultTableModel)tblPrestamos.getModel();
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            String[] columns = {"ID_Préstamo", "ID_Cliente", "Tipo_Prestamo", "Monto_Otorgado", "Tasa_Interes", "Fecha_Inicio", "Fecha_Termino" };
            
            for(String column: columns){
                modelo.addColumn(column); 
}

            
            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("ID_Préstamo")),
                    resultSet.getString("ID_Cliente"),
                    resultSet.getString("Tipo_Prestamo"),
                    resultSet.getString("Monto_Otorgado"),
                    resultSet.getString("Tasa_Interes"),
                    resultSet.getString("Fecha_Inicio"),
                    resultSet.getString("Fecha_Termino"),

                };
                modelo.addRow(row);
        }
        tblPrestamos.setModel(modelo);
        } catch(SQLException e){
            e.printStackTrace();           
        }
    }
    
    
        public void insertarPrestamos(){
        try{
            int id = Integer.parseInt(txtIdPrestamo.getText());
            String ID_Cliente = txtIdCliente.getText();
            String Tipo_Prestamo = cbTipo.getSelectedItem().toString();
            String Monto_Otorgado = txtMonto.getText();
            String Tasa_Interes = txtTasaIn.getText();
            String Fecha_Inicio = txtInicio.getText();
            String Fecha_Termino = txtTermino.getText();
          
            
            Conexion cn = new Conexion();
            
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("INSERT INTO Prestamos VALUES(?, ?, ?, ?, ?, ?, ?)");
             ps.setInt(1,id);
            ps.setString(2,ID_Cliente);
            ps.setString(3,Tipo_Prestamo);
            ps.setString(4,Monto_Otorgado);
            ps.setString(5,Tasa_Interes);
            ps.setString(6,Fecha_Inicio);
            ps.setString(7,Fecha_Termino);
            
          
            
            int rows = ps.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Prestamo Insertado Exitosamente ");
                mostrarPrestamos();
            } else {
                JOptionPane.showMessageDialog(null, "Error Insertar");
        } 
        } catch(SQLException e){
            e.printStackTrace();
}
        
}  
        

        
     
        
   public void eliminarPrestamos(){
        try{
            int ID_Préstamo;
            ID_Préstamo = Integer.parseInt(txtIdPrestamo.getText());        
            Conexion cn = new Conexion();
        
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Prestamos WHERE ID_Préstamo = ?");
            preparedStatement.setInt(1, ID_Préstamo); 
        
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
                mostrarPrestamos();
            } else {
                JOptionPane.showMessageDialog(null, "Error en la Eliminación");
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
public void actualizarPrestamos() {
    try {
        int id = Integer.parseInt(txtIdPrestamo.getText());
        String ID_Cliente = txtIdCliente.getText();
        String Tipo_Prestamo = cbTipo.getSelectedItem().toString();
        String Monto_Otorgado = txtMonto.getText();
        String Tasa_Interes = txtTasaIn.getText();
        String Fecha_Inicio = txtInicio.getText();
        String Fecha_Termino = txtTermino.getText();

        Conexion cn = new Conexion();
        PreparedStatement ps = cn.conectar().prepareStatement("UPDATE Prestamos SET ID_Cliente = ?, Tipo_Prestamo = ?, Monto_Otorgado = ?, Tasa_Interes = ?, Fecha_Inicio = ?, Fecha_Termino = ? WHERE ID_Préstamo = ?");
        ps.setString(1, ID_Cliente);
        ps.setString(2, Tipo_Prestamo);
        ps.setString(3, Monto_Otorgado);
        ps.setString(4, Tasa_Interes);
        ps.setString(5, Fecha_Inicio);
        ps.setString(6, Fecha_Termino);
        ps.setInt(7, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
            mostrarPrestamos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar del préstamo");
        }
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

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTermino = new javax.swing.JTextField();
        txtTasaIn = new javax.swing.JTextField();
        txtIdPrestamo = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtInicio = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox<>();

        jLabel5.setText("Id Cliente:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Prestamos");

        jLabel2.setText("Id Préstamo:");

        jLabel3.setText("Tipo de Prést.. :");

        jLabel4.setText("Id Cliente:");

        jLabel6.setText("Monto Otorgado:");

        jLabel7.setText("Tasa Interes:");

        jLabel8.setText("Fecha Inicio:");

        jLabel9.setText("Fecha Termino:");

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

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPrestamos);

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
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTasaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(btnActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnInsertar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(25, 25, 25))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtIdPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtTasaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        insertarPrestamos();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarPrestamos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarPrestamos();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamos;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTasaIn;
    private javax.swing.JTextField txtTermino;
    // End of variables declaration//GEN-END:variables
}
