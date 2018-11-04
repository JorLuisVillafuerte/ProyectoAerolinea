package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.Vuelos;
import edu.usal.excepciones.DAOExcepcion;

public interface VuelosDAO {
	
	public int addVuelos (Vuelos vuelo) throws DAOExcepcion;
	public int updateVuelos (Vuelos vuelo) throws DAOExcepcion;
	public int deleteVuelos (Vuelos vuelo) throws DAOExcepcion;
	public List<Vuelos> getVuelos() throws DAOExcepcion;

}
