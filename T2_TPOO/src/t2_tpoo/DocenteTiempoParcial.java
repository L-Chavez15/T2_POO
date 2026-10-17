/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

/**
 *
 * @author leoch
 */
public class DocenteTiempoParcial extends Docente //Usamos EXTENDS para hacer herencia
{
    private double Horas_dictadas;
    private double tarifa;
    
    //Si el padre tiene constructores, el hijo necesita contructores

    public double getHoras_dictadas() {
        return Horas_dictadas;
    }

    public void setHoras_dictadas(double Horas_dictadas) {
        this.Horas_dictadas = Horas_dictadas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    public double Calcular_remuneracion()
    {
        double remuneracion;
        remuneracion = this.Horas_dictadas * this.tarifa;
        return remuneracion;
    }

    @Override//usamos polimorfismos
    public void verDatos() 
    {
        System.out.println("PROFESOR A TIEMPO PARCIAL");
        System.out.println("TIPO DOC: " + this.tipo_documento + " NRO DOC: " + this.Nro_documento);
        System.out.println("NOMBRE: " + this.Nombre+ " " + this.Apellido_pa+ " " + this.Apellido_ma);
        System.out.println("DIRECCION: "+this.Direccion);
        System.out.println("TELEFONO: "+this.Telefono);
        System.out.println("FECHA INGRESO: " + this.fecha_ingreso);
        System.out.println("DEPARTAMENTO: " + this.departmaneto);
        System.out.println("AFILIACION: " + this.pension);
        System.out.println("HORAS DICTADAS: " + this.Horas_dictadas);
        System.out.println("TARIFA POR HORA: " + this.tarifa);
        System.out.println("REMUNERACION: " + this.Calcular_remuneracion());
    }

    
    
}
