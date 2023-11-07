package UD22_Cliente_Video.UD22_Cliente_Video.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UD22_Cliente_Video.UD22_Cliente_Video.interfaces.IControllerCliente;
import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;


public class ClienteTablaVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControllerCliente controller;
	private ArrayList<Cliente> listaClientes;
	public JPanel panel;
	public JButton btnAñadirCliente;
	public ClienteTablaVista(IControllerCliente controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 787, 412);
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
		
		JLabel lblIdTitulo = new JLabel("Id");
		lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdTitulo.setBounds(10, 5, 60, 20);
		panel.add(lblIdTitulo);
		
		JLabel lblFechaTitulo = new JLabel("Fecha");
		lblFechaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaTitulo.setBounds(430, 5, 80, 20);
		panel.add(lblFechaTitulo);
		
		JLabel lblDniTitulo = new JLabel("DNI");
		lblDniTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniTitulo.setBounds(350, 5, 70, 20);
		panel.add(lblDniTitulo);
		
		JLabel lblDireccionTitulo = new JLabel("Dirección");
		lblDireccionTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccionTitulo.setBounds(260, 5, 80, 20);
		panel.add(lblDireccionTitulo);
		
		JLabel lblApellidoTitulo = new JLabel("Apellido");
		lblApellidoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoTitulo.setBounds(170, 5, 80, 20);
		panel.add(lblApellidoTitulo);
		
		JLabel lblNombreTitulos = new JLabel("Nombre");
		lblNombreTitulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTitulos.setBounds(80, 5, 80, 20);
		panel.add(lblNombreTitulos);
		
		btnAñadirCliente = new JButton("Añadir Cliente");
		btnAñadirCliente.setForeground(SystemColor.desktop);
		btnAñadirCliente.setBackground(SystemColor.textHighlightText);
		btnAñadirCliente.setBounds(551, 10, 125, 21);
		contentPane.add(btnAñadirCliente);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(244, 10, 150, 20);
		contentPane.add(lblNewLabel);
		
		controller.conectarDb("Videoclub");
		listaClientes = controller.darClientes();
		if(listaClientes != null) {
			mostrarListaClientes();
		}
		
	}
	
	public void mostrarListaClientes() {
		int xId = 10;
		int xNombre = 80;
		int xApellidos = 170;
		int xDireccion = 260;
		int xDni = 350;
		int xFecha = 430;
		int xMostrar = 520;
		int xEditar = 580;
		int xBorrar = 640;
		int y = 5;
		for (int i = 0; i < listaClientes.size(); i++) {
			y += 30;
			Cliente cliente = listaClientes.get(i);
			JLabel lblIdTitulo = new JLabel(cliente.getId());
			lblIdTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdTitulo.setBounds(xId, y, 60, 20);
			panel.add(lblIdTitulo);
			
			JLabel lblFechaTitulo = new JLabel(cliente.getFecha());
			lblFechaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaTitulo.setBounds(xFecha, y, 80, 20);
			panel.add(lblFechaTitulo);
			
			JLabel lblDniTitulo = new JLabel(cliente.getDni());
			lblDniTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDniTitulo.setBounds(xDni, y, 70, 20);
			panel.add(lblDniTitulo);
			
			JLabel lblDireccionTitulo = new JLabel(cliente.getDireccion());
			lblDireccionTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccionTitulo.setBounds(xDireccion, y, 80, 20);
			panel.add(lblDireccionTitulo);
			
			JLabel lblApellidoTitulo = new JLabel(cliente.getApellido());
			lblApellidoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidoTitulo.setBounds(xApellidos, y, 80, 20);
			panel.add(lblApellidoTitulo);
			
			JLabel lblNombreTitulos = new JLabel(cliente.getNombre());
			lblNombreTitulos.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreTitulos.setBounds(xNombre, y, 80, 20);
			panel.add(lblNombreTitulos);
			
			JButton btnMostrar = new JButton("M");
			btnMostrar.setBackground(new Color(51, 204, 0));
			btnMostrar.setBounds(xMostrar, y, 50, 20);
			panel.add(btnMostrar);
			btnMostrar.addActionListener(a->controller.crearMostrarCliente(cliente));
			btnMostrar.setToolTipText("Mostrar");
			
			JButton btnEditar = new JButton("E");
			btnEditar.setBackground(new Color(255, 204, 0));
			btnEditar.setBounds(xEditar, y, 50, 20);
			panel.add(btnEditar);
			btnEditar.addActionListener(a->controller.crearEditCliente(cliente));
			btnEditar.setToolTipText("Editar");
			
			JButton btnEliminar = new JButton("B");
			btnEliminar.setBackground(new Color(255, 0, 0));
			btnEliminar.setBounds(xBorrar, y, 50, 20);
			panel.add(btnEliminar);
			btnEliminar.addActionListener(a->controller.eliminarCliente(cliente.getId()));	
			btnEliminar.setToolTipText("Borrar");
			
			JButton btnVideos = new JButton("V");
			btnVideos.setBackground(new Color(250,0, 250));
			btnVideos.setBounds(xBorrar+60, y, 50, 20);
			btnVideos.setToolTipText("Videos");
			panel.add(btnVideos);
			btnVideos.addActionListener(a->controller.crearMostrarVideos(cliente));
		}
	}
}
