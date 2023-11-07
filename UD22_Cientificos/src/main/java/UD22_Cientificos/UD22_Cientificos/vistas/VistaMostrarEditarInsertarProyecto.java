package UD22_Cientificos.UD22_Cientificos.vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UD22_Cientificos.UD22_Cientificos.models.Proyecto;

public class VistaMostrarEditarInsertarProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldHoras;
	public JButton btnConfirmar;
	private Proyecto proyecto;

	public VistaMostrarEditarInsertarProyecto(Proyecto proyecto, String opcion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.proyecto = proyecto;
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Horas");
		lblNewLabel_2.setBounds(53, 90, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setBounds(130, 89, 296, 19);
		contentPane.add(textFieldHoras);
		textFieldHoras.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(177, 145, 150, 21);
		contentPane.add(btnConfirmar);

		if(proyecto != null) {
			textFieldId.setText(proyecto.getId());
			textFieldNombre.setText(proyecto.getNombre());
			textFieldHoras.setText(proyecto.getHoras());
			if(opcion != "Editar"){
				textFieldId.setEnabled(false);
				textFieldNombre.setEnabled(false);
				textFieldHoras.setEnabled(false);
			}
		}
	}

	public Proyecto getProyecto() {
		return new Proyecto(getId(),getNombre(),getHoras());
	}
	public String getId() {
		return textFieldId.getText();
	}
	public String getNombre() {
		return textFieldNombre.getText();
	}
	public String getHoras() {
		return textFieldHoras.getText();
	}
}
