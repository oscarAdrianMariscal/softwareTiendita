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

import modelo.Producto;
import controlador.Controlador;

public class VentanaProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;
	private JTextField nombreText;
	private JTextField descripcionText;
	private JSpinner precioSpinner;
	private JSpinner eliminarSpinner;

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
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n: ");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		panel.add(lblDescripcin, gbc_lblDescripcin);
		
		descripcionText = new JTextField();
		GridBagConstraints gbc_descripcionText = new GridBagConstraints();
		gbc_descripcionText.insets = new Insets(0, 0, 5, 0);
		gbc_descripcionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionText.gridx = 1;
		gbc_descripcionText.gridy = 1;
		panel.add(descripcionText, gbc_descripcionText);
		descripcionText.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		precioSpinner = new JSpinner();
		precioSpinner.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_precioSpinner = new GridBagConstraints();
		gbc_precioSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_precioSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_precioSpinner.gridx = 1;
		gbc_precioSpinner.gridy = 2;
		panel.add(precioSpinner, gbc_precioSpinner);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (nombreText.getText().isEmpty() || descripcionText.getText().isEmpty()){
				
			}
			else{
				int precio = (int)precioSpinner.getValue();
				
				controlador.agregarProducto(precio,1,nombreText.getText(),descripcionText.getText());
				ArrayList<Producto> productos = controlador.productos(); 
				Object[][] productosParaTabla= new Object[productos.size()][];
				int i =0;		
				for (Producto p: productos){
					productosParaTabla[i]= new Object[5];
					productosParaTabla[i][0] =p.id_producto;
					productosParaTabla[i][1] =p.precio;
					productosParaTabla[i][2] =p.id_proveedor;
					productosParaTabla[i][3] =p.nombre;
					productosParaTabla[i][4] =p.descripcion;
					i++;
				}
				
				table.setModel(new DefaultTableModel(
					productosParaTabla,
					new String[] {
						"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
					}
				));
				table.repaint();
				
				
				JOptionPane.showMessageDialog(null, "Producto agregado");
				
			}
			
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 3;
		panel.add(btnOk, gbc_btnOk);
		
		JLabel lblRegistroAEliminar = new JLabel("Registro a eliminar:");
		GridBagConstraints gbc_lblRegistroAEliminar = new GridBagConstraints();
		gbc_lblRegistroAEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistroAEliminar.gridx = 0;
		gbc_lblRegistroAEliminar.gridy = 5;
		panel.add(lblRegistroAEliminar, gbc_lblRegistroAEliminar);
		
		eliminarSpinner = new JSpinner();
		GridBagConstraints gbc_eliminarSpinner = new GridBagConstraints();
		gbc_eliminarSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_eliminarSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_eliminarSpinner.gridx = 1;
		gbc_eliminarSpinner.gridy = 5;
		panel.add(eliminarSpinner, gbc_eliminarSpinner);
		
		JButton btnOk_1 = new JButton("Ok");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.eliminarProducto((int)eliminarSpinner.getValue());
				table.repaint();
			}
		});
		GridBagConstraints gbc_btnOk_1 = new GridBagConstraints();
		gbc_btnOk_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk_1.gridx = 1;
		gbc_btnOk_1.gridy = 6;
		panel.add(btnOk_1, gbc_btnOk_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1 , BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		ArrayList<Producto> productos = controlador.productos(); 
		Object[][] productosParaTabla= new Object[productos.size()][];
		int i =0;		
		for (Producto p: productos){
			productosParaTabla[i]= new Object[5];
			productosParaTabla[i][0] =p.id_producto;
			productosParaTabla[i][1] =p.precio;
			productosParaTabla[i][2] =p.id_proveedor;
			productosParaTabla[i][3] =p.nombre;
			productosParaTabla[i][4] =p.descripcion;
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			productosParaTabla,
			new String[] {
				"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
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
				
				for ( Producto p: productosUno){
					if (p.id_producto ==Integer.parseInt(buscarText.getText())){
						productosDos.add(p);
					}
				}
				Object[][] productosParaTablaBuscar = new Object[productosDos.size()][];
				int i=0;
				for (Producto p: productosDos){
					productosParaTablaBuscar[i]= new Object[5];
					productosParaTablaBuscar[i][0] =p.id_producto;
					productosParaTablaBuscar[i][1] =p.precio;
					productosParaTablaBuscar[i][2] =p.id_proveedor;
					productosParaTablaBuscar[i][3] =p.nombre;
					productosParaTablaBuscar[i][4] =p.descripcion;
					i++;
				}
				table.setModel(new DefaultTableModel(productosParaTablaBuscar,			new String[] {
				"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
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
