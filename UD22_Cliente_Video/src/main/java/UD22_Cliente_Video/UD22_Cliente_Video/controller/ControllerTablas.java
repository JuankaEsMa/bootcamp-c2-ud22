package UD22_Cliente_Video.UD22_Cliente_Video.controller;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerTabla;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerVideo;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.TablasVista;

public class ControllerTablas implements IControllerTabla{

	IControllerCliente controllerCliente;
	IControllerVideo controllerVideo;
	TablasVista tablaVista;
	
	public ControllerTablas(IControllerCliente controllerCliente, IControllerVideo controllerVideo) {
		this.controllerCliente = controllerCliente;
		this.controllerVideo = controllerVideo;
	}
	@Override
	public void startCliente(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		controllerCliente.start(connexion);
	}

	@Override
	public void startVideos(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		controllerVideo.start(connexion,null);
	}

	@Override
	public void start(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		tablaVista = new TablasVista();
		tablaVista.setVisible(true);
		tablaVista.btnClientes.addActionListener(a-> startCliente(connexion));
		tablaVista.btnVideos.addActionListener(a-> startVideos(connexion));
	}

}
