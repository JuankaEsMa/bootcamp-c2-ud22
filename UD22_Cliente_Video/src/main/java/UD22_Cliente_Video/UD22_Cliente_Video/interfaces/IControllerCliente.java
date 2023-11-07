package UD22_Cliente_Video.UD22_Cliente_Video.interfaces;

import java.util.ArrayList;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;


public interface IControllerCliente {
	public void start(ConexionSQL conexion);
	public ArrayList<Cliente> darClientes();
	public boolean conectarDb(String db);
	public void crearInsertCliente();
	public void crearEditCliente(Cliente cliente);
	public void crearMostrarCliente(Cliente cliente);
	public void eliminarCliente(String id);
	public void crearMostrarVideos(Cliente cliente);
}
