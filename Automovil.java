
package proyecto_12021;
import java.util.Date;

/**
 *Esta clase hereda de la clase Vehiculo y tiene funcionalidad util para el uso del programa
 * @author Emmanuel Herrera y Yoni Custoio
 * @version 1.0.0
 **/
public class Automovil extends Vehiculos {    

    /**
     * Este metodo es un constructor vacio
     **/
    public Automovil() {
    }

    /**
     * Este metodo es un constructor con parametros
     * @param numeroDeEstacionamiento numero entero necesario para mandar como parametro al constructor de la clase padre
     * @param placa String necesario para mandar como parametro al constructor de la clase padre
     * @param horaYFecha tipo Date necesario para mandar como parametro al constructor de la clase padre
     * @param tarifa double necesario para mandar como parametro al constructor de la clase padre 
     * @param enumVehiculo tipo EnumVehiculo necesario para mandar como parametro al constructor de la clase padre
     **/
    public Automovil(int numeroDeEstacionamiento, String placa, Date horaYFecha, double tarifa, EnumVehiculo enumVehiculo) {
        super(numeroDeEstacionamiento, placa, horaYFecha, tarifa, enumVehiculo);
    }

    /**
     * Metodo que establece el total a pagar para los automoviles que salen del estacionamiento
     * @param tarifa double necesario para hacer un calculo y devolver otro double
     * @return double devuelve el total a pagar para el automovil
     **/
    public double total(double tarifa){
        
        double total = tarifa;
                
        return total;
    }
}
