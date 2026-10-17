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
    protected String tipo_documento;
    protected String Nro_documento;
    protected String Nombre;
    protected String Apellido_pa;
    protected String Apellido_ma;
    protected String Direccion;
    protected String Telefono;
    protected LocalDate fecha_ingreso;
    
    protected Departamento departmaneto;
    protected Pension pension;
    protected ArrayList<Asistencias> asistencias = new ArrayList<>();

    //COLOCAMOS LOS GETTES AND SETTERS
    public String getTipo_documento() {
        return tipo_documento;
    }

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

    public boolean setNro_documento(String Nro_documento) 
    {
        if(Nro_documento != null)
        {
            if(Nro_documento.length()==8)
            {
                this.Nro_documento = Nro_documento;
                return true;
            }
            else if(Nro_documento.length()==11)
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

    public boolean setTelefono(String Telefono) 
    {
        if(Telefono.length()==9)
        {
            this.Telefono = Telefono;
            return true;
        }
        else 
        {
            System.out.println("ERRO: ES OBLIGATORIO INGRESAR EL TELEFONO");
            return false;
        }
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    

    public Departamento getDepartmaneto() {
        return departmaneto;
    }

    public void setDepartmaneto(Departamento departmaneto) {
        this.departmaneto = departmaneto;
    }

    public Pension getPension() {
        return pension;
    }

    public boolean setPension(Pension pension) 
    {
        if (pension != null)
        {
            if (pension.getTipoSistema() != null)
            {
                if (pension.getTipoSistema().equalsIgnoreCase("ONP"))
                {
                    this.pension = pension;
                    return true;
                }
                else
                {
                    if (pension.getTipoSistema().equalsIgnoreCase("AFP"))
                    {
                        if (pension.getEmpresaAFP() != null)
                        {
                            if (pension.getEmpresaAFP().equalsIgnoreCase("Prima"))
                            {
                                this.pension = pension;
                                return true;
                            }
                            else
                            {
                                if (pension.getEmpresaAFP().equalsIgnoreCase("Habitat"))
                                {
                                    this.pension = pension;
                                    return true;
                                }
                                else
                                {
                                    if (pension.getEmpresaAFP().equalsIgnoreCase("Integra"))
                                    {
                                        this.pension = pension;
                                        return true;
                                    }
                                    else
                                    {
                                        return false;
                                    }
                                }
                            }
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public ArrayList<Asistencias> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Asistencias ReAsistencias) 
    {
        this.asistencias.add(ReAsistencias);
    }
    
    
    public abstract void verDatos();
}
