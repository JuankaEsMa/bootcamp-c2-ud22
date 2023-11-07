package UD22_Cientificos.UD22_Cientificos.vistas;

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
	public JButton btnCientificos;
	public JButton btnProyecto;
	public JButton btnAsignadoA;
	public TablasVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige una Tabla");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 20, 360, 30);
		contentPane.add(lblNewLabel);
		
		btnCientificos = new JButton("Cientificos");
		btnCientificos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCientificos.setBounds(50, 100, 100, 30);
		contentPane.add(btnCientificos);
		
		btnProyecto = new JButton("Proyecto");
		btnProyecto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProyecto.setBounds(200, 100, 100, 30);
		contentPane.add(btnProyecto);
		
		btnAsignadoA = new JButton("Asignado A");
		btnAsignadoA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAsignadoA.setBounds(350, 100, 100, 30);
		contentPane.add(btnAsignadoA);
		
	}
}
