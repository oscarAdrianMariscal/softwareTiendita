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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Producto;

public class VentanaCaja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField idProductoText;
	ArrayList<Integer> productosIngresados =new ArrayList<Integer>();
	String informacion="";

	/**
	 * Create the frame.
	 */
	public VentanaCaja(final Controlador controlador) {
		setTitle("Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
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
		
		idProductoText = new JTextField();
		GridBagConstraints gbc_idProductoText = new GridBagConstraints();
		gbc_idProductoText.insets = new Insets(0, 0, 0, 5);
		gbc_idProductoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_idProductoText.gridx = 0;
		gbc_idProductoText.gridy = 0;
		panel_2.add(idProductoText, gbc_idProductoText);
		idProductoText.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Producto> productos = controlador.productos();
				ArrayList<Producto> productosDos = new ArrayList<Producto>();
				productosIngresados.add(Integer.parseInt(idProductoText.getText()));
				for (Producto p : productos){
					for (int ingresado: productosIngresados){
						if (p.id_producto==ingresado){
							productosDos.add(p);
						}
					}
				}
				Object[][] productosParaTabla= new Object[productosDos.size()][];
				int i =0;		
				for (Producto p: productosDos){
					productosParaTabla[i]= new Object[5];
					productosParaTabla[i][0] =p.id_producto;
					productosParaTabla[i][1] =p.precio;
					productosParaTabla[i][2] =p.id_proveedor;
					productosParaTabla[i][3] =p.nombre;
					productosParaTabla[i][4] =p.descripcion;
					informacion +=p.nombre + "-";
					i++;
				}
				table.setModel(new DefaultTableModel(productosParaTabla,new String[] {
				"id Producto", "Precio", "id Proveedor", "nombre", "Descripcion"
			}));
				repaint();
				
			}
		});
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.gridx = 1;
		gbc_btnIngresar.gridy = 0;
		panel_2.add(btnIngresar, gbc_btnIngresar);
		
		JButton btnTerminarVenta = new JButton("Terminar Venta");
		btnTerminarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(informacion);
				controlador.ingresarTicket(1, informacion);
				JOptionPane.showMessageDialog(null, "Gracias por su compra!.");
			}
		});
		panel_1.add(btnTerminarVenta, BorderLayout.SOUTH);
	}

}
