package UD22_Cliente.UD22_Cliente.interfaces;

import java.util.ArrayList;

import UD22_Cliente.UD22_Cliente.connection.logica.ConexionSQL;
import UD22_Cliente.UD22_Cliente.models.Cliente;



public interface IControllerCliente {
	public void start(ConexionSQL conexion);
	public ArrayList<Cliente> darClientes();
	public boolean conectarDb(String db);
	public void crearInsertCliente();
	public void crearEditCliente(Cliente cliente);
	public void crearMostrarCliente(Cliente cliente);
	public void eliminarCliente(String id);
}
