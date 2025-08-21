/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author aliso
 */
public class Espacio {

     private String estado;
    private String estadoOriginal;
    private int idSocio;

    public Espacio(String estado) {
        this.estado = estado;
        this.estadoOriginal = estado;
        this.idSocio = 0; // 0 indica que no hay socio
    }

    public Espacio() {
        this.estado = "V"; 
        this.estadoOriginal = "V";
        this.idSocio = 0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoOriginal() {
        return estadoOriginal;
    }

    public void setEstadoOriginal(String estadoOriginal) {
        this.estadoOriginal = estadoOriginal;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public boolean isOcupado() {
        return this.estado.equals("O");
    }
    
    public void setOcupado(boolean ocupado) {
        if (ocupado) {
            this.estado = "O";
        } else {
            this.estado = this.estadoOriginal;
            this.idSocio = 0;
        }
    }

    public boolean estaLibre() {
        return !this.estado.equals("O");
    }

    public void resetearEstado() {
        this.estado = this.estadoOriginal;
        this.idSocio = 0;
    }
    
    @Override
    public String toString() {
        return estado;
    }
}
