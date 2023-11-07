package UD22_Cientificos.UD22_Cientificos.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UD22_Cientificos.UD22_Cientificos.connection.logica.ConexionSQL;
import UD22_Cientificos.UD22_Cientificos.interfaces.ICientificoController;
import UD22_Cientificos.UD22_Cientificos.models.Cientifico;
import UD22_Cientificos.UD22_Cientificos.vistas.CientificoTablaVista;
import UD22_Cientificos.UD22_Cientificos.vistas.VistaMostrarEditarInsertarCientifico;


public class ControllerCientifico implements ICientificoController{
	ConexionSQL connection;
	CientificoTablaVista vistaCliente;
	VistaMostrarEditarInsertarCientifico vistaInsertar;
	VistaMostrarEditarInsertarCientifico vistaEditar;
	VistaMostrarEditarInsertarCientifico vistaMostrar;
	WindowListener windowListener;

	public ControllerCientifico(){
		windowListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				crearVistaCientifico();
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
	public ArrayList<Cientifico> darCientificos() {
		// TODO Auto-generated method stub
		ArrayList<Cientifico> listaClientes = new ArrayList<Cientifico>();
		ArrayList<String> listaClientesStrings = connection.getAllTable("Cientifico", 2);
		if(listaClientesStrings != null) {
			for (int i = 0; i < listaClientesStrings.size(); i+=2) {
				String id = listaClientesStrings.get(0+i);
				String nomApels= listaClientesStrings.get(1+i);

				Cientifico cientifico = new Cientifico(id, nomApels);
				listaClientes.add(cientifico);
			}
			return listaClientes;
		}else {
			if(JOptionPane.showConfirmDialog(null, "No existe la tabla Cientifico ¿Quieres crearla?") == 0) {
				connection.createTable("Cientifico", "id int auto_increment primary key, nom_apels varchar(255) default null");
			}
			return null;
		}

	}
	@Override
	public void start(ConexionSQL connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
		crearVistaCientifico();
	}
	public void crearVistaCientifico() {
		if(vistaCliente != null){
			vistaCliente.dispose();
		}
		vistaCliente = new CientificoTablaVista(this);
		vistaCliente.setVisible(true);
		vistaCliente.btnAñadirCliente.addActionListener(a->crearInsertCientifico());
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
	public void crearInsertCientifico() {
		// TODO Auto-generated method stub
		vistaInsertar = new VistaMostrarEditarInsertarCientifico(null,"");
		vistaInsertar.setVisible(true);
		vistaInsertar.addWindowListener(windowListener);
		vistaInsertar.btnConfirmar.addActionListener(a->insertarCliente());
	}
	
	@Override
	public void crearEditCientifico(Cientifico cientifico) {
		// TODO Auto-generated method stub
		vistaEditar = new VistaMostrarEditarInsertarCientifico(cientifico,"Editar");
		vistaEditar.setVisible(true);
		vistaEditar.btnConfirmar.addActionListener(a->editarCliente(vistaEditar.getCientifico(),cientifico.getDni()));
		vistaEditar.addWindowListener(windowListener);
	}
	
	@Override
	public void crearMostrarCientifico(Cientifico cientifico) {
		// TODO Auto-generated method stub
		vistaMostrar = new VistaMostrarEditarInsertarCientifico(cientifico,"Mostrar");
		vistaMostrar.setVisible(true);
		vistaMostrar.btnConfirmar.addActionListener(a->vistaMostrar.dispose());
		vistaMostrar.addWindowListener(windowListener);
	}
	
	public void insertarCliente() {
		String id = vistaInsertar.getDni(); 
		String nombre = vistaInsertar.getNomApels(); 
		String values = "(";
		String atributos = "(";
		if(!id.isEmpty()) {
			values += "dni,";
			atributos +="'" +id + "',";
		}
		if(!nombre.isEmpty()) {
			values += "nom_apels,";
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
		if(connection.insertIntoTable("Cientifico", values, atributos)) {
			vistaInsertar.dispose();
			crearVistaCientifico();
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
		}
	}
	@Override
	public void eliminarCientifico(String id) {
		// TODO Auto-generated method stub
		connection.deleteTableWithId("Cientifico","dni" ,id);
		crearVistaCientifico();
	}
	public void editarCliente(Cientifico cientifico, String id) {
		
		String atributos = "dni="+cientifico.getDni()+", nom_apels='"+cientifico.getNomApels()+"'";
		
		if(connection.updateTableWithId("Cientifico", atributos, "dni" ,id)) {
			vistaEditar.dispose();
			crearVistaCientifico();
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}
}
