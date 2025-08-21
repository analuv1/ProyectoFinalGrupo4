/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author alons
 */
public class ReservaER {
    String tipo;
    String espacio;
    String hora;

    ReservaER(String tipo, String espacio, String hora) {
        this.tipo = tipo;
        this.espacio = espacio;
        this.hora = hora;
    }

    String mostrar() {
        return tipo + " - " + espacio + " - " + hora;
    }
    
}
