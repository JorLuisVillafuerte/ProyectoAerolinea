package edu.usal.interfaces;


import java.util.List;
import edu.usal.dto.Pasaporte;
import edu.usal.excepciones.DAOExcepcion;

public interface PasaporteDAO {
	public int addPasaporte (Pasaporte pas) throws DAOExcepcion;
	public int updatePasaporte (Pasaporte pas) throws DAOExcepcion;
	public int deletePasaporte (Pasaporte pas) throws DAOExcepcion;
	public List<Pasaporte> getPasaportes() throws DAOExcepcion;
}
