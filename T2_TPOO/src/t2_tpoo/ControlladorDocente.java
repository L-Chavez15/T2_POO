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
        //la lista referencia a Docente, puede recibir objetos de cualqiera de sus clases
        lista_docentes.add(docente_nuevo);
    }
    public Docente buscar(String nrodoc) 
    {
        for (Docente d : lista_docentes) {
            if (d.getNro_documento().equals(nrodoc)) 
            {
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
            
            //DOWNCASTING
            //convertimos una referencia de tipo Docente a una referencia de una de sus clases hijas
 
            if (d instanceof DocenteTiempoParcial)//comprobamos si el objeto es de tipo DocenteTiempoParcial
            {
                DocenteTiempoParcial p;
                p = (DocenteTiempoParcial) d;//realiza el downcasting
 
                System.out.println("Calculo parcial: " + p.Calcular_remuneracion());//permite llamar a un método específico de esa clase hija.
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
