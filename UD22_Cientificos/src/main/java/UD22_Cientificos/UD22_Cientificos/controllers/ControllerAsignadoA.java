package UD22_Cientificos.UD22_Cientificos.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.interfaces.IAsignadoAController;
import UD22_Cientificos.UD22_Cientificos.models.AsignadoA;
import UD22_Cientificos.UD22_Cientificos.vistas.AsignadoATablaVista;
import UD22_Cientificos.UD22_Cientificos.vistas.VistaMostrarEditarInsertarAsignadoA;

public class ControllerAsignadoA implements IAsignadoAController{
	ConexionSQL connection;
	AsignadoATablaVista vistaCliente;
	VistaMostrarEditarInsertarAsignadoA vistaInsertar;
	VistaMostrarEditarInsertarAsignadoA vistaEditar;
	VistaMostrarEditarInsertarAsignadoA vistaMostrar;
	WindowListener windowListener;

	public ControllerAsignadoA(){
		windowListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				crearVistaAsignado();
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
	public ArrayList<AsignadoA> darAsignados() {
		// TODO Auto-generated method stub
		ArrayList<AsignadoA> listaClientes = new ArrayList<AsignadoA>();
		ArrayList<String> listaClientesStrings = connection.getAllTable("Asignado_a", 2);
		if(listaClientesStrings != null) {
			for (int i = 0; i < listaClientesStrings.size(); i+=2) {
				String id = listaClientesStrings.get(0+i);
				String nomApels= listaClientesStrings.get(1+i);

				AsignadoA asignado = new AsignadoA(id, nomApels);
				listaClientes.add(asignado);
			}
			return listaClientes;
		}else {
			if(JOptionPane.showConfirmDialog(null, "No existe la tabla Asignación ¿Quieres crearla?") == 0) {
				connection.createTable("Asignado_a", "cientifico varchar(8), proyecto char(4), primary key (cientifico, proyecto), "
						+ "foreign key (cientifico) references Cientifico (dni), foreign key (proyecto) references Proyecto(id)");
			}
			return null;
		}

	}
	@Override
	public void start(ConexionSQL connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
		crearVistaAsignado();
	}
	public void crearVistaAsignado() {
		if(vistaCliente != null){
			vistaCliente.dispose();
		}
		vistaCliente = new AsignadoATablaVista(this);
		vistaCliente.setVisible(true);
		vistaCliente.btnAñadirCliente.addActionListener(a->crearInsertAsignado());
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
	public void crearInsertAsignado() {
		// TODO Auto-generated method stub
		vistaInsertar = new VistaMostrarEditarInsertarAsignadoA(null,"");
		vistaInsertar.setVisible(true);
		vistaInsertar.addWindowListener(windowListener);
		vistaInsertar.btnConfirmar.addActionListener(a->insertarAsignado());
	}
	
	@Override
	public void crearEditAsignado(AsignadoA asignado) {
		// TODO Auto-generated method stub
		vistaEditar = new VistaMostrarEditarInsertarAsignadoA(asignado,"Editar");
		vistaEditar.setVisible(true);
		vistaEditar.btnConfirmar.addActionListener(a->editarAsignado(vistaEditar.getAsignado(),asignado.getIdCientifico(),asignado.getIdProyecto()));
		vistaEditar.addWindowListener(windowListener);
	}
	
	@Override
	public void crearMostrarAsignado(AsignadoA asignado) {
		// TODO Auto-generated method stub
		vistaMostrar = new VistaMostrarEditarInsertarAsignadoA(asignado,"Mostrar");
		vistaMostrar.setVisible(true);
		vistaMostrar.btnConfirmar.addActionListener(a->vistaMostrar.dispose());
		vistaMostrar.addWindowListener(windowListener);
	}
	
	public void insertarAsignado() {
		String id = vistaInsertar.getCientifico(); 
		String nombre = vistaInsertar.getProyecto(); 
		String values = "(";
		String atributos = "(";
		if(!id.isEmpty()) {
			values += "cientifico,";
			atributos +="'" +id + "',";
		}
		if(!nombre.isEmpty()) {
			values += "proyecto,";
			atributos +="'"+ nombre + "',";
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
		if(connection.insertIntoTable("Asignado_a", values, atributos)) {
			vistaInsertar.dispose();
			crearVistaAsignado();
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
		}
	}
	@Override
	public void eliminarAsignado(String idCientifico, String idProyecto) {
		// TODO Auto-generated method stub
		String[] id_names = new String[2];
		String[] ids = new String[2];
		id_names[0] = "cientifico";
		id_names[1] = "proyecto";
		ids[0] = idCientifico;
		ids[1] = idProyecto;
		connection.deleteTableWithMultipleKeys("Asignado_a",id_names ,ids);
		crearVistaAsignado();
	}
	public void editarAsignado(AsignadoA asignado, String idCientifico, String idProyecto) {
		
		String atributos = "cientifico='"+asignado.getIdCientifico()+"', proyecto='"+asignado.getIdProyecto()+"'";
		String[] id_names = new String[2];
		String[] ids = new String[2];
		
		id_names[0] = "cientifico";
		id_names[1] = "proyecto";
		ids[0] = idCientifico;
		ids[1] = idProyecto;
		if(connection.updateTableWithMultipleKeys("Asignado_a", atributos, id_names ,ids)) {
			vistaEditar.dispose();
			crearVistaAsignado();
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}
}
