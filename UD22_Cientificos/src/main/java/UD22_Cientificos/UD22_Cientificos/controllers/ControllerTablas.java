package UD22_Cientificos.UD22_Cientificos.controllers;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.interfaces.IAsignadoAController;
import UD22_Cientificos.UD22_Cientificos.interfaces.ICientificoController;
import UD22_Cientificos.UD22_Cientificos.interfaces.IControllerTabla;
import UD22_Cientificos.UD22_Cientificos.interfaces.IProyectoController;
import UD22_Cientificos.UD22_Cientificos.vistas.TablasVista;

public class ControllerTablas implements IControllerTabla{

	ICientificoController controllerCientifico;
	IProyectoController controllerProyecto;
	IAsignadoAController controllerAsignado;
	TablasVista tablaVista;
	
	public ControllerTablas(ICientificoController controllerCientifico, IProyectoController controllerProyecto, IAsignadoAController controllerAsignado) {
		this.controllerCientifico = controllerCientifico;
		this.controllerProyecto = controllerProyecto;
		this.controllerAsignado = controllerAsignado;
	}
	@Override
	public void startCientificos(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		controllerCientifico.start(connexion);
	}

	@Override
	public void startProyectos(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		controllerProyecto.start(connexion);
	}

	@Override
	public void start(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		tablaVista = new TablasVista();
		tablaVista.setVisible(true);
		tablaVista.btnCientificos.addActionListener(a-> startCientificos(connexion));
		tablaVista.btnProyecto.addActionListener(a-> startProyectos(connexion));
		tablaVista.btnAsignadoA.addActionListener(a-> startAsignadoA(connexion));
	}
	@Override
	public void startAsignadoA(ConexionSQL connexion) {
		// TODO Auto-generated method stub
		controllerAsignado.start(connexion);
	}

}
