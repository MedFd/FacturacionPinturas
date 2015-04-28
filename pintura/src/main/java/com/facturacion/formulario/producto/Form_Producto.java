package com.facturacion.formulario.producto;

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
import com.facturacion.busquedas.ProductoBusqueda;
import com.facturacion.dao.ClienteDao;
import com.facturacion.dao.ProductoDao;
import com.facturacion.entitys.Cliente;
import com.facturacion.entitys.Producto;
import javax.swing.DefaultComboBoxModel;

public class Form_Producto extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusqueda;
	protected JTable table;
	private JTextField txtNombre;
	private JTextField txtLitros;
	private JTextField txtStock;
	private JTextField txtPrecio;
	
	private JComboBox cmbAplicacion; 
	private JComboBox cmbTipoEnvase;
	private JScrollPane scrollPane;
	
	private JButton btnEliminarProducto;
	private JButton btnModificarProducto;
	
	private JLabel lblNewLabel;
	private JTextField txtColor;
	private JTextField txtMarca;
	private JTextField txtCodigo;

	/**
	 * Create the frame.
	 */
	public Form_Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	 
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setBounds(31, 40, 90, 15);
		contentPane.add(lblBusqueda);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(31, 67, 125, 19);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
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
		        	visualizarProducto((table.getValueAt(table.getSelectedRow(), 0)).toString());
		        }
		    }
		});
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setText("nombe");
		txtNombre.setColumns(10);
		txtNombre.setBounds(287, 103, 182, 19);
		contentPane.add(txtNombre);
		
		JLabel lbLitros = new JLabel("Litros");
		lbLitros.setBounds(458, 287, 114, 15);
		contentPane.add(lbLitros);
		
		txtLitros = new JTextField();
		txtLitros.setEditable(false);
		txtLitros.setText("Litros");
		txtLitros.setColumns(10);
		txtLitros.setBounds(458, 321, 114, 19);
		contentPane.add(txtLitros);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(290, 352, 70, 15);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setText("stock");
		txtStock.setColumns(10);
		txtStock.setBounds(283, 373, 135, 19);
		contentPane.add(txtStock);
		
		JLabel lblPrecioVenta = new JLabel("Precio");
		lblPrecioVenta.setBounds(458, 352, 70, 15);
		contentPane.add(lblPrecioVenta);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setText("Precio");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(458, 373, 114, 19);
		contentPane.add(txtPrecio);
		
		JLabel lblTipoDeEnvase = new JLabel("Tipo de envase");
		lblTipoDeEnvase.setBounds(280, 287, 113, 15);
		contentPane.add(lblTipoDeEnvase);
		
		
		String[] listaEnvase = new String[]{"Pote","Balde"};
		cmbTipoEnvase = new JComboBox(listaEnvase);
		cmbTipoEnvase.setBounds(283, 318, 136, 24);
		contentPane.add(cmbTipoEnvase);
		
		JButton btnAgregarCliente = new JButton("Nuevo producto");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregar();
				
			}
		});
		btnAgregarCliente.setBounds(650, 155, 161, 40);
		contentPane.add(btnAgregarCliente);
		
		btnModificarProducto = new JButton("Modificar producto");
		btnModificarProducto.setBounds(650, 204, 161, 40);
		contentPane.add(btnModificarProducto);
		btnModificarProducto.setEnabled(false);
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
				
				visualizarProducto((table.getValueAt(table.getSelectedRow(), 0)).toString());
			}
		});
		
		btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.setBounds(650, 256, 161, 36);
		contentPane.add(btnEliminarProducto);
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
				
				
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(650, 338, 161, 40);
		contentPane.add(btnVolver);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(287, 82, 70, 15);
		contentPane.add(lblNombre);
		
		lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(293, 153, 70, 15);
		contentPane.add(lblNewLabel);
		
		txtColor = new JTextField();
		txtColor.setEnabled(true);
		txtColor.setEditable(false);
		txtColor.setText("color");
		txtColor.setBounds(282, 166, 150, 19);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(479, 83, 70, 15);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setText("marca");
		txtMarca.setBounds(479, 103, 127, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(458, 134, 70, 25);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setText("codigo");
		txtCodigo.setBounds(479, 166, 114, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblAplicacion = new JLabel("Aplicacion");
		lblAplicacion.setBounds(283, 205, 149, 15);
		contentPane.add(lblAplicacion);
		
		cmbAplicacion = new JComboBox();
		cmbAplicacion.setModel(new DefaultComboBoxModel(new String[] {"Interior/Exterior", "Interior", "Exterior"}));
		cmbAplicacion.setBounds(283, 232, 289, 24);
		contentPane.add(cmbAplicacion);
		
	}
	
	
	public void visualizarProducto(String id){
		List<Producto> lista = ProductoBusqueda.getInstance().getByID(id);
		for(Producto pro : lista){
			txtNombre.setText(pro.getNombre());
			txtColor.setText(pro.getColor());
			txtLitros.setText(String.valueOf(pro.getLitros()));
			txtCodigo.setText(pro.getCodigo());
			txtMarca.setText(pro.getMarca());
			txtStock.setText(String.valueOf(pro.getStock()));
			txtPrecio.setText(String.valueOf(pro.getPrecioVenta()));
			cmbAplicacion.setSelectedItem(pro.getAplicacion());
			cmbTipoEnvase.setSelectedItem(pro.getEnvase());
		}
		btnModificarProducto.setEnabled(true);
		btnEliminarProducto.setEnabled(true); 
	}
	
	public void llenarJtablePorNombre(){
		
		
		try{
		
			String nombreBusqueda = txtBusqueda.getText().toUpperCase().trim();						
			List<Producto> lista  = ProductoDao.getInstance().getAllByName(nombreBusqueda);
			
			if (0!=lista.size()) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("Producto");
				model.addColumn("MARCA");
				
				for(Producto pro : lista){	
					if(pro.isEstado()==true){
						model.addRow(new String[]{						
								String.valueOf(pro.getId()),
								pro.getNombre(),
								pro.getMarca()
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
	 * Agregar producto
	 */
	private void agregar(){
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Agregar un nuevo cliente",
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			Form_ProductoAgregar form = new Form_ProductoAgregar(this);
			form.setVisible(true);
		}	

	}
	/*
	 * Modificar producto
	 */
	private boolean modificar(){
	
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Modificar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
		//Form_ClienteModificar form = new Form_ClienteModificar((table.getValueAt(table.getSelectedRow(), 0)).toString());
			Form_ProductoModificar form = new Form_ProductoModificar(this);

			
			
			form.setVisible(true);
			
		
		}		
		btnModificarProducto.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
	

		
		return true;
	}
	/*
	 * Borrar producto
	 */
	private boolean borrar(){
		
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Desea borrar los datos del cliente\n"			    
			    		+ table.getValueAt(table.getSelectedRow(), 0),
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			Form_ProductoBaja form = new Form_ProductoBaja();
			form.modificarEstado(this);			
			
		}	
		btnModificarProducto.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		
		return true;
	}
}