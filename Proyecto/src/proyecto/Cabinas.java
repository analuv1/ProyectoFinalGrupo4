/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import proyecto.Entrada;
import proyecto.Entrada;
import proyecto.Socio;
import proyecto.Socio;

class Reserva implements Serializable {

    String nombre;
    String codigo;
    int cabina;
    int hora;

    public Reserva(String nombre, String codigo, int cabina, int hora) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cabina = cabina;
        this.hora = hora;
    }
}

/**
 *
 * @author Dell 7490
 */
public class Cabinas extends javax.swing.JFrame {

    private JFrame menuPrincipal;
    private Entrada entrada;
    private final int HORA_INICIO = 9;
    private final int HORA_FIN = 18;

    // Variables dinámicas para las cabinas
    private int numCabinasActuales = 5; // Empezamos con 5 cabinas
    private JPanel cabinasPanel; // Panel que contendrá las cabinas
    private List<JPanel> listaPanelesCabinas = new ArrayList<>(); // Lista para guardar los paneles

    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Cabinas(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        cargarReservas();
        Socio.cargarSocios();

        setTitle("Reserva de Cabinas");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        // Panel de cabinas dinámico
        cabinasPanel = new JPanel();
        cabinasPanel.setBackground(Color.BLACK);
        cabinasPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(cabinasPanel, BorderLayout.CENTER);

        // **Crear los paneles según numCabinasActuales cargado**
        crearCabinasIniciales();

        // Panel inferior
        JPanel inferiorPanel = new JPanel();
        inferiorPanel.setBackground(Color.BLACK);
        inferiorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton agregarCabinaBtn = new JButton("Añadir Cabina");
        agregarCabinaBtn.setBackground(new Color(255, 200, 100));
        agregarCabinaBtn.addActionListener(ev -> añadirCabina());

        JButton quitarCabinaBtn = new JButton("Quitar Cabina");
        quitarCabinaBtn.setBackground(new Color(255, 200, 100));
        quitarCabinaBtn.addActionListener(ev -> quitarCabina());

        JButton verReservasBtn = new JButton("Ver Reservas");
        verReservasBtn.setBackground(new Color(255, 200, 100));
        verReservasBtn.addActionListener(ev -> mostrarReservas());

        JButton volverMenuBtn = new JButton("Volver al Menú");
        volverMenuBtn.setBackground(new Color(255, 200, 100));
        volverMenuBtn.addActionListener(ev -> {
            this.dispose();
            if (menuPrincipal != null) {
                menuPrincipal.setVisible(true);
            }
        });

        inferiorPanel.add(agregarCabinaBtn);
        inferiorPanel.add(quitarCabinaBtn);
        inferiorPanel.add(verReservasBtn);
        inferiorPanel.add(volverMenuBtn);

        add(inferiorPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void crearCabinasIniciales() {
        for (int i = 1; i <= numCabinasActuales; i++) {
            JPanel cabina = crearCabinaPanel(i);
            cabinasPanel.add(cabina);
            listaPanelesCabinas.add(cabina);
        }
    }

    private void añadirCabina() {
        numCabinasActuales++;
        JPanel nuevaCabina = crearCabinaPanel(numCabinasActuales);
        cabinasPanel.add(nuevaCabina);
        listaPanelesCabinas.add(nuevaCabina);

        // Actualizar la interfaz
        cabinasPanel.revalidate();
        cabinasPanel.repaint();
    }

    private void quitarCabina() {
        if (numCabinasActuales > 1) { // Asegura que siempre haya al menos una cabina
            // Quitar la cabina del panel y de la lista
            JPanel ultimaCabina = listaPanelesCabinas.get(numCabinasActuales - 1);
            cabinasPanel.remove(ultimaCabina);
            listaPanelesCabinas.remove(ultimaCabina);

            // Eliminar reservas asociadas
            reservas.removeIf(r -> r.cabina == numCabinasActuales);

            numCabinasActuales--;

            // Actualizar la interfaz y guardar
            cabinasPanel.revalidate();
            cabinasPanel.repaint();
            guardarReservas();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede quitar más cabinas. Debe haber al menos una.");
        }
    }

    private JPanel crearCabinaPanel(int numeroCabina) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridLayout(HORA_FIN - HORA_INICIO + 2, 1, 3, 3));
        panel.setBorder(BorderFactory.createLineBorder(new Color(255, 200, 100), 2));

        JLabel titulo = new JLabel("Cabina " + numeroCabina, SwingConstants.CENTER);
        titulo.setForeground(new Color(255, 200, 100));
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo);

