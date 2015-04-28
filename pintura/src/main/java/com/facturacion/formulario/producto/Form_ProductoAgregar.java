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
import com.facturacion.entitys.form.FormProducto;
import com.facturacion.excepciones.CampoCantidadMinimaIncorrecta;
import com.facturacion.excepciones.CampoFormatoIncorrecto;
import com.facturacion.excepciones.CampoNulo;
import com.facturacion.excepciones.CampoVacio;
import com.facturacion.excepciones.RegistroExistente;
import com.facturacion.validacion.form.FormProductoValidacion;
import javax.swing.DefaultComboBoxModel;

public class Form_ProductoAgregar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLitros;
	private JTextField txtStock;
	private JTextField txtPrecio;
	
	private JComboBox cmbTipoEnvase;
	private JButton btnBorrarCampos;
	
	private JLabel lblNewLabel;
	
	private static FormProducto formProducto;
	private JLabel label;
	private JTextField txtColor;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JLabel lblAplicacion;
	private JComboBox cmbAplicacion;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	

	/**
	 * Create the frame.
	 */
	public Form_ProductoAgregar(final Form_Producto formP) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombe");
		txtNombre.setColumns(10);
		txtNombre.setBounds(73, 92, 148, 19);
		contentPane.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() == 45)
					e.consume();
			}
		});
		
		JLabel lblPresentacionlitros = new JLabel("Litros");
		lblPresentacionlitros.setBounds(248, 179, 114, 15);
		contentPane.add(lblPresentacionlitros);
		
		txtLitros = new JTextField();
		txtLitros.setText("Litros");
		txtLitros.setColumns(10);
		txtLitros.setBounds(248, 199, 114, 19);
		contentPane.add(txtLitros);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(80, 305, 70, 15);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setText("stock");
		txtStock.setColumns(10);
		txtStock.setBounds(73, 326, 135, 19);
		contentPane.add(txtStock);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(248, 305, 70, 15);
		contentPane.add(lblPrecioVenta);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("Precio");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(248, 326, 114, 19);
		contentPane.add(txtPrecio);
		
		JLabel lblTipoDeEnvase = new JLabel("Tipo de envase");
		lblTipoDeEnvase.setBounds(73, 179, 113, 15);
		contentPane.add(lblTipoDeEnvase);
		
		
		String[] listaEnvase = new String[]{"Pote","Balde"};
		cmbTipoEnvase = new JComboBox(listaEnvase);
		cmbTipoEnvase.setBounds(73, 196, 136, 24);
		contentPane.add(cmbTipoEnvase);
		
		JButton btnAgregarCliente = new JButton("Agregar producto");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarProducto();
				actualizar(formP);
			}
		});
		btnAgregarCliente.setBounds(436, 92, 161, 40);
		contentPane.add(btnAgregarCliente);
		
		btnBorrarCampos = new JButton("Borrar campos");
		btnBorrarCampos.setBounds(436, 141, 161, 40);
		contentPane.add(btnBorrarCampos);
		btnBorrarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(436, 193, 161, 40);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();	
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(73, 71, 70, 15);
		contentPane.add(lblNombre);
		
		lblNewLabel = new JLabel("Agregar nuevo producto al sistema");
		lblNewLabel.setBounds(73, 23, 262, 15);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("Color");
		label.setBounds(72, 122, 70, 15);
		contentPane.add(label);
		
		txtColor = new JTextField();
		txtColor.setText("color");
		txtColor.setEnabled(true);
		txtColor.setColumns(10);
		txtColor.setBounds(72, 148, 114, 19);
		contentPane.add(txtColor);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(258, 71, 70, 15);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setText("marca");
		txtMarca.setBounds(248, 89, 114, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		lblAplicacion = new JLabel("Aplicacion");
		lblAplicacion.setBounds(80, 232, 106, 15);
		contentPane.add(lblAplicacion);
		
		cmbAplicacion = new JComboBox();
		cmbAplicacion.setModel(new DefaultComboBoxModel(new String[] {"Interior/Exterior", "Interior", "Exterior"}));
		cmbAplicacion.setBounds(73, 260, 289, 24);
		contentPane.add(cmbAplicacion);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(248, 122, 70, 15);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("codigo");
		txtCodigo.setBounds(248, 141, 114, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
	}
	
	/*
	 * 
	 */
	private void asignarJTextFields_String() {
		
		formProducto = new FormProducto();

		formProducto.setNombre(txtNombre.getText().toUpperCase().trim().toString());
		formProducto.setColor(txtColor.getText().toUpperCase().trim().toString());
		formProducto.setEnvase((String)cmbTipoEnvase.getSelectedItem().toString());
		formProducto.setPrecioVenta(txtPrecio.getText().trim().toString());
		formProducto.setMarca(txtMarca.getText().trim().toUpperCase().toString());
		formProducto.setCodigo(txtCodigo.getText().trim().toUpperCase().toString());
		formProducto.setAplicacion((String)cmbAplicacion.getSelectedItem().toString());
		formProducto.setLitros(txtLitros.getText().trim().toString());
		formProducto.setStock(txtStock.getText().trim().toString());
		formProducto.setEstado(true);
	
	}
	private void validarFormulario() throws CampoNulo, CampoVacio, CampoFormatoIncorrecto, CampoCantidadMinimaIncorrecta{
		FormProductoValidacion validacion = new FormProductoValidacion();
		validacion.validarNombre(formProducto);
		validacion.validarMarca(formProducto);
		validacion.validarColor(formProducto);
		validacion.validarPrecio(formProducto);
		validacion.validarStock(formProducto);
		validacion.validarLitros(formProducto);
	}
	
	/*
	 * Agregar producto
	 */
	private void agregar(){
		try {
			
			asignarJTextFields_String();
			
			validarFormulario();
			
			Producto pro = new Producto(formProducto);
			
			//buscar si existe un cliente con la clave ingresada
			Long id = ProductoBusqueda.getInstance().buscarIdPorObjeto(pro);
			if (id != 0)
				throw new RegistroExistente("producto", id);
			
			//guardar registro
			if (ProductoDao.getInstance().save(pro) == true) {
				JOptionPane.showMessageDialog(null, "Se guard� el registro", 
						"�xito", JOptionPane.INFORMATION_MESSAGE);
				//cierra el formulario
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "No se guard� el registro", 
						"Fallo", JOptionPane.ERROR_MESSAGE);
			}
			// TODO PREGUNTAR A MALENA, SE PUEDE PONER LOS CATCH eN UN SOLA LINEA PERO ES PARA VERSIONES 1.7
		} catch (CampoNulo ex) {
			ex.mostrarMensaje();
		} catch (CampoVacio ex) {
			ex.mostrarMensaje();
		} catch (CampoCantidadMinimaIncorrecta ex) {
			ex.mostrarMensaje();
		} catch (CampoFormatoIncorrecto ex) {
			ex.mostrarMensaje();
		} catch (RegistroExistente ex) {
			ex.mostrarMensaje();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), 
					"Error desconocido", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	
	private void agregarProducto(){
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Agregar un nuevo producto",
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			agregar();
		}	

	}
	/*
	 * Modificar producto
	 */
	private void limpiar(){
	
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Desea borrar todos los campos?\n",
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			txtNombre.setText("");
			txtColor.setText("");			
			txtPrecio.setText("");
			txtLitros.setText("");
			txtStock.setText("");
		}		
	}
	private void cancelar(){

		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Cancelar operacion?\n",
			    null,
			    JOptionPane.YES_NO_OPTION);
		if(n==0){
			dispose();
		}		
	}
	private void actualizar(Form_Producto p){
		p.llenarJtablePorNombre();
	}
}