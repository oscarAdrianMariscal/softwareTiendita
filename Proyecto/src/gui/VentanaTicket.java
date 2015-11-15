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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Ticket;
import controlador.Controlador;

public class VentanaTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;

	/**
	 * Create the frame.
	 */
	public VentanaTicket(final Controlador controlador) {
		setTitle("Tickets");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
//		JButton btnMostrarTicket = new JButton("Mostrar ticket");
//		btnMostrarTicket.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		GridBagConstraints gbc_btnMostrarTicket = new GridBagConstraints();
		gbc_btnMostrarTicket.insets = new Insets(0, 0, 5, 0);
		gbc_btnMostrarTicket.gridx = 0;
		gbc_btnMostrarTicket.gridy = 0;
//		panel.add(btnMostrarTicket, gbc_btnMostrarTicket);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		ArrayList<Ticket> productos = controlador.tickets();
		Object[][] productosParaTabla= new Object[productos.size()][];
		int i =0;		
		for (Ticket p: productos){
			productosParaTabla[i]= new Object[4];
			productosParaTabla[i][0] =p.id_ticket;
			productosParaTabla[i][1] =p.fecha;
			productosParaTabla[i][2] =p.id_empleado;
			//System.out.println(p.informacion);
			//productosParaTabla[i][3] =p.informacion;
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			productosParaTabla,
			new String[] {
				"id Ticket", "Fecha", "id empleado"
			}
		));
		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);
		
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
			public void actionPerformed(ActionEvent e) {
				ArrayList<Ticket> productosUno = controlador.tickets();
				ArrayList<Ticket> productosDos = new ArrayList<Ticket>();
				
				for ( Ticket p: productosUno){
					if (p.id_ticket ==Integer.parseInt(buscarText.getText())){
						productosDos.add(p);
					}
				}
				Object[][] productosParaTablaBuscar = new Object[productosDos.size()][];
				int i=0;
				
				ArrayList<Ticket> productos = controlador.tickets();
				Object[][] productosParaTabla= new Object[productos.size()][];
				int j =0;		
				for (Ticket p: productosDos){
					productosParaTabla[j]= new Object[4];
					productosParaTabla[j][0] =p.id_ticket;
					productosParaTabla[j][1] =p.fecha;
					productosParaTabla[j][2] =p.id_empleado;
					productosParaTabla[j][3] =p.informacion;
					j++;
				}
				
				table.setModel(new DefaultTableModel(
					productosParaTabla,
					new String[] {
						"id Ticket", "Fecha", "id empleado"
					}
				));
				table.repaint();
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		panel_2.add(btnBuscar, gbc_btnBuscar);
	}

}
