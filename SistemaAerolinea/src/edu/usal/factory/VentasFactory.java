package edu.usal.factory;

import edu.usal.implementacionFile.VentasImpFile;
import edu.usal.interfaces.VentasDAO;

public class VentasFactory {
	

	public static VentasDAO getVentasDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			return new VentasImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			//return new VentasImpDB();
		}
		return null;
	}

}
