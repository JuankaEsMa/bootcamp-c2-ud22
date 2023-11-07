package UD22_Cliente_Video.UD22_Cliente_Video.interfaces;

import java.util.ArrayList;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Video;

public interface IControllerVideo {
	
	public void start(ConexionSQL conexion, Cliente cliente);
	public ArrayList<Video> darVideos(Cliente cliente);
	public boolean conectarDb(String db);
	public void crearInsertVideo();
	public void crearEditVideo(Video video);
	public void crearMostrarVideo(Video video);
	public void eliminarVideo(String id);
	public void crearVistaVideo(Cliente cliente);
	
}
