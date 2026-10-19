/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public abstract class Docente 
{
    // Atributos protegidos para compartir datos con las clases hijas.
    protected String tipo_documento;
    protected String Nro_documento;
    protected String Nombre;
    protected String Apellido_pa;
    protected String Apellido_ma;
    protected String Direccion;
    protected String Telefono;
    protected LocalDate fecha_ingreso;
    
    // Objetos y colección relacionados con la información del docente.
    protected Departamento departamento;
    protected Pension pension;
    protected ArrayList<Asistencias> asistencias = new ArrayList<>();//relacion entre docente y asitencia es de 1...n

    //COLOCAMOS LOS GETTES AND SETTERS
    public String getTipo_documento() {
        return tipo_documento;
    }
    
    // Valida que el tipo de documento sea DNI o CE.
    public boolean setTipo_documento(String tipo_documento) 
    {
        if(tipo_documento != null)
        {
            if(tipo_documento.equalsIgnoreCase("DNI"))
            {
                this.tipo_documento = "DNI";
                return true;
            }
            else if(tipo_documento.equalsIgnoreCase("CE"))
            {
                this.tipo_documento = "CE";
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE NUEVAMENTE");
                return false;
            }   
        }
        else
        {
            System.out.println("ERROR: INGRESE EL TIPO DE DOCUMENTO (DNI/CE)");
            return false;
        }
    }

    public String getNro_documento() {
        return Nro_documento;
    }

    // Comprueba que el documento tenga 8 u 11 dígitos numéricos.
    public boolean setNro_documento(String Nro_documento) 
    {
        if(Nro_documento != null)
        {
            if(Nro_documento.matches("[0-9]{8}"))
            {
                this.Nro_documento = Nro_documento;
                return true;
            }
            else if(Nro_documento.matches("[0-9]{11}"))
            {
                this.Nro_documento = Nro_documento;
                return true;
            }
            else
            {
                System.out.println("ERROR, CANTIDAD DE CARACTERES INVALIDA");
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public boolean setNombre(String Nombre) 
    {
        if (Nombre != null)
        {
            if (Nombre.length() > 0)
            {
                this.Nombre = Nombre;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL NOMBRE");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: INGRESE EL NOMBRE");
            return false;
        }
    }

    public String getApellido_pa() {
        return Apellido_pa;
    }

    public boolean setApellido_pa(String Apellido_pa) 
    {
        if (Apellido_pa != null)
        {
            if (Apellido_pa.length() > 0)
            {
                this.Apellido_pa = Apellido_pa;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL APELLIDO PATERNO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: INGRESE EL APELLIDO PATERNO");
            return false;
        }
    }

    public String getApellido_ma() {
        return Apellido_ma;
    }

    public boolean setApellido_ma(String Apellido_ma) 
    {
        if (Apellido_ma != null)
        {
            if (Apellido_ma.length() > 0)
            {
                this.Apellido_ma = Apellido_ma;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL APELLIDO MATERNO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: INGRESE EL APELLIDO MATERNO");
            return false;
        }
    }

    public String getDireccion() {
        return Direccion;
    }

    public boolean setDireccion(String Direccion) 
    {
        if(Direccion!=null)
        {
            this.Direccion = Direccion;
            return true;
        }
        else 
        {
            System.out.println("ERRO: ES OBLIGATORIO INGRESAR LA DIRECCION");
            return false;
        }
    }

    public String getTelefono() {
        return Telefono;
    }

    // Valida que el teléfono contenga exactamente 9 dígitos.
    public boolean setTelefono(String Telefono) 
    {
        // Primero comprobamos que el teléfono no sea nulo.
        if (Telefono != null)
        {
            // El teléfono debe tener 9 caracteres.
            //.matches es para que solo valide números
            if (Telefono.matches("[0-9]{9}"))
            {
                this.Telefono = Telefono;
                return true;
            }
            else
            {
                System.out.println("ERROR: EL TELEFONO DEBE TENER 9 DIGITOS");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: ES OBLIGATORIO INGRESAR EL TELEFONO");
            return false;
        }
    }

    public LocalDate getFecha_ingreso() 
    {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) 
    {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    public Departamento getDepartmaneto() {
        return departamento;
    }

    public boolean setDepartmamento(Departamento departamento) 
    {
        if (departamento != null)
        {
            this.departamento = departamento;
            return true;
        }
        else
        {
            System.out.println("ERROR: EL DEPARTAMENTO NO PUEDE ESTAR VACIO");
            return false;
        }
    }

    public Pension getPension() {
        return pension;
    }

    // Valida el sistema previsional y la empresa AFP cuando corresponde.
    public boolean setPension(Pension pension) 
    {
        if (pension == null || pension.getTipoSistema()==null) 
        {
         return false;   
        }
        String sistema = pension.getTipoSistema();
        if (sistema.equalsIgnoreCase("ONP")) 
        {
            this.pension=pension;
            return true;
        }
        if (sistema.equalsIgnoreCase("AFP")) 
        {
           String empresa=pension.getEmpresaAFP();
           
            if (empresa.equalsIgnoreCase("INTEGRA")|| empresa.equalsIgnoreCase("PRIMA")||empresa.equalsIgnoreCase("HABITAT")) 
            {
                this.pension=pension;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Asistencias> getAsistencias() {
        return asistencias;
    }

    // Agrega una asistencia al historial del docente.
    public void setAsistencias(Asistencias ReAsistencias) 
    {
        this.asistencias.add(ReAsistencias);
    }
    
    // Muestra los datos personales y el departamento del docente.
    public void verHistorialPersonal()
    {
        System.out.println("");
        System.out.println("===== HISTORIAL DE PERSONAL =====");
        System.out.println("Nombre: " + this.Nombre + " " + this.Apellido_pa + " " + this.Apellido_ma);
        System.out.println("Numero de documento: " + this.Nro_documento);
        System.out.println("Fecha de ingreso: " + this.fecha_ingreso);

        if (this.departamento != null)
        {
            System.out.println("Departamento actual:");
            System.out.println(this.departamento.getCodigo()+" - "+this.departamento.getNombre());
        }
        else
        {
            System.out.println("Departamento actual: No registrado");
        }
    }
    
    // Obliga a las clases hijas a implementar la visualización de datos.
    public abstract void verDatos();
}
