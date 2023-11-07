package UD22_Cientificos.UD22_Cientificos;

import UD22_Cientificos.UD22_Cientificos.controllers.ControllerAsignadoA;
import UD22_Cientificos.UD22_Cientificos.controllers.ControllerCientifico;
import UD22_Cientificos.UD22_Cientificos.controllers.ControllerConnection;
import UD22_Cientificos.UD22_Cientificos.controllers.ControllerProyecto;
import UD22_Cientificos.UD22_Cientificos.controllers.ControllerTablas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ControllerCientifico controlerCliente  = new ControllerCientifico();
    	ControllerProyecto controllerProyecto = new ControllerProyecto();
    	ControllerAsignadoA controllerAsignado = new ControllerAsignadoA();
    	ControllerTablas controllerTabla = new ControllerTablas(controlerCliente, controllerProyecto, controllerAsignado);
    	ControllerConnection controllerConnection = new ControllerConnection(controllerTabla);
    }
}
