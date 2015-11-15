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
import javax.swing.table.DefaultTableModel;

import modelo.Empleado;
import controlador.Controlador;
import javax.swing.DefaultComboBoxModel;

public class VentanaEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField buscarText;
	private JTextField nombreText;
	private JComboBox horarioCombo;
	private JSpinner salarioSpinner;
	private JSpinner edadSpinner;
	private JComboBox puestoCombo;

	/**
	 * Create the frame.
	 */
	public VentanaEmpleados(final Controlador controlador) {
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 605, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblHorario = new JLabel("Horario: ");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.WEST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 1;
		panel.add(lblHorario, gbc_lblHorario);
		
		horarioCombo = new JComboBox();
		horarioCombo.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino"}));
		GridBagConstraints gbc_horarioCombo = new GridBagConstraints();
		gbc_horarioCombo.insets = new Insets(0, 0, 5, 0);
		gbc_horarioCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_horarioCombo.gridx = 1;
		gbc_horarioCombo.gridy = 1;
		panel.add(horarioCombo, gbc_horarioCombo);
		
		JLabel lblSalario = new JLabel("Salario: ");
		GridBagConstraints gbc_lblSalario = new GridBagConstraints();
		gbc_lblSalario.anchor = GridBagConstraints.WEST;
		gbc_lblSalario.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalario.gridx = 0;
		gbc_lblSalario.gridy = 2;
		panel.add(lblSalario, gbc_lblSalario);
		
		salarioSpinner = new JSpinner();
		salarioSpinner.setModel(new SpinnerNumberModel(new Integer(1000), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_salarioSpinner = new GridBagConstraints();
		gbc_salarioSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_salarioSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_salarioSpinner.gridx = 1;
		gbc_salarioSpinner.gridy = 2;
		panel.add(salarioSpinner, gbc_salarioSpinner);
		
		JLabel lblEdad = new JLabel("Edad: ");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 3;
		panel.add(lblEdad, gbc_lblEdad);
		
		edadSpinner = new JSpinner();
		edadSpinner.setModel(new SpinnerNumberModel(new Integer(18), new Integer(16), null, new Integer(1)));
		GridBagConstraints gbc_edadSpinner = new GridBagConstraints();
		gbc_edadSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_edadSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_edadSpinner.gridx = 1;
		gbc_edadSpinner.gridy = 3;
		panel.add(edadSpinner, gbc_edadSpinner);
		
		JLabel lblPuesto = new JLabel("Puesto: ");
		GridBagConstraints gbc_lblPuesto = new GridBagConstraints();
		gbc_lblPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuesto.anchor = GridBagConstraints.WEST;
		gbc_lblPuesto.gridx = 0;
		gbc_lblPuesto.gridy = 4;
		panel.add(lblPuesto, gbc_lblPuesto);
		
		puestoCombo = new JComboBox();
		puestoCombo.setModel(new DefaultComboBoxModel(new String[] {"Administrativo", "Standard"}));
		GridBagConstraints gbc_puestoCombo = new GridBagConstraints();
		gbc_puestoCombo.insets = new Insets(0, 0, 5, 0);
		gbc_puestoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_puestoCombo.gridx = 1;
		gbc_puestoCombo.gridy = 4;
		panel.add(puestoCombo, gbc_puestoCombo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombreText.getText().isEmpty()){
					
					
				}
				else{
					controlador.agregarEmpleado((int)salarioSpinner.getValue(), 
							horarioCombo.getSelectedItem().toString(), 
							puestoCombo.getSelectedItem().toString(), 
							(int)edadSpinner.getValue(), nombreText.getText());
					ArrayList<Empleado> empleados = controlador.empleados(); 
					Object[][] empleadosParaTabla= new Object[empleados.size()][];
					int i =0;		
					for (Empleado e: empleados){
						empleadosParaTabla[i]= new Object[6];
						empleadosParaTabla[i][0] =e.id_empleado;
						empleadosParaTabla[i][1] =e.salario;
						empleadosParaTabla[i][2] =e.horario;
						empleadosParaTabla[i][3] =e.puesto;
						empleadosParaTabla[i][4] =e.edad;
						empleadosParaTabla[i][5] =e.nombre;
						i++;
					}
					
					table.setModel(new DefaultTableModel(
						empleadosParaTabla,
						new String[] {
							"id Empleado", "Salario", "Horario", "puesto", "edad", "nombre"
						}
					));
					JOptionPane.showMessageDialog(null, "Empleado agregado");
				}
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 5;
		panel.add(btnOk, gbc_btnOk);
		
		JLabel lblIdempleadoAEliminar = new JLabel("IdEmpleado a eliminar");
		GridBagConstraints gbc_lblIdempleadoAEliminar = new GridBagConstraints();
		gbc_lblIdempleadoAEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdempleadoAEliminar.gridx = 0;
		gbc_lblIdempleadoAEliminar.gridy = 7;
		panel.add(lblIdempleadoAEliminar, gbc_lblIdempleadoAEliminar);
		
		final JSpinner eliminarIdSpinner = new JSpinner();
		eliminarIdSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_eliminarIdSpinner = new GridBagConstraints();
		gbc_eliminarIdSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_eliminarIdSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_eliminarIdSpinner.gridx = 1;
		gbc_eliminarIdSpinner.gridy = 7;
		panel.add(eliminarIdSpinner, gbc_eliminarIdSpinner);
		
		JButton btnOk_1 = new JButton("Ok");
		btnOk_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				controlador.eliminarEmpleado((int)eliminarIdSpinner.getValue());
				ArrayList<Empleado> empleados = controlador.empleados(); 
				Object[][] empleadosParaTabla= new Object[empleados.size()][];
				int i=0;
				for (Empleado c: empleados){
					empleadosParaTabla[i]= new Object[6];
					empleadosParaTabla[i][0] =c.id_empleado;
					empleadosParaTabla[i][1] =c.salario;
					empleadosParaTabla[i][2] =c.horario;
					empleadosParaTabla[i][3] =c.puesto;
					empleadosParaTabla[i][4] =c.edad;
					empleadosParaTabla[i][5] =c.nombre;
					i++;
				}
				
				table.setModel(new DefaultTableModel(
					empleadosParaTabla,
					new String[] {
						"id Empleado", "Salario", "Horario", "puesto", "edad", "nombre"
					}
				));
				table.repaint();
				
			}
		});
		GridBagConstraints gbc_btnOk_1 = new GridBagConstraints();
		gbc_btnOk_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk_1.gridx = 1;
		gbc_btnOk_1.gridy = 8;
		panel.add(btnOk_1, gbc_btnOk_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		ArrayList<Empleado> empleados = controlador.empleados(); 
		Object[][] empleadosParaTabla= new Object[empleados.size()][];
		int i =0;		
		for (Empleado e: empleados){
			empleadosParaTabla[i]= new Object[6];
			empleadosParaTabla[i][0] =e.id_empleado;
			empleadosParaTabla[i][1] =e.salario;
			empleadosParaTabla[i][2] =e.horario;
			empleadosParaTabla[i][3] =e.puesto;
			empleadosParaTabla[i][4] =e.edad;
			empleadosParaTabla[i][5] =e.nombre;
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			empleadosParaTabla,
			new String[] {
				"id Empleado", "Salario", "Horario", "puesto", "edad", "nombre"
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
			public void actionPerformed(ActionEvent e) {
				ArrayList<Empleado> productosUno = controlador.empleados();
				ArrayList<Empleado> productosDos = new ArrayList<Empleado>();
				
				for ( Empleado p: productosUno){
					if (p.id_empleado ==Integer.parseInt(buscarText.getText())){
						productosDos.add(p);
					}
				}
				Object[][] empleadosParaTablaBuscar = new Object[productosDos.size()][];
				int i=0;
				for (Empleado p: productosDos){
					empleadosParaTablaBuscar[i]= new Object[6];
					empleadosParaTablaBuscar[i][0] =p.id_empleado;
					empleadosParaTablaBuscar[i][1] =p.salario;
					empleadosParaTablaBuscar[i][2] =p.horario;
					empleadosParaTablaBuscar[i][3] =p.puesto;
					empleadosParaTablaBuscar[i][4] =p.edad;
					empleadosParaTablaBuscar[i][5] =p.nombre;
					i++;
				}
				table.setModel(new DefaultTableModel(empleadosParaTablaBuscar,			new String[] {
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
