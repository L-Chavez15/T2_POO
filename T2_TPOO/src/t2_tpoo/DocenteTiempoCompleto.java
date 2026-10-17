/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

/**
 *
 * @author leoch
 */
public class DocenteTiempoCompleto extends Docente
{
    private double sueldo_fijo;
    private double descuentos;


    public double getSueldo_fijo() {
        return sueldo_fijo;
    }

    public void setSueldo_fijo(double sueldo_fijo) {
        this.sueldo_fijo = sueldo_fijo;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }
    
    public int contarInasistencias()
    {
        int contador = 0;

        for (Asistencias a : asistencias)
        {
            if (a.getEstado() != null)
            {
                if (a.getEstado().equalsIgnoreCase("Falto"))
                {
                    contador++;
                }
            }
        }

        return contador;
    }

    public int contarTardanzas()
    {
        int contador = 0;

        for (Asistencias a : asistencias)
        {
             if (a.getEstado() != null)
            {
                if (a.getEstado().equalsIgnoreCase("Tardanza"))
                {
                    contador++;
                }
            }
        }

        return contador;
    }
    
     public double calcular_sueldo()
    {
        double descuentoPension = sueldo_fijo * 0.05;
        double descuentoInasistencias = contarInasistencias() * 50;
        double descuentoTardanzas = contarTardanzas() * 10;

        // Sumamos todos los descuentos.
        descuentos = descuentoPension+ descuentoInasistencias+ descuentoTardanzas;
        // Restamos el total al sueldo fijo.
        double sueldo = sueldo_fijo - descuentos;

        if (sueldo < 0)
        {
            sueldo = 0;
        }

        return sueldo;
    }

    @Override
    public void verDatos() 
    {
        System.out.println("");
        System.out.println("::::::PROFESOR A TIEMPO COMPLETO::::::");
        System.out.println("TIPO DOC: " + this.tipo_documento+ " NRO DOC: " + this.Nro_documento);
        System.out.println("NOMBRE: " + this.Nombre+ " " + this.Apellido_pa+ " " + this.Apellido_ma);
        System.out.println("DIRECCION: "+this.Direccion);
        System.out.println("TELEFONO: "+this.Telefono);
        System.out.println("FECHA INGRESO: " + this.fecha_ingreso);
        if (this.departamento != null)
        {
            this.departamento.verDatos();
        }
        else
        {
        
            System.out.println("DEPARTAMENTO: NO REGISTRADO");
        }       
        // Mostramos los datos de la pensión si existe.
        if (this.pension != null)
        {
            this.pension.verDatos();
        }
        System.out.println("SUELDO FIJO: " + this.sueldo_fijo);
        System.out.println("INASISTENCIAS: " + contarInasistencias());
        System.out.println("TARDANZAS: " + contarTardanzas());
        System.out.println("SUELDO: " + calcular_sueldo()+ " SOLES");
    }
    
}
