/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author alons
 */
public class SistemaReservaER {

    private static ReservaER[] reservas = new ReservaER[100];
    int contador = 0;
    String[] opciones = {"Ping-pong", "Billar", "Fútbol", "Baloncesto", "Tenis"};
    int[] contadoresPorTipo = new int[]{0, 0, 0, 0, 0};

    void actualizarContadores() {
        for (int i = 0; i < contadoresPorTipo.length; i++) {
            contadoresPorTipo[i] = 0;
        }

        for (int i = 0; i < contador; i++) {
            String tipo = reservas[i].espacio;

            if (tipo.startsWith("Ping-pong")) {
                contadoresPorTipo[0]++;
            } else if (tipo.startsWith("Billar")) {
                contadoresPorTipo[1]++;
            } else if (tipo.startsWith("Fútbol")) {
                contadoresPorTipo[2]++;
            } else if (tipo.startsWith("Baloncesto")) {
                contadoresPorTipo[3]++;
            } else if (tipo.startsWith("Tenis")) {
                contadoresPorTipo[4]++;
            }
        }
    }

    void agregarReserva() {

         String tipo = (String) JOptionPane.showInputDialog(null, "Elija el espacio:", "Espacios", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

    if (tipo == null) {
        return;
    }

    if (tipo.equals("Fútbol") && contadoresPorTipo[2] >= 2) {
        JOptionPane.showMessageDialog(null, "Lo sentimos, las 2 canchas de fútbol ya están reservadas.");
        return;
    }

    if (tipo.equals("Baloncesto") && contadoresPorTipo[3] >= 1) {
        JOptionPane.showMessageDialog(null, "Lo sentimos, la cancha de baloncesto ya está reservada.");
        return;
    }
    
    // Validación para limitar a 2 reservas de tenis
    if (tipo.equals("Tenis") && contadoresPorTipo[4] >= 2) {
        JOptionPane.showMessageDialog(null, "Lo sentimos, las 2 canchas de tenis ya están reservadas.");
        return;
    }
    
    String hora = pedirHoraValida();
    
    if (hora == null) {
        return;
    }

    if (hayChoque(tipo, hora)) {
        JOptionPane.showMessageDialog(null, "Ya hay una reserva para " + tipo + " a esa hora.");
        return;
    }

    if (tipo.equals("Ping-pong") || tipo.equals("Billar")) {
        reservas[contador] = new ReservaER("Mesa", tipo, hora + " (30 min)");
    } else {
        String capacidad;
        int capacidadInt;
        do {
            int maxJugadores = 0;
            if (tipo.equals("Fútbol")) {
                maxJugadores = 12;
            } else if (tipo.equals("Baloncesto")) {
                maxJugadores = 10;
            } else if (tipo.equals("Tenis")) {
                maxJugadores = 2;
            }
            
            capacidad = JOptionPane.showInputDialog("Ingrese cantidad de personas (máximo " + maxJugadores + "):");
            if (capacidad == null) {
                return;
            }
            try {
                capacidadInt = Integer.parseInt(capacidad);
                if (capacidadInt > maxJugadores || capacidadInt <= 0) {
                    JOptionPane.showMessageDialog(null, "Número de personas inválido. Ingrese un número entre 1 y " + maxJugadores + ".");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número.");
                capacidadInt = 0;
            }
        } while (capacidadInt > (tipo.equals("Fútbol") ? 12 : (tipo.equals("Baloncesto") ? 10 : 2)) || capacidadInt <= 0);
        
        reservas[contador] = new ReservaER("Cancha", tipo + " (" + capacidadInt + " personas)", hora);
    }

    contador++;
    actualizarContadores();
    JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.");
    }

    void eliminarReserva() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay reservas para eliminar.");
            return;
        }

        verReservas();
        String input = JOptionPane.showInputDialog("Ingrese el número de la reserva a eliminar:");
        int pos = Integer.parseInt(input) - 1;

        if (pos >= 0 && pos < contador) {
            for (int i = pos; i < contador - 1; i++) {
                reservas[i] = reservas[i + 1];
            }
            contador--;
            actualizarContadores();
            JOptionPane.showMessageDialog(null, "Reserva eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "Número inválido.");
        }
    }

    void actualizarReserva() {
        if (contador == 0) {
        JOptionPane.showMessageDialog(null, "No hay reservas para actualizar.");
        return;
    }

    verReservas();
    String input = JOptionPane.showInputDialog("Ingrese el número de la reserva a actualizar:");
    int pos;
    try {
        pos = Integer.parseInt(input) - 1;
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
        return;
    }

    if (pos >= 0 && pos < contador) {
        String[] opciones = {"Ping-pong", "Billar", "Fútbol", "Baloncesto", "Tenis"};
        String tipo = (String) JOptionPane.showInputDialog(null, "Nuevo tipo de espacio:", "Actualizar", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (tipo == null) {
            return;
        }

        if (tipo.equals("Baloncesto") && contadoresPorTipo[3] >= 1) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, la cancha de baloncesto ya está reservada.");
            return;
        }

        // Validación para limitar reservas de tenis a 2 en la actualización
        if (tipo.equals("Tenis") && contadoresPorTipo[4] >= 2) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, las 2 canchas de tenis ya están reservadas.");
            return;
        }
        
        String hora = pedirHoraValida();
        if (hora == null) {
            return;
        }

        if (hayChoque(tipo, hora) && !reservas[pos].espacio.startsWith(tipo) || (reservas[pos].espacio.startsWith(tipo) && !reservas[pos].hora.equals(hora))) {
            JOptionPane.showMessageDialog(null, "Ya existe otra reserva para ese tipo a esa hora.");
            return;
        }

        if (tipo.equals("Ping-pong") || tipo.equals("Billar")) {
            reservas[pos] = new ReservaER("Mesa", tipo, hora + " (30 min)");
        } else {
            String capacidad;
            int capacidadInt;
            do {
                int maxJugadores = 0;
                if (tipo.equals("Fútbol")) {
                    maxJugadores = 12;
                } else if (tipo.equals("Baloncesto")) {
                    maxJugadores = 10;
                } else if (tipo.equals("Tenis")) {
                    maxJugadores = 2;
                }
                
                capacidad = JOptionPane.showInputDialog("Nueva cantidad de personas (máximo " + maxJugadores + "):");
                if (capacidad == null) {
                    return;
                }
                try {
                    capacidadInt = Integer.parseInt(capacidad);
                    if (capacidadInt > maxJugadores || capacidadInt <= 0) {
                        JOptionPane.showMessageDialog(null, "Número de personas inválido. Ingrese un número entre 1 y " + maxJugadores + ".");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número.");
                    capacidadInt = 0;
                }
            } while (capacidadInt > (tipo.equals("Fútbol") ? 12 : (tipo.equals("Baloncesto") ? 10 : 2)) || capacidadInt <= 0);
            
            reservas[pos] = new ReservaER("Cancha", tipo + " (" + capacidadInt + " personas)", hora);
        }

        actualizarContadores();
        JOptionPane.showMessageDialog(null, "Reserva actualizada.");
    } else {
        JOptionPane.showMessageDialog(null, "Número inválido.");
    }
    }

    void verReservas() {
        String texto = "";
        for (int i = 0; i < contador; i++) {
            texto += (i + 1) + ". " + reservas[i].mostrar() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto.equals("") ? "No hay reservas." : texto);
    }

    String pedirHoraValida() {
        String hora;
        do {
            hora = JOptionPane.showInputDialog("Ingrese hora en formato H:MM AM/PM (ej: 2:30 PM):");
            if (!esHoraValida(hora)) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Ejemplo válido: 2:30 PM");
            }
        } while (!esHoraValida(hora));
        return hora.trim().toUpperCase();
    }

