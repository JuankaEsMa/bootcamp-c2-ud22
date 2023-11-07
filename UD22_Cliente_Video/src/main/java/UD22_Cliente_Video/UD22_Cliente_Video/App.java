package UD22_Cliente_Video.UD22_Cliente_Video;

import UD22_Cliente_Video.UD22_Cliente_Video.controller.ControllerCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.controller.ControllerConnection;
import UD22_Cliente_Video.UD22_Cliente_Video.controller.ControllerTablas;
import UD22_Cliente_Video.UD22_Cliente_Video.controller.ControllerVideo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ControllerVideo controllerVideo = new ControllerVideo();
    	ControllerCliente controlerCliente = new ControllerCliente(controllerVideo);
    	ControllerTablas controllerTabla = new ControllerTablas(controlerCliente, controllerVideo);
    	ControllerConnection controllerConnection = new ControllerConnection(controllerTabla);
    }
}
