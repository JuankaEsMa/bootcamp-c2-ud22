package UD22_Cientificos.UD22_Cientificos.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UD22_Cientificos.UD22_Cientificos.models.Cientifico;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaMostrarEditarInsertarCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNomApels;
	public JButton btnConfirmar;

	public VistaMostrarEditarInsertarCientifico(Cientifico cientifico, String opcion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni");
		lblNewLabel.setBounds(53, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		textFieldDni = new JTextField();
		textFieldDni.setToolTipText("Dejar vacio para autmático");
		textFieldDni.setBounds(130, 31, 296, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NomApels");
		lblNewLabel_1.setBounds(53, 63, 67, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldNomApels = new JTextField();
		textFieldNomApels.setBounds(130, 60, 296, 19);
		contentPane.add(textFieldNomApels);
		textFieldNomApels.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(165, 89, 150, 21);
		contentPane.add(btnConfirmar);
		
		if(cientifico != null) {
			textFieldDni.setText(cientifico.getDni());
			textFieldNomApels.setText(cientifico.getNomApels());
			if(opcion != "Editar"){
				textFieldDni.setEnabled(false);
				textFieldNomApels.setEnabled(false);
			}
		}
		
	}
	public Cientifico getCientifico() {
		return new Cientifico(getDni(),getNomApels());
	}
	public String getDni() {
		return textFieldDni.getText();
	}
	public String getNomApels() {
		return textFieldNomApels.getText();
	}
}
