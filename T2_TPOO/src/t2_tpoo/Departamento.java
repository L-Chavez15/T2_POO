/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

/**
 *
 * @author leoch
 */
public class Departamento 
{
    private String codigo;
    private String nombre;
    private String tipoDepartamento;

    public Departamento()
    {
    }
    

    public String getCodigo()
    {
        return codigo;
    }

    public boolean setCodigo(String codigo)
    {
        if (codigo != null)
        {
            this.codigo = codigo;
            return true;
        }
        else
        {
            System.out.println("El codigo es obligatorio.");
            return false;
        }
    }

    public String getNombre()
    {
        return nombre;
    }

    public boolean setNombre(String nombre)
    {
        if (nombre != null)
        {
            this.nombre = nombre;
            return true;
        }
        else
        {
            System.out.println("El nombre es obligatorio.");
            return false;
        }
    }

    public String getTipoDepartamento()
    {
        return tipoDepartamento;
    }

    // Valida los dos tipos de departamento permitidos.
    public boolean setTipoDepartamento(String tipoDepartamento)
    {
        if (tipoDepartamento != null)
        {
            if (tipoDepartamento.equalsIgnoreCase("Independiente"))
            {
                this.tipoDepartamento = "Independiente";
                return true;
            }
            else
            {
                if (tipoDepartamento.equalsIgnoreCase("Jerarquia"))
                {
                    this.tipoDepartamento = "Jerarquia";
                    return true;
                }
                else
                {
                    System.out.println(
                        "Ingrese Independiente o Jerarquia."
                    );
                    return false;
                }
            }
        }
        else
        {
            System.out.println("El tipo es obligatorio.");
            return false;
        }
    }

    public void verDatos()
    {
        System.out.println("CODIGO DEL DEPARTAMENTO: " + this.codigo);
        System.out.println("NOMBRE DEL DEPARTAMENTO: " + this.nombre);
        System.out.println("TIPO DE DEPARTAMENTO: " + this.tipoDepartamento);
    }

}
