package UD22_Cientificos.UD22_Cientificos.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UD22_Cientificos.UD22_Cientificos.interfaces.IAsignadoAController;
import UD22_Cientificos.UD22_Cientificos.interfaces.ICientificoController;
import UD22_Cientificos.UD22_Cientificos.models.AsignadoA;
import UD22_Cientificos.UD22_Cientificos.models.Cientifico;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;


public class AsignadoATablaVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IAsignadoAController controller;
	private ArrayList<AsignadoA> listaClientes;
	public JPanel panel;
	public JButton btnAñadirCliente;
	public AsignadoATablaVista(IAsignadoAController controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 412);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 41, 919, 507);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdTitulo = new JLabel("Id Cientifico");
		lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdTitulo.setBounds(10, 5, 60, 20);
		panel.add(lblIdTitulo);
		
		JLabel lblNombreTitulos = new JLabel("Id Proyecto");
		lblNombreTitulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitulos.setBounds(80, 5, 80, 20);
		panel.add(lblNombreTitulos);
		
		btnAñadirCliente = new JButton("Añadir Asignación");
		btnAñadirCliente.setForeground(SystemColor.desktop);
		btnAñadirCliente.setBackground(SystemColor.textHighlightText);
		btnAñadirCliente.setBounds(300, 10, 125, 21);
		contentPane.add(btnAñadirCliente);
		
		JLabel lblNewLabel = new JLabel("Asignaciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 10, 150, 20);
		contentPane.add(lblNewLabel);
		
		controller.conectarDb("Cientificos");
		listaClientes = controller.darAsignados();
		if(listaClientes != null) {
			mostrarListaClientes();
		}
		
	}
	
	public void mostrarListaClientes() {
		int xId = 10;
		int xNombre = 80;
		int xMostrar = 200;
		int xEditar = xMostrar+60;
		int xBorrar = xEditar+60;
		int y = 5;
		for (int i = 0; i < listaClientes.size(); i++) {
			y += 30;
			AsignadoA asignadoA = listaClientes.get(i);
			JLabel lblDniTitulo = new JLabel(asignadoA.getIdCientifico());
			lblDniTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDniTitulo.setBounds(xId, y, 60, 20);
			panel.add(lblDniTitulo);
			
			JLabel lblNomApelsTitulo = new JLabel(asignadoA.getIdProyecto());
			lblNomApelsTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNomApelsTitulo.setBounds(xNombre, y, 80, 20);
			panel.add(lblNomApelsTitulo);
			
			JButton btnMostrar = new JButton("M");
			btnMostrar.setBackground(new Color(51, 204, 0));
			btnMostrar.setBounds(xMostrar, y, 50, 20);
			panel.add(btnMostrar);
			btnMostrar.addActionListener(a->controller.crearMostrarAsignado(asignadoA));
			btnMostrar.setToolTipText("Mostrar");
			
			JButton btnEditar = new JButton("E");
			btnEditar.setBackground(new Color(255, 204, 0));
			btnEditar.setBounds(xEditar, y, 50, 20);
			panel.add(btnEditar);
			btnEditar.addActionListener(a->controller.crearEditAsignado(asignadoA));
			btnEditar.setToolTipText("Editar");
			
			JButton btnEliminar = new JButton("B");
			btnEliminar.setBackground(new Color(255, 0, 0));
			btnEliminar.setBounds(xBorrar, y, 50, 20);
			panel.add(btnEliminar);
			btnEliminar.addActionListener(a->controller.eliminarAsignado(asignadoA.getIdCientifico(),asignadoA.getIdProyecto()));	
			btnEliminar.setToolTipText("Borrar");
		}
	}
}
