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
public class Motocicleta extends Vehiculos {    

    /**
     * Este metodo es un constructor vacio
     **/
    public Motocicleta() {
    }

    /**
     * Este metodo es un constructor con parametros
     * @param numeroDeEstacionamiento numero entero necesario para mandar como parametro al constructor de la clase padre
     * @param placa String necesario para mandar como parametro al constructor de la clase padre
     * @param horaYFecha tipo Date necesario para mandar como parametro al constructor de la clase padre
     * @param tarifa double necesario para mandar como parametro al constructor de la clase padre 
     * @param enumVehiculo tipo EnumVehiculo necesario para mandar como parametro al constructor de la clase padre
     **/
    public Motocicleta(int numeroDeEstacionamiento, String placa, Date horaYFecha, double tarifa, EnumVehiculo enumVehiculo) {
        super(numeroDeEstacionamiento, placa, horaYFecha, tarifa, enumVehiculo);
    }
    
    /**
     * Metodo que establece el total a pagar para las motocicletas que salen del estacionamiento
     * @param tarifa double necesario para hacer un calculo y devolver otro double
     * @return double devuelve el total a pagar para las motocicletas
     **/
    public double monto(double tarifa){
        
        double monto = tarifa-(tarifa*0.10);
                
        return monto;
    }   
    
}
