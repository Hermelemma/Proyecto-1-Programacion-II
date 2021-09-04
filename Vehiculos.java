/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_12021;
import java.util.Date;

/**
 * Esta es la clase padre de los tipos de vehiculos
 * @author Emmanuel Herrera y Yoni Custodio
 * @version 1.0.0
 */
public class Vehiculos extends ArregloDeVehiculos{
    
    private int numeroDeEstacionamientos;
    private String noPlaca;
    private Date hora_Fecha;
    private double tarifa;
    private EnumVehiculo enumVehiculo;

    /**
     * Este metodo es un constructor vacio
     */
    public Vehiculos() {
    }    

    /**
     * Este metodo es un constructor con parametros
     * @param numeroDeEstacionamiento numero entero necesario para ingresar el valor de este atributo
     * @param placa String necesario para ingresar el valor de este atributo
     * @param horaYFecha tipo Date necesario para ingresar el valor de este atributo
     * @param tarifa double necesario para ingresar el valor de este atributo 
     * @param enumVehiculo tipo EnumVehiculo necesario para ingresar el valor de este atributo
     **/
    public Vehiculos(int numeroDeEstacionamiento, String placa, Date horaYFecha, double tarifa, EnumVehiculo enumVehiculo) {
        this.numeroDeEstacionamientos = numeroDeEstacionamiento;
        this.noPlaca = placa;
        this.hora_Fecha = horaYFecha;
        this.tarifa = tarifa;
        this.enumVehiculo = enumVehiculo;
    }
    
    /**
     * Metodo para obtener el valor del atributo numeroDeEstacionamientos
     * @return int devuelve un entero con el valor del atributo
     */
    public int getNumeroDeEstacionamiento() {
        return numeroDeEstacionamientos;
    }

    /**
     * Metodo para obtener el valor del atributo noPlaca
     * @return String devuelve un string con el valor del atributo
     */
    public String getNoPlaca() {
        return noPlaca;
    }

    /**
     * Metodo para obtener el valor del atributo hora_Fecha
     * @return Date devuelve un valor tipo Date con el valor del atributo
     */
    public Date getHora_Fecha() {
        return hora_Fecha;
    }

    /**
     * Metodo para obtener el valor del atributo tarifa
     * @return double devuelve un double con el valor del atributo
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Metodo para obtener el valor del atributo numeroDeEstacionamientos
     * @return enum devuelve un objeto con el valor del atributo
     */
    public EnumVehiculo getEnumVehiculo() {
        return enumVehiculo;
    } 
    
}

