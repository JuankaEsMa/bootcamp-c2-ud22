package UD22_Cientificos.UD22_Cientificos.vistas;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import UD22_Cientificos.UD22_Cientificos.interfaces.IProyectoController;
import UD22_Cientificos.UD22_Cientificos.models.Proyecto;

import java.awt.Font;

public class ProyectoTablaVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IProyectoController controller;
	private ArrayList<Proyecto> listaVideos;
	public JPanel panel;
	public JButton btnAñadirCliente;

	public ProyectoTablaVista(IProyectoController controller) {
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

		JLabel lblApellidoTitulo = new JLabel("Horas");
		lblApellidoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoTitulo.setBounds(170, 5, 80, 20);
		panel.add(lblApellidoTitulo);

		JLabel lblNombreTitulos = new JLabel("Nombre");
		lblNombreTitulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitulos.setBounds(80, 5, 80, 20);
		panel.add(lblNombreTitulos);

		btnAñadirCliente = new JButton("Añadir Proyecto");
		btnAñadirCliente.setForeground(SystemColor.desktop);
		btnAñadirCliente.setBackground(SystemColor.textHighlightText);
		btnAñadirCliente.setBounds(380, 10, 125, 21);
		contentPane.add(btnAñadirCliente);
		
		JLabel lblNewLabel = new JLabel("Proyectos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 10, 150, 20);
		contentPane.add(lblNewLabel);
		
		controller.conectarDb("Cientificos");

		listaVideos = controller.darProyectos();
		if(listaVideos != null) {
			mostrarTablaVideos();
		}
	}
	public void mostrarTablaVideos() {
		int xId = 10;
		int xNombre = 80;
		int xHoras = 170;
		int xMostrar = 260;
		int xEditar = 320;
		int xBorrar = 380;
		int y = 5;
		for (int i = 0; i < listaVideos.size(); i++) {
			y += 30;
			Proyecto proyecto = listaVideos.get(i);
			JLabel lblIdTitulo = new JLabel(proyecto.getId());
			lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdTitulo.setBounds(xId, y, 60, 20);
			panel.add(lblIdTitulo);

			JLabel lblNombreTitulo = new JLabel(proyecto.getNombre());
			lblNombreTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreTitulo.setBounds(xNombre, y, 80, 20);
			panel.add(lblNombreTitulo);

			JLabel lblHorasTitulo = new JLabel(proyecto.getHoras());
			lblHorasTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblHorasTitulo.setBounds(xHoras, y, 70, 20);
			panel.add(lblHorasTitulo);

			JButton btnMostrar = new JButton("M");
			btnMostrar.setBackground(new Color(51, 204, 0));
			btnMostrar.setBounds(xMostrar, y, 50, 20);
			panel.add(btnMostrar);
			btnMostrar.addActionListener(a->controller.crearMostrarProyecto(proyecto));

			JButton btnEditar = new JButton("E");
			btnEditar.setBackground(new Color(255, 204, 0));
			btnEditar.setBounds(xEditar, y, 50, 20);
			panel.add(btnEditar);
			btnEditar.addActionListener(a->controller.crearEditProyecto(proyecto));

			JButton btnEliminar = new JButton("B");
			btnEliminar.setBackground(new Color(255, 0, 0));
			btnEliminar.setBounds(xBorrar, y, 50, 20);
			panel.add(btnEliminar);
			btnEliminar.addActionListener(a->controller.eliminarProyecto(proyecto.getId()));
		}
	}
}
