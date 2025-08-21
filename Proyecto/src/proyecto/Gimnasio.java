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
public class Gimnasio {

    ClasesEnGrupo[] clase;
    private int clasesTotales; //atributos
    private Socio[] socios;
    private int sociosTotales;
    private String tipoUsuario;
    private int insAc;

    public Gimnasio() {
    }

    public Gimnasio(ClasesEnGrupo[] clase, int clasesTotales) { //constructor
        this.clase = clase;
        this.clasesTotales = clasesTotales;
    }

    public Gimnasio(int maxClase) {
        clase = new ClasesEnGrupo[maxClase];
        clasesTotales = 0;
        sociosTotales = 0;
        socios = new Socio[maxClase];

    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void nuevaClase(String nombre, String horario, int capacidad) { //metodo para registrar una nueva clase en el gimnasio
        if (clasesTotales < clase.length) {
            clase[clasesTotales++] = new ClasesEnGrupo(horario, nombre, capacidad);
        } else {
            JOptionPane.showMessageDialog(null, "no se pueden añadir más clases");
        }
    }

    public void modificarClase(int indice, String nombre, String horario, int capacidad) { //modifica datos de una clase
        if (indice >= 0 && indice < clasesTotales) {
            clase[indice].modificacionesClases(indice, nombre, horario, capacidad);
        }

    }


    public String reserverClase(String nombre, String idSocio) {
        for (int i = 0; i < clasesTotales; i++) {
            if (clase[i].getNombre().equals(nombre)) {
                if (clase[i].inscritosActual < clase[i].getCapMaxima()) {
                    if (clase[i].socioRegistrado(idSocio)) {
                        return "El socio ya esta inscrito";
                    } else {
                        clase[i].registroDeSocio(idSocio); // en  regustroDeSocio se debe return en lugar de true y false si se logro inscribir o no,hacer lo mismo con las cabinas
                        return "Se registro a la clase " + clase[i].getNombre();
                    }
                    //registrar al socio
                } else {
                    return "No hay cupo en la clase";
                }
            }
        }
        return "No se ha podido registrar en la clase escrita";
    }

    public boolean liberEspacio(String nombre, String idSocio) {
        for (int i = 0; i < clasesTotales; i++) {
            if (clase[i].getNombre().equals(nombre)) {
                if (clase[i].socioRegistrado(idSocio)) {
                    boolean eliminar = clase[i].eliminaReg(idSocio);
                    if (eliminar) {
                        JOptionPane.showMessageDialog(null, "Se libero correctamente el cupo de la clase" + clase[i].getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se liberó el cupo por un error");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El socio no está inscrito");
                }
            }

        }
        return false;
    }

    public void mostrar() {
        String listadosClases = "";
        for (int i = 0; i < clasesTotales; i++) { //muestra 
            listadosClases += "Clase: " + clase[i].getNombre() + "-Horario: " + clase[i].getHorario() + "\n";

        }
        JOptionPane.showMessageDialog(null, listadosClases);
    }

    @Override
    public String toString() {
        return "Gimnasio{" + "clase=" + clase + ", clasesTotales=" + clasesTotales + '}';
    }

}
