package UD22_Cientificos.UD22_Cientificos.interfaces;

import java.util.ArrayList;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.models.Proyecto;


public interface IProyectoController {
	public void start(ConexionSQL conexion);
	public ArrayList<Proyecto> darProyectos();
	public boolean conectarDb(String db);
	public void crearInsertProyecto();
	public void crearEditProyecto(Proyecto proyecto);
	public void crearMostrarProyecto(Proyecto proyecto);
	public void eliminarProyecto(String id);
}
