package UD22_Cliente.UD22_Cliente.controller;

import UD22_Cliente.UD22_Cliente.connection.interfaces.IConectarDatabase;
import UD22_Cliente.UD22_Cliente.connection.logica.ConexionSQL;
import UD22_Cliente.UD22_Cliente.connection.vista.ConexionVista;
import UD22_Cliente.UD22_Cliente.interfaces.IControllerCliente;

public class ControllerConnection implements IConectarDatabase{
	
	ConexionVista vista;
	ConexionSQL conexion;
	IControllerCliente controllerCliente;

	public ControllerConnection(IControllerCliente controllerCliente) {
		this.controllerCliente = controllerCliente;
		vista = new ConexionVista(this);
		vista.setVisible(true);
	}
	
	@Override
	public void onConnectPress(String port, String username, String password) {
		// TODO Auto-generated method stub
		conexion = new ConexionSQL(port,username,password);
		if(conexion.conectar()) {
			vista.dispose();
			controllerCliente.start(conexion);
		}else {
			vista.errorConnection();
		}
	}

	@Override
	public void onCancelPress() {
		// TODO Auto-generated method stub
		
	}

}
