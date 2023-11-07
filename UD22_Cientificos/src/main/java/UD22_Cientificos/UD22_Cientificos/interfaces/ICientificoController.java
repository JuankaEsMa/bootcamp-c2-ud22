package UD22_Cientificos.UD22_Cientificos.interfaces;

import java.util.ArrayList;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.models.Cientifico;


public interface ICientificoController {
	public void start(ConexionSQL conexion);
	public ArrayList<Cientifico> darCientificos();
	public boolean conectarDb(String db);
	public void crearInsertCientifico();
	public void crearEditCientifico(Cientifico cientifico);
	public void crearMostrarCientifico(Cientifico cientifico);
	public void eliminarCientifico(String dni);
}
