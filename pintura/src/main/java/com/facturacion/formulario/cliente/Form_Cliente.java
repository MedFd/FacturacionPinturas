package com.facturacion.formulario.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;

public class Form_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaCliente;
	private JTable table;
	private JTextField txtClave1;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtLocalidad;
	private JTextField txtTelefono;
	private JTextField txtDescuento;
	private JTextField txtMail;
	private JTextField txtDeuda;
	private JTextField txtClave2;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public Form_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setBounds(31, 40, 90, 15);
		contentPane.add(lblBusqueda);
		
		txtBusquedaCliente = new JTextField();
		txtBusquedaCliente.setText("Busqueda cliente");
		txtBusquedaCliente.setBounds(31, 67, 125, 19);
		contentPane.add(txtBusquedaCliente);
		txtBusquedaCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(165, 64, 82, 25);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 101, 210, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
		JLabel label = new JLabel("CUIL-CUIT");
		label.setBounds(283, 101, 70, 15);
		contentPane.add(label);
		
		txtClave1 = new JTextField();
		txtClave1.setColumns(10);
		txtClave1.setBounds(289, 122, 23, 19);
		contentPane.add(txtClave1);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(283, 153, 70, 15);
		contentPane.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombe");
		txtNombre.setColumns(10);
		txtNombre.setBounds(283, 180, 135, 19);
		contentPane.add(txtNombre);
		
		JLabel label_2 = new JLabel("Apellido");
		label_2.setBounds(458, 159, 70, 15);
		contentPane.add(label_2);
		
		txtApellido = new JTextField();
		txtApellido.setText("apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(458, 179, 114, 19);
		contentPane.add(txtApellido);
		
		JLabel label_3 = new JLabel("Direccion");
		label_3.setBounds(290, 217, 70, 15);
		contentPane.add(label_3);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("Direccion");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(283, 238, 135, 19);
		contentPane.add(txtDireccion);
		
		JLabel label_4 = new JLabel("Localidad");
		label_4.setBounds(458, 217, 70, 15);
		contentPane.add(label_4);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setText("Localidad");
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(458, 238, 114, 19);
		contentPane.add(txtLocalidad);
		
		JLabel label_5 = new JLabel("Telefono");
		label_5.setBounds(283, 269, 70, 15);
		contentPane.add(label_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(283, 296, 129, 19);
		contentPane.add(txtTelefono);
		
		JLabel label_6 = new JLabel("Descuento");
		label_6.setBounds(283, 327, 95, 19);
		contentPane.add(label_6);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("descuento");
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(283, 349, 135, 19);
		contentPane.add(txtDescuento);
		
		JLabel label_7 = new JLabel("Tipo de cliente");
		label_7.setBounds(459, 101, 113, 15);
		contentPane.add(label_7);
		
		JComboBox cmbTipoCliente = new JComboBox();
		cmbTipoCliente.setBounds(458, 119, 136, 24);
		contentPane.add(cmbTipoCliente);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(458, 269, 70, 15);
		contentPane.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setText("Mail");
		txtMail.setBounds(458, 296, 114, 19);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JButton btnAgregarCliente = new JButton("Nuevo cliente");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarCliente();
			}
		});
		btnAgregarCliente.setBounds(650, 155, 161, 40);
		contentPane.add(btnAgregarCliente);
		
		JButton btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.setBounds(650, 204, 161, 40);
		contentPane.add(btnModificarCliente);
		
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCliente();	
			}
		});
		
		JButton btnEliminarCliente = new JButton("Eliminar cliente");
		btnEliminarCliente.setBounds(650, 256, 161, 36);
		contentPane.add(btnEliminarCliente);
		
		JLabel lblDeuda = new JLabel("Deuda");
		lblDeuda.setBounds(458, 327, 70, 15);
		contentPane.add(lblDeuda);
		
		txtDeuda = new JTextField();
		txtDeuda.setText("Deuda");
		txtDeuda.setBounds(458, 349, 114, 19);
		contentPane.add(txtDeuda);
		txtDeuda.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(650, 338, 161, 40);
		contentPane.add(btnVolver);
		
		txtClave2 = new JTextField();
		txtClave2.setBounds(320, 122, 82, 19);
		contentPane.add(txtClave2);
		txtClave2.setColumns(10);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(405, 122, 23, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
	
	/*
	 *  LLENAR JTABLE CON LOS DATOS DE TODOS
	 *  TODO: filtrado especial
	 */ 
	private void llenarJTableDefault(){
		List<Cliente> lista = ClienteDao.getInstance().getAll();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CUIL / CUIT");
		model.addColumn("NOMBRE");
		
		
		for(Cliente cliente : lista){
			model.addRow(new String[]{
					cliente.getCUITCUIL(),
					cliente.getNombre() +" "+ cliente.getApellido()
					});			
		}
		table.setModel(model);
	}
	/*
	 * Agregar cliente
	 */
	private void agregarCliente(){
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Agregar un nuevo cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==1){
//			Form_ModificarCliente form = new Form_ModificarCliente((table.getValueAt(table.getSelectedRow(), 0)).toString());
//			form.setVisible(true);
		}	
	}
	/*
	 * Modificar cliente
	 */
	private void modificarCliente(){
		
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Modificar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==1){
//			Form_ModificarCliente form = new Form_ModificarCliente((table.getValueAt(table.getSelectedRow(), 0)).toString());
//			form.setVisible(true);
		}		
	}
	/*
	 * Borrar cliente
	 */
	private void borrarCliente(){
		
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Desea borrar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==1){
//			Form_BajaCliente form = new Form_BajaCliente();
//			form.modificarEstado((table.getValueAt(table.getSelectedRow(), 0)).toString());
		}	

	}
}
