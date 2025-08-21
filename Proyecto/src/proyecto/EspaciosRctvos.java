/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author alons
 */
public class EspaciosRctvos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EspaciosRctvos.class.getName());

    private Entrada entrada;
    private ReservaER reservaER;//se referencia el menu principal
    private SistemaReservaER sistemaReservaER;

    public EspaciosRctvos(Entrada entrada) {
        initComponents();

        this.getContentPane().setBackground(Color.black);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Espacios recreativos - Reservas");
        this.entrada = entrada;
        this.sistemaReservaER = new SistemaReservaER();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarReserva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agregarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eliminarReserva = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBaloncesto = new javax.swing.JTextField();
        jTextFieldPingPong = new javax.swing.JTextField();
        jTextFieldTenis = new javax.swing.JTextField();
        jTextFieldBillar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        actualizarReserva = new javax.swing.JButton();
        jTextFieldFutbol = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mostrarReserva.setBackground(new java.awt.Color(255, 204, 102));
        mostrarReserva.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        mostrarReserva.setForeground(new java.awt.Color(0, 0, 0));
        mostrarReserva.setText("Mostrar Reservas");
        mostrarReserva.setBorderPainted(false);
        mostrarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarReservaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 102));
        jLabel2.setText("Futbol");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 102));
        jLabel5.setText("Reservas de mesas");

        agregarReserva.setBackground(new java.awt.Color(255, 204, 102));
        agregarReserva.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        agregarReserva.setForeground(new java.awt.Color(0, 0, 0));
        agregarReserva.setText("Agregar Reservas");
        agregarReserva.setBorderPainted(false);
        agregarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarReservaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESPACIOS RECREATIVOS");
        jLabel1.setToolTipText("");

        eliminarReserva.setBackground(new java.awt.Color(255, 204, 102));
        eliminarReserva.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        eliminarReserva.setForeground(new java.awt.Color(0, 0, 0));
        eliminarReserva.setText("Eliminar Reservas");
        eliminarReserva.setBorderPainted(false);
        eliminarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarReservaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 102));
        jLabel4.setText("Tenis");

        jTextFieldBaloncesto.setEditable(false);
        jTextFieldBaloncesto.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jTextFieldPingPong.setEditable(false);
        jTextFieldPingPong.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jTextFieldPingPong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPingPongActionPerformed(evt);
            }
        });

        jTextFieldTenis.setEditable(false);
        jTextFieldTenis.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jTextFieldTenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenisActionPerformed(evt);
            }
        });

        jTextFieldBillar.setEditable(false);
        jTextFieldBillar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 102));
        jLabel8.setText("Reservas de canchas");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 102));
        jLabel6.setText("Ping Pong");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Baloncesto");

        actualizarReserva.setBackground(new java.awt.Color(255, 204, 102));
        actualizarReserva.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        actualizarReserva.setForeground(new java.awt.Color(0, 0, 0));
        actualizarReserva.setText("Actualizar Reservas");
        actualizarReserva.setBorderPainted(false);
        actualizarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarReservaActionPerformed(evt);
            }
        });

        jTextFieldFutbol.setEditable(false);
        jTextFieldFutbol.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 102));
        jLabel7.setText("Billard");

        MenuPrincipal.setBackground(new java.awt.Color(255, 204, 102));
        MenuPrincipal.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        MenuPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        MenuPrincipal.setText("Volver al menu principal");
        MenuPrincipal.setBorderPainted(false);
        MenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eliminarReserva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(actualizarReserva))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarReserva)
                                .addGap(18, 18, 18)
                                .addComponent(mostrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(MenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldBillar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(35, 35, 35)
                                    .addComponent(jTextFieldPingPong, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(82, 82, 82)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFutbol, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBaloncesto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrarReserva)
                            .addComponent(agregarReserva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminarReserva)
                            .addComponent(actualizarReserva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MenuPrincipal))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(173, 173, 173))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldPingPong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBillar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldFutbol, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldBaloncesto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarReservaActionPerformed
        // TODO add your handling code here:
        sistema.verReservas();
        mostrarContadores();
    }//GEN-LAST:event_mostrarReservaActionPerformed

    private void agregarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarReservaActionPerformed
        sistema.agregarReserva();
        mostrarContadores();
        
    }//GEN-LAST:event_agregarReservaActionPerformed

    private void eliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarReservaActionPerformed
        // TODO add your handling code here:
        sistema.eliminarReserva();
        mostrarContadores();
    }//GEN-LAST:event_eliminarReservaActionPerformed

    private void jTextFieldPingPongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPingPongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPingPongActionPerformed

    private void jTextFieldTenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenisActionPerformed

    private void actualizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarReservaActionPerformed
        // TODO add your handling code here:
        sistema.actualizarReserva();
        mostrarContadores();
    }//GEN-LAST:event_actualizarReservaActionPerformed

    private void MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPrincipalActionPerformed
        this.setVisible(false);
        entrada.setVisible(true);
    }//GEN-LAST:event_MenuPrincipalActionPerformed

    public void mostrarContadores() {

        if (sistema == null) {
            return;
        }

        sistema.actualizarContadores();

        jTextFieldPingPong.setText(sistema.contadoresPorTipo[0] + " reservas");
        jTextFieldBillar.setText(sistema.contadoresPorTipo[1] + " reservas");
        jTextFieldFutbol.setText(sistema.contadoresPorTipo[2] + " reservas");
        jTextFieldBaloncesto.setText(sistema.contadoresPorTipo[3] + " reservas");
        jTextFieldTenis.setText(sistema.contadoresPorTipo[4] + " reservas");
    }

    static SistemaReservaER sistema = new SistemaReservaER();

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EspaciosRctvos v = new EspaciosRctvos(null);
                v.mostrarContadores();
                v.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuPrincipal;
    private javax.swing.JButton actualizarReserva;
    private javax.swing.JButton agregarReserva;
    private javax.swing.JButton eliminarReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldBaloncesto;
    private javax.swing.JTextField jTextFieldBillar;
    private javax.swing.JTextField jTextFieldFutbol;
    private javax.swing.JTextField jTextFieldPingPong;
    private javax.swing.JTextField jTextFieldTenis;
    private javax.swing.JButton mostrarReserva;
    // End of variables declaration//GEN-END:variables
}
