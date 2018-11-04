package edu.usal.factory;

import edu.usal.implementacionFile.VuelosImpFile;
import edu.usal.interfaces.VuelosDAO;

public class VuelosFactory {


	public static VuelosDAO getVuelosDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			return new VuelosImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			//return new VuelosImpDB();
		}
		return null;
	}

}
