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
import javax.swing.JSpinner;

public class VentanaProveedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;
	private JTextField nombreText;
	private JTextField textField_2;

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
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
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
		
		JLabel lblIdProveedor = new JLabel("Id proveedor: ");
		GridBagConstraints gbc_lblIdProveedor = new GridBagConstraints();
		gbc_lblIdProveedor.anchor = GridBagConstraints.WEST;
		gbc_lblIdProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdProveedor.gridx = 0;
		gbc_lblIdProveedor.gridy = 1;
		panel.add(lblIdProveedor, gbc_lblIdProveedor);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombreText.getText().isEmpty()){
					
				}
				else{
					controlador.agregarProveedor(nombreText.getText());
					ArrayList<Proveedor>proveedores =  controlador.proveedores();
					Object[][] proveedoresParaTabla= new Object[proveedores.size()][];
					int i =0;
					for (Proveedor p : proveedores){
						proveedoresParaTabla[i]= new Object[2];
						proveedoresParaTabla[i][0]= p.id_proveedor;
						proveedoresParaTabla[i][1] = p.nombre;
						i++;
					}
					table = new JTable();
					table.setModel(new DefaultTableModel(
						proveedoresParaTabla,
						new String[] {
							"id", "Nombre"
						}
					));
					table.repaint();
					JOptionPane.showMessageDialog(null, "Proveedor agregado");
					
				}
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 2;
		panel.add(btnOk, gbc_btnOk);
		
		JLabel lblIdProvedorA = new JLabel("Id provedor a eliminar:");
		GridBagConstraints gbc_lblIdProvedorA = new GridBagConstraints();
		gbc_lblIdProvedorA.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdProvedorA.gridx = 0;
		gbc_lblIdProvedorA.gridy = 4;
		panel.add(lblIdProvedorA, gbc_lblIdProvedorA);
		
		JSpinner eliminarSpinner = new JSpinner();
		GridBagConstraints gbc_eliminarSpinner = new GridBagConstraints();
		gbc_eliminarSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_eliminarSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_eliminarSpinner.gridx = 1;
		gbc_eliminarSpinner.gridy = 4;
		panel.add(eliminarSpinner, gbc_eliminarSpinner);
		
		JButton btnOk_1 = new JButton("Ok");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Proveedor> productosUno = controlador.proveedores();
				ArrayList<Proveedor> productosDos = new ArrayList<Proveedor>();
				
				for ( Proveedor p: productosUno){
					if (p.id_proveedor ==Integer.parseInt(buscarText.getText())){
						productosDos.add(p);
					}
				}
				Object[][] productosParaTablaBuscar = new Object[productosDos.size()][];
				int i=0;
				for (Proveedor p: productosDos){
					productosParaTablaBuscar[i]= new Object[2];
					productosParaTablaBuscar[i][0]= p.id_proveedor;
					productosParaTablaBuscar[i][1] = p.nombre;
					i++;
				}
				table.setModel(new DefaultTableModel(productosParaTablaBuscar,			new String[] {
				"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
			}));
				table.repaint();
			}
		});
		GridBagConstraints gbc_btnOk_1 = new GridBagConstraints();
		gbc_btnOk_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk_1.gridx = 1;
		gbc_btnOk_1.gridy = 5;
		panel.add(btnOk_1, gbc_btnOk_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		ArrayList<Proveedor>proveedores =  controlador.proveedores();
		Object[][] proveedoresParaTabla= new Object[proveedores.size()][];
		int i =0;
		for (Proveedor p : proveedores){
			proveedoresParaTabla[i]= new Object[2];
			proveedoresParaTabla[i][0]= p.id_proveedor;
			proveedoresParaTabla[i][1] = p.nombre;
			i++;
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(
			proveedoresParaTabla,
			new String[] {
				"id", "Nombre"
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
					proveedoresParaTablaBuscar[i]= new Object[2];
					proveedoresParaTablaBuscar[i][0]= p.id_proveedor;
					proveedoresParaTablaBuscar[i][1] = p.nombre;
					i++;
				}
				table.setModel(new DefaultTableModel(proveedoresParaTablaBuscar,new String[] {
				"id", "Nombre"
			}));
				table.repaint();
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		panel_2.add(btnBuscar, gbc_btnBuscar);
	}

}