package com.facturacion.formulario.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
import com.facturacion.validacion.form.FormProveedorValidacion;


public class Form_AltaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCUIT1;
	private JTextField txtCUIT2;
	private JTextField txtCUIT3;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtLocalidad;
	private JTextField txtDescuento;
	private JTextField txtTelefono;
	private JComboBox<String>  cmbAfiliacion;
	/*
	 * JTEXTFIELD SE GUARDA EN ESTAS VARIABLES
	 */
	private static FormCliente formCliente;

	
	/**
	 * Create the frame.
	 */
	public Form_AltaCliente() {
		setTitle("Alta cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlta = new JLabel("Registro de clientes");
		lblAlta.setBounds(46, 12, 153, 31);
		contentPane.add(lblAlta);
		
		JLabel lblCuilcuit = new JLabel("CUIL-CUIT");
		lblCuilcuit.setBounds(56, 51, 70, 15);
		contentPane.add(lblCuilcuit);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(66, 84, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(56, 111, 70, 15);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(56, 138, 70, 15);
		contentPane.add(lblDireccion);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(56, 165, 70, 15);
		contentPane.add(lblLocalidad);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(56, 192, 70, 15);
		contentPane.add(lblTelefono);
		
		JLabel lblTipoDeCliente = new JLabel("Tipo de cliente");
		lblTipoDeCliente.setBounds(56, 273, 113, 15);
		contentPane.add(lblTipoDeCliente);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(53, 224, 95, 19);
		contentPane.add(lblDescuento);
		
		txtCUIT1 = new JTextField();
		txtCUIT1.setBounds(144, 49, 20, 19);
		contentPane.add(txtCUIT1);
		txtCUIT1.setColumns(10);
		txtCUIT1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT1.getText().length() == 2) {
					e.consume();
				}
			}
		});		
		txtCUIT2 = new JTextField();
		txtCUIT2.setBounds(170, 49, 90, 19);
		contentPane.add(txtCUIT2);
		txtCUIT2.setColumns(10);
		txtCUIT2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT2.getText().length() == 9) {
					e.consume();
				}
			}
		});	
		
		txtCUIT3 = new JTextField();
		txtCUIT3.setBounds(264, 49, 20, 19);
		contentPane.add(txtCUIT3);
		txtCUIT3.setColumns(10);
		txtCUIT3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCUIT3.getText().length() == 1) {
					e.consume();
				}
			}
		});	
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(144, 82, 150, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() == 45)
					e.consume();
			}
		});
		
		txtApellido = new JTextField();
		txtApellido.setText("apellido");
		txtApellido.setBounds(144, 109, 150, 19);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellido.getText().length() == 45)
					e.consume();
			}
		});
		
		txtDireccion = new JTextField();
		txtDireccion.setText("Direccion");
		txtDireccion.setBounds(144, 136, 150, 19);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() == 45)
					e.consume();
			}
		});
		
		txtLocalidad = new JTextField();
		txtLocalidad.setText("Localidad");
		txtLocalidad.setBounds(144, 163, 150, 19);
		contentPane.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		txtLocalidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() == 45)
					e.consume();
			}
		});		
		txtDescuento = new JTextField();
		txtDescuento.setText("descuento");
		txtDescuento.setBounds(144, 224, 150, 19);
		contentPane.add(txtDescuento);
		txtDescuento.setColumns(10);
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() <= 3)
					e.consume();
			}
		});
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setBounds(144, 190, 150, 19);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() == 15)
					e.consume();
			}
		});
		
		String[] listaCliente = new String[]{"Responsable inscripto","No responsable","No responsable","Exento","Consumidor final","Responsable monotributista"};

		cmbAfiliacion = new JComboBox<String> (listaCliente);
		cmbAfiliacion.setBounds(181, 268, 200, 24);
		contentPane.add(cmbAfiliacion);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(46, 323, 117, 46);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					asignarJTextFields_String();
					
					//validarFormulario();
					
					Cliente cliente = new Cliente(formCliente);
					
					
					//buscar si existe un cliente con la clave ingresada
					Long id = ClienteBusqueda.getInstance().buscarIdPorObjeto(cliente);
					if (id != 0)
						throw new RegistroExistente("cliente", id);
					
					//guardar registro
					if (ClienteDao.getInstance().save(cliente) == true) {
						JOptionPane.showMessageDialog(null, "Se guard� el registro", 
								"�xito", JOptionPane.INFORMATION_MESSAGE);
						//cierra el formulario
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se guard� el registro", 
								"Fallo", JOptionPane.ERROR_MESSAGE);
					}
//				} catch (CampoNulo ex) {
//					ex.mostrarMensaje();
//				} catch (CampoVacio ex) {
//					ex.mostrarMensaje();
//				} catch (CampoCantidadMinimaIncorrecta ex) {
//					ex.mostrarMensaje();
//				} catch (CampoFormatoIncorrecto ex) {
//					ex.mostrarMensaje();
//				} catch (RegistroExistente ex) {
//					ex.mostrarMensaje();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), 
							"Error desconocido", JOptionPane.ERROR_MESSAGE);
				} 
				//fin try-catch
			}
		});
		
		
		
		
		
		
		JButton btnBorrarCampos = new JButton("Reset");
		btnBorrarCampos.setBounds(181, 323, 117, 46);
		contentPane.add(btnBorrarCampos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(310, 323, 117, 46);
		contentPane.add(btnCancelar);
	}
	
	/*
	 * ASIGNAR VALORES DE LOS JTEXTFIELD
	 *
	 */
	
	private void asignarJTextFields_String() {
		
		formCliente = new FormCliente();
		formCliente.setClaveParte1(txtCUIT1.getText().toString());
		formCliente.setClaveParte2(txtCUIT2.getText().toString());
		formCliente.setClaveParte3(txtCUIT3.getText().toString());
		formCliente.setNombre(txtNombre.getText().toUpperCase().trim().toString());
		formCliente.setApellido(txtApellido.getText().toUpperCase().trim().toString());
		formCliente.setDireccion(txtDireccion.getText().toUpperCase().trim().toString());
		formCliente.setLocalidad(txtLocalidad.getText().toUpperCase().trim().toString());
		formCliente.setTelefono(txtTelefono.getText().trim().toString());
	//	formCliente.setMail(mail);
		formCliente.setAfiliacionSocial((String)cmbAfiliacion.getSelectedItem().toString());
	//	formCliente.setDeuda(deuda);
		formCliente.setDescuento(txtDescuento.getText().trim().toString());
		formCliente.setEstado(true);
	
	}
	

	
	private void validarFormulario() throws CampoNulo, CampoVacio, CampoFormatoIncorrecto, CampoCantidadMinimaIncorrecta{
		FormClienteValidacion validacion = new FormClienteValidacion();
		validacion.validarFormulario_Clave(formCliente);
		validacion.validarFormulario_Nombre(formCliente);
		validacion.validarFormulario_Apellido(formCliente);
		validacion.validarFormulario_Telefono(formCliente);
		validacion.validarFormulario_Localidad(formCliente);
		validacion.validarFormulario_Descuento(formCliente);
		validacion.validarFormulario_Deuda(formCliente);
		validacion.validarFormulario_Mail(formCliente);
	}
	/*
	 * FIN DEL PROGRAMA
	 */
	
	
	
	
	
	
	
	

}
