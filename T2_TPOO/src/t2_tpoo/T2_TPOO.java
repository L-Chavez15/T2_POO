/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t2_tpoo;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author leoch
 */
public class T2_TPOO {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ControlladorDocente c = new ControlladorDocente();
        ControladorAsitencias ca = new ControladorAsitencias();

        int opcion = -1;

        while (opcion != 0)
        {
            System.out.println("\nSISTEMA DE DOCENTES - GLOBAL TEC");
            System.out.println("1. Registrar profesor a tiempo parcial");
            System.out.println("2. Registrar profesor a tiempo completo");
            System.out.println("3. Listar docentes");
            System.out.println("4. Registrar Asistencia");
            System.out.println("5. Lista de asistencias");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try
            {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion)
                {
                    case 1:
                    {
                        DocenteTiempoParcial p =new DocenteTiempoParcial();
                        ingresarDatos(sc, p);
                        System.out.print("Horas dictadas: ");
                        p.setHoras_dictadas(Double.parseDouble(sc.nextLine()));

                        System.out.print("Tarifa por hora: ");
                        p.setTarifa(Double.parseDouble(sc.nextLine()));

                        c.agregar(p);

                        System.out.println("Profesor registrado.");
                        break;
                    }

                    case 2:
                    {
                        DocenteTiempoCompleto p = new DocenteTiempoCompleto();

                        ingresarDatos(sc, p);

                        System.out.print("Sueldo fijo: ");
                        p.setSueldo_fijo(Double.parseDouble(sc.nextLine()));

                        System.out.print("Descuentos ya calculados: ");
                        p.setDescuentos(Double.parseDouble(sc.nextLine()));

                        c.agregar(p);

                        System.out.println("Profesor registrado.");
                        break;
                    }

                    case 3:
                        c.listar();
                        break;
                        
                    case 4:
                        System.out.print("INGRESE DOCUMENTO DEL DOCENTE: ");
                        String nro_documento = sc.nextLine();

                        Docente de = c.buscar(nro_documento);

                        if (de != null)
                        {
                            registrarAsistencia(sc, de, ca);
                        }
                        else
                        {
                            System.out.println("No existe un docente con ese documento.");
                        }

                        break;
                    case 5:
                        ca.listar();

                    case 0:
                        System.out.println("Fin del programa.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            }
            catch (RuntimeException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

    public static void ingresarDatos(Scanner sc, Docente d)
    {
        Boolean aux = false;

        while (!aux)
        {
            System.out.print("Tipo de documento: ");
            aux = d.setTipo_documento(sc.nextLine());
        }
        aux = false;

        while (!aux)
        {
            System.out.print("Numero de documento: ");
            aux = d.setNro_documento(sc.nextLine());
        }
        aux = false;

        while (!aux)
        {
            System.out.print("Nombre: ");
            aux = d.setNombre(sc.nextLine());
        }
        aux = false;

        while (!aux)
        {
            System.out.print("Apellido paterno: ");
            aux = d.setApellido_pa(sc.nextLine());
        }
        aux = false;

        while (!aux)
        {
            System.out.print("Apellido materno: ");
            aux = d.setApellido_ma(sc.nextLine());
        }
        
        aux = false;
        while(!aux)
        {
            System.out.print("DIRECCION: ");
            aux = d.setDireccion(sc.nextLine());
        }
        aux = false;
        while(!aux)
        {
            System.out.print("TELEFONO: ");
            aux = d.setTelefono(sc.nextLine());
        }
        System.out.print("Fecha de ingreso (AAAA-MM-DD): ");
        d.setFecha_ingreso(LocalDate.parse(sc.nextLine()));
       
        /*
        while (!aux)
        {
            System.out.print("Departamento: ");
            d.setDepartamento(sc.nextLine());
        }
        aux=false;
        
        while (!aux)
        {
            System.out.print("Afiliacion (ONP / AFP Prima / AFP Habitat / AFP Integra): ");
            d.setAfiliacion(sc.nextLine());
        }
        aux=false;*/
    }
    public static void registrarAsistencia(Scanner sc, Docente d, ControladorAsitencias ca)
    {
        System.out.println("REGISTRO DE ASISTENCIA");

        System.out.print("Fecha de asistencia (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        Asistencias a = new Asistencias(fecha, "",d);

        boolean aux = false;

        while (!aux)
        {
            System.out.print("Estado (Asistio, Falto, Tardanza): ");
            aux = a.setEstado(sc.nextLine());
        }

        ca.agregar(a);

        System.out.println("Asistencia registrada correctamente.");
    }
    
}
