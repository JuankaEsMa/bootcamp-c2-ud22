package UD22_Cliente_Video.UD22_Cliente_Video.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;

public class TablasVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnClientes;
	public JButton btnVideos;
	public TablasVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige una Tabla");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 20, 360, 30);
		contentPane.add(lblNewLabel);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClientes.setBounds(70, 100, 100, 30);
		contentPane.add(btnClientes);
		
		btnVideos = new JButton("Videos");
		btnVideos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVideos.setBounds(270, 100, 100, 30);
		contentPane.add(btnVideos);
		
	}
}
