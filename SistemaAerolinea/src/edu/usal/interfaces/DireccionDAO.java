package edu.usal.interfaces;

import java.util.List;
import edu.usal.dto.Direccion;
import edu.usal.excepciones.DAOExcepcion;

public interface DireccionDAO {
	public int addDireccion (Direccion dir) throws DAOExcepcion;
	public int updateDireccion (Direccion dir) throws DAOExcepcion;
	public int deleteDireccion (Direccion dir) throws DAOExcepcion;
	public List<Direccion> getDirecciones() throws DAOExcepcion;
}
