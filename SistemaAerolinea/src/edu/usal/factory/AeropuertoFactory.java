package edu.usal.factory;

import edu.usal.implementacionJDBC.AeropuertoImpJDBC;
import edu.usal.interfaces.AeropuertoDAO;

public class AeropuertoFactory {

	public static AeropuertoDAO getAeropuertoDAO(String data) {

		if(data.equalsIgnoreCase("file")) {
			//return new AeropuertoImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new AeropuertoImpJDBC();
		}
		return null;
	}
}
