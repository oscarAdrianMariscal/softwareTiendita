package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(final Controlador controlador) {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 495, 377);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setForeground(Color.BLACK);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnProductos = new JButton("Productos");
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File("Img/fresh7.png"));
		} catch (IOException e) {
			
		}
		btnProductos.setIcon(new ImageIcon(buttonIcon));
		toolBar.add(btnProductos);
		
		
		JButton btnProveedores = new JButton("Proveedores");
		toolBar.add(btnProveedores);
		BufferedImage iconProveedor = null;
		try {
			iconProveedor = ImageIO.read(new File("Img/boxes2.png"));
		} catch (IOException e) {
			
		}
		btnProveedores.setIcon(new ImageIcon(iconProveedor) );
		BufferedImage inventarioProveedor = null;
		try {
			inventarioProveedor = ImageIO.read(new File("Img/inventario.png"));
		} catch (IOException e) {
			
		}
		
		JButton btnEmpleados = new JButton("Empleados");
		toolBar.add(btnEmpleados);
		BufferedImage iconEmpleados = null;
		try {
			iconEmpleados = ImageIO.read(new File("Img/empleados.png"));
		} catch (IOException e) {
			
		}
		btnEmpleados.setIcon(new ImageIcon(iconEmpleados));
		
		JButton btnTickets = new JButton("Tickets");
		toolBar.add(btnTickets);
		BufferedImage iconTicket = null;
		try {
			iconTicket = ImageIO.read(new File("Img/ticket.png"));
		} catch (IOException e) {
			
		}
		btnTickets.setIcon(new ImageIcon(iconTicket));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_4, BorderLayout.NORTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblBuscar = new JLabel("Buscar: ");
		GridBagConstraints gbc_lblBuscar = new GridBagConstraints();
		gbc_lblBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_lblBuscar.anchor = GridBagConstraints.EAST;
		gbc_lblBuscar.gridx = 0;
		gbc_lblBuscar.gridy = 0;
		panel_4.add(lblBuscar, gbc_lblBuscar);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JLabel lblTotal = new JLabel("Total");
		panel_5.add(lblTotal);
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_5.add(btnCobrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Sucursal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_3.add(horizontalStrut);
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaTicket(controlador);
			}
		});
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaEmpleados(controlador);
			}
		});
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaProveedores(controlador);
			}
		});
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaProducto(controlador);
			}
		});
		
		Image tienda = new ImageIcon(this.getClass().getResource("/tienda.png")).getImage();
	}

}
