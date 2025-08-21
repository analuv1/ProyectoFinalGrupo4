/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell 7490
 */
public class DisponCabina {

    private boolean[] horarios;
    public int[] contadoresPorCabina = new int[5]; // 5 cabinas

    
    public int getContador(int indice) {
    return contadoresPorCabina[indice];
}

    public DisponCabina() { //constructor vacío
        horarios = new boolean[10];

    }

    public DisponCabina(boolean[] horarios) { //constructor
        this.horarios = horarios;
    }

    public String mostrarDispo() { //recorre el arreglo para ver si cda hora esta ocupada o no
        StringBuilder sb = new StringBuilder("La disponibilidad de la cabina es:");
        for (int i = 0; i < horarios.length; i++) {
            int hora = 9 + i; //el horario inicia a la 9
            sb.append(hora).append(":00 - ").append(horarios[i] ? "ocupado" : "disponible").append("\n");
        }
        return sb.toString();
    }

    public void reservaC() { //metodo para reservar en la cabina
        String input = JOptionPane.showInputDialog(null, mostrarDispo() + "Ingrese la hora que desea reservar(debe estar entre 9 y 18)");
        try {
            int hora = Integer.parseInt(input); //convierte la entrada a numero
            if (hora < 9 || hora > 18) { //la hora debe estar entre 9 y 18h
                JOptionPane.showMessageDialog(null, "La hora es inválida, debe estar entre 9 y 18");
                return;
            }
            int index = hora - 9; //hora 9 igual a indice 0
            if (horarios[index]) { //en caso de ocupado
                JOptionPane.showMessageDialog(null, "Lo sentimos, este horario ya está reservado");
            } else {
                horarios[index] = true; //en caso de no ocupado
                JOptionPane.showMessageDialog(null, "Su reserva ha sido confirmada para las" + hora + ":00");
            }
        } catch (NumberFormatException e) { //por si el usuario ingresa algo mas
            JOptionPane.showMessageDialog(null, "Entrada no válida");

        }

    }

    public void liberarC() { //metodo para liberar una hora reservada en la cabina
        String input = JOptionPane.showInputDialog(null, mostrarDispo() + "Ingrese la hora que desea liberar(debe estar entre 9 y 18)");
        try {
            int hora = Integer.parseInt(input); //convierte la entrada a numero
            if (hora < 9 || hora > 18) { //la hora debe estar entre 9 y 18h
                JOptionPane.showMessageDialog(null, mostrarDispo() + "La hora es inválida, debe estar entre 9 y 18");
                return;
            }
            int index = hora - 9; //hora 9 igual a indice 0
            if (!horarios[index]) { //en caso de no reservado
                JOptionPane.showMessageDialog(null, "Este horario no está reservado");
            } else {
                horarios[index] = false;
                JOptionPane.showMessageDialog(null, "Su reserva ha sido cancelada para las" + hora + ":00");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida");

        }

    }

}
