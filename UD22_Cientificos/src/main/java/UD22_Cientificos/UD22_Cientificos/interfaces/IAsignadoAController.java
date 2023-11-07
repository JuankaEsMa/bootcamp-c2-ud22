package UD22_Cientificos.UD22_Cientificos.interfaces;

import java.util.ArrayList;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.models.AsignadoA;

public interface IAsignadoAController {
	public void start(ConexionSQL conexion);
	public ArrayList<AsignadoA> darAsignados();
	public boolean conectarDb(String db);
	public void crearInsertAsignado();
	public void crearEditAsignado(AsignadoA cientifico);
	public void crearMostrarAsignado(AsignadoA cientifico);
	public void eliminarAsignado(String idCientifico,String idProyecto);
}
