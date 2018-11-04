package edu.usal.factory;


import edu.usal.implementacionJDBC.TelefonoImpJDBC;
import edu.usal.interfaces.TelefonoDAO;

public class TelefonoFactory {

	public static TelefonoDAO getPasaporteDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new TelefonoImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new TelefonoImpJDBC();
		}
		return null;
	}

}
