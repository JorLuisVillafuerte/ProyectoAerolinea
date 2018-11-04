package edu.usal.util;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtil {

	//Metodo para cargar los valores del archivo properties
	//Se utiliza en la clase conexionDB
	public static Properties cargarProperties(String nombre_properties) {
		Properties prop = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(nombre_properties);
		Enumeration e = bundle.getKeys();
		String key = null;
		while(e.hasMoreElements()) {
			key = (String) e.nextElement();
			prop.put(key,bundle.getObject(key));
		}
		return prop;
	}
}
