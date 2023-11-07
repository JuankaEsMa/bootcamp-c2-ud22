package UD22_Cliente_Video.UD22_Cliente_Video.vistas;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UD22_Cliente_Video.UD22_Cliente_Video.models.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaMostrarEditarInsertarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldDni;
	private JTextField textFieldFecha;
	public JButton btnConfirmar;

	public VistaMostrarEditarInsertarCliente(Cliente cliente, String opcion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(53, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setToolTipText("Dejar vacio para autmático");
		textFieldId.setBounds(130, 31, 296, 19);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(53, 63, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(130, 60, 296, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(53, 90, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(130, 89, 296, 19);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección");
		lblNewLabel_3.setBounds(53, 122, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(130, 118, 296, 19);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		lblNewLabel_4.setBounds(53, 150, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textFieldDni = new JTextField();
		textFieldDni.setToolTipText("39976231");
		textFieldDni.setBounds(130, 147, 296, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(53, 179, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setToolTipText("yyyy-mm-dd");
		textFieldFecha.setBounds(130, 176, 296, 19);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(175, 205, 150, 21);
		contentPane.add(btnConfirmar);
		
		if(cliente != null) {
			textFieldId.setText(cliente.getId());
			textFieldNombre.setText(cliente.getNombre());
			textFieldApellido.setText(cliente.getApellido());
			textFieldDireccion.setText(cliente.getDireccion());
			textFieldDni.setText(cliente.getDni());
			textFieldFecha.setText(cliente.getFecha());
			if(opcion != "Editar"){
				textFieldId.setEnabled(false);
				textFieldNombre.setEnabled(false);
				textFieldApellido.setEnabled(false);
				textFieldDireccion.setEnabled(false);
				textFieldDni.setEnabled(false);
				textFieldFecha.setEnabled(false);
			}
		}
		
	}
	public Cliente getCliente() {
		return new Cliente(getId(),getNombre(),getApellido(),getDireccion(),getDni(),getFecha());
	}
	public String getId() {
		return textFieldId.getText();
	}
	public String getNombre() {
		return textFieldNombre.getText();
	}
	public String getApellido() {
		return textFieldApellido.getText();
	}
	public String getDireccion() {
		return textFieldDireccion.getText();
	}
	public String getDni() {
		return textFieldDni.getText();
	}
	public String getFecha() {
		return textFieldFecha.getText();
	}
}
