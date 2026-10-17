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
public class ControlladorDocente 
{
    ArrayList<Docente> lista_docentes = new ArrayList();

    public void agregar(Docente docente_nuevo)
    {
        lista_docentes.add(docente_nuevo);
    }
    public Docente buscar(String nrodoc) 
    {
        for (Docente d : lista_docentes) {
            if (d.getNro_documento().equals(nrodoc)) {
                return d;
            }
        }
        return null;
    }
    
    public void listar()
    {
        System.out.println("::::::::LISTA DE DOCENTES::::::::");

        for (Docente d : lista_docentes)
        {
            d.verDatos();

            if (d instanceof DocenteTiempoParcial)
            {
                DocenteTiempoParcial p;
                p = (DocenteTiempoParcial) d;

                System.out.println("Calculo parcial: " + p.Calcular_remuneracion());
            }
            else if (d instanceof DocenteTiempoCompleto)
            {
                DocenteTiempoCompleto p;
                p = (DocenteTiempoCompleto) d;
                p.calcular_sueldo();
            }
            System.out.println("----------------------------------");
        }
    }
}
