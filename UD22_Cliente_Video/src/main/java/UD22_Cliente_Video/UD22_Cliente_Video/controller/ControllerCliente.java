package UD22_Cliente_Video.UD22_Cliente_Video.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerVideo;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.ClienteTablaVista;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.VistaMostrarEditarInsertarCliente;


public class ControllerCliente implements IControllerCliente{
	ConexionSQL connection;
	ClienteTablaVista vistaCliente;
	VistaMostrarEditarInsertarCliente vistaInsertar;
	VistaMostrarEditarInsertarCliente vistaEditar;
	VistaMostrarEditarInsertarCliente vistaMostrar;
	WindowListener windowListener;
	IControllerVideo controllerVideo;

	public ControllerCliente(IControllerVideo controllerVideo){
		this.controllerVideo = controllerVideo;
		windowListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				crearVistaCliente();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		};
	}
	@Override
	public ArrayList<Cliente> darClientes() {
		// TODO Auto-generated method stub
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<String> listaClientesStrings = connection.getAllTable("Cliente", 6);
		if(listaClientesStrings != null) {
			for (int i = 0; i < listaClientesStrings.size(); i+=6) {
				String id = listaClientesStrings.get(0+i);
				String nombre = listaClientesStrings.get(1+i);
				String apellido = listaClientesStrings.get(2+i);
				String direccion = listaClientesStrings.get(3+i);
				String dni = listaClientesStrings.get(4+i);
				String fecha = listaClientesStrings.get(5+i);
				Cliente cliente = new Cliente(id, nombre, apellido, direccion, dni, fecha);
				listaClientes.add(cliente);
			}
			return listaClientes;
		}else {
			if(JOptionPane.showConfirmDialog(null, "No existe la tabla Cliente ¿Quieres crearla?") == 0) {
				connection.createTable("Cliente", "id int auto_increment primary key, nombre varchar(250) default null, "
						+ "apellido varchar(250) default null, "
						+ "direccion varchar(250) default null, dni varchar(8) default null, fecha date default null");
			}
			return null;
		}

	}
	@Override
	public void start(ConexionSQL connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
		crearVistaCliente();
	}
	public void crearVistaCliente() {
		if(vistaCliente != null){
			vistaCliente.dispose();
		}
		vistaCliente = new ClienteTablaVista(this);
		vistaCliente.setVisible(true);
		vistaCliente.btnAñadirCliente.addActionListener(a->crearInsertCliente());
	}
	@Override
	public boolean conectarDb(String db) {
		// TODO Auto-generated method stub
		if(connection.conectarDb(db)) {
			return true;
		}else {
			if(JOptionPane.showConfirmDialog(null, "¿La tabla"+db+"no existe, quieres crear una con ése nombre?") == 0) {
				connection.createDB(db);
				return true;
			}
		}
		return false;
	}
	@Override
	public void crearInsertCliente() {
		// TODO Auto-generated method stub
		vistaInsertar = new VistaMostrarEditarInsertarCliente(null,"");
		vistaInsertar.setVisible(true);
		vistaInsertar.addWindowListener(windowListener);
		vistaInsertar.btnConfirmar.addActionListener(a->insertarCliente());
	}
	
	@Override
	public void crearEditCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		vistaEditar = new VistaMostrarEditarInsertarCliente(cliente,"Editar");
		vistaEditar.setVisible(true);
		vistaEditar.btnConfirmar.addActionListener(a->editarCliente(vistaEditar.getCliente(),cliente.getId()));
		vistaEditar.addWindowListener(windowListener);
	}
	
	@Override
	public void crearMostrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		vistaMostrar = new VistaMostrarEditarInsertarCliente(cliente,"Mostrar");
		vistaMostrar.setVisible(true);
		vistaMostrar.btnConfirmar.addActionListener(a->vistaMostrar.dispose());
		vistaMostrar.addWindowListener(windowListener);
	}
	
	public void insertarCliente() {
		String id = vistaInsertar.getId(); 
		String nombre = vistaInsertar.getNombre(); 
		String apellidos = vistaInsertar.getApellido(); 
		String direccion = vistaInsertar.getDireccion(); 
		String dni = vistaInsertar.getDni(); 
		String fecha = vistaInsertar.getFecha(); 
		String values = "(";
		String atributos = "(";
		if(!id.isEmpty()) {
			values += "id,";
			atributos += id + ",";
		}
		if(!nombre.isEmpty()) {
			values += "nombre,";
			atributos +="'"+ nombre + "',";
		}
		if(!apellidos.isEmpty()) {
			values += "apellido,";
			atributos +="'"+ apellidos + "',";
		}
		if(!direccion.isEmpty()) {
			values += "direccion,";
			atributos +="'"+ direccion + "',";
		}
		if(!dni.isEmpty()) {
			values += "dni,";
			atributos +="'"+ dni + "',";
		}
		if(!fecha.isEmpty()) {
			values += "fecha,";
			atributos +="'"+ fecha + "',";
		}
		if(values.length() == 1 || atributos.length() == 1) {
			values = "";
			atributos = "()";
		}else {
			values = values.substring(0,values.length()-1);
			values += ")";
			atributos = atributos.substring(0,atributos.length()-1);
			atributos += ")";
		}
		System.out.println(values);
		System.out.println(atributos);
		if(connection.insertIntoTable("Cliente", values, atributos)) {
			vistaInsertar.dispose();
			crearVistaCliente();
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
		}
	}
	@Override
	public void eliminarCliente(String id) {
		// TODO Auto-generated method stub
		connection.deleteTableWithId("Cliente", id);
		crearVistaCliente();
	}
	public void editarCliente(Cliente cliente, String id) {
		
		String atributos = "id="+cliente.getId()+", nombre='"+cliente.getNombre()+"',apellido='"+cliente.getApellido()+"',"
				+ "direccion='"+cliente.getDireccion()+"',dni='"+cliente.getDni()+"',fecha='"+cliente.getFecha()+"'";
		
		if(connection.updateTableWithId("Cliente", atributos, id)) {
			vistaEditar.dispose();
			crearVistaCliente();
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}
	@Override
	public void crearMostrarVideos(Cliente cliente) {
		// TODO Auto-generated method stub
		controllerVideo.start(connection, cliente);
	}
}
