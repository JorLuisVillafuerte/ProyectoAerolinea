package edu.usal.factory;

import edu.usal.implementacionJDBC.PasajeroFrecuenteImpJDBC;
import edu.usal.interfaces.PasajeroFrecuenteDAO;

public class PasajeroFrecuenteFactory {

	public static PasajeroFrecuenteDAO getPasajeroFrecuenteDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new PasajeroFrecuenteImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new PasajeroFrecuenteImpJDBC();
		}
		return null;
	}

}
