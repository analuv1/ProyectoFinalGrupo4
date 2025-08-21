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
public class Parqueo {

    private Espacio[][][] espacios;
    private int[] sociosConEspacio;
    private int cantidadSociosConEspacio;

    private static final int ESPACIOS_DISCAPACITADOS = 3;
    private static final int CAPACIDAD_MAXIMA = 150;

    public Parqueo() {
        sociosConEspacio = new int[CAPACIDAD_MAXIMA];
        cantidadSociosConEspacio = 0;

        espacios = new Espacio[3][][];
        
        // Nivel 1: 4 filas, 5 columnas
        espacios[0] = new Espacio[4][5];
        // Nivel 2: 5 filas, 5 columnas
        espacios[1] = new Espacio[5][5];
        // Nivel 3: 6 filas, 5 columnas
        espacios[2] = new Espacio[6][5];
        
        // Inicializar todos los espacios como "V" (vacío)
        for (int nivel = 0; nivel < 3; nivel++) {
            for (int fila = 0; fila < espacios[nivel].length; fila++) {
                for (int columna = 0; columna < espacios[nivel][fila].length; columna++) {
                    espacios[nivel][fila][columna] = new Espacio("V");
                }
            }
        }

        // Asignar los espacios de discapacitados y entrenadores
        for (int nivel = 0; nivel < 3; nivel++) {
            // Espacios de Discapacitados
            for (int i = 0; i < ESPACIOS_DISCAPACITADOS; i++) {
                espacios[nivel][0][i] = new Espacio("D");
            }
            // Espacio de Entrenadores
            espacios[nivel][1][0] = new Espacio("E");
        }
    }

    public boolean asignarEspacio(int idSocio, boolean esDiscapacitado, boolean esEntrenador) {
        try {
            if (yaTieneEspacio(idSocio)) {
                JOptionPane.showMessageDialog(null, "Error: El socio ya tiene un espacio asignado.");
                return false;
            }
            
            Socio socio = Socio.buscarSocioPorCodigo(idSocio);

            if (socio == null) {
                JOptionPane.showMessageDialog(null, "Error: Socio no encontrado.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (!socio.isMembresia()) {
                JOptionPane.showMessageDialog(null, "Error: La membresía del socio no está activa.", "Error de Membresía", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Lógica de asignación: Prioridad a espacios especiales
            if (esDiscapacitado) {
                if (buscarYAsignar("D", idSocio)) {
                    anadirSocioConEspacio(idSocio); // Agregar al socio a la lista
                    return true;
                }
                JOptionPane.showMessageDialog(null, "No hay espacios de discapacitados disponibles.", "Espacio no disponible", JOptionPane.INFORMATION_MESSAGE);
            } else if (esEntrenador) {
                if (buscarYAsignar("E", idSocio)) {
                    anadirSocioConEspacio(idSocio); // Agregar al socio a la lista
                    return true;
                }
                JOptionPane.showMessageDialog(null, "No hay espacios de entrenador disponibles.", "Espacio no disponible", JOptionPane.INFORMATION_MESSAGE);
            }

            // Si no es un tipo especial, o no hay espacios especiales, buscar un espacio vacío
            if (buscarYAsignar("V", idSocio)) {
                anadirSocioConEspacio(idSocio); // Agregar al socio a la lista
                return true;
            }

            JOptionPane.showMessageDialog(null, "El parqueo está lleno. No hay espacios disponibles.", "Parqueo Lleno", JOptionPane.INFORMATION_MESSAGE);
            return false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    private boolean buscarYAsignar(String tipo, int idSocio) {
        for (int nivel = 0; nivel < 3; nivel++) {
        for (int fila = 0; fila < espacios[nivel].length; fila++) {
            for (int columna = 0; columna < espacios[nivel][fila].length; columna++) {
                Espacio espacioActual = espacios[nivel][fila][columna];
                if (espacioActual.estaLibre() && espacioActual.getEstadoOriginal().equals(tipo)) {
                    espacioActual.setOcupado(true);
                    espacioActual.setIdSocio(idSocio);
                    return true;
                }
            }
        }
    }
    return false;
    }

    public boolean liberarEspacio(int idSocio) {
        for (int nivel = 0; nivel < 3; nivel++) {
        for (int fila = 0; fila < espacios[nivel].length; fila++) {
            for (int columna = 0; columna < espacios[nivel][fila].length; columna++) {
                Espacio espacioActual = espacios[nivel][fila][columna];
                if (espacioActual.isOcupado() && espacioActual.getIdSocio() == idSocio) {
                    espacioActual.setOcupado(false);
                    removerSocioConEspacio(idSocio);
                    return true;
                }
            }
        }
    }
    JOptionPane.showMessageDialog(null, "Error: El socio no fue encontrado en el parqueo.", "Socio no Encontrado", JOptionPane.ERROR_MESSAGE);
    return false;
    }
    
    

    public String mostrarEstadoParqueo() {
        StringBuilder estado = new StringBuilder();
    for (int nivel = 0; nivel < 3; nivel++) {
        estado.append("Nivel G").append(nivel + 1).append(":\n");
        // El bucle de filas usa la longitud del nivel actual
        for (int fila = 0; fila < espacios[nivel].length; fila++) {
            // El bucle de columnas usa la longitud de la fila actual
            for (int columna = 0; columna < espacios[nivel][fila].length; columna++) {
                Espacio espacioActual = espacios[nivel][fila][columna];
                estado.append(espacioActual.toString()).append(" ");
            }
            estado.append("\n");
        }
        estado.append("\n");
    }
    return estado.toString();
    }

    private boolean yaTieneEspacio(int idSocio) {
        for (int i = 0; i < cantidadSociosConEspacio; i++) {
            if (sociosConEspacio[i] == idSocio) {
                return true;
            }
        }
        return false;
    }

    private void anadirSocioConEspacio(int idSocio) {
        if (cantidadSociosConEspacio < CAPACIDAD_MAXIMA) {
            sociosConEspacio[cantidadSociosConEspacio] = idSocio;
            cantidadSociosConEspacio++;
        }
    }

    private void removerSocioConEspacio(int idSocio) {
        for (int i = 0; i < cantidadSociosConEspacio; i++) {
            if (sociosConEspacio[i] == idSocio) {
                // Desplazar los elementos restantes para llenar el "hueco"
                for (int j = i; j < cantidadSociosConEspacio - 1; j++) {
                    sociosConEspacio[j] = sociosConEspacio[j + 1];
                }
                cantidadSociosConEspacio--;
                break;
            }
        }
    }

    public int[] buscarUbicacionSocio(int idSocio) {
        for (int nivel = 0; nivel < 3; nivel++) {
        for (int fila = 0; fila < espacios[nivel].length; fila++) {
            for (int columna = 0; columna < espacios[nivel][fila].length; columna++) {
                Espacio espacioActual = espacios[nivel][fila][columna];
                if (espacioActual.isOcupado() && espacioActual.getIdSocio() == idSocio) {
                    return new int[]{nivel + 1, fila + 1, columna + 1};
                }
            }
        }
    }
    return null;
    }

}
