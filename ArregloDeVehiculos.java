/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_12021;
import java.util.ArrayList;

/**
 *Esta es una clase abstracta que gestiona un arreglo de vehiculos ingresados
 * @author Emmanuel Herrera y Yoni Custodio
 * @version 1.0.0
 **/
public abstract class ArregloDeVehiculos {
    
    private ArrayList<Vehiculos>  vehiculo;
    
    /**
     * Metodo constructor que no recibe parametros
     */
    public ArregloDeVehiculos() {
        this.vehiculo = new ArrayList<>();
    }
   
    /**
     * Metodo que sirve para aÃ±adir un nuevo vehiculo al arrayList
     * @param p objeto necesario para aÃ±adir un nuevo vehiculo a la lista
     */
    public void agregarUnVehiculo(Vehiculos p){
        this.vehiculo.add(p);
    }
    
}
