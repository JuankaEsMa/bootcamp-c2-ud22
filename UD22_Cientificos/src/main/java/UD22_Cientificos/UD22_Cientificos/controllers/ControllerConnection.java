package UD22_Cientificos.UD22_Cientificos.controllers;

import UD22_Cientificos.UD22_Cientificos.connection.interfaces.IConectarDatabase;
import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.connection.vistas.ConexionVista;
import UD22_Cientificos.UD22_Cientificos.interfaces.IControllerTabla;

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
