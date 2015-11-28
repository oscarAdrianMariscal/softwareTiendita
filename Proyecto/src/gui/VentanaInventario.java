package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

import controlador.Controlador;

public class VentanaInventario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JSpinner cantidadSpinner;
	private JSpinner idProductoSpinner;

	/**
	 * Create the frame.
	 */
	public VentanaInventario(final Controlador controlador) {
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		idProductoSpinner = new JSpinner();
		GridBagConstraints gbc_idProductoSpinner = new GridBagConstraints();
		gbc_idProductoSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_idProductoSpinner.gridx = 1;
		gbc_idProductoSpinner.gridy = 0;
		panel.add(idProductoSpinner, gbc_idProductoSpinner);
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Actualizado!.");
//				controlador.actualizarInventario((int)idProductoSpinner.getValue(),(int)cantidadSpinner.getValue());
//				
			}
		});
		
		JLabel lblIdProducto = new JLabel("id Producto");
		GridBagConstraints gbc_lblIdProducto = new GridBagConstraints();
		gbc_lblIdProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdProducto.gridx = 0;
		gbc_lblIdProducto.gridy = 0;
		panel.add(lblIdProducto, gbc_lblIdProducto);
		
		
		
		JLabel lblCantidadDeCambio = new JLabel("Nueva cantidad:");
		GridBagConstraints gbc_lblCantidadDeCambio = new GridBagConstraints();
		gbc_lblCantidadDeCambio.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadDeCambio.gridx = 0;
		gbc_lblCantidadDeCambio.gridy = 1;
		panel.add(lblCantidadDeCambio, gbc_lblCantidadDeCambio);
		
		cantidadSpinner = new JSpinner();
		cantidadSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_cantidadSpinner = new GridBagConstraints();
		gbc_cantidadSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_cantidadSpinner.gridx = 1;
		gbc_cantidadSpinner.gridy = 1;
		panel.add(cantidadSpinner, gbc_cantidadSpinner);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 2;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
//		ArrayList<Inventario> inventarios = controlador.inventarios();
//		Object[][] inventariosParaTabla= new Object[inventarios.size()][];
		int i =0;		
//		for (Inventario n: inventarios){
//			inventariosParaTabla[i]= new Object[3];
//			inventariosParaTabla[i][0] =n.nombreProducto;
//			inventariosParaTabla[i][1] =n.id_producto;
//			inventariosParaTabla[i][2] =n.cantidad;
//			i++;
//		}
//		table.setModel(new DefaultTableModel( inventariosParaTabla
//			,
//			new String[] {
//				"Nombre producto", "Id producto", "Cantidad"
//			}
//		));
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		panel_2.add(btnBuscar, gbc_btnBuscar);
	}

}
