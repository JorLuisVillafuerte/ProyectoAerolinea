package edu.usal.factory;


import edu.usal.implementacionJDBC.VuelosImpJDBC;
import edu.usal.interfaces.VuelosDAO;

public class VuelosFactory {


	public static VuelosDAO getVuelosDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new VuelosImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new VuelosImpJDBC();
		}
		return null;
	}

}
