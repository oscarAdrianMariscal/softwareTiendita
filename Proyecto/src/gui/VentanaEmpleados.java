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
import javax.swing.JTabbedPane;

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
	private JTextField apellidoText;
	private JTextField telefonoText;
	private JTextField direccionText;
	private JTextField correoText;
	private JTextField textEliminarEmpleado;

	/**
	 * Create the frame.
	 */
	public VentanaEmpleados(final Controlador controlador) {
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 605, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		//
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
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 1;
		panel.add(lblApellido, gbc_lblApellido);
		
		apellidoText = new JTextField();
		GridBagConstraints gbc_apellidoText = new GridBagConstraints();
		gbc_apellidoText.insets = new Insets(0, 0, 5, 0);
		gbc_apellidoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidoText.gridx = 1;
		gbc_apellidoText.gridy = 1;
		panel.add(apellidoText, gbc_apellidoText);
		apellidoText.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario: ");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.WEST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 2;
		panel.add(lblHorario, gbc_lblHorario);
		
		horarioCombo = new JComboBox();
		horarioCombo.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino"}));
		GridBagConstraints gbc_horarioCombo = new GridBagConstraints();
		gbc_horarioCombo.insets = new Insets(0, 0, 5, 0);
		gbc_horarioCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_horarioCombo.gridx = 1;
		gbc_horarioCombo.gridy = 2;
		panel.add(horarioCombo, gbc_horarioCombo);
		
		JLabel lblSalario = new JLabel("Salario: ");
		GridBagConstraints gbc_lblSalario = new GridBagConstraints();
		gbc_lblSalario.anchor = GridBagConstraints.WEST;
		gbc_lblSalario.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalario.gridx = 0;
		gbc_lblSalario.gridy = 3;
		panel.add(lblSalario, gbc_lblSalario);
		
		salarioSpinner = new JSpinner();
		salarioSpinner.setModel(new SpinnerNumberModel(new Integer(1000), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_salarioSpinner = new GridBagConstraints();
		gbc_salarioSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_salarioSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_salarioSpinner.gridx = 1;
		gbc_salarioSpinner.gridy = 3;
		panel.add(salarioSpinner, gbc_salarioSpinner);
		
		JLabel lblEdad = new JLabel("Edad: ");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 4;
		panel.add(lblEdad, gbc_lblEdad);
		
		edadSpinner = new JSpinner();
		edadSpinner.setModel(new SpinnerNumberModel(new Integer(18), new Integer(16), null, new Integer(1)));
		GridBagConstraints gbc_edadSpinner = new GridBagConstraints();
		gbc_edadSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_edadSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_edadSpinner.gridx = 1;
		gbc_edadSpinner.gridy = 4;
		panel.add(edadSpinner, gbc_edadSpinner);
		
		JLabel lblPuesto = new JLabel("Puesto: ");
		GridBagConstraints gbc_lblPuesto = new GridBagConstraints();
		gbc_lblPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuesto.anchor = GridBagConstraints.WEST;
		gbc_lblPuesto.gridx = 0;
		gbc_lblPuesto.gridy = 5;
		panel.add(lblPuesto, gbc_lblPuesto);
		
		puestoCombo = new JComboBox();
		puestoCombo.setModel(new DefaultComboBoxModel(new String[] {"Administrativo", "Standard"}));
		GridBagConstraints gbc_puestoCombo = new GridBagConstraints();
		gbc_puestoCombo.insets = new Insets(0, 0, 5, 0);
		gbc_puestoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_puestoCombo.gridx = 1;
		gbc_puestoCombo.gridy = 5;
		panel.add(puestoCombo, gbc_puestoCombo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 6;
		panel.add(lblTelefono, gbc_lblTelefono);
		
		telefonoText = new JTextField();
		GridBagConstraints gbc_telefonoText = new GridBagConstraints();
		gbc_telefonoText.insets = new Insets(0, 0, 5, 0);
		gbc_telefonoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonoText.gridx = 1;
		gbc_telefonoText.gridy = 6;
		panel.add(telefonoText, gbc_telefonoText);
		telefonoText.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 7;
		panel.add(lblDireccin, gbc_lblDireccin);
		
		direccionText = new JTextField();
		GridBagConstraints gbc_direccionText = new GridBagConstraints();
		gbc_direccionText.insets = new Insets(0, 0, 5, 0);
		gbc_direccionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_direccionText.gridx = 1;
		gbc_direccionText.gridy = 7;
		panel.add(direccionText, gbc_direccionText);
		direccionText.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombreText.getText().isEmpty()){
					
					
				}
				else{
					String nombre = nombreText.getText();
					String apellido = apellidoText.getText();
					int salario =(int)salarioSpinner.getValue();
					String horario =horarioCombo.getSelectedItem().toString();
					String puesto =puestoCombo.getSelectedItem().toString();
					int edad = (int)edadSpinner.getValue();
					String telefono = telefonoText.getText();
					String direccion = direccionText.getText();
					String correo = correoText.getText();
					controlador.agregarEmpleado(nombre, apellido, (Integer)salario, puesto, horario, edad, telefono, direccion, correo);
					ArrayList<Empleado> empleados = controlador.empleados(); 
					Object[][] empleadosParaTabla= new Object[empleados.size()][];
					int i =0;		
					for (Empleado e: empleados){
						empleadosParaTabla[i]= new Object[10];
						empleadosParaTabla[i][0] =e.id_empleado;
						empleadosParaTabla[i][1] =e.nombre;
						empleadosParaTabla[i][2] =e.apellido;
						empleadosParaTabla[i][3] =e.salario;
						empleadosParaTabla[i][4] =e.puesto;
						empleadosParaTabla[i][5] =e.horario;
						empleadosParaTabla[i][6] =e.edad;
						empleadosParaTabla[i][7] =e.telefono;
						empleadosParaTabla[i][8] =e.direccion;
						empleadosParaTabla[i][9] =e.correo;
						i++;
					}
					
					table.setModel(new DefaultTableModel(
						empleadosParaTabla,
						new String[] {
								"id Empleado", "nombre", "Apellido","Salario","Puesto", "Horario",  "edad", "telefono", "Direccion", "Correo"
						}
					));
					JOptionPane.showMessageDialog(null, "Empleado agregado");
				}
				
			}
		});
		
		JLabel lblCorreo = new JLabel("Correo:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 8;
		panel.add(lblCorreo, gbc_lblCorreo);
		
		correoText = new JTextField();
		GridBagConstraints gbc_correoText = new GridBagConstraints();
		gbc_correoText.insets = new Insets(0, 0, 5, 0);
		gbc_correoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_correoText.gridx = 1;
		gbc_correoText.gridy = 8;
		panel.add(correoText, gbc_correoText);
		correoText.setColumns(10);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 9;
		panel.add(btnOk, gbc_btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		ArrayList<Empleado> empleados = controlador.empleados(); 
		Object[][] empleadosParaTabla= new Object[empleados.size()][];
		int i =0;		
		for (Empleado e: empleados){
			empleadosParaTabla[i]= new Object[10];
			empleadosParaTabla[i][0] =e.id_empleado;
			empleadosParaTabla[i][1] =e.nombre;
			empleadosParaTabla[i][2] =e.apellido;
			empleadosParaTabla[i][3] =e.salario;
			empleadosParaTabla[i][4] =e.puesto;
			empleadosParaTabla[i][5] =e.horario;
			empleadosParaTabla[i][6] =e.edad;
			empleadosParaTabla[i][7] =e.telefono;
			empleadosParaTabla[i][8] =e.direccion;
			empleadosParaTabla[i][9] =e.correo;
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			empleadosParaTabla,
			new String[] {
				"id Empleado", "nombre", "Apellido","Salario","Puesto", "Horario",  "edad", "telefono", "Direccion", "Correo"
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
				ArrayList<Empleado> empleadosUno = controlador.empleados();
				ArrayList<Empleado> empleadosDos = new ArrayList<Empleado>();
				
				for ( Empleado p: empleadosUno){
					if (p.id_empleado ==Integer.parseInt(buscarText.getText())){
						empleadosDos.add(p);
					}
				}
				Object[][] empleadosParaTablaBuscar = new Object[empleadosDos.size()][];
				int i=0;
				for (Empleado p: empleadosDos){
					empleadosParaTablaBuscar[i]= new Object[10];
					empleadosParaTablaBuscar[i][0] =p.id_empleado;
					empleadosParaTablaBuscar[i][1] =p.nombre;
					empleadosParaTablaBuscar[i][2] =p.apellido;
					empleadosParaTablaBuscar[i][3] =p.salario;
					empleadosParaTablaBuscar[i][4] =p.puesto;
					empleadosParaTablaBuscar[i][5] =p.horario;
					empleadosParaTablaBuscar[i][6] =p.edad;
					empleadosParaTablaBuscar[i][7] =p.telefono;
					empleadosParaTablaBuscar[i][8] =p.direccion;
					empleadosParaTablaBuscar[i][9] =p.correo;
					i++;
				}
				table.setModel(new DefaultTableModel(empleadosParaTablaBuscar,			new String[] {
						"id Empleado", "nombre", "Apellido","Salario","Puesto", "Horario",  "edad", "telefono", "Direccion", "Correo"
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
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label = new JLabel("Id: ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_3.add(label, gbc_label);
		
		textEliminarEmpleado = new JTextField();
		textEliminarEmpleado.setColumns(10);
		GridBagConstraints gbc_textEliminarEmpleado = new GridBagConstraints();
		gbc_textEliminarEmpleado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEliminarEmpleado.insets = new Insets(0, 0, 5, 0);
		gbc_textEliminarEmpleado.gridx = 1;
		gbc_textEliminarEmpleado.gridy = 0;
		panel_3.add(textEliminarEmpleado, gbc_textEliminarEmpleado);
		
		JButton btnBorrar = new JButton("Ok");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Empleado> empleados = controlador.empleados();
				for (Empleado p : empleados){
					if (p.id_empleado == Integer.parseInt(textEliminarEmpleado.getText()) ){
						controlador.eliminarEmpleado(p.id_empleado);
					}
				}
			}
		});
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 1;
		panel_3.add(btnBorrar, gbc_btnBorrar);
	}

}
