package edu.usal.implementacionJDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Telefono;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.TelefonoDAO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TelefonoDAO tel = new TelefonoImpJDBC();
			Telefono tele = new Telefono(1,"11","1155232058","1155232058");
			ArrayList<Telefono> lista = (ArrayList<Telefono>) tel.getTelefonos();
			for(Telefono a: lista) {
				System.out.println(a.getNumeroCelular());
			}
			
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
