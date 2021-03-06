package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Categoria;
import modelo.Producto;
import modelo.Proveedor;
import controlador.Controlador;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.Box;

public class VentanaProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;
	private JTextField nombreText;
	private JSpinner precioSpinner;
	private JSpinner spinnerCantidad;
	private JTextField textCodigo;
	final public JComboBox comboBox;
	final public JComboBox comboCategoria;
	private JTextField textCodigoEliminar;

	/**
	 * Create the frame.
	 */
	public VentanaProducto(final Controlador controlador) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 591, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
//		contentPane.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.WEST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		panel.add(lblCodigo, gbc_lblCodigo);
		
		textCodigo = new JTextField();
		GridBagConstraints gbc_textCodigo = new GridBagConstraints();
		gbc_textCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_textCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCodigo.gridx = 1;
		gbc_textCodigo.gridy = 0;
		panel.add(textCodigo, gbc_textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		nombreText = new JTextField();
		GridBagConstraints gbc_nombreText = new GridBagConstraints();
		gbc_nombreText.insets = new Insets(0, 0, 5, 0);
		gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreText.gridx = 1;
		gbc_nombreText.gridy = 1;
		panel.add(nombreText, gbc_nombreText);
		nombreText.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		precioSpinner = new JSpinner();
		precioSpinner.setModel(new SpinnerNumberModel(new Float(3), new Float(1), null, new Float(1)));
		GridBagConstraints gbc_precioSpinner = new GridBagConstraints();
		gbc_precioSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_precioSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_precioSpinner.gridx = 1;
		gbc_precioSpinner.gridy = 2;
		panel.add(precioSpinner, gbc_precioSpinner);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.anchor = GridBagConstraints.WEST;
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 0;
		gbc_lblProveedor.gridy = 3;
		panel.add(lblProveedor, gbc_lblProveedor);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.WEST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 4;
		panel.add(lblCategoria, gbc_lblCategoria);
		
		
		ArrayList<Proveedor>provedores = controlador.proveedores();
		for (Proveedor proveedor : provedores) {
			comboBox.addItem(proveedor.nombre);
		}
		JButton btnAgregar = new JButton("Ok");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (nombreText.getText().isEmpty()){
				
			}
			else{
				float precio = (float)precioSpinner.getValue();
				 
				String categoria =comboCategoria.getItemAt(comboCategoria.getSelectedIndex()).toString();
				String proveedor =comboBox.getSelectedItem().toString();
				int cantidad = (int)spinnerCantidad.getValue();
				
				controlador.agregarProducto(Integer.parseInt(textCodigo.getText()), nombreText.getText(), precio,proveedor ,categoria , cantidad);
				ArrayList<Producto> productos = controlador.productos(); 
				Object[][] productosParaTabla= new Object[productos.size()][];
				int i =0;		
				for (Producto p: productos){
					productosParaTabla[i]= new Object[6];
					productosParaTabla[i][0] =p.id_producto;
					productosParaTabla[i][1] =p.nombre;
					productosParaTabla[i][2] =p.precio;
					productosParaTabla[i][3] =p.proveedor;
					productosParaTabla[i][4] =p.categoria;
					productosParaTabla[i][5] =p.cantidad;
					i++;
				}
				
				table.setModel(new DefaultTableModel(
					productosParaTabla,
					new String[] {
							"C�digo", "Nombre", "precio", "proveedor", "Categoria","Cantidad"
					}
				));
				table.repaint();
				
				
				//JOptionPane.showMessageDialog(null, "Producto agregado");
				
			}
			
			}
		});
		comboCategoria = new JComboBox();
		ArrayList<Categoria> categorias = controlador.categoria();
		for (Categoria c: categorias){
			comboCategoria.addItem(c.categoria);
		}
		GridBagConstraints gbc_comboCategoria = new GridBagConstraints();
		gbc_comboCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_comboCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCategoria.gridx = 1;
		gbc_comboCategoria.gridy = 4;
		panel.add(comboCategoria, gbc_comboCategoria);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.WEST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 5;
		panel.add(lblCantidad, gbc_lblCantidad);
		
		spinnerCantidad = new JSpinner();
		GridBagConstraints gbc_spinnerCantidad = new GridBagConstraints();
		gbc_spinnerCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerCantidad.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerCantidad.gridx = 1;
		gbc_spinnerCantidad.gridy = 5;
		panel.add(spinnerCantidad, gbc_spinnerCantidad);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 6;
		panel.add(btnAgregar, gbc_btnAgregar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1 , BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		ArrayList<Producto> productos = controlador.productos(); 
		Object[][] productosParaTabla= new Object[productos.size()][];
		int i =0;		
		for (Producto p: productos){
			productosParaTabla[i]= new Object[6];
			productosParaTabla[i][0] =p.id_producto;
			productosParaTabla[i][1] =p.nombre;
			productosParaTabla[i][2] =p.precio;
			productosParaTabla[i][3] =p.proveedor;
			productosParaTabla[i][4] =p.categoria;
			productosParaTabla[i][5] =p.cantidad;
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			productosParaTabla,
			new String[] {
				"C�digo", "Nombre", "precio", "proveedor", "Categoria","Cantidad"
			}
		));
		panel_1.add(new JScrollPane(table)	, BorderLayout.CENTER);
		
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
				ArrayList<Producto> productosUno = controlador.productos();
				ArrayList<Producto> productosDos = new ArrayList<Producto>();
