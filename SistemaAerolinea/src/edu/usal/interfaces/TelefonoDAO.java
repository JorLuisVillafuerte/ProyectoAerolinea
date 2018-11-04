package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.Telefono;
import edu.usal.excepciones.DAOExcepcion;

public interface TelefonoDAO {
	public int addTelefono (Telefono tel) throws DAOExcepcion;
	public int updateTelefono (Telefono tel) throws DAOExcepcion;
	public int deleteTelefono (Telefono tel) throws DAOExcepcion;
	public List<Telefono> getTelefonos() throws DAOExcepcion;
}
