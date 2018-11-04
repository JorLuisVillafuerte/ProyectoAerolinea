package edu.usal.implementacionJDBC;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Aeropuerto;
import edu.usal.dto.Direccion;
import edu.usal.dto.PasajeroFrecuente;
import edu.usal.dto.Pasaporte;
import edu.usal.dto.Telefono;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.factory.AeropuertoFactory;
import edu.usal.factory.DireccionFactory;
import edu.usal.factory.PasajeroFrecuenteFactory;
import edu.usal.factory.PasaporteFactory;
import edu.usal.interfaces.AeropuertoDAO;
import edu.usal.interfaces.DireccionDAO;
import edu.usal.interfaces.PasajeroFrecuenteDAO;
import edu.usal.interfaces.PasaporteDAO;
import edu.usal.interfaces.TelefonoDAO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//TelefonoDAO tel = new TelefonoImpJDBC();
			//Telefono tele = new Telefono(1,"11","1155232058","1155232058");
			/*ArrayList<Telefono> lista = (ArrayList<Telefono>) tel.getTelefonos();
			for(Telefono a: lista) {
				System.out.println(a.getNumeroCelular());
			}*/
			//tel.addTelefono(tele);
			/*
			DireccionDAO dire = DireccionFactory.getDireccionDAO("db");
			Direccion dir = new Direccion(2,"los lirios","839","Pilar","BS AS","ARG","1629");
			
			ArrayList<Direccion> lista = (ArrayList<Direccion>) dire.getDirecciones();
			for(Direccion a: lista) {
				System.out.println(a.getCiudad());
			}*/
			//PasaporteDAO pasa = PasaporteFactory.getPasaporteDAO("db");
			//Pasaporte pas = new Pasaporte(1,"abc123","ARG","master",new Date(118,10,4),new Date(118,10,4));
			/*ArrayList<Pasaporte> lista = (ArrayList<Pasaporte>) pasa.getPasaportes();
			for(Pasaporte p : lista) {
				System.out.println(p.toString());
			}*/
			//pasa.deletePasaporte(pas);
			//AeropuertoDAO aer = AeropuertoFactory.getAeropuertoDAO("db");
			//Aeropuerto aero = new Aeropuerto("ASD","Moreno","bs as","ARG");
			//aer.addAeropuerto(aero);
			/*ArrayList<Aeropuerto> lista = (ArrayList<Aeropuerto>) aer.getAeropuerto();
			for(Aeropuerto a: lista) {
				System.out.println(a.getPais());
			}*/
			/*PasajeroFrecuenteDAO pf = PasajeroFrecuenteFactory.getPasajeroFrecuenteDAO("db");
			PasajeroFrecuente pas = new PasajeroFrecuente(1,"Airlines","lan","12","basico");
			ArrayList<PasajeroFrecuente> lista = (ArrayList<PasajeroFrecuente>) pf.getPasajeroFrecuente();
			for(PasajeroFrecuente a : lista) {
				System.out.println(a.getAlianza());
			}*/
			
			
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
