/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t2_tpoo;

/**
 *
 * @author leoch
 */
// Representa el sistema previsional del docente.
public class Pension 
{
    // Almacena el sistema de pensiones y la empresa AFP, si corresponde.
    private String tipoSistema;//ONP o AFP
    private String empresaAFP;
    

    public Pension() {
    }

    public Pension(String tipoSistema, String empresaAFP) {
        this.tipoSistema = tipoSistema;
        this.empresaAFP = empresaAFP;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public String getEmpresaAFP() {
        return empresaAFP;
    }

    public void setEmpresaAFP(String empresaAFP) {
        this.empresaAFP = empresaAFP;
    }
    
    // Calcula el descuento aplicando el porcentaje definido en el método.
    public double calcularDescuento(double sueldo)
    {
        return sueldo*0.02;//Aplicamos descuento general del 2%
    }
    
    // Muestra el sistema previsional y la empresa AFP cuando corresponde.
    public void verDatos() {
        System.out.println("Sistema de Pension: " + tipoSistema);
        
        if (tipoSistema != null && tipoSistema.equalsIgnoreCase("AFP")) 
        {
            System.out.println("Empresa AFP: " + empresaAFP);
        }
        System.out.println("Descuento por pension: 2% del sueldo");
    }
}
