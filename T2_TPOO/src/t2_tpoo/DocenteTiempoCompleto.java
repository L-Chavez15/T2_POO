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
    
     public double calcular_sueldo()
    {
        if (this.descuentos > this.sueldo_fijo) {
            throw new IllegalArgumentException(
                "Los descuentos superan el sueldo fijo"
            );
        }

        double sueldo;
        sueldo = this.sueldo_fijo - (this.sueldo_fijo*0.05);
        return sueldo;
    }

    @Override
    public void verDatos() 
    {
        System.out.println("::::::PROFESOR A TIEMPO COMPLETO::::::");
        System.out.println("TIPO DOC: " + this.tipo_documento+ " NRO DOC: " + this.Nro_documento);
        System.out.println("NOMBRE: " + this.Nombre+ " " + this.Apellido_pa+ " " + this.Apellido_ma);
        System.out.println("DIRECCION: "+this.Direccion);
        System.out.println("TELEFONO: "+this.Telefono);
        System.out.println("FECHA INGRESO: " + this.fecha_ingreso);
        System.out.println("DEPARTAMENTO: " + this.departmaneto);
        System.out.println("AFILIACION: " + this.pension);
        System.out.println("SUELDO FIJO: " + this.sueldo_fijo);
        System.out.println("DESCUENTOS: " + this.descuentos);
        System.out.println("SUELDO: " + calcular_sueldo());
    }
    
}
