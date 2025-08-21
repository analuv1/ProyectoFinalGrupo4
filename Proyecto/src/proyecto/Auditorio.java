/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alons
 */
public class Auditorio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Auditorio.class.getName());

    private static final int CAPACIDAD_MAXIMA_SESION = 50; //se crea la constante para la maxima capacidad del arreglo
    private Entrada entrada; //se referencia el menu principal

    DefaultTableModel modelo = new DefaultTableModel() { //la tabla para mostrar los usuarios inscritos
        public boolean isCellEditable(int row, int column) {  //Para que las celdas no se puedan editar
            return false;
        }
    };

    Socio[] usuarios = new Socio[100]; //arreglo para ambos horarios del auditorio
    int cantidadUsuarios = 0;

    int cantidadUsuarios10AM = 0;  //contadores para los horarios
    int cantidadUsuarios3PM = 0;

    public Auditorio(Entrada entrada) { //parte de la construccion del JFrame
        initComponents();
        this.setTitle("Registrar en el Auditorio");
        this.setLocationRelativeTo(null);
        modelo.addColumn("Nombre"); //configuracion de las columnas del modelo de tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Horario");
        refrescarTabla();
        this.entrada = entrada;
        getContentPane().setBackground(Color.BLACK); //pone de color negro el fondo 
        tblAudi.getTableHeader().setBackground(Color.LIGHT_GRAY); //hace que la parte de arriba de la tabla se ponga en gris
        tblAudi.setBackground(Color.BLACK);

    }

    @SuppressWarnings("unchecked")

    public void refrescarTabla() {
        tblAudi.setModel(modelo); //se asigna el modelo a la table

    }

    private void agregarUsuarioAuditorio(Socio socio, String horario) {  //validacion del espacio por horario
        if (horario.equals("10 AM")) {
            if (cantidadUsuarios10AM >= CAPACIDAD_MAXIMA_SESION) {
                JOptionPane.showMessageDialog(this, "El horario 10 AM ya alcanzó el límite de 50 personas.");
                return;
            }
        } else if (horario.equals("3 PM")) {
            if (cantidadUsuarios3PM >= CAPACIDAD_MAXIMA_SESION) {
                JOptionPane.showMessageDialog(this, "El horario 3 PM ya alcanzó el límite de 50 personas.");
                return;
            }
        }

        if (cantidadUsuarios >= usuarios.length) {
            JOptionPane.showMessageDialog(this, "Se alcanzo el limite total de inscripciones en el auditorio");
            return;
        }

        // Validar si ya existe el socio en el horario
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null
                    && usuarios[i].getCodigo() == socio.getCodigo()
                    && usuarios[i].getHoraAudi().equals(horario)) {
                JOptionPane.showMessageDialog(this, "El socio ya está inscrito en este horario");
                return;
            }
        }

        Socio socioInscrito = new Socio(socio.getNombre(), socio.getCodigo(), socio.isMembresia(), horario);

        usuarios[cantidadUsuarios] = socioInscrito;
        cantidadUsuarios++;

        if (horario.equals("10 AM")) {
            cantidadUsuarios10AM++;
        } else if (horario.equals("3 PM")) {
            cantidadUsuarios3PM++;
        }

        modelo.addRow(new Object[]{
            socioInscrito.getNombre(),
            socioInscrito.getCodigo(),
            socioInscrito.getHoraAudi()
        });

        JOptionPane.showMessageDialog(this, "Socio " + socioInscrito.getNombre() + " registrado correctamente");
    }

    private void eliminarUsuarioAuditorio(int indice) {
        if (indice < 0 || indice >= cantidadUsuarios) {    //metodo para eliminar un usuario del auditorio
            JOptionPane.showMessageDialog(this, "Seleccion invalida para eliminar");
            return;
        }

        int codigoAEliminar = (int) modelo.getValueAt(indice, 1);  //obtener el socio de la tabla para determinar el horario
        String horarioAEliminar = (String) modelo.getValueAt(indice, 2);

        // Buscar y remover del arreglo interno
        int indiceEnArreglo = -1;
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null
                    && usuarios[i].getCodigo() == codigoAEliminar
                    && usuarios[i].getHoraAudi().equals(horarioAEliminar)) {
                indiceEnArreglo = i;
                break;
            }
        }

        if (indiceEnArreglo != -1) {
            // Decrementar contador de horario
            if (horarioAEliminar.equals("10 AM")) {
                cantidadUsuarios10AM--;
            } else { // 3 PM
                cantidadUsuarios3PM--;
            }

            // Desplazar elementos en el arreglo para eliminar el espacio
            for (int i = indiceEnArreglo; i < cantidadUsuarios - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[cantidadUsuarios - 1] = null; // Eliminar última referencia
            cantidadUsuarios--; // Decrementar el contador total

            // Remover fila de la tabla
            modelo.removeRow(indice);

            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente del auditorio.");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Socio no encontrado en el registro interno del auditorio.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectHorarioAudi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBorrarAudi = new javax.swing.JButton();
        btnAgregarAudi = new javax.swing.JButton();
        txtCodigoAudi = new javax.swing.JTextField();
        txtNombreAudi1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAudi = new javax.swing.JTable();
        MenuprincipalSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 102));
        jLabel2.setText("Nombre");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Codigo");

        selectHorarioAudi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10 AM", "3 PM", " " }));
        selectHorarioAudi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectHorarioAudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHorarioAudiActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 102));
        jLabel4.setText("Registrar usuario en el auditorio");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 102));
        jLabel5.setText("Horario");

        btnBorrarAudi.setBackground(new java.awt.Color(255, 204, 102));
        btnBorrarAudi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBorrarAudi.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarAudi.setText("Borrar");
        btnBorrarAudi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrarAudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAudiActionPerformed(evt);
            }
        });

        btnAgregarAudi.setBackground(new java.awt.Color(255, 204, 102));
        btnAgregarAudi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarAudi.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarAudi.setText("Agregar");
        btnAgregarAudi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarAudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAudiActionPerformed(evt);
            }
        });

        tblAudi.setBackground(new java.awt.Color(255, 204, 102));
        tblAudi.setForeground(new java.awt.Color(255, 255, 255));
        tblAudi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAudi);

        MenuprincipalSP.setBackground(new java.awt.Color(255, 204, 102));
        MenuprincipalSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MenuprincipalSP.setForeground(new java.awt.Color(0, 0, 0));
        MenuprincipalSP.setText("Volver al menu principal");
        MenuprincipalSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuprincipalSP.setFocusPainted(false);
        MenuprincipalSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuprincipalSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreAudi1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectHorarioAudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigoAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(btnAgregarAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBorrarAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(64, 64, 64)
                                .addComponent(MenuprincipalSP))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MenuprincipalSP))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreAudi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigoAudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(selectHorarioAudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAudiActionPerformed
        String codigoStr = txtCodigoAudi.getText().trim();
        if (codigoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código."); //En caso de que el espacio del codigo se envie vacio
            return;
        }

        int codigoIngresado;
        try {
            codigoIngresado = Integer.parseInt(codigoStr);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El código debe ser un número válido."); //valida si se ingresa un numero
            return;
        }

        try {
            Socio.cargarSocios();

            String horarioSeleccionado = selectHorarioAudi.getSelectedItem().toString();

            Socio socioExistente = Socio.buscarSocioPorCodigo(codigoIngresado);

            if (socioExistente == null) {
                JOptionPane.showMessageDialog(null, "El código ingresado no pertenece a ningún socio registrado."); //revisa el arreglo a ver si es valido el codigo
                return;
            }

            // Validar nombre
            String nombreIngresado = txtNombreAudi1.getText().trim();
            if (!nombreIngresado.equalsIgnoreCase(socioExistente.getNombre())) {
                JOptionPane.showMessageDialog(null, "El nombre ingresado no coincide con el código.");
                return;
            }

            if (!socioExistente.isMembresia()) {
                JOptionPane.showMessageDialog(null, "El socio no tiene una membresía activa.");
                return;
            }

            // Aqui se usa un metodo que actualiza tabla y arreglo
            agregarUsuarioAuditorio(
                    new Socio(socioExistente.getNombre(), socioExistente.getCodigo(), true, horarioSeleccionado),
                    horarioSeleccionado
            );

            // Limpiar campos
            txtNombreAudi1.setText("");
            txtCodigoAudi.setText("");
            selectHorarioAudi.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el socio: " + e.getMessage());
        }

    }//GEN-LAST:event_btnAgregarAudiActionPerformed

    private void btnBorrarAudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAudiActionPerformed

        int filaSeleccionada = tblAudi.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar."); //valida si se seleccion un usuario para eliminar
            return;
        }

        int indiceModelo = tblAudi.convertRowIndexToModel(filaSeleccionada); //convierte el dato de la tabla para eliminarlo en el arreglo
        eliminarUsuarioAuditorio(indiceModelo);
    }//GEN-LAST:event_btnBorrarAudiActionPerformed

    private void selectHorarioAudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHorarioAudiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectHorarioAudiActionPerformed

    private void MenuprincipalSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuprincipalSPActionPerformed
        this.setVisible(false);
        entrada.setVisible(true); //metodo para regresar al menu principal
    }//GEN-LAST:event_MenuprincipalSPActionPerformed

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuprincipalSP;
    private javax.swing.JButton btnAgregarAudi;
    private javax.swing.JButton btnBorrarAudi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectHorarioAudi;
    private javax.swing.JTable tblAudi;
    private javax.swing.JTextField txtCodigoAudi;
    private javax.swing.JTextField txtNombreAudi1;
    // End of variables declaration//GEN-END:variables
}