    boolean esHoraValida(String hora) {
        if (hora == null) {
            return false;
        }
        return hora.trim().toUpperCase().matches("^(1[0-2]|[1-9]):[0-5][0-9]\\s?(AM|PM)$");
    }

    boolean hayChoque(String tipo, String horaNueva) {
        int inicioNueva = convertirAHoraEnMinutos(horaNueva);
        int finNueva = inicioNueva + 30;

        for (int i = 0; i < contador; i++) {
            if (reservas[i].espacio.startsWith(tipo)) {
                String horaExistente = reservas[i].hora.split(" ")[0] + " " + reservas[i].hora.split(" ")[1];
                int inicioExistente = convertirAHoraEnMinutos(horaExistente);
                int finExistente = inicioExistente + 30;

                if ((inicioNueva < finExistente) && (finNueva > inicioExistente)) {
                    return true;
                }
            }
        }
        return false;
    }

    int convertirAHoraEnMinutos(String hora) {
        hora = hora.trim().toUpperCase();
        String[] partes = hora.split(" ");
        String[] tiempo = partes[0].split(":");
        int horas = Integer.parseInt(tiempo[0]);
        int minutos = Integer.parseInt(tiempo[1]);

        if (partes[1].equals("PM") && horas != 12) {
            horas += 12;
        }
        if (partes[1].equals("AM") && horas == 12) {
            horas = 0;
        }

        return horas * 60 + minutos;
    }

    String formatearTextoReserva(final String entradaUsuario) {
        return entradaUsuario.replaceAll(" ", "");
    }

    void menu() {
        String[] opciones = {"Agregar reserva", "Eliminar reserva", "Actualizar reserva", "Ver reservas", "Salir"};
        int op;
        do {
            op = JOptionPane.showOptionDialog(null, "Menú principal", "Sistema de Reservas", 0, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            if (op == 0) {
                agregarReserva();
            } else if (op == 1) {
                eliminarReserva();
            } else if (op == 2) {
                actualizarReserva();
            } else if (op == 3) {
                verReservas();
            }
        } while (op != 4);
    }
}
