package UD22_Cliente.UD22_Cliente;

import UD22_Cliente.UD22_Cliente.controller.ControllerCliente;
import UD22_Cliente.UD22_Cliente.controller.ControllerConnection;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ControllerCliente controllerCliente = new ControllerCliente();
    	ControllerConnection controllerConnection = new ControllerConnection(controllerCliente);
    }
}
