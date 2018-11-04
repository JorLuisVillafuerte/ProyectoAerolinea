package edu.usal.interfaces;

import java.util.List;

import edu.usal.dto.Ventas;
import edu.usal.excepciones.DAOExcepcion;

public interface VentasDAO {
	public int addVentas (Ventas venta) throws DAOExcepcion;
	public int updateVentas (Ventas venta) throws DAOExcepcion;
	public int deleteVentas (Ventas venta) throws DAOExcepcion;
	public List<Ventas> getVentas() throws DAOExcepcion;
}
