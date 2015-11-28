package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class VentanaCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public VentanaCorreo(String correo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Configuraci\u00F3n correo", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCorreoDelEmpleado = new JLabel("Correo del empleado actual:");
		GridBagConstraints gbc_lblCorreoDelEmpleado = new GridBagConstraints();
		gbc_lblCorreoDelEmpleado.anchor = GridBagConstraints.WEST;
		gbc_lblCorreoDelEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoDelEmpleado.gridx = 0;
		gbc_lblCorreoDelEmpleado.gridy = 0;
		panel.add(lblCorreoDelEmpleado, gbc_lblCorreoDelEmpleado);
		
		textField = new JTextField();
		textField.setText(correo);
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 1;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCorreoAMandar = new JLabel("Correo a mandar: ");
		GridBagConstraints gbc_lblCorreoAMandar = new GridBagConstraints();
		gbc_lblCorreoAMandar.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoAMandar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoAMandar.gridx = 0;
		gbc_lblCorreoAMandar.gridy = 2;
		panel.add(lblCorreoAMandar, gbc_lblCorreoAMandar);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 3;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JButton btnOk = new JButton("Ok");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 4;
		panel.add(btnOk, gbc_btnOk);
	}

}
