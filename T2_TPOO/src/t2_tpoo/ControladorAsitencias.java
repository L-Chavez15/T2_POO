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
public class ControladorAsitencias 
{
    ArrayList<Asistencias> lista_asistencias = new ArrayList();

    public void agregar(Asistencias asistencia_nueva)
    {
        lista_asistencias.add(asistencia_nueva);
    }

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
