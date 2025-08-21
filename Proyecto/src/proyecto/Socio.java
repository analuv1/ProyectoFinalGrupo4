/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author alons
 */
public class Socio {
    private String nombre;
    int codigo;
    private boolean membresiaActiva;
    private String horaAudi;
    private boolean enSalaPesas;
    
    
    public Socio(String nombre, int codigo, boolean membresia) {   //constructor con parametros
        this.nombre = nombre;
        this.codigo = codigo;
        this.membresiaActiva = membresia;
        this.horaAudi = horaAudi;
    }

    public Socio(int codigo) {
        this.codigo = codigo;
    }
    
    
    public Socio(String nombre, int codigo, boolean membresia, String horaAudi) {   //constructor con parametros
        this(nombre, codigo, membresia);
        this.horaAudi = horaAudi;
    }
    
    public Socio(String nombre, int codigo, boolean membresia, boolean enSalaPesas) {   //constructor con parametros
        this(nombre, codigo, membresia);
        this.enSalaPesas = enSalaPesas;
    }

    Socio(int sociosTotales, String nombreSocio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isMembresia() {
        return membresiaActiva;
    }

    public void setMembresia(boolean membresia) {
        this.membresiaActiva = membresia;
    }

    public String getHoraAudi() {
        return horaAudi;
    }

    public void setHoraAudi(String horaAudi) {
        this.horaAudi = horaAudi;
    }
    
    public static Socio[] socios = new Socio[50]; //se crea el arreglo de 50 socios
    public static int numSociosActuales = 0;
    private static boolean cargado = false;
    
    public static void cargarSocios(){      //Lista precargada de socios
        if (cargado) return;
        
        socios[0] = new Socio("Carlos Ramos", 1000, true, "");
        socios[1] = new Socio("Raquel Sanchez", 1010, true, "");
        socios[2] = new Socio("Belen Rubio", 1020, true, "");
        socios[3] = new Socio("Martin Morales", 1030, true, "");
        socios[4] = new Socio("Carmen Ortega", 1040, true, "");
        socios[5] = new Socio("Julio Alonso", 1050, false, "");
        socios[6] = new Socio("Jesus Romero", 1060, true, "");
        socios[7] = new Socio("Vicente Iglesias", 1070, true, "");
        socios[8] = new Socio("Eva Castro", 1080, true, "");
        socios[9] = new Socio("Alberto Vazquez", 1090, false, "");
        socios[10] = new Socio("Maria Gonzalez", 1100, true, "");
        socios[11] = new Socio("Rocio Ortiz", 1110, true, "");
        socios[12] = new Socio("Sandra Ortega", 1120, true, "");
        socios[13] = new Socio("Beatriz Santos", 1130, true, "");
        socios[14] = new Socio("Jorge Moreno", 1140, true, "");
        socios[15] = new Socio("Salvador Iglesias", 1150, false, "");
        socios[16] = new Socio("Carmen Castro", 1160, true, "");
        socios[17] = new Socio("Beatriz Romero", 1170, false, "");
        socios[18] = new Socio("Silvia Ortega", 1180, true, "");
        socios[19] = new Socio("Francisco Cortes", 1190, true, "");
        socios[20] = new Socio("Gabriel Marin", 1200, true, "");
        socios[21] = new Socio("Irene Torres", 1210, false, "");
        socios[22] = new Socio("Jose Ruiz", 1220, true, "");
        socios[23] = new Socio("Hugo Nunez", 1230, true, "");
        socios[24] = new Socio("Jose Fernandez", 1240, true, "");
        socios[25] = new Socio("Yolanda Garcia", 1250, true, "");
        socios[26] = new Socio("Pilar Cruz", 1260, true, "");
        socios[27] = new Socio("Maria Torres", 1270, false, "");
        socios[28] = new Socio("Marta Hernandez", 1280, true, "");
        socios[29] = new Socio("Jesus Gutierrez", 1290, true, "");
        socios[30] = new Socio("Sergio Rubio", 1300, true, "");
        socios[31] = new Socio("Emilio Lopez", 1310, false, "");
        socios[32] = new Socio("Antonia Hernandez", 1320, false, "");
        socios[33] = new Socio("Alba Serrano", 1330, true, "");
        socios[34] = new Socio("Ruben Nunez", 1340, true, "");
        socios[35] = new Socio("Antonio Gutierrez", 1350, true, "");
        socios[36] = new Socio("Alvaro Lozano", 1360, true, "");
        socios[37] = new Socio("Pedro Garrido", 1370, true, "");
        socios[38] = new Socio("Nuria Martinez", 1380, true, "");
        socios[39] = new Socio("Francisca Marin", 1390, false, "");
        socios[40] = new Socio("Juana Jimenez", 1400, true, "");
        socios[41] = new Socio("Adrian Suarez", 1410, true, "");
        socios[42] = new Socio("Jaime Rubio", 1420, true, "");
        socios[43] = new Socio("Carmen Lopez", 1430, true, "");
        socios[44] = new Socio("Sofia Gonzalez", 1440, false, "");
        socios[45] = new Socio("Pablo Gonzalez", 1450, true, "");
        socios[46] = new Socio("Andres Artavia", 1460, true, "");
        socios[47] = new Socio("David Alvarado", 1470, false, "");
        socios[48] = new Socio("Enoc Venegas", 1480, true, "");
        socios[49] = new Socio("Marjorie Calvo", 1490, true, "");
        numSociosActuales = 50;
        cargado = true;
             
        
    }
    
    private static void agregarSocio(Socio socio) {
        if (numSociosActuales < socios.length) {
            socios[numSociosActuales] = socio;
            numSociosActuales++;
            }
        }
    
    public static Socio buscarSocioPorCodigo (int codigo) {
        
        cargarSocios();
        for(int i = 0; i<numSociosActuales; i++) {
            if (socios[i] != null && socios[i].getCodigo() ==codigo) {
                return socios[i];
            }
        }
        return null;
    }
    public boolean codigoI(int id) {
        return this.codigo == id;
    }


    
    
    
}
