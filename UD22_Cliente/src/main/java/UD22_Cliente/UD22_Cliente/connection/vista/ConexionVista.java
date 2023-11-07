package UD22_Cliente.UD22_Cliente.connection.vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UD22_Cliente.UD22_Cliente.connection.interfaces.IConectarDatabase;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class ConexionVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	public ConexionVista(IConectarDatabase conectarDatabase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 10, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea txtArea = new JTextArea();
		txtArea.setRows(3);
		txtArea.setText("Para conectarte con los valores predeterminados \r\n(puerto: 3060, Username: root, Password: root) \r\ndejar en blanco los valores que te interesen.");
		panel.add(txtArea);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblPuerto = new JLabel("Puerto:       ");
		panel_2.add(lblPuerto);
		
		textFieldPort = new JTextField();
		panel_2.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblUsername = new JLabel("Username: ");
		panel_3.add(lblUsername);
		
		textFieldUsername = new JTextField();
		panel_3.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblPassword = new JLabel("Password: ");
		panel_4.add(lblPassword);
		
		textFieldPassword = new JTextField();
		panel_4.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton btnConectar = new JButton("Connectar");
		panel_6.add(btnConectar);
		btnConectar.addActionListener(a->conectarDatabase.onConnectPress(textFieldPort.getText(),
				textFieldUsername.getText(),textFieldPassword.getText()));
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_6.add(btnCancelar);
		btnConectar.addActionListener(a->conectarDatabase.onCancelPress());
	}
	
	public void errorConnection() {
		textFieldPort.setText("");
		textFieldUsername.setText("");
		textFieldPassword.setText("");
		JOptionPane.showMessageDialog(null, "Conexión no válida, porfavor cambie los datos e intente de nuevo");
	}

}
