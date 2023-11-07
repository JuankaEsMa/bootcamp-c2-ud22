package UD22_Cliente_Video.UD22_Cliente_Video.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UD22_Cliente_Video.UD22_Cliente_Video.connection.logica.ConexionSQL;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerVideo;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Video;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.VideoTablaVista;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.VistaMostrarEditarInsertarCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.vistas.VistaMostrarEditarInsertarVideo;

public class ControllerVideo implements IControllerVideo{

	ConexionSQL connection;
	VideoTablaVista vistaVideo;
	VistaMostrarEditarInsertarVideo vistaInsertar;
	VistaMostrarEditarInsertarVideo vistaEditar;
	VistaMostrarEditarInsertarVideo vistaMostrar;
	WindowListener windowListener;

	public ControllerVideo() {
		windowListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getSource());
				crearVistaVideo(null);
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
	public void start(ConexionSQL conexion, Cliente cliente) {
		// TODO Auto-generated method stub
		this.connection = conexion;
		crearVistaVideo(cliente);
	}

	@Override
	public ArrayList<Video> darVideos(Cliente cliente) {
		// TODO Auto-generated method stub
		ArrayList<String> videoStrings;
		ArrayList<Video> listaVideos = new ArrayList<Video>();
		if(cliente == null) {
			videoStrings = connection.getAllTable("Video", 4);
		}else {
			videoStrings = connection.getAllTableWithWhere("Video",4,"cli_id="+cliente.getId());
		}
		if(videoStrings != null) {
			for (int i = 0; i < videoStrings.size(); i+=4) {
				String id = videoStrings.get(0+i);
				String title = videoStrings.get(1+i);
				String director = videoStrings.get(2+i);
				String cli_id = videoStrings.get(3+i);
				Video video = new Video(id, title, director, cli_id);
				listaVideos.add(video);
			}
			return listaVideos;
		}else {
			if(JOptionPane.showConfirmDialog(null, "No existe la tabla Video ¿Quieres crearla?") == 0) {
				connection.createTable("Video", "id int auto_increment primary key, title varchar(250) default null, "
						+ "director varchar(250) default null, "
						+ "cli_id int default null, foreign key (cli_id) references Cliente(id)");
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
			if(JOptionPane.showConfirmDialog(null, "¿La tabla "+ db +" no existe, quieres crear una con ése nombre?") == 0) {
				connection.createDB(db);
				return true;
			}
		}
		return false;
	}

	@Override
	public void crearInsertVideo() {
		// TODO Auto-generated method stub
		vistaInsertar = new VistaMostrarEditarInsertarVideo(null,"");
		vistaInsertar.setVisible(true);
		vistaInsertar.addWindowListener(windowListener);
		vistaInsertar.btnConfirmar.addActionListener(a->insertarVideo());
	}

	@Override
	public void crearEditVideo(Video video) {
		// TODO Auto-generated method stub
		vistaEditar = new VistaMostrarEditarInsertarVideo(video,"Editar");
		vistaEditar.setVisible(true);
		vistaEditar.btnConfirmar.addActionListener(a->editarVideo(vistaEditar.getVideo(),video.getId()));
		vistaEditar.addWindowListener(windowListener);
	}

	@Override
	public void crearMostrarVideo(Video video) {
		// TODO Auto-generated method stub
		vistaMostrar = new VistaMostrarEditarInsertarVideo(video,"Mostrar");
		vistaMostrar.setVisible(true);
		vistaMostrar.btnConfirmar.addActionListener(a->vistaMostrar.dispose());
		vistaMostrar.addWindowListener(windowListener);
	}

	@Override
	public void eliminarVideo(String id) {
		// TODO Auto-generated method stub
		System.out.println("Borrando id = " + id);
		connection.deleteTableWithId("Video", id);
		crearVistaVideo(null);
	}
	
	public void crearVistaVideo(Cliente cliente) {
		if(vistaVideo != null) {
			vistaVideo.dispose();
		}
		vistaVideo = new VideoTablaVista(this, cliente);
		vistaVideo.setVisible(true);
		vistaVideo.btnAñadirCliente.addActionListener(a->crearInsertVideo());
	}
	
	public void insertarVideo() {
		String id = vistaInsertar.getId(); 
		String title = vistaInsertar.getTitle(); 
		String director = vistaInsertar.getDirector(); 
		String clienteId = vistaInsertar.getClienteId(); 
		String values = "(";
		String atributos = "(";
		if(!id.isEmpty()) {
			values += "id,";
			atributos += id + ",";
		}
		if(!title.isEmpty()) {
			values += "title,";
			atributos +="'"+ title + "',";
		}
		if(!director.isEmpty()) {
			values += "director,";
			atributos +="'"+ director + "',";
		}
		if(!clienteId.isEmpty()) {
			values += "cli_id,";
			atributos +="'"+ clienteId + "',";
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
		if(connection.insertIntoTable("Video", values, atributos)) {
			vistaInsertar.dispose();
			crearVistaVideo(null);
		}else {
			JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
		}

	}
	public void editarVideo(Video video, String id) {
		
		String atributos = "id="+video.getId()+", title='"+video.getTitle()+"',director='"+video.getDirector()+"',"
				+ "cli_id='"+video.getCliId()+"'";
		
		if(connection.updateTableWithId("Video", atributos, id)) {
			vistaEditar.dispose();
			crearVistaVideo(null);
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
	}

}
