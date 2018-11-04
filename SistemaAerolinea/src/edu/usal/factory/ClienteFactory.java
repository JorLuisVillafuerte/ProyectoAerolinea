package edu.usal.factory;

import edu.usal.implementacionFile.ClienteImpFile;
import edu.usal.interfaces.ClienteDAO;

public class ClienteFactory {
	
	public static ClienteDAO getClienteDAO(String data) {

		if(data.equalsIgnoreCase("stream")) {
			return new ClienteImpFile();
		}else if(data.equalsIgnoreCase("db")) {
			//return new ClienteImpDB();
		}
		return null;
	}
}
