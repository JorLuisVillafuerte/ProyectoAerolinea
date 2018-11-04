package edu.usal.factory;

import edu.usal.implementacionJDBC.DireccionImpJDBC;
import edu.usal.interfaces.DireccionDAO;

public class DireccionFactory {
	
	public static DireccionDAO getDireccionDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new DireccionImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new DireccionImpJDBC();
		}
		return null;
	}

}
