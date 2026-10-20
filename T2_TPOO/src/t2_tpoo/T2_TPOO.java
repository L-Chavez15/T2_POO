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
        // Inicializa los controladores que administran docentes y asistencias.
        Scanner sc = new Scanner(System.in);
        ControlladorDocente c = new ControlladorDocente();
        ControladorAsitencias ca = new ControladorAsitencias();

        int opcion = -1;

        // Mantiene el menú activo hasta que el usuario seleccione salir.
        while (opcion != 0)
        {
            System.out.println("\n::::::SISTEMA DE DOCENTES - GLOBAL TEC::::::");
            System.out.println("1. Registrar profesor a tiempo parcial");
            System.out.println("2. Registrar profesor a tiempo completo");
            System.out.println("3. Listar docentes");
            System.out.println("4. Registrar Asistencia");
            System.out.println("5. Lista de asistencias");
            System.out.println("6. Informacion del Docentes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            // Controla errores producidos durante el ingreso y procesamiento de datos.
            try
            {
                opcion = Integer.parseInt(sc.nextLine());

                // Ejecuta la operación seleccionada por el usuario.
                switch (opcion)
                {
                    case 1:
                    {
                        // Ejecuta la operación seleccionada por el usuario.
                        DocenteTiempoParcial p =new DocenteTiempoParcial();
                        //aplicamos upcasting
                        ingresarDatos(sc, p,c);
                        System.out.print("Horas dictadas: ");
                        p.setHoras_dictadas(Double.parseDouble(sc.nextLine()));

                        boolean aux =false;
                        while(!aux)
                        {
                            System.out.print("Tarifa por hora: ");
                            aux=p.setTarifa(Double.parseDouble(sc.nextLine()));
                        }

                        c.agregar(p);

                        System.out.println("Profesor registrado.");
                        break;
                    }

                    case 2:
                    {
                        // Ejecuta la operación seleccionada por el usuario.
                        DocenteTiempoCompleto p = new DocenteTiempoCompleto();
                        
                        // Solicita y valida los datos comunes de cualquier tipo de docente.
                        ingresarDatos(sc, p,c);
                        
                        boolean aux =false;
                        while(!aux)
                        {
                            System.out.print("Sueldo fijo: ");
                            aux= p.setSueldo_fijo(Double.parseDouble(sc.nextLine()));
                        }
                        
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
                        break;
                    case 6:
                        System.out.print("Ingrese el numero de documento del docente: ");
                        String nrodoc = sc.nextLine();

                        Docente d = c.buscar(nrodoc);

                        if (d != null)
                        {
                            d.verHistorialPersonal();
                        }
                        else
                        {
                            System.out.println("Docente no encontrado.");
                        }
                        break;

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

   //upcasting: El parámetro del método está declarado como Docente
    public static void ingresarDatos(Scanner sc, Docente d, ControlladorDocente c)
    {
        Boolean aux = false;

        while (!aux)//true
        {
            System.out.print("Tipo de documento: ");
            aux = d.setTipo_documento(sc.nextLine());
        }
        aux = false;

        while (!aux)
        {
            System.out.print("Numero de documento: ");
            String nrodoc =sc.nextLine();
            if (c.buscar(nrodoc) != null)
            {
                System.out.println("ERROR: EL NUMERO DE DOCUMENTO YA ESTA REGISTRADO.");
            }
            else
            {
                aux = d.setNro_documento(nrodoc);
            }
            
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
        aux =false;
        while (!aux)
        {
            System.out.print("Ingrese sistema de pensiones (ONP / AFP): ");
            String tipo = sc.nextLine();

            if (tipo.equalsIgnoreCase("ONP"))
            {
                Pension pension = new Pension("ONP", "");
                // Verificasmos si la pensión es válida.
                aux = d.setPension(pension);
                if (!aux)
                {
                    System.out.println("Pension no valida.");
                }
            }
            else if (tipo.equalsIgnoreCase("AFP"))
            {
                System.out.print("Ingrese la empresa AFP (Prima / Habitat / Integra): ");
                String empresa = sc.nextLine();
                Pension pension = new Pension("AFP", empresa);
                // Solo continuamos si Docente acepta la pensión.
                aux = d.setPension(pension);
                if (!aux)
                {
                    System.out.println("Empresa AFP no valida.");
                }
            }
            else
            {
                System.out.println("Opcion no valida. Debe ingresar ONP o AFP.");
            }
        }
        
        Departamento dep = new Departamento();
        aux = false;
        while (!aux)
        {
            System.out.print("Codigo del departamento: ");
            aux = dep.setCodigo(sc.nextLine());
        }

        aux = false;
        while (!aux)
        {
            System.out.print("Nombre del departamento: ");
            aux = dep.setNombre(sc.nextLine());
        }

        aux = false;
        while (!aux)
        {
            System.out.print("Tipo de departamento (Independiente / Jerarquia): ");
            aux = dep.setTipoDepartamento(sc.nextLine());
        }
        d.setDepartmamento(dep);
        
        System.out.print("Fecha de ingreso (AAAA-MM-DD): ");
        d.setFecha_ingreso(LocalDate.parse(sc.nextLine()));
        
    }
    // Registra una asistencia y la relaciona con el docente correspondiente.
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
        
        d.setAsistencias(a);
        ca.agregar(a);

        System.out.println("Asistencia registrada correctamente.");
    }
    
    

    
}
    