package com.facturacion.formulario.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.facturacion.busquedas.ClienteBusqueda;
import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;
import com.facturacion.entitys.form.FormCliente;
import com.facturacion.excepciones.CampoCantidadMinimaIncorrecta;
import com.facturacion.excepciones.CampoFormatoIncorrecto;
import com.facturacion.excepciones.CampoNulo;
import com.facturacion.excepciones.CampoVacio;
import com.facturacion.excepciones.RegistroExistente;
import com.facturacion.validacion.form.FormClienteValidacion;

public class Form_ClienteModificar extends JFrame{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtLocalidad;
	private JTextField txtTelefono;
	private JTextField txtDescuento;
	private JTextField txtMail;
	private JTextField txtCUIT1;
	private JTextField txtCUIT2;
	private JTextField txtCUIT3;
	private JComboBox cmbTipoCliente;

	private static FormCliente formCliente;
	private Long id;
	private float deuda;

	/**
	 * Create the frame.
	 */
	//public Form_ClienteModificar(String identficiacion) {

		//final String CUIT = identficiacion;
	public Form_ClienteModificar(final Form_Cliente padre) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_11 = new JLabel("CUIL-CUIT");
		label_11.setBounds(56, 61, 70, 15);
		contentPane.add(label_11);
				
		JLabel label_12 = new JLabel("Nombre");
		label_12.setBounds(58, 132, 70, 15);
		contentPane.add(label_12);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombe");
		txtNombre.setColumns(10);
		txtNombre.setBounds(56, 155, 135, 19);
		contentPane.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() == 45)
					e.consume();
			}
		});
		
		JLabel label_13 = new JLabel("Apellido");
		label_13.setBounds(228, 132, 70, 15);
		contentPane.add(label_13);
		
		txtApellido = new JTextField();
		txtApellido.setText("apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(224, 151, 114, 19);
		contentPane.add(txtApellido);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellido.getText().length() == 45)
					e.consume();
			}
		});
		
		JLabel label_14 = new JLabel("Direccion");
		label_14.setBounds(61, 199, 70, 15);
		contentPane.add(label_14);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("Direccion");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(58, 224, 135, 19);
		contentPane.add(txtDireccion);
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() == 45)
					e.consume();
			}
		});
		
		JLabel label_15 = new JLabel("Localidad");
		label_15.setBounds(229, 201, 70, 15);
		contentPane.add(label_15);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setText("Localidad");
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(229, 221, 114, 19);
		contentPane.add(txtLocalidad);
		txtLocalidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtLocalidad.getText().length() == 45)
					e.consume();
			}
		});	
		
		JLabel label_16 = new JLabel("Telefono");
		label_16.setBounds(63, 264, 70, 15);
		contentPane.add(label_16);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(59, 292, 129, 19);
		contentPane.add(txtTelefono);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() == 15)
					e.consume();
			}
		});
		
		JLabel label_17 = new JLabel("Descuento");
		label_17.setBounds(399, 52, 95, 19);
		contentPane.add(label_17);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("descuento");
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(395, 88, 135, 19);
		contentPane.add(txtDescuento);

		JLabel label_18 = new JLabel("Tipo de cliente");
		label_18.setBounds(220, 55, 113, 15);
		contentPane.add(label_18);
		
		String[] listaCliente = new String[]{"Responsable inscripto","No responsable","No responsable","Exento","Consumidor final","Responsable monotributista"};
		cmbTipoCliente = new JComboBox(listaCliente);
		cmbTipoCliente.setBounds(216, 82, 136, 24);
		contentPane.add(cmbTipoCliente);
		
		JLabel label_19 = new JLabel("Mail");
		label_19.setBounds(231, 269, 70, 15);
		contentPane.add(label_19);
		
		txtMail = new JTextField();
		txtMail.setText("Mail");
		txtMail.setColumns(10);
		txtMail.setBounds(227, 298, 114, 19);
		contentPane.add(txtMail);
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMail.getText().length() <= 45)
					e.consume();
			}
		});
		
		txtCUIT1 = new JTextField();
		txtCUIT1.setColumns(10);
		txtCUIT1.setBounds(54, 90, 23, 19);
		contentPane.add(txtCUIT1);
		txtCUIT1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT1.getText().length() == 2) {
					e.consume();
				}
			}
		});	
		
		txtCUIT2 = new JTextField();
		txtCUIT2.setColumns(10);
		txtCUIT2.setBounds(83, 88, 82, 19);
		contentPane.add(txtCUIT2);
		txtCUIT2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT2.getText().length() == 9) {
					e.consume();
				}
			}
		});	
		txtCUIT3 = new JTextField();
		txtCUIT3.setText("");
		txtCUIT3.setColumns(10);
		txtCUIT3.setBounds(170, 85, 23, 19);
		contentPane.add(txtCUIT3);
		txtCUIT3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT3.getText().length() == 1) {
					e.consume();
				}
			}
		});	
		JLabel label_20 = new JLabel("Agregar nuevo cliente al sistema");
		label_20.setBounds(53, 12, 239, 15);
		contentPane.add(label_20);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(433, 191, 117, 25);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarCliente();
				actualizar(padre);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(433, 283, 117, 25);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();	
			}
		});
		
		JButton btnBorrarCampos = new JButton("Borrar campos");
		btnBorrarCampos.setBounds(433, 234, 117, 25);
		contentPane.add(btnBorrarCampos);
		btnBorrarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();	
			}
		});
		obtenerRegistroModificar(padre.table);
	}
	/*
	 * Obtener datos para modificar
	 */
	private void obtenerRegistroModificar(JTable tabla){
		
		List<Cliente> lista = ClienteDao.getInstance().getAll();
		for(Cliente cliente : lista){
			if( cliente.getCUITCUIL().equals((tabla.getValueAt(tabla.getSelectedRow(), 0)).toString())){
				this.id = cliente.getId();
				txtCUIT1.setText(cliente.getCUITCUIL().substring(0,2));
				txtCUIT2.setText(cliente.getCUITCUIL().substring(3,12));
				txtCUIT3.setText(cliente.getCUITCUIL().substring(13,14));
				txtNombre.setText(cliente.getNombre());
				txtApellido.setText(cliente.getApellido());
				txtDireccion.setText(cliente.getDireccion());
				txtLocalidad.setText(cliente.getLocalidad());
				txtTelefono.setText(cliente.getTelefono());
				txtMail.setText(cliente.getMail());
				txtDescuento.setText(String.valueOf(cliente.getDescuento()));
				deuda = cliente.getDeuda();// DEUDA ? 
				cmbTipoCliente.setSelectedItem(cliente.getAfiliacionSocial());
			}	
		}
	}

	/*
	 * ASIGNAR VALORES DE LOS JTEXTFIELD
	 *
	 */
	
	private void asignarJTextFields_String() {
		
		formCliente = new FormCliente();
		formCliente.setId(id);
		formCliente.setClaveParte1(txtCUIT1.getText().toString());
		formCliente.setClaveParte2(txtCUIT2.getText().toString());
		formCliente.setClaveParte3(txtCUIT3.getText().toString());
		formCliente.setNombre(txtNombre.getText().toUpperCase().trim().toString());
		formCliente.setApellido(txtApellido.getText().toUpperCase().trim().toString());
		formCliente.setDireccion(txtDireccion.getText().toUpperCase().trim().toString());
		formCliente.setLocalidad(txtLocalidad.getText().toUpperCase().trim().toString());
		formCliente.setTelefono(txtTelefono.getText().trim().toString());
		formCliente.setMail(txtMail.getText().toUpperCase().trim().toString());
		formCliente.setAfiliacionSocial((String)cmbTipoCliente.getSelectedItem().toString());
		formCliente.setDeuda(String.valueOf(deuda));
		formCliente.setDescuento(txtDescuento.getText().trim().toString());
		formCliente.setEstado(true);
	
	}
	private void validarFormulario() throws CampoNulo, CampoVacio, CampoFormatoIncorrecto, CampoCantidadMinimaIncorrecta{
		FormClienteValidacion validacion = new FormClienteValidacion();
		validacion.validarFormulario_Clave(formCliente);
		validacion.validarFormulario_Nombre(formCliente);
		validacion.validarFormulario_Apellido(formCliente);
		validacion.validarFormulario_Telefono(formCliente);
		//validacion.validarFormulario_Localidad(formCliente);
		validacion.validarFormulario_Descuento(formCliente);
		//validacion.validarFormulario_Deuda(formCliente);
		validacion.validarFormulario_Mail(formCliente);
	}
	private void modificarCliente(){
		try {
			
			asignarJTextFields_String();
			
			validarFormulario();
			
			Cliente cliente = new Cliente(formCliente,id);
			
			//buscar si existe un cliente con la clave ingresada
			Long id = ClienteBusqueda.getInstance().buscarIdPorObjeto(cliente);
			if (id != 0)
				throw new RegistroExistente("cliente", id);
			
			//guardar registro
			if (ClienteDao.getInstance().update(cliente) == true) {
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
	private void cancelar(){
		dispose();
	}
	private void limpiar(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtLocalidad.setText("");
		txtTelefono.setText("");
		txtDescuento.setText("");
		txtMail.setText("");
		txtCUIT1.setText("");
		txtCUIT2.setText("");
		txtCUIT3.setText("");
	}
	private void actualizar(Form_Cliente p ){
		p.llenarJtablePorNombre();
		
	}
}
		
		