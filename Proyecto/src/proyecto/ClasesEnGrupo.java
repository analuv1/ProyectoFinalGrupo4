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
public class ClasesEnGrupo {

    // como yoga,crossfit, funcionales, pilates, zumba, entre otras.
    // atributos 
    private String horario;
    private String nombre;
    private int capMaxima;
    Socio[] inscritos;
    int inscritosActual;
    Socio[] inscrito;

    public ClasesEnGrupo() { //constructor vacío
    }

    public ClasesEnGrupo(String horario, String nombre, int capMaxima) { //constructor
        this.horario = horario;
        this.nombre = nombre;
        this.capMaxima = capMaxima;
        this.inscritos = new Socio[capMaxima];
        this.inscritosActual = 0;
    }

    ClasesEnGrupo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getHorario() {  //setter y getters
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public Socio[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(Socio[] inscritos) {
        this.inscritos = inscritos;
    }

    public int getInscritosActual() {
        return inscritosActual;
    }

    public void setInscritosActual(int inscritosActual) {
        this.inscritosActual = inscritosActual;
    }

    public boolean registroDeSocio(int socio) { //metodo para registrar un nuevo socio 
        if (inscritosActual < capMaxima) { //verifica si no se ha alcanzado la capacidad maxima
            inscritos[inscritosActual++] = new Socio(socio);
            return true;
        }
        return false;
    }

    public boolean cancelacionClase(int indice, String idSocio) { //metodo para cancelar la inscripcion
        for (int i = 0; i < inscritosActual; i++) {
            if (inscritos[i].equals(idSocio)) { //compara el socio con el ID dado
                inscritos[i] = inscritos[inscritosActual - 1]; //sustituye el socio eliminado con el ultimo de la lista
                inscritos[inscritosActual - 1] = null; //reduce el contador de inscritos
                inscritosActual--;
                return true;
            }

        }
        return false;
    }

    public boolean eliminaReg(String idSocio) { //elimina un socio de la lista de inscritos
        int indiceEnArreglo = -1;

// Buscar el índice del socio en el arreglo 'inscrito'
        for (int i = 0; i < inscrito.length; i++) {
            if (inscrito[i] != null) {
                indiceEnArreglo = i;
                break;
            }
        }

        if (indiceEnArreglo != -1) {
            // Desplazar elementos en el arreglo para eliminar el socio
            for (int i = indiceEnArreglo; i < inscrito.length - 1; i++) {
                inscrito[i] = inscrito[i + 1];
            }
            inscrito[inscrito.length - 1] = null; // Eliminar última referencia

            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente del auditorio.");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Socio no encontrado en el registro interno del auditorio.");
        }
        return false;
    }

    public void modificacionesClases(int indice, String nuevoNombre, String nuevoHorario, int nuevaCapacidad) { //metodo para modificaciones
        this.nombre = nuevoNombre;
        this.horario = nuevoHorario;

        if (nuevaCapacidad != this.capMaxima) {
            Socio[] nuevosSocios = new Socio[nuevaCapacidad];
            //copia la cantidad minimo entre la nueva y la actual
            int cantAnterior = Math.min(nuevaCapacidad, inscritosActual);
            for (int i = 0; i < cantAnterior; i++) {
                nuevosSocios[i] = inscritos[i];
            }
            inscritos = nuevosSocios; //reemplaza el arreglo antiguo
            inscritosActual = cantAnterior; //ajusta el contador
            capMaxima = nuevaCapacidad; //actualiza la capacidad maxima
        }

    }

    public StringBuilder informacion() {
        StringBuilder info = new StringBuilder();
        info.append("Nombre: ").append(nombre).append("\n");
        info.append("Horario: ").append(horario).append("\n");
        info.append("Capacidad: ").append(capMaxima).append("\n");
        info.append("Inscritos: ").append(inscritosActual).append("\n");
        //agrega los codigos de los socios inscritos
        for (int i = 0; i < inscritosActual; i++) {
            info.append(inscritos[i].getCodigo()).append("");

        }
        return info;
    }

    public void Informacion() { //cuadro de dialogo para la informacion
        JOptionPane.showMessageDialog(null, "ClasesEnGrupo{" + "horario=" + horario + ", nombre=" + nombre + ", capMaxima=" + capMaxima + ", inscritos=" + inscritosActual + '}');
        for (int i = 0; i < inscritosActual; i++) {
            JOptionPane.showMessageDialog(null, inscritos[i] + "");

        }
    }

    public boolean socioRegistrado(String idSocio) { //verifica si el ID esta ya verificado
        for (int i = 0; i < inscritosActual; i++) {
            if (inscritos[i].equals(idSocio)) {
                return true;
            }
        }
        return false;
    }

    void registroDeSocio(String idSocio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean registroDeSocio(String nombreSocio, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean cancelacionClase(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