        for (int h = HORA_INICIO; h <= HORA_FIN; h++) {
            int hora = h;
            JButton boton = new JButton(hora + ":00");
            boton.setBackground(new Color(255, 200, 100));
            boton.setForeground(Color.BLACK);

            Reserva reservaExistente = null;
            for (Reserva r : reservas) {
                if (r.cabina == numeroCabina && r.hora == hora) {
                    reservaExistente = r;
                    break;
                }
            }

            final boolean[] reservado = {reservaExistente != null};
            if (reservaExistente != null) {
                boton.setText(hora + ":00 - por " + reservaExistente.nombre);
                boton.setBackground(Color.RED);
            }

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!reservado[0]) {
                        String nombre = JOptionPane.showInputDialog(panel, "Ingrese su nombre:");
                        String codigoStr = JOptionPane.showInputDialog(panel, "Ingrese su código:");

                        if (nombre == null || codigoStr == null || nombre.trim().isEmpty() || codigoStr.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(panel, "Debe ingresar nombre y código.");
                            return;
                        }

                        int codigoUsuario;
                        try {
                            codigoUsuario = Integer.parseInt(codigoStr);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(panel, "Código debe ser un número.");
                            return;
                        }

                        // Verificar socio usando el método de Socio.java
                        Socio socio = Socio.buscarSocioPorCodigo(codigoUsuario);
                        if (socio == null || !socio.getNombre().equalsIgnoreCase(nombre.trim())) {
                            JOptionPane.showMessageDialog(panel, "Socio no válido.");
                            return;
                        }

                        // Verificar si ya tiene una reserva en otra cabina
                        for (Reserva r : reservas) {
                            if (r.codigo.equals(codigoStr)) {
                                JOptionPane.showMessageDialog(panel, "Ya tiene una reserva activa.");
                                return;
                            }
                        }

                        // Reservar
                        reservado[0] = true;
                        boton.setText(hora + ":00 - Reservado por " + nombre);
                        boton.setBackground(Color.RED);
                        reservas.add(new Reserva(nombre.trim(), codigoStr.trim(), numeroCabina, hora));
                        guardarReservas();
                    } else {
                        // Liberar
                        String codigoLiberar = JOptionPane.showInputDialog(panel, "Ingrese su código para liberar:");
                        if (codigoLiberar == null) {
                            return;
                        }

                        Reserva res = null;
                        for (Reserva r : reservas) {
                            if (r.cabina == numeroCabina && r.hora == hora && r.codigo.equals(codigoLiberar.trim())) {
                                res = r;
                                break;
                            }
                        }

                        if (res != null) {
                            reservas.remove(res);
                            reservado[0] = false;
                            boton.setText(hora + ":00");
                            boton.setBackground(new Color(255, 200, 100));
                            guardarReservas();
                        } else {
                            JOptionPane.showMessageDialog(panel, "Código incorrecto. No puede liberar esta cabina.");
                        }
                    }
                }
            });

            panel.add(boton);
        }

        return panel;
    }

    private void guardarReservas() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("reservas.dat"))) {
        oos.writeObject(reservas); // Guardamos solo la lista
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void cargarReservas() {
    reservas = new ArrayList<>(); // por defecto

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reservas.dat"))) {
        Object obj = ois.readObject();

        if (obj instanceof ArrayList) {
            reservas = (ArrayList<Reserva>) obj;
            // Calcular el número de cabinas según la reserva más alta
            numCabinasActuales = 5; // valor por defecto
            for (Reserva r : reservas) {
                if (r.cabina > numCabinasActuales) {
                    numCabinasActuales = r.cabina;
                }
            }
        } else if (obj instanceof Integer) {
            numCabinasActuales = (Integer) obj;
            reservas = (ArrayList<Reserva>) ois.readObject();
        }

    } catch (IOException | ClassNotFoundException e) {
        // Archivo no existe o error: usar valores por defecto
        numCabinasActuales = 5;
        reservas = new ArrayList<>();
    }
}

    private void mostrarReservas() {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay reservas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas) {
            sb.append("Cabina ").append(r.cabina)
                    .append(", Hora: ").append(r.hora).append(":00")
                    .append(", Nombre: ").append(r.nombre)
                    .append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Reservas", JOptionPane.INFORMATION_MESSAGE);
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
        // Crear un menú principal ficticio para probar el botón de volver
        Socio.cargarSocios();

        JFrame menu = new JFrame("Menú Principal");
        menu.setSize(300, 200);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

        SwingUtilities.invokeLater(() -> new Cabinas(menu));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
