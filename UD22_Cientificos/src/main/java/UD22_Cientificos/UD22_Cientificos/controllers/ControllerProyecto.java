package UD22_Cientificos.UD22_Cientificos.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.interfaces.IProyectoController;
import UD22_Cientificos.UD22_Cientificos.models.Cientifico;
import UD22_Cientificos.UD22_Cientificos.models.Proyecto;
import UD22_Cientificos.UD22_Cientificos.vistas.CientificoTablaVista;
import UD22_Cientificos.UD22_Cientificos.vistas.ProyectoTablaVista;
import UD22_Cientificos.UD22_Cientificos.vistas.VistaMostrarEditarInsertarCientifico;
import UD22_Cientificos.UD22_Cientificos.vistas.VistaMostrarEditarInsertarProyecto;

public class ControllerProyecto implements IProyectoController{
	ConexionSQL connection;
	WindowListener windowListener;
	ProyectoTablaVista vistaProyecto;
	VistaMostrarEditarInsertarProyecto vistaInsertar;
	VistaMostrarEditarInsertarProyecto vistaEditar;
	VistaMostrarEditarInsertarProyecto vistaMostrar;

	public ControllerProyecto() {
		windowListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				crearVistaProyecto();
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
	public void start(ConexionSQL conexion) {
		// TODO Auto-generated method stub
		this.connection = conexion;
		crearVistaProyecto();
	}

	@Override
	public ArrayList<Proyecto> darProyectos() {
		// TODO Auto-generated method stub
		ArrayList<Proyecto> listaClientes = new ArrayList<Proyecto>();
		ArrayList<String> listaClientesStrings = connection.getAllTable("Proyecto", 3);
		if(listaClientesStrings != null) {
			for (int i = 0; i < listaClientesStrings.size(); i+=3) {
				String id = listaClientesStrings.get(0+i);
				String nombre= listaClientesStrings.get(1+i);
				String horas= listaClientesStrings.get(2+i);
				Proyecto proyecto = new Proyecto(id, nombre, horas);
				listaClientes.add(proyecto);
			}
			return listaClientes;
		}else {
			if(JOptionPane.showConfirmDialog(null, "No existe la tabla Proyecto ¿Quieres crearla?") == 0) {
				connection.createTable("Proyecto", "id char(4) primary key, nombre varchar(255) default null, horas int default null");
			}
			return null;
		}
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
	public void crearInsertProyecto() {
		// TODO Auto-generated method stub
		vistaInsertar = new VistaMostrarEditarInsertarProyecto(null,"");
		vistaInsertar.setVisible(true);
		vistaInsertar.addWindowListener(windowListener);
		vistaInsertar.btnConfirmar.addActionListener(a->insertarProyecto());
	}

	@Override
	public void crearEditProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		vistaEditar = new VistaMostrarEditarInsertarProyecto(proyecto,"Editar");
		vistaEditar.setVisible(true);
		vistaEditar.btnConfirmar.addActionListener(a->editarProyecto(vistaEditar.getProyecto(),proyecto.getId()));
		vistaEditar.addWindowListener(windowListener);
	}

	@Override
	public void crearMostrarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		vistaMostrar = new VistaMostrarEditarInsertarProyecto(proyecto,"Mostrar");
		vistaMostrar.setVisible(true);
		vistaMostrar.btnConfirmar.addActionListener(a->vistaMostrar.dispose());
		vistaMostrar.addWindowListener(windowListener);
	}

	@Override
	public void eliminarProyecto(String id) {
		// TODO Auto-generated method stub
		connection.deleteTableWithId("Proyecto","id" ,"'"+id+"'");
		crearVistaProyecto();
	}

	public void crearVistaProyecto() {
		if(vistaProyecto != null){
			vistaProyecto.dispose();
		}
		vistaProyecto = new ProyectoTablaVista(this);
		vistaProyecto.setVisible(true);
		vistaProyecto.btnAñadirCliente.addActionListener(a->crearInsertProyecto());
	}

	public void insertarProyecto() {
		String id = vistaInsertar.getId(); 
		String nombre = vistaInsertar.getNombre(); 
		String horas = vistaInsertar.getHoras(); 
		String values = "(";
		String atributos = "(";
		if(!id.isEmpty()) {
			values += "id,";
			atributos +="'" +id + "',";
		}
		if(!nombre.isEmpty()) {
			values += "nombre,";
			atributos +="'"+ nombre + "',";
		}
		if(!horas.isEmpty()) {
			values += "horas,";
			atributos +=horas + ",";
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
		if(connection.insertIntoTable("Proyecto", values, atributos)) {
			vistaInsertar.dispose();
			crearVistaProyecto();
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
		}
	}

	public void editarProyecto(Proyecto proyecto, String id) {
		Integer horas;
		try {
			horas = Integer.valueOf(proyecto.getHoras());
		}catch(NumberFormatException e) {
			horas = null;
		}
		String atributos = "id='"+proyecto.getId()+"', nombre='"+proyecto.getNombre()+"', horas = " + horas;

		if(connection.updateTableWithId("Proyecto", atributos, "id" ,"'"+id+"'")) {
			vistaEditar.dispose();
			crearVistaProyecto();
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}
}
