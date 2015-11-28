package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaCobro extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner;

	public VentanaCobro(final String total) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 315, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 1;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		JLabel lblNewLabel = new JLabel(total);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAPagarCon = new JLabel("A pagar con:");
		lblAPagarCon.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblAPagarCon = new GridBagConstraints();
		gbc_lblAPagarCon.anchor = GridBagConstraints.WEST;
		gbc_lblAPagarCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblAPagarCon.gridx = 1;
		gbc_lblAPagarCon.gridy = 2;
		contentPane.add(lblAPagarCon, gbc_lblAPagarCon);
		
		spinner = new JSpinner();

	
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 2;
		contentPane.add(spinner, gbc_spinner);
		
		JLabel lblCambio = new JLabel("Cambio:");
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblCambio = new GridBagConstraints();
		gbc_lblCambio.anchor = GridBagConstraints.WEST;
		gbc_lblCambio.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambio.gridx = 1;
		gbc_lblCambio.gridy = 4;
		contentPane.add(lblCambio, gbc_lblCambio);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnFinalizar = new JButton("Finalizar.");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.gridx = 2;
		gbc_btnFinalizar.gridy = 5;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);
		spinner.setModel(new SpinnerNumberModel(new Integer(Integer.parseInt(total)), Integer.parseInt(total), null, new Integer(10)));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String totalDeCuenta;
				int dineroAPagar = (int)spinner.getValue();
				totalDeCuenta= String.valueOf(dineroAPagar- Integer.parseInt(total));
				lblNewLabel_1.setText(totalDeCuenta);
			}
		});
	}

}
