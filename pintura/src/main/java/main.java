import java.util.ArrayList;

import com.facturacion.dao.ClienteDoa;
import com.facturacion.entitys.Cliente;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Cliente cliente = new Cliente();
		cliente.setCUIL(1);
		cliente.setApellido("uno");
		cliente.setDescuento(1);
		cliente.setDireccion("direccion");
		cliente.setEstado(true);
		cliente.setLocalidad("localidad");
		cliente.setNombre("nombre");
		cliente.setTelefono("telefono");
		cliente.setTipoCliente("tipo");
		
		System.out.println("INSERTAR EN LA BASE DE DATOS");
		ClienteDoa.getInstance().save(cliente);
		
		System.out.println("SELECT FROM BASE DE DATOS");		
		ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) ClienteDoa.getInstance().getAll();
		for (Cliente clienteSolo : listaCliente) {
			System.out.println(clienteSolo.getNombre() + " " + clienteSolo.getApellido());
		}
		
		cliente.setApellido("APELLDIODOS");
		cliente.setNombre("NombreDos");
		ClienteDoa.getInstance().update(cliente);
		
		System.out.println("SELECT FROM BASE DE DATOS");		
		ArrayList<Cliente> listaCliente2 = (ArrayList<Cliente>) ClienteDoa.getInstance().getAll();
		for (Cliente clienteSolo : listaCliente2) {
			System.out.println(clienteSolo.getNombre() + " " + clienteSolo.getApellido());
		}
		
		System.out.println("BORRAR DE LA BASE DE DATOS");		
		ClienteDoa.getInstance().delete(cliente);
	}

}
