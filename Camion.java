/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_12021;
import java.util.Date;

/**
 *Esta clase hereda de la clase Vehiculo y tiene funcionalidad util para el uso del programa
 * @author Emmanuel Herrera y Yoni Custodio
 * @version 1.0.0
 **/
public class Camion extends Vehiculos {
    
    /**
     * Este metodo es un constructor vacio
     **/
    public Camion() {
    }

    /**
     * Este metodo es un constructor con parametros
     * @param numeroDeEstacionamiento numero entero necesario para mandar como parametro al constructor de la clase padre
     * @param placa String necesario para mandar como parametro al constructor de la clase padre
     * @param horaYFecha tipo Date necesario para mandar como parametro al constructor de la clase padre
     * @param tarifa double necesario para mandar como parametro al constructor de la clase padre 
     * @param enumVehiculo tipo EnumVehiculo necesario para mandar como parametro al constructor de la clase padre*
     **/
    public Camion(int numeroDeEstacionamiento, String placa, Date horaYFecha, double tarifa, EnumVehiculo enumVehiculo) {
        super(numeroDeEstacionamiento, placa, horaYFecha, tarifa, enumVehiculo);
    }

    /**
     * Metodo que calcula el total a pagar para los camiones que salen del estacionamiento
     * @param cantPeriodos double necesario para hacer un calculo y devolver otro double
     * @return double devuelve el total a pagar para el camion
     **/
    public double total(double cantPeriodos){
        
        
        double total=(10*cantPeriodos)+(5*(cantPeriodos-1));
        
        return total;
    }
    
}
