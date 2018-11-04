package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.Aeropuerto;
import edu.usal.excepciones.DAOExcepcion;

public interface AeropuertoDAO {
	public int addAeropuerto (Aeropuerto aero) throws DAOExcepcion;
	public int updateAeropuerto (Aeropuerto aero) throws DAOExcepcion;
	public int deleteAeropuerto (Aeropuerto aero) throws DAOExcepcion;
	public List<Aeropuerto> getAeropuerto() throws DAOExcepcion;
}
