package com.facturacion.formulario.proveedor;

import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.facturacion.busquedas.ProveedorBusqueda;
import com.facturacion.validacion.form.FormProveedorValidacion;
import com.facturacion.validacion.form.ProveedorValidacion;
import com.facturacion.dao.ProveedorDao;
import com.facturacion.entitys.Proveedor;
import com.facturacion.entitys.form.FormProveedor;
import com.facturacion.excepciones.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Form_AltaProveedor extends JFrame {

	private JPanel panel;
	private JTextField txtClave1;
	private JTextField txtClave2;
	private JTextField txtClave3;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	private static FormProveedor formProveedor;

	/**
	 * Create the frame.
	 */
	public Form_AltaProveedor() {
		setTitle("Alta proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		pasarFoco();
		
		JLabel lblAltaProveedor = new JLabel("Alta proveedor");
		lblAltaProveedor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAltaProveedor.setBounds(10, 11, 156, 34);
		panel.add(lblAltaProveedor);
		
		JLabel lblCuitcuil = new JLabel("CUIT-CUIL:");
		lblCuitcuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCuitcuil.setBounds(10, 56, 67, 14);
		panel.add(lblCuitcuil);
		
		txtClave1 = new JTextField();
		txtClave1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave1.getText().length() == 2) {
					e.consume();
				}
			}
		});
		txtClave1.setBounds(91, 56, 42, 20);
		panel.add(txtClave1);
		txtClave1.setColumns(10);
		
		txtClave2 = new JTextField();
		txtClave2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave2.getText().length() == 9) {
					e.consume();
				}
			}
		});
		txtClave2.setColumns(10);
		txtClave2.setBounds(143, 56, 99, 20);
		panel.add(txtClave2);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(244, 57, 14, 14);
		panel.add(label_1);
		
		txtClave3 = new JTextField();
		txtClave3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave3.getText().length() == 1) {
					e.consume();
				}
			}
		});
		txtClave3.setColumns(10);
		txtClave3.setBounds(252, 56, 42, 20);
		panel.add(txtClave3);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 93, 67, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() == 45)
					e.consume();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(91, 91, 126, 20);
		panel.add(txtNombre);
		
		JLabel lblDireccion = new JLabel("DIRECCI\u00D3N:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(10, 124, 99, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() == 45)
					e.consume();
			}
		});
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(91, 124, 126, 20);
		panel.add(txtDireccion);
		
		JLabel lblTelfono = new JLabel("TEL\u00C9FONO:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelfono.setBounds(10, 163, 67, 14);
		panel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() == 15)
					e.consume();
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(91, 163, 126, 20);
		panel.add(txtTelefono);
		
		JLabel label = new JLabel("-");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(135, 57, 14, 14);
		panel.add(label);
		
		JButton btnAceptar = new JButton("Aceptar");
		//evento click del boton Aceptar
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Asigna los valores que al formProveedor
					asignarJTextFields_String();
					
					// Tira las excepciones si algo esta mal
					validarFormulario();
			
					// El contructori recibe formProveedor
					Proveedor prov = new Proveedor(formProveedor);
					
					//buscar si existe un cliente con la clave ingresada
					Long id = ProveedorBusqueda.getInstance().buscarIdPorObjeto(prov);
					if (id != 0)
						throw new RegistroExistente("proveedor", id);
					
					//guardar registro
					if (ProveedorDao.getInstance().save(prov) == true) {
						JOptionPane.showMessageDialog(null, "Se guard� el registro", 
								"�xito", JOptionPane.INFORMATION_MESSAGE);
						//cierra el formulario
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se guard� el registro", 
								"Fallo", JOptionPane.ERROR_MESSAGE);
					}
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
				//fin try-catch
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(62, 209, 89, 23);
		panel.add(btnAceptar);
		
		
	}

	/**
	 * Funciones propias del formulario
	 */
	private void pasarFoco() {
		// Conjunto de teclas que queremos que sirvan para pasar el foco 
        // al siguiente campo de texto: ENTER y TAB
        Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
//        teclas.add(AWTKeyStroke.getAWTKeyStroke(
//                KeyEvent.VK_ENTER, 0));
        teclas.add(AWTKeyStroke.getAWTKeyStroke(
                KeyEvent.VK_TAB, 0));

		// Se pasa el conjunto de teclas al panel principal 
        getContentPane().setFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, 
                teclas);
	}
	
	private void asignarJTextFields_String() {
		
		formProveedor = new FormProveedor();
		formProveedor.setClaveParte1(txtClave1.getText());
		formProveedor.setClaveParte2(txtClave2.getText());
		formProveedor.setClaveParte3(txtClave3.getText());
		formProveedor.setNombre(txtNombre.getText().toUpperCase().trim());
		formProveedor.setDireccion(txtDireccion.getText().toUpperCase().trim());
		formProveedor.setTelefono(txtTelefono.getText().trim());
		formProveedor.setEstado(true);
	}

	private void validarFormulario() throws CampoNulo, CampoVacio, CampoFormatoIncorrecto, CampoCantidadMinimaIncorrecta{
		FormProveedorValidacion validacion = new FormProveedorValidacion();
		validacion.validarFormulario_Clave(formProveedor);
		validacion.validarFormulario_Nombre(formProveedor);
		validacion.validarFormulario_Telefono(formProveedor);
		
	}
	
}
