/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;

public class Entrada extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Entrada.class.getName());

    private SalaPesas SalaPesas; //Se declaran las ventanas como atributos
    private Auditorio Auditorio;
    private EspaciosRctvos EspaciosRctvos;
    private PantallaParqueo PantallaParqueo;
    private SistemaReservaER sistemaReservaER;
    private Parqueo parqueo;
    
    

    public Entrada() {
        initComponents();

        //Importa la imagen de la carpeta fotos, y le da las dimensiones necesarias
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/fotos/smartfi.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        jLabel4.setIcon(iconoEscalado);

        //Crea el borde gris del panel verde
        jPanelVerde.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, Color.DARK_GRAY));

        //Le da color al fondo del menu principal
        this.getContentPane().setBackground(Color.BLACK);

        this.setLocationRelativeTo(null);  //Centra la ventana emergente al centro de la pantalla

        SalaPesas = new SalaPesas(this); //se inicializan los atributos
        Auditorio = new Auditorio(this);
        EspaciosRctvos = new EspaciosRctvos(this);
        parqueo = new Parqueo();

        

    }
    
    public Entrada(Parqueo parqueo){
        this();
        this.parqueo = parqueo;
    }
    
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnParqueo = new javax.swing.JButton();
        btnEspaciosRctvos = new javax.swing.JButton();
        btnSocios = new javax.swing.JButton();
        btnSalaPesas = new javax.swing.JButton();
        btnClases = new javax.swing.JButton();
        btnCabinas = new javax.swing.JButton();
        btnAuditorio = new javax.swing.JButton();
        jPanelVerde = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Elegí una de las siguientes opciones para continuar");

        btnParqueo.setBackground(new java.awt.Color(255, 204, 102));
        btnParqueo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnParqueo.setForeground(new java.awt.Color(0, 0, 0));
        btnParqueo.setText("Parqueo");
        btnParqueo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParqueoActionPerformed(evt);
            }
        });

        btnEspaciosRctvos.setBackground(new java.awt.Color(255, 204, 102));
        btnEspaciosRctvos.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        btnEspaciosRctvos.setForeground(new java.awt.Color(0, 0, 0));
        btnEspaciosRctvos.setText("Espacios Recreativos");
        btnEspaciosRctvos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEspaciosRctvos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspaciosRctvosActionPerformed(evt);
            }
        });

        btnSocios.setBackground(new java.awt.Color(255, 204, 102));
        btnSocios.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSocios.setForeground(new java.awt.Color(0, 0, 0));
        btnSocios.setText("Socios");
        btnSocios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSociosActionPerformed(evt);
            }
        });

        btnSalaPesas.setBackground(new java.awt.Color(255, 204, 102));
        btnSalaPesas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSalaPesas.setForeground(new java.awt.Color(0, 0, 0));
        btnSalaPesas.setText("Sala de Pesas");
        btnSalaPesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalaPesas.setFocusPainted(false);
        btnSalaPesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaPesasActionPerformed(evt);
            }
        });

        btnClases.setBackground(new java.awt.Color(255, 204, 102));
        btnClases.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnClases.setForeground(new java.awt.Color(0, 0, 0));
        btnClases.setText("Clases");
        btnClases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasesActionPerformed(evt);
            }
        });

        btnCabinas.setBackground(new java.awt.Color(255, 204, 102));
        btnCabinas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnCabinas.setForeground(new java.awt.Color(0, 0, 0));
        btnCabinas.setText("Cabinas");
        btnCabinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCabinas.setFocusPainted(false);
        btnCabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabinasActionPerformed(evt);
            }
        });

        btnAuditorio.setBackground(new java.awt.Color(255, 204, 102));
        btnAuditorio.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnAuditorio.setForeground(new java.awt.Color(0, 0, 0));
        btnAuditorio.setText("Auditorio");
        btnAuditorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAuditorio.setFocusPainted(false);
        btnAuditorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditorioActionPerformed(evt);
            }
        });

        jPanelVerde.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(255, 204, 102));
        jLabel4.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido al Gimnasio SmartFit");

        javax.swing.GroupLayout jPanelVerdeLayout = new javax.swing.GroupLayout(jPanelVerde);
        jPanelVerde.setLayout(jPanelVerdeLayout);
        jPanelVerdeLayout.setHorizontalGroup(
            jPanelVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVerdeLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVerdeLayout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelVerdeLayout.setVerticalGroup(
            jPanelVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVerdeLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnParqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(btnSalaPesas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnClases, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEspaciosRctvos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAuditorio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCabinas)
                    .addComponent(btnAuditorio))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClases)
                    .addComponent(btnEspaciosRctvos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParqueo)
                    .addComponent(btnSalaPesas))
                .addGap(61, 61, 61)
                .addComponent(btnSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAuditorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditorioActionPerformed
        this.setVisible(false); //oculta el menu
        Auditorio.setVisible(true); //muestra la misma ventana de antes
    }//GEN-LAST:event_btnAuditorioActionPerformed

    private void btnParqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParqueoActionPerformed
        this.setVisible(false);
        PantallaParqueo ventanaSala = new PantallaParqueo(parqueo, this);          //Hace que el boton parqueo rediriga a el jframe del parqueo
        ventanaSala.setVisible(true);
    }//GEN-LAST:event_btnParqueoActionPerformed

    private void btnClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasesActionPerformed
        this.setVisible(false);
        Clases ventanaClase = new Clases(this);  //Hace que el boton clases rediriga a el jframe de las clases
        ventanaClase.setVisible(true);
    }//GEN-LAST:event_btnClasesActionPerformed

    private void btnSalaPesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaPesasActionPerformed
        this.setVisible(false); //oculta el menu
        SalaPesas.setVisible(true); //muestra la misma ventana de antes
    }//GEN-LAST:event_btnSalaPesasActionPerformed

    private void btnCabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabinasActionPerformed
        this.setVisible(false);
        Cabinas ventanaSala = new Cabinas(this);  //Hace que el boton cabinas rediriga a el jframe de las cabinas
        ventanaSala.setVisible(true);
    }//GEN-LAST:event_btnCabinasActionPerformed

    private void btnEspaciosRctvosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspaciosRctvosActionPerformed
        this.setVisible(false);
        EspaciosRctvos.setVisible(true);
    }//GEN-LAST:event_btnEspaciosRctvosActionPerformed

    private void btnSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSociosActionPerformed
        this.setVisible(false);
        Socios ventanaSala = new Socios(this);   //Hace que el boton de los socios rediriga a el jframe de los socios
        ventanaSala.setVisible(true);
    }//GEN-LAST:event_btnSociosActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Entrada().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuditorio;
    private javax.swing.JButton btnCabinas;
    private javax.swing.JButton btnClases;
    private javax.swing.JButton btnEspaciosRctvos;
    private javax.swing.JButton btnParqueo;
    private javax.swing.JButton btnSalaPesas;
    private javax.swing.JButton btnSocios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelVerde;
    // End of variables declaration//GEN-END:variables

    
}