//				
				for ( Producto p: productosUno){
					if (p.id_producto ==Integer.parseInt(buscarText.getText())){
						productosDos.add(p);
					}
				}
				Object[][] productosParaTablaBuscar = new Object[productosDos.size()][];
				int i=0;
				for (Producto p: productosDos){
					productosParaTablaBuscar[i]= new Object[6];
					productosParaTablaBuscar[i][0] =p.id_producto;
					productosParaTablaBuscar[i][1] =p.nombre;
					productosParaTablaBuscar[i][2] =p.precio;
					productosParaTablaBuscar[i][3] =p.proveedor;
					productosParaTablaBuscar[i][4] =p.categoria;
					productosParaTablaBuscar[i][5] =p.cantidad;
					
					i++;
				}
				table.setModel(new DefaultTableModel(productosParaTablaBuscar,			new String[] {
						"C�digo", "Nombre", "precio", "proveedor", "Categoria","Cantidad"
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
		tabbedPane.addTab("Eliminar", null, panel_3, null);
		panel_3.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Component verticalStrut = Box.createVerticalStrut(30);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 0;
		panel_3.add(verticalStrut, gbc_verticalStrut);
		
		JLabel label = new JLabel("Codigo:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel_3.add(label, gbc_label);
		
		textCodigoEliminar = new JTextField();
		textCodigoEliminar.setColumns(10);
		GridBagConstraints gbc_textCodigoEliminar = new GridBagConstraints();
		gbc_textCodigoEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCodigoEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_textCodigoEliminar.gridx = 1;
		gbc_textCodigoEliminar.gridy = 1;
		panel_3.add(textCodigoEliminar, gbc_textCodigoEliminar);
		
		JButton button = new JButton("Ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.eliminarProducto(Integer.parseInt(textCodigoEliminar.getText()));
				ArrayList<Producto> productosUno = controlador.productos();
//				
				Object[][] productosParaTablaBuscar = new Object[productosUno.size()][];
				int i=0;
				for (Producto p: productosUno){
					productosParaTablaBuscar[i]= new Object[6];
					productosParaTablaBuscar[i][0] =p.id_producto;
					productosParaTablaBuscar[i][1] =p.nombre;
					productosParaTablaBuscar[i][2] =p.precio;
					productosParaTablaBuscar[i][3] =p.proveedor;
					productosParaTablaBuscar[i][4] =p.categoria;
					productosParaTablaBuscar[i][5] =p.cantidad;
					
					i++;
				}
				table.setModel(new DefaultTableModel(productosParaTablaBuscar,			new String[] {
						"C�digo", "Nombre", "precio", "proveedor", "Categoria","Cantidad"
			}));
				table.repaint();
				
					    
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		panel_3.add(button, gbc_button);
	}
	
	

}
