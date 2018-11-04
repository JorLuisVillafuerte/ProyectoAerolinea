package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.LineasAereas;
import edu.usal.excepciones.DAOExcepcion;

public interface LineasAereasDAO {
	
	public int addLineasAereas (LineasAereas aero) throws DAOExcepcion;
	public int updateLineasAereas (LineasAereas aero) throws DAOExcepcion;
	public int deleteLineasAereas (LineasAereas aero) throws DAOExcepcion;
	public List<LineasAereas> getLineasAereas() throws DAOExcepcion;

}
