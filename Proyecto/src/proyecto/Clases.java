/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import proyecto.Entrada;
import proyecto.Entrada;
import proyecto.Socio;

/**
 *
 * @author Dell 7490
 */
public class Clases extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Clases.class.getName());

    /**
     * Creates new form Clases
     */
    private JTextField txtNombreClase, txtCapacidad, txtNombreParticipante;
    private JComboBox<String> comboHorario, comboClases;
    private JTable tablaClases, tablaParticipantes;
    private static DefaultTableModel modeloClases, modeloParticipantes;
    private JButton btnAgregarClase, btnBorrarClase, btnAgregarParticipante, btnBorrarParticipante, btnMenu;
    private Entrada entrada;

    // Almacenamiento de datos en memoria para la sesión
    private static final int MAX_CLASES = 50; // Limite fijo para el número de clases
    private static final int MAX_PARTICIPANTES_POR_CLASE = 50; // Limite fijo de participantes
    
    private String[] nombresClases = new String[MAX_CLASES];
    private int[] capacidadClases = new int[MAX_CLASES];
    private String[] horarioClases = new String[MAX_CLASES];
    private int contadorClases = 0;
    
    private String[][] participantesPorClase = new String[MAX_CLASES][MAX_PARTICIPANTES_POR_CLASE];
    private int[] contadorParticipantesPorClase = new int[MAX_CLASES];

    // Constructor que no recibe datos, los maneja internamente
    public Clases(Entrada entrada) {
        this.entrada = entrada;
        initComponentsClases();
        // Cargar socios al iniciar la ventana
        Socio.cargarSocios();
        cargarDatos();
    }
    
    private void initComponentsClases() {
        // Configuración de la ventana
        setTitle("Gestión de Clases en Grupo");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Clases en Grupo");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(255, 191, 73));
        lblTitulo.setBounds(280, 10, 400, 40);
        add(lblTitulo);

        // Botón volver al menú
        btnMenu = new JButton("Volver al menú principal");
        btnMenu.setBounds(650, 60, 200, 30);
        estiloBoton(btnMenu);
        add(btnMenu);

        // ----------- SECCIÓN CREAR CLASES -----------
        JLabel lblNombreClase = new JLabel("Nombre Clase:");
        lblNombreClase.setForeground(new Color(255, 191, 73));
        lblNombreClase.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNombreClase.setBounds(50, 100, 150, 25);
        add(lblNombreClase);

        txtNombreClase = new JTextField();
        txtNombreClase.setBounds(200, 100, 200, 25);
        add(txtNombreClase);

        JLabel lblHorario = new JLabel("Horario:");
        lblHorario.setForeground(new Color(255, 191, 73));
        lblHorario.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHorario.setBounds(50, 140, 150, 25);
        add(lblHorario);

        comboHorario = new JComboBox<>(new String[]{
            "8 AM", "9 AM", "10 AM", "11 AM", "12 PM",
            "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM"
        });
        comboHorario.setBounds(200, 140, 100, 25);
        add(comboHorario);

        JLabel lblCapacidad = new JLabel("Capacidad:");
        lblCapacidad.setForeground(new Color(255, 191, 73));
        lblCapacidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCapacidad.setBounds(50, 180, 150, 25);
        add(lblCapacidad);

        txtCapacidad = new JTextField();
        txtCapacidad.setBounds(200, 180, 80, 25);
        add(txtCapacidad);

        btnAgregarClase = new JButton("Agregar Clase");
        btnAgregarClase.setBounds(320, 220, 150, 40);
        estiloBoton(btnAgregarClase);
        add(btnAgregarClase);

        btnBorrarClase = new JButton("Borrar Clase");
        btnBorrarClase.setBounds(500, 220, 150, 40);
        estiloBoton(btnBorrarClase);
        add(btnBorrarClase);

        // Tabla clases
        String[] columnasClases = {"Nombre", "Horario", "Capacidad"};
        modeloClases = new DefaultTableModel(columnasClases, 0);
        tablaClases = new JTable(modeloClases);
        JScrollPane scrollClases = new JScrollPane(tablaClases);
        scrollClases.setBounds(50, 280, 400, 200);
        add(scrollClases);

        // ----------- SECCIÓN PARTICIPANTES -----------
        JLabel lblClaseSel = new JLabel("Clase Seleccionada:");
        lblClaseSel.setForeground(new Color(255, 191, 73));
        lblClaseSel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblClaseSel.setBounds(500, 280, 200, 25);
        add(lblClaseSel);

        comboClases = new JComboBox<>();
        comboClases.setBounds(700, 280, 150, 25);
        add(comboClases);

        JLabel lblParticipante = new JLabel("ID Participante:");
        lblParticipante.setForeground(new Color(255, 191, 73));
        lblParticipante.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblParticipante.setBounds(500, 320, 200, 25);
        add(lblParticipante);

        txtNombreParticipante = new JTextField();
        txtNombreParticipante.setBounds(700, 320, 150, 25);
        add(txtNombreParticipante);

        btnAgregarParticipante = new JButton("Agregar Participante");
        btnAgregarParticipante.setBounds(500, 360, 180, 40);
        estiloBoton(btnAgregarParticipante);
        add(btnAgregarParticipante);

        btnBorrarParticipante = new JButton("Borrar Participante");
        btnBorrarParticipante.setBounds(700, 360, 180, 40);
        estiloBoton(btnBorrarParticipante);
        add(btnBorrarParticipante);

        // Tabla participantes
        String[] columnasParticipantes = {"Participante"};
        modeloParticipantes = new DefaultTableModel(columnasParticipantes, 0);
        tablaParticipantes = new JTable(modeloParticipantes);
        JScrollPane scrollParticipantes = new JScrollPane(tablaParticipantes);
        scrollParticipantes.setBounds(500, 420, 350, 200);
        add(scrollParticipantes);

        // ----------- EVENTOS -----------
        // Agregar Clase
        btnAgregarClase.addActionListener(e -> {
            String nombre = txtNombreClase.getText().trim();
    String horario = (String) comboHorario.getSelectedItem();
    String capacidadStr = txtCapacidad.getText().trim();

    if (!nombre.isEmpty() && !capacidadStr.isEmpty()) {
        if (contadorClases < MAX_CLASES) {
            try {
                int capacidad = Integer.parseInt(capacidadStr);
                
                nombresClases[contadorClases] = nombre;
                horarioClases[contadorClases] = horario;
                capacidadClases[contadorClases] = capacidad;
                
                Object[] fila = new Object[]{nombre, horario, capacidad};
                modeloClases.addRow(fila);
                
                comboClases.addItem(nombre);
                contadorParticipantesPorClase[contadorClases] = 0; // Inicializar contador de participantes
                contadorClases++;
                
                txtNombreClase.setText("");
                txtCapacidad.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacidad debe ser un número");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más clases. Se ha alcanzado el límite.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
    }
        });

        // Borrar Clase
        btnBorrarClase.addActionListener(e -> {
            int fila = tablaClases.getSelectedRow();
    if (fila >= 0) {
        String nombreClase = (String) modeloClases.getValueAt(fila, 0);
        
        // Desplazar los elementos en los arreglos para eliminar la clase
        for (int i = fila; i < contadorClases - 1; i++) {
            nombresClases[i] = nombresClases[i + 1];
            horarioClases[i] = horarioClases[i + 1];
            capacidadClases[i] = capacidadClases[i + 1];
            participantesPorClase[i] = participantesPorClase[i + 1]; // Desplazar el arreglo de participantes
            contadorParticipantesPorClase[i] = contadorParticipantesPorClase[i + 1];
        }
        contadorClases--;
        
        modeloClases.removeRow(fila);
        comboClases.removeItem(nombreClase);
        modeloParticipantes.setRowCount(0);
        
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una clase para borrar");
    }
        });

        // Agregar Participante con validación de socio
        btnAgregarParticipante.addActionListener(e -> {
            String claseSel = (String) comboClases.getSelectedItem();
    String nombreParticipante = txtNombreParticipante.getText().trim();

    if (claseSel == null || nombreParticipante.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe elegir una clase y escribir un nombre.");
        return;
    }

    String codigoStr = JOptionPane.showInputDialog(this, "Ingrese el código del socio:");
    if (codigoStr == null || codigoStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar el código del socio.");
        return;
    }

    int codigo;
    try {
        codigo = Integer.parseInt(codigoStr.trim());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El código debe ser un número.");
        return;
    }

    Socio socio = Socio.buscarSocioPorCodigo(codigo);
    boolean socioValido = socio != null && socio.getNombre().equalsIgnoreCase(nombreParticipante);

    if (!socioValido) {
        JOptionPane.showMessageDialog(this, "El nombre o código del socio no es válido.");
        return;
    }

    int claseIndex = -1;
    for (int i = 0; i < contadorClases; i++) {
        if (nombresClases[i] != null && nombresClases[i].equals(claseSel)) {
            claseIndex = i;
            break;
        }
    }

    if (claseIndex != -1) {
        int capacidad = capacidadClases[claseIndex];
        int numParticipantes = contadorParticipantesPorClase[claseIndex];

        if (numParticipantes < capacidad) {
            boolean yaInscrito = false;
            for (int i = 0; i < numParticipantes; i++) {
                if (participantesPorClase[claseIndex][i].equals(nombreParticipante)) {
                    yaInscrito = true;
                    break;
                }
            }
            
            if (yaInscrito) {
                JOptionPane.showMessageDialog(this, "Este socio ya está inscrito en la clase.");
            } else {
                participantesPorClase[claseIndex][numParticipantes] = nombreParticipante;
                contadorParticipantesPorClase[claseIndex]++;
                modeloParticipantes.addRow(new Object[]{nombreParticipante});
                txtNombreParticipante.setText("");
                JOptionPane.showMessageDialog(this, "Socio inscrito correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La clase ya está llena");
        }
    }
        });

        // Borrar Participante
        btnBorrarParticipante.addActionListener(e -> {
            int fila = tablaParticipantes.getSelectedRow();
    String claseSel = (String) comboClases.getSelectedItem();
    
    if (fila >= 0 && claseSel != null) {
        String nombre = (String) modeloParticipantes.getValueAt(fila, 0);
        int claseIndex = -1;
        
        // Buscar el índice de la clase seleccionada
        for (int i = 0; i < contadorClases; i++) {
            if (nombresClases[i] != null && nombresClases[i].equals(claseSel)) {
                claseIndex = i;
                break;
            }
        }
        
        if (claseIndex != -1) {
            int participanteIndex = -1;
            int numParticipantes = contadorParticipantesPorClase[claseIndex];

            // Buscar el índice del participante a borrar
            for (int i = 0; i < numParticipantes; i++) {
                if (participantesPorClase[claseIndex][i] != null && participantesPorClase[claseIndex][i].equals(nombre)) {
                    participanteIndex = i;
                    break;
                }
            }

            if (participanteIndex != -1) {
                // Desplazar los elementos para llenar el hueco
                for (int i = participanteIndex; i < numParticipantes - 1; i++) {
                    participantesPorClase[claseIndex][i] = participantesPorClase[claseIndex][i + 1];
                }
                participantesPorClase[claseIndex][numParticipantes - 1] = null; // Eliminar el último elemento duplicado
                contadorParticipantesPorClase[claseIndex]--;
                modeloParticipantes.removeRow(fila);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un participante para borrar");
    }
        });

        // Cambiar clase seleccionada → actualizar tabla de participantes
        comboClases.addActionListener(e -> {
            actualizarTablaParticipantes();
        });

        // Botón volver
        btnMenu.addActionListener(e -> MenuprincipalSPAction());
        
        // Muestra la ventana
        setVisible(true);
    }

    private void actualizarTablaParticipantes() {
        modeloParticipantes.setRowCount(0);
    String claseSel = (String) comboClases.getSelectedItem();
    if (claseSel != null) {
        int claseIndex = -1;
        // Buscar el índice de la clase seleccionada
        for (int i = 0; i < contadorClases; i++) {
            if (nombresClases[i] != null && nombresClases[i].equals(claseSel)) {
                claseIndex = i;
                break;
            }
        }
        
        if (claseIndex != -1) {
            int numParticipantes = contadorParticipantesPorClase[claseIndex];
            // Llenar la tabla con los participantes
            for (int i = 0; i < numParticipantes; i++) {
                modeloParticipantes.addRow(new Object[]{participantesPorClase[claseIndex][i]});
            }
        }
    }
    }

    private void estiloBoton(JButton btn) {
        btn.setBackground(new Color(255, 191, 73));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
    private void guardarDatos() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clases.dat"))) {
        // Se guardan los datos de los arreglos en el orden que se necesiten.
        oos.writeObject(nombresClases);
        oos.writeObject(capacidadClases);
        oos.writeObject(horarioClases);
        oos.writeInt(contadorClases);
        oos.writeObject(participantesPorClase);
        oos.writeObject(contadorParticipantesPorClase);
        
        JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage());
    }
}
    private void cargarDatos() {
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clases.dat"))) {
        nombresClases = (String[]) ois.readObject();
        capacidadClases = (int[]) ois.readObject();
        horarioClases = (String[]) ois.readObject();
        contadorClases = ois.readInt();
        participantesPorClase = (String[][]) ois.readObject();
        contadorParticipantesPorClase = (int[]) ois.readObject();

        modeloClases.setRowCount(0);
        comboClases.removeAllItems();

        for (int i = 0; i < contadorClases; i++) {
            Object[] fila = new Object[]{nombresClases[i], horarioClases[i], capacidadClases[i]};
            modeloClases.addRow(fila);
            comboClases.addItem(nombresClases[i]);
        }

        if (comboClases.getItemCount() > 0) {
            comboClases.setSelectedIndex(0);
        }
        actualizarTablaParticipantes();

    } catch (IOException | ClassNotFoundException e) {
        System.err.println("No se encontró el archivo de datos. Cargando clases por defecto.");

        // Lógica para cargar clases por defecto
        String[][] clasesPorDefecto = {
            {"Yoga", "8 AM", "15"},
            {"Zumba", "9 AM", "20"},
            {"Spinning", "10 AM", "10"}
        };

        // Limpiar arreglos
        nombresClases = new String[MAX_CLASES];
        capacidadClases = new int[MAX_CLASES];
        horarioClases = new String[MAX_CLASES];
        participantesPorClase = new String[MAX_CLASES][MAX_PARTICIPANTES_POR_CLASE];
        contadorParticipantesPorClase = new int[MAX_CLASES];
        contadorClases = 0;

        modeloClases.setRowCount(0);
        comboClases.removeAllItems();

        for (int i = 0; i < clasesPorDefecto.length; i++) {
            String[] clase = clasesPorDefecto[i];
            
            nombresClases[i] = clase[0];
            horarioClases[i] = clase[1];
            capacidadClases[i] = Integer.parseInt(clase[2]);
            contadorClases++;
            
            Object[] fila = new Object[]{clase[0], clase[1], Integer.parseInt(clase[2])};
            modeloClases.addRow(fila);
            comboClases.addItem(clase[0]);
        }

        if (comboClases.getItemCount() > 0) {
            comboClases.setSelectedIndex(0);
        }
        actualizarTablaParticipantes();
    }
}
    private void MenuprincipalSPAction() {
    guardarDatos(); // Llama al método para guardar
    this.dispose();
    if (entrada != null) {
        entrada.setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(Clases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Ocurrió un error al establecer la apariencia de la interfaz de usuario", ex);
        }

        Entrada menu = new Entrada();
        menu.setVisible(true);
        
        // Esto crea y muestra la ventana de Clases
        // new Clases(menu); // Descomenta esta linea si quieres probar la ventana de forma directa
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
