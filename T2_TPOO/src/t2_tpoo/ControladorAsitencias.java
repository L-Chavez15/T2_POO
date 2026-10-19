/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

import java.util.ArrayList;

/**
 *
 * @author leoch
 */
// Administra el registro, la búsqueda y el listado de docentes.
public class ControladorAsitencias 
{
    // Administra los registros de asistencia.
    ArrayList<Asistencias> lista_asistencias = new ArrayList();

    // Agrega una nueva asistencia a la colección.
    public void agregar(Asistencias asistencia_nueva)
    {
        lista_asistencias.add(asistencia_nueva);
    }

    // Recorre la colección y muestra cada registro de asistencia.
    public void listar()
    {
        System.out.println("::::::::LISTA DE ASISTENCIAS::::::::");

        for (Asistencias a : lista_asistencias)
        {
            a.verDatos();

            System.out.println("----------------------------------");
        }
    }
}
