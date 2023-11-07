package UD22_Cliente_Video.UD22_Cliente_Video.vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerVideo;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Video;
import java.awt.Font;

public class VideoTablaVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControllerVideo controller;
	private ArrayList<Video> listaVideos;
	public JPanel panel;
	public JButton btnAñadirCliente;

	public VideoTablaVista(IControllerVideo controller, Cliente cliente) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 415);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 41, 705, 332);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblIdTitulo = new JLabel("Id");
		lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdTitulo.setBounds(10, 5, 60, 20);
		panel.add(lblIdTitulo);

		JLabel lblDireccionTitulo = new JLabel("Cliente Id");
		lblDireccionTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccionTitulo.setBounds(260, 5, 80, 20);
		panel.add(lblDireccionTitulo);

		JLabel lblApellidoTitulo = new JLabel("Director");
		lblApellidoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoTitulo.setBounds(170, 5, 80, 20);
		panel.add(lblApellidoTitulo);

		JLabel lblNombreTitulos = new JLabel("Title");
		lblNombreTitulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitulos.setBounds(80, 5, 80, 20);
		panel.add(lblNombreTitulos);

		btnAñadirCliente = new JButton("Añadir Video");
		btnAñadirCliente.setForeground(SystemColor.desktop);
		btnAñadirCliente.setBackground(SystemColor.textHighlightText);
		btnAñadirCliente.setBounds(380, 10, 125, 21);
		contentPane.add(btnAñadirCliente);
		
		JLabel lblNewLabel = new JLabel("Videos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 10, 150, 20);
		contentPane.add(lblNewLabel);
		
		controller.conectarDb("Videoclub");
		if(cliente != null) {
			listaVideos = controller.darVideos(cliente);
		}else {
			listaVideos = controller.darVideos(null);
		}
		if(listaVideos != null) {
			mostrarTablaVideos();
		}
	}
	public void mostrarTablaVideos() {
		int xId = 10;
		int xTitle = 80;
		int xDirector = 170;
		int xCliId = 260;
		int xMostrar = 350;
		int xEditar = 410;
		int xBorrar = 470;
		int y = 5;
		for (int i = 0; i < listaVideos.size(); i++) {
			y += 30;
			Video video = listaVideos.get(i);
			JLabel lblIdTitulo = new JLabel(video.getId());
			lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdTitulo.setBounds(xId, y, 60, 20);
			panel.add(lblIdTitulo);

			JLabel lblTitleTitulo = new JLabel(video.getTitle());
			lblTitleTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitleTitulo.setBounds(xTitle, y, 80, 20);
			panel.add(lblTitleTitulo);

			JLabel lblDirectorTitulo = new JLabel(video.getDirector());
			lblDirectorTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDirectorTitulo.setBounds(xDirector, y, 70, 20);
			panel.add(lblDirectorTitulo);

			JLabel lblClienteIdTitulo = new JLabel(video.getCliId());
			lblClienteIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblClienteIdTitulo.setBounds(xCliId, y, 80, 20);
			panel.add(lblClienteIdTitulo);

			JButton btnMostrar = new JButton("M");
			btnMostrar.setBackground(new Color(51, 204, 0));
			btnMostrar.setBounds(xMostrar, y, 50, 20);
			panel.add(btnMostrar);
			btnMostrar.addActionListener(a->controller.crearMostrarVideo(video));

			JButton btnEditar = new JButton("E");
			btnEditar.setBackground(new Color(255, 204, 0));
			btnEditar.setBounds(xEditar, y, 50, 20);
			panel.add(btnEditar);
			btnEditar.addActionListener(a->controller.crearEditVideo(video));

			JButton btnEliminar = new JButton("B");
			btnEliminar.setBackground(new Color(255, 0, 0));
			btnEliminar.setBounds(xBorrar, y, 50, 20);
			panel.add(btnEliminar);
			btnEliminar.addActionListener(a->controller.eliminarVideo(video.getId()));
		}
	}
}
