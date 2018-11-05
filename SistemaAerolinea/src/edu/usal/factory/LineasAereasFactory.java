package edu.usal.factory;

import edu.usal.implementacionJDBC.LineasAereasImpJDBC;
import edu.usal.interfaces.LineasAereasDAO;

public class LineasAereasFactory {

	public static LineasAereasDAO getLineasAereasDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			//return new LineasAereasImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			return new LineasAereasImpJDBC();
		}
		return null;
	}

}
