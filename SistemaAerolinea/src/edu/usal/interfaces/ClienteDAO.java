package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.Cliente;
import edu.usal.excepciones.DAOExcepcion;

public interface ClienteDAO {
	
	public int addCliente (Cliente cliente) throws DAOExcepcion;
	public int updateCliente (Cliente cliente) throws DAOExcepcion;
	public int deleteCliente (Cliente cliente) throws DAOExcepcion;
	public List<Cliente> getClientes() throws DAOExcepcion;
	
}
