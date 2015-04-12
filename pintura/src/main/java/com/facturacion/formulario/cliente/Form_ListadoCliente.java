package com.facturacion.formulario.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;


public class Form_ListadoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBbusqueda;
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * Create the frame.
	 */
	public Form_ListadoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusquedaDeClientes = new JLabel("Busqueda de clientes");
		lblBusquedaDeClientes.setBounds(33, 12, 164, 15);
		contentPane.add(lblBusquedaDeClientes);
		
		txtBbusqueda = new JTextField();
		txtBbusqueda.setText("bbusqueda");
		txtBbusqueda.setBounds(43, 39, 142, 19);
		contentPane.add(txtBbusqueda);
		txtBbusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(192, 39, 90, 25);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarJTable();
			}
			
		});
		
		
		// TODO: AGREGAR JSCROLLPANEL COMO CONTENEDOR
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 730, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(498, 36, 117, 25);
		contentPane.add(btnModificar);
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "VOY A MODIFICAR " + table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) , 
						"Fallo", JOptionPane.ERROR_MESSAGE);
				
				Form_ModificarCliente form = new Form_ModificarCliente((table.getValueAt(table.getSelectedRow(), 0)).toString());
				form.setVisible(true);
				
			
				
			}
			
		});
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(627, 36, 117, 25);
		contentPane.add(btnBorrar);
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				borrarCliente();
			}
			
		});
		
	}
	/*
	 * LLENAR JTABLE
	 */
	public void llenarJTable(){
		List<Cliente> lista = ClienteDao.getInstance().getAll();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CUIL / CUIT");
		model.addColumn("NOMBRE");
		model.addColumn("AFILIACION");
		model.addColumn("DEUDA");
		model.addColumn("DESCUENTO");
		model.addColumn("DIRECCION");
		model.addColumn("LOCALIDAD");
		model.addColumn("TELEFONO");		
		model.addColumn("MAIL");
		
		
		for(Cliente cliente : lista){
			model.addRow(new String[]{
					cliente.getCUITCUIL(),
					cliente.getNombre() +" "+ cliente.getApellido(), 
					cliente.getAfiliacionSocial(),
					String.valueOf(cliente.getDeuda()),
					String.valueOf(cliente.getDescuento()),
					cliente.getDireccion(),
					cliente.getLocalidad(),
					cliente.getTelefono(),
					cliente.getMail()});			
		}
		table.setModel(model);
	}
	/*
	 * "BORRAR" CLIENTE
	 * 
	 */
	public void borrarCliente(){
		Form_BajaCliente form = new Form_BajaCliente();
		form.modificarEstado((table.getValueAt(table.getSelectedRow(), 0)).toString());
	}
}
