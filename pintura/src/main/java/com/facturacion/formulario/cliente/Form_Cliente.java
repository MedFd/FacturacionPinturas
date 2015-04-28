package com.facturacion.formulario.cliente;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.facturacion.busquedas.ClienteBusqueda;
import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;

public class Form_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaCliente;
	protected JTable table;
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
	private JTextField txtClave3;
	
	private JComboBox cmbTipoCliente;
	private JScrollPane scrollPane;
	
	private JButton btnEliminarCliente;
	private JButton btnModificarCliente;

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
		txtBusquedaCliente.setBounds(31, 67, 125, 19);
		contentPane.add(txtBusquedaCliente);
		txtBusquedaCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(165, 64, 82, 25);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarJtablePorNombre();
			}
		});
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 101, 210, 285);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			@Override
	          public boolean isCellEditable ( int row, int column )
	          {
	              return false;
	          }
		};
		table.getTableHeader().setReorderingAllowed(false);
		  
		
		
		
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table2 =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table2.rowAtPoint(p);
		        if (me.getClickCount() == 1) {
		            // your valueChanged overridden method 
		        	visualizarCliente((table.getValueAt(table.getSelectedRow(), 0)).toString());
		        }
		    }
		});
				
		JLabel label = new JLabel("CUIL-CUIT");
		label.setBounds(283, 101, 70, 15);
		contentPane.add(label);
		
		txtClave1 = new JTextField();
		txtClave1.setEditable(false);
		txtClave1.setColumns(10);
		txtClave1.setBounds(289, 122, 23, 19);
		contentPane.add(txtClave1);
		txtClave1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave1.getText().length() == 2) {
					e.consume();
				}
			}
		});
		txtClave2 = new JTextField();
		txtClave2.setEditable(false);
		txtClave2.setBounds(320, 122, 82, 19);
		contentPane.add(txtClave2);
		txtClave2.setColumns(10);
		txtClave2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave2.getText().length() == 9) {
					e.consume();
				}
			}
		});
		
		txtClave3 = new JTextField();
		txtClave3.setEditable(false);
		txtClave3.setText("");
		txtClave3.setBounds(405, 122, 23, 19);
		contentPane.add(txtClave3);
		txtClave3.setColumns(10);
		txtClave3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave3.getText().length() == 1) {
					e.consume();
				}
			}
		});
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(283, 153, 70, 15);
		contentPane.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setText("nombe");
		txtNombre.setColumns(10);
		txtNombre.setBounds(283, 180, 135, 19);
		contentPane.add(txtNombre);
		
		JLabel label_2 = new JLabel("Apellido");
		label_2.setBounds(458, 159, 70, 15);
		contentPane.add(label_2);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setText("apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(458, 179, 114, 19);
		contentPane.add(txtApellido);
		
		JLabel label_3 = new JLabel("Direccion");
		label_3.setBounds(290, 217, 70, 15);
		contentPane.add(label_3);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setText("Direccion");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(283, 238, 135, 19);
		contentPane.add(txtDireccion);
		
		JLabel label_4 = new JLabel("Localidad");
		label_4.setBounds(458, 217, 70, 15);
		contentPane.add(label_4);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setEditable(false);
		txtLocalidad.setText("Localidad");
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(458, 238, 114, 19);
		contentPane.add(txtLocalidad);
		
		JLabel label_5 = new JLabel("Telefono");
		label_5.setBounds(283, 269, 70, 15);
		contentPane.add(label_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(283, 296, 129, 19);
		contentPane.add(txtTelefono);
		
		JLabel label_6 = new JLabel("Descuento");
		label_6.setBounds(283, 327, 95, 19);
		contentPane.add(label_6);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setText("descuento");
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(283, 349, 135, 19);
		contentPane.add(txtDescuento);
		
		JLabel label_7 = new JLabel("Tipo de cliente");
		label_7.setBounds(459, 101, 113, 15);
		contentPane.add(label_7);
		
		
		String[] listaCliente = new String[]{"Responsable inscripto","No responsable","No responsable","Exento","Consumidor final","Responsable monotributista"};
		cmbTipoCliente = new JComboBox(listaCliente);
		cmbTipoCliente.setBounds(458, 119, 136, 24);
		contentPane.add(cmbTipoCliente);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(458, 269, 70, 15);
		contentPane.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
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
		
		btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.setBounds(650, 204, 161, 40);
		contentPane.add(btnModificarCliente);
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCliente();
				
				visualizarCliente((table.getValueAt(table.getSelectedRow(), 0)).toString());
			}
		});
		
		btnEliminarCliente = new JButton("Eliminar cliente");
		btnEliminarCliente.setBounds(650, 256, 161, 36);
		contentPane.add(btnEliminarCliente);
		btnEliminarCliente.setEnabled(false);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCliente();
				
				
			}
		});
		
		JLabel lblDeuda = new JLabel("Deuda");
		lblDeuda.setBounds(458, 327, 70, 15);
		contentPane.add(lblDeuda);
		
		txtDeuda = new JTextField();
		txtDeuda.setEditable(false);
		txtDeuda.setText("Deuda");
		txtDeuda.setBounds(458, 349, 114, 19);
		contentPane.add(txtDeuda);
		txtDeuda.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(650, 338, 161, 40);
		contentPane.add(btnVolver);
		
	}
	
	
	public void visualizarCliente(String cuit){
		List<Cliente> lista = ClienteBusqueda.getInstance().getByCUITCUIL(cuit);
		for(Cliente cliente : lista){
			txtClave1.setText(cliente.getCUITCUIL().substring(0,2));
			txtClave2.setText(cliente.getCUITCUIL().substring(3,12));
			txtClave3.setText(cliente.getCUITCUIL().substring(13,14));
			txtNombre.setText(cliente.getNombre());
			txtApellido.setText(cliente.getApellido());
			txtDireccion.setText(cliente.getDireccion());
			txtLocalidad.setText(cliente.getLocalidad());
			txtTelefono.setText(cliente.getTelefono());
			txtMail.setText(cliente.getMail());
			txtDescuento.setText(String.valueOf(cliente.getDescuento()));
			txtDeuda.setText(String.valueOf(cliente.getDeuda()));
			cmbTipoCliente.setSelectedItem(cliente.getAfiliacionSocial());
		}
		btnModificarCliente.setEnabled(true);
		btnEliminarCliente.setEnabled(true); 
	}

	public void llenarJtablePorNombre(){
		
		
		try{
		//	table.setModel(new DefaultTableModel());
			List<Cliente> lista;
			String[] separada = txtBusquedaCliente.getText().toUpperCase().split(" ");
			
			if(separada.length == 2){
				lista = ClienteDao.getInstance().getAllByName(separada[0], separada[1]);
			}else{
				 lista = ClienteDao.getInstance().getAllByName(separada[0], separada[0]);
			}

			if (0!=lista.size()) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("CUIL / CUIT");
				model.addColumn("NOMBRE");				
				for(Cliente cliente : lista){	
					if(cliente.isEstado()==true){
						model.addRow(new String[]{						
								cliente.getCUITCUIL(),
								cliente.getNombre() +" "+ cliente.getApellido()
								});		
					}
				}
				table.setModel(model);
			}
		}catch(Exception ex){
			ex.getMessage();
		}
	}
	
	/*
	 * Agregar cliente
	 */
	private void agregarCliente(){
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Agregar un nuevo cliente",
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			Form_ClienteAgregar form = new Form_ClienteAgregar(this);
			form.setVisible(true);
		}	

	}
	/*
	 * Modificar cliente
	 */
	private boolean modificarCliente(){
	
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Modificar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
		//Form_ClienteModificar form = new Form_ClienteModificar((table.getValueAt(table.getSelectedRow(), 0)).toString());
			Form_ClienteModificar form = new Form_ClienteModificar(this);

			
			
			form.setVisible(true);
			
		
		}		
		btnModificarCliente.setEnabled(false);
		btnEliminarCliente.setEnabled(false);
	

		
		return true;
	}
	/*
	 * Borrar cliente
	 */
	private boolean borrarCliente(){
		
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Desea borrar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			Form_ClienteBaja form = new Form_ClienteBaja();
			form.modificarEstado(this);			
			
		}	
		btnModificarCliente.setEnabled(false);
		btnEliminarCliente.setEnabled(false);
		
		return true;
	}

}