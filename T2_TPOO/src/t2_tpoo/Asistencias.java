/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

import java.time.LocalDate;

/**
 *
 * @author leoch
 */
public class Asistencias 
{
    // Atributos según tu diagrama UML
    private LocalDate fecha;
    private String estado;
    private Docente profe;
 
 
    // Constructor con parámetros
    public Asistencias(LocalDate fecha, String estado, Docente profe) {
        this.fecha = fecha;
        this.estado = estado;
        this.profe=profe;
    }
 
    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }
 
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
 
    public String getEstado() {
        return estado;
    }
 
    // Método set con validación estricta y básica (igual que tus otros setters)
    public boolean setEstado(String estado) {
        // Validamos que no sea nulo
        if (estado != null) {
            // Validamos que no esté vacío
            if (estado.equals("")) {
                System.out.println("Error: No se ingresó nada. El campo de estado está vacío.");
                return false;
            } else {
                // Validamos opciones permitidas para la asistencia (Asistió, Faltó, Tardanza)
                if (estado.equalsIgnoreCase("Asistio")) {
                    System.out.println("ESTADO REGISTRADO: ASISTIÓ");
                    this.estado = estado;
                    return true;
                } else {
                    if (estado.equalsIgnoreCase("Falto")) {
                        System.out.println("ESTADO REGISTRADO: FALTO");
                        this.estado = estado;
                        return true;
                    } else {
                        if (estado.equalsIgnoreCase("Tardanza")) {
                            System.out.println("ESTADO REGISTRADO: TARDANZA");
                            this.estado = estado;
                            return true;
                        } else {
                            System.out.println("Error: Estado no válido. Ingrese Asistio, Falto o Tardanza.");
                            return false;
                        }
                    }
                }
            }
        } else {
            System.out.println("Error: El valor no puede ser nulo.");
            return false;
        }
    }

    public Docente getProfe() {
        return profe;
    }

    public void setProfe(Docente profe) {
        this.profe = profe;
    }
    
 
    // Método verDatos requerido en el UML
    public void verDatos() 
    {
        
        System.out.println("Fecha de Asistencia: " + fecha);
        System.out.println("Estado del Docente: " + estado);
        if(this.profe != null)
        {
            System.out.println("El docente es: "+this.profe.getNombre()+" "+this.profe.getApellido_pa()+" "+this.profe.getApellido_ma());
        }
        else
        {
            System.out.println("NO HAY DOCENTES REGISTRADOS");
        }
    }
}
