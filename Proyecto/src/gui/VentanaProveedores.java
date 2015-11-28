package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Proveedor;
import controlador.Controlador;
import javax.swing.JTabbedPane;

public class VentanaProveedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;
	private JTextField nombreText;
	private JTextField domiciolioText;
	private JTextField telefonoText;
	private JTextField correoText;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public VentanaProveedores(final Controlador controlador) {
		setTitle("Proveedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
//		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel.add(lblNombre, gbc_lblNombre);
		
		nombreText = new JTextField();
		GridBagConstraints gbc_nombreText = new GridBagConstraints();
		gbc_nombreText.insets = new Insets(0, 0, 5, 0);
		gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreText.gridx = 1;
		gbc_nombreText.gridy = 0;
		panel.add(nombreText, gbc_nombreText);
		nombreText.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombreText.getText().isEmpty()){
					
				}
				else{
					controlador.agregarProveedor(nombreText.getText(),domiciolioText.getText(),telefonoText.getText(), correoText.getText());
					ArrayList<Proveedor>proveedores =  controlador.proveedores();
					Object[][] proveedoresParaTabla= new Object[proveedores.size()][];
					int i =0;
					for (Proveedor p : proveedores){
						proveedoresParaTabla[i]= new Object[4];
						proveedoresParaTabla[i][0]= p.nombre;
						proveedoresParaTabla[i][1] = p.domicilio;
						proveedoresParaTabla[i][2] = p.telefono;
						proveedoresParaTabla[i][3] = p.correo;
						i++;
					}
					table = new JTable();
					table.setModel(new DefaultTableModel(
						proveedoresParaTabla,
						new String[] {
								"Nombre", "Domicilio", "Telefono", "Correo"
						}
					));
					table.repaint();
					JOptionPane.showMessageDialog(null, "Proveedor agregado");
					
				}
				
			}
		});
		
		JLabel lblDomicilio = new JLabel("Domicilio: ");
		GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 0;
		gbc_lblDomicilio.gridy = 1;
		panel.add(lblDomicilio, gbc_lblDomicilio);
		
		domiciolioText = new JTextField();
		GridBagConstraints gbc_domiciolioText = new GridBagConstraints();
		gbc_domiciolioText.insets = new Insets(0, 0, 5, 0);
		gbc_domiciolioText.fill = GridBagConstraints.HORIZONTAL;
		gbc_domiciolioText.gridx = 1;
		gbc_domiciolioText.gridy = 1;
		panel.add(domiciolioText, gbc_domiciolioText);
		domiciolioText.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 2;
		panel.add(lblTelefono, gbc_lblTelefono);
		
		telefonoText = new JTextField();
		GridBagConstraints gbc_telefonoText = new GridBagConstraints();
		gbc_telefonoText.insets = new Insets(0, 0, 5, 0);
		gbc_telefonoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonoText.gridx = 1;
		gbc_telefonoText.gridy = 2;
		panel.add(telefonoText, gbc_telefonoText);
		telefonoText.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 3;
		panel.add(lblCorreo, gbc_lblCorreo);
		
		correoText = new JTextField();
		GridBagConstraints gbc_correoText = new GridBagConstraints();
		gbc_correoText.insets = new Insets(0, 0, 5, 0);
		gbc_correoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_correoText.gridx = 1;
		gbc_correoText.gridy = 3;
		panel.add(correoText, gbc_correoText);
		correoText.setColumns(10);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 4;
		panel.add(btnOk, gbc_btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		ArrayList<Proveedor>proveedores =  controlador.proveedores();
		Object[][] proveedoresParaTabla= new Object[proveedores.size()][];
		int i =0;
		for (Proveedor p : proveedores){
			proveedoresParaTabla[i]= new Object[4];
			proveedoresParaTabla[i][0]= p.nombre;
			proveedoresParaTabla[i][1] = p.domicilio;
			proveedoresParaTabla[i][2] = p.telefono;
			proveedoresParaTabla[i][3] = p.correo;
			i++;
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(
			proveedoresParaTabla,
			new String[] {
					"Nombre", "Domicilio", "Telefono", "Correo"
			}
		));
		panel_1.add(new JScrollPane(table) , BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		buscarText = new JTextField();
		GridBagConstraints gbc_buscarText = new GridBagConstraints();
		gbc_buscarText.insets = new Insets(0, 0, 0, 5);
		gbc_buscarText.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarText.gridx = 0;
		gbc_buscarText.gridy = 0;
		panel_2.add(buscarText, gbc_buscarText);
		buscarText.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Proveedor> proveedoresUno= controlador.proveedores();
				ArrayList<Proveedor> proveedoresDos= new ArrayList<Proveedor>();
				for (Proveedor p : proveedoresUno){
					if(p.id_proveedor==Integer.parseInt(buscarText.getText())){
						proveedoresDos.add(p);
					}
				}
				Object[][]proveedoresParaTablaBuscar=new Object[proveedoresDos.size()][];
				int i=0;
				for (Proveedor p : proveedoresDos){
					proveedoresParaTablaBuscar[i]= new Object[4];
					proveedoresParaTablaBuscar[i][0]= p.nombre;
					proveedoresParaTablaBuscar[i][1] = p.domicilio;
					proveedoresParaTablaBuscar[i][2] = p.telefono;
					proveedoresParaTablaBuscar[i][3] = p.correo;
					
					i++;
				}
				table.setModel(new DefaultTableModel(proveedoresParaTablaBuscar,new String[] {
				"Nombre", "Domicilio", "Telefono", "Correo"
			}));
				table.repaint();
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		panel_2.add(btnBuscar, gbc_btnBuscar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add("Agregar",panel);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Eliminar", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNombre_1 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
		gbc_lblNombre_1.anchor = GridBagConstraints.EAST;
		gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre_1.gridx = 0;
		gbc_lblNombre_1.gridy = 0;
		panel_3.add(lblNombre_1, gbc_lblNombre_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		panel_3.add(button, gbc_button);
	}

}
