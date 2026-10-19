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
// Representa el registro de asistencia de un docente.
public class Asistencias 
{
    // Almacena la fecha, el estado y el docente asociado.
    private LocalDate fecha;
    private String estado;
    private Docente profe;
 
 
    // Almacena la fecha, el estado y el docente asociado.
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
 
    // Valida que el estado sea Asistio, Falto o Tardanza.
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

    // Permiten consultar y modificar el docente asociado a la asistencia.
    public Docente getProfe() {
        return profe;
    }

    public void setProfe(Docente profe) {
        this.profe = profe;
    }
    
 
    // Muestra la fecha, el estado y los datos del docente asociado.
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
