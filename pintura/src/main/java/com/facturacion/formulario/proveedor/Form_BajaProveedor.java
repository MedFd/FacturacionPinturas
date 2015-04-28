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




import com.facturacion.swingworker.ListaProveedores_Busqueda;
import com.facturacion.busquedas.ProveedorBusqueda;
import com.facturacion.validacion.form.ProveedorValidacion;
import com.facturacion.dao.ProveedorDao;
import com.facturacion.entitys.Proveedor;
import com.facturacion.entitys.form.FormProveedor;
import com.facturacion.excepciones.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Form_BajaProveedor extends JFrame {

	private JPanel panel;
	private JTextField txtClave1;
	private JTextField txtClave2;
	private JTextField txtClave3;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtNombreBuscar;
	
	private static FormProveedor formProveedor;
	
	private Long id;
	

	private DefaultListModel modeloLista = new DefaultListModel();
	private JList lstResultadoBusqueda;

	/**
	 * Create the frame.
	 */
	public Form_BajaProveedor() {
		setTitle("Baja proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 432);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		pasarFoco();

		JLabel lblBajaProveedor = new JLabel(
				"Baja proveedor");
		lblBajaProveedor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBajaProveedor.setBounds(195, 0, 171, 34);
		panel.add(lblBajaProveedor);

		JLabel lblCuitcuil = new JLabel("CUIT-CUIL:");
		lblCuitcuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCuitcuil.setBounds(10, 155, 67, 14);
		panel.add(lblCuitcuil);

		txtClave1 = new JTextField();
		txtClave1.setEditable(false);
		txtClave1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave1.getText().length() == 2) {
					e.consume();
				}
			}
		});
		txtClave1.setBounds(91, 155, 42, 20);
		panel.add(txtClave1);
		txtClave1.setColumns(10);

		txtClave2 = new JTextField();
		txtClave2.setEditable(false);
		txtClave2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave2.getText().length() == 9) {
					e.consume();
				}
			}
		});
		txtClave2.setColumns(10);
		txtClave2.setBounds(143, 155, 99, 20);
		panel.add(txtClave2);

		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(244, 156, 14, 14);
		panel.add(label_1);

		txtClave3 = new JTextField();
		txtClave3.setEditable(false);
		txtClave3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave3.getText().length() == 1) {
					e.consume();
				}
			}
		});
		txtClave3.setColumns(10);
		txtClave3.setBounds(252, 155, 42, 20);
		panel.add(txtClave3);

		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 192, 67, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() == 45)
					e.consume();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(91, 190, 126, 20);
		panel.add(txtNombre);

		JLabel lblDireccion = new JLabel("DIRECCI\u00D3N:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(10, 223, 99, 14);
		panel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() == 45)
					e.consume();
			}
		});
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(91, 223, 126, 20);
		panel.add(txtDireccion);

		JLabel lblTelfono = new JLabel("TEL\u00C9FONO:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelfono.setBounds(10, 262, 67, 14);
		panel.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() == 15)
					e.consume();
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(91, 262, 126, 20);
		panel.add(txtTelefono);

		JLabel label = new JLabel("-");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(135, 156, 14, 14);
		panel.add(label);

		JButton btnEliminar = new JButton("Eliminar");
		// evento click del boton Aceptar
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					asignarJTextFields_String();

					// "Borrar" registro
					
					Integer respuesta = JOptionPane.showConfirmDialog(null, "Est� seguro de eliminar?", "Alerta", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					//0: para si
					//1: para no
					
					if (respuesta == 0) {
						Proveedor prov = new Proveedor(formProveedor,id);
						ProveedorDao.getInstance().update(prov);
						JOptionPane.showMessageDialog(null,
						"Se elimin� el registro", "�xito",
						JOptionPane.INFORMATION_MESSAGE);

					}
					

				} 
					catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"Error desconocido", JOptionPane.ERROR_MESSAGE);
				}
				// fin try-catch
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(62, 308, 89, 23);
		panel.add(btnEliminar);

		JLabel lblSeleccione = new JLabel("SELECCIONE:");
		lblSeleccione.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccione.setBounds(328, 45, 99, 14);
		panel.add(lblSeleccione);

		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseNombre.setBounds(10, 56, 123, 14);
		panel.add(lblIngreseNombre);

		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setColumns(10);
		txtNombreBuscar.setBounds(120, 54, 126, 20);
		panel.add(txtNombreBuscar);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(315, 43, 14, 276);
		panel.add(separator);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// trae los resultados filtrados con el patron ingresado
				try {
	
					txtNombreBuscar.setText(txtNombreBuscar.getText().trim());
					String patron = txtNombreBuscar.getText().toUpperCase();
					ListaProveedores_Busqueda lpb = new ListaProveedores_Busqueda(
							patron, modeloLista, lstResultadoBusqueda);
					lpb.execute();


				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(119, 83, 89, 23);
		panel.add(btnBuscar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 140, 307, 7);
		panel.add(separator_1);

		lstResultadoBusqueda = new JList();
		lstResultadoBusqueda
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int indice = lstResultadoBusqueda.getSelectedIndex();
						if (indice != -1) {
							Proveedor seleccionado = (Proveedor) modeloLista
									.getElementAt(indice);

							String[] clavePartida = seleccionado.getClave()
									.split("-");

							txtClave1.setText(clavePartida[0]);
							txtClave2.setText(clavePartida[1]);
							txtClave3.setText(clavePartida[2]);

							txtNombre.setText(seleccionado.getNombre());
							txtDireccion.setText(seleccionado.getDireccion());
							txtTelefono.setText(seleccionado.getTelefono());
							
							id = seleccionado.getId();
						}
					}
				});
		lstResultadoBusqueda.setModel(modeloLista);
		lstResultadoBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lstResultadoBusqueda.setVisibleRowCount(12);
		lstResultadoBusqueda
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane panelDesplazamiento = new JScrollPane(lstResultadoBusqueda);
		panelDesplazamiento.setBounds(328, 100, 286, 263);
		panel.add(panelDesplazamiento);

	}

	/**
	 * Funciones propias del formulario
	 */
	private void pasarFoco() {
		// Conjunto de teclas que queremos que sirvan para pasar el foco
		// al siguiente campo de texto: ENTER y TAB
		Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
		// teclas.add(AWTKeyStroke.getAWTKeyStroke(
		// KeyEvent.VK_ENTER, 0));
		teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_TAB, 0));

		// Se pasa el conjunto de teclas al panel principal
		getContentPane().setFocusTraversalKeys(
				KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, teclas);
	}

	private void asignarJTextFields_String() {
		formProveedor = new FormProveedor();
		
		formProveedor.setClaveParte1(txtClave1.getText());
		formProveedor.setClaveParte2(txtClave2.getText());
		formProveedor.setClaveParte3(txtClave3.getText());
		formProveedor.setNombre(txtNombre.getText().toUpperCase().trim());
		formProveedor.setDireccion(txtDireccion.getText().toUpperCase().trim());
		formProveedor.setTelefono(txtTelefono.getText().trim());
		formProveedor.setEstado(false);
		
	}



}