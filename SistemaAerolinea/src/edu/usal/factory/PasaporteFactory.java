package edu.usal.factory;

import edu.usal.implementacionJDBC.PasaporteImpJDBC;
import edu.usal.interfaces.PasaporteDAO;

public class PasaporteFactory {
	
	public static PasaporteDAO getPasaporteDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new PasaporteImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new PasaporteImpJDBC();
		}
		return null;
	}

}
