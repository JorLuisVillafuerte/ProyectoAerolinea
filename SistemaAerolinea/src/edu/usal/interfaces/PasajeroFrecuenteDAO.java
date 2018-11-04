package edu.usal.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.dto.PasajeroFrecuente;
import edu.usal.excepciones.DAOExcepcion;

public interface PasajeroFrecuenteDAO {
	public int addPasajeroFrecuente (PasajeroFrecuente pf) throws DAOExcepcion;
	public int updatePasajeroFrecuente (PasajeroFrecuente pf) throws DAOExcepcion;
	public int deletePasajeroFrecuente (PasajeroFrecuente pf) throws DAOExcepcion;
	public List<PasajeroFrecuente> getPasajeroFrecuente() throws DAOExcepcion;
	
}
