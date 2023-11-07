package UD22_Cliente_Video.UD22_Cliente_Video.controller;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.interfaces.IConectarDatabase;
import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.connection.vista.ConexionVista;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerTabla;

public class ControllerConnection implements IConectarDatabase{
	
	ConexionVista vista;
	ConexionSQL conexion;
	IControllerTabla controllerTabla;

	public ControllerConnection(IControllerTabla controllerTabla) {
		this.controllerTabla = controllerTabla;
		vista = new ConexionVista(this);
		vista.setVisible(true);
	}
	
	@Override
	public void onConnectPress(String port, String username, String password) {
		// TODO Auto-generated method stub
		conexion = new ConexionSQL(port,username,password);
		if(conexion.conectar()) {
			vista.dispose();
			controllerTabla.start(conexion);
		}else {
			vista.errorConnection();
		}
	}

	@Override
	public void onCancelPress() {
		// TODO Auto-generated method stub
		
	}

}
