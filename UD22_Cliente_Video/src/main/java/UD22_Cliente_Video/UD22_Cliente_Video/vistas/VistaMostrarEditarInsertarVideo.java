package UD22_Cliente_Video.UD22_Cliente_Video.vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UD22_Cliente_Video.UD22_Cliente_Video.models.Video;

public class VistaMostrarEditarInsertarVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldTitle;
	private JTextField textFieldDirector;
	private JTextField textFieldClienteId;
	public JButton btnConfirmar;
	private Video video;

	public VistaMostrarEditarInsertarVideo(Video video, String opcion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.video = video;
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(53, 63, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(130, 60, 296, 19);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Director");
		lblNewLabel_2.setBounds(53, 90, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setBounds(130, 89, 296, 19);
		contentPane.add(textFieldDirector);
		textFieldDirector.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cliente Id");
		lblNewLabel_3.setBounds(53, 122, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textFieldClienteId = new JTextField();
		textFieldClienteId.setBounds(130, 118, 296, 19);
		contentPane.add(textFieldClienteId);
		textFieldClienteId.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(175, 205, 150, 21);
		contentPane.add(btnConfirmar);

		if(video != null) {
			textFieldId.setText(video.getId());
			textFieldTitle.setText(video.getTitle());
			textFieldDirector.setText(video.getDirector());
			textFieldClienteId.setText(video.getCliId());
			if(opcion != "Editar"){
				textFieldId.setEnabled(false);
				textFieldTitle.setEnabled(false);
				textFieldDirector.setEnabled(false);
				textFieldClienteId.setEnabled(false);
			}
		}
	}

	public Video getVideo() {
		return video;
	}
	public String getId() {
		return textFieldId.getText();
	}
	public String getTitle() {
		return textFieldTitle.getText();
	}
	public String getDirector() {
		return textFieldDirector.getText();
	}
	public String getClienteId() {
		return textFieldClienteId.getText();
	}
}
