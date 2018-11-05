package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Aeropuerto;
import edu.usal.dto.Telefono;
import edu.usal.dto.Vuelos;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.VuelosDAO;

public class VuelosImpJDBC implements VuelosDAO{
	
	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO Vuelos(numVuelo,cantidadAsientos,aeropuertoSalida,aeropuertoLlegada,fechahorasalida,fechahorallegada,tiempoVuelo) VALUES(?,?,?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE Vuelos SET numVuelo=?,cantidadAsientos=?,aeropuertoSalida=?,aeropuertoLlegada=?,fechahorasalida=?,fechahorallegada=?,tiempoVuelo=? WHERE idVuelo=?";
	private final String SQL_DELETE = "DELETE FROM Vuelos WHERE idVuelo = ?";
	private final String SQL_SELECT = "SELECT * FROM Vuelos";
	private Connection userConn;
	
	//Constructores
	public VuelosImpJDBC() {}
	public VuelosImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}
	
	//Metodos CRUD
	@Override
	public int addVuelos(Vuelos vuelo) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
        	ps.setString(1,vuelo.getNumVuelo());
        	ps.setInt(2,vuelo.getCantAsientos());
            ps.setString(3,vuelo.getAerSalida().getIdAeropuerto());
            ps.setString(4,vuelo.getAerLlegada().getIdAeropuerto());
            ps.setTimestamp(5,vuelo.getFechaSalida());
            ps.setTimestamp(6, vuelo.getFechaLlegada());
            ps.setString(7,vuelo.getTiempoVuelo());
            System.out.println("Ejecutando query : "+SQL_INSERT);
            rows = ps.executeUpdate();
            System.out.println("Registro afectados: "+rows);
        }
        catch(SQLException e) {
        	System.out.println("Error ejecutando sentencia: "+SQL_INSERT);
        	throw new DAOExcepcion("Error ejecutando metodo SQL",e);
        }
        finally{
            conexionDB.close(ps);
            if (conn == null) {
                conexionDB.close(conn);
            }
        }
        return rows;
	}
	@Override
	public int updateVuelos(Vuelos vuelo) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,vuelo.getNumVuelo());
        	ps.setInt(2,vuelo.getCantAsientos());
            ps.setString(3,vuelo.getAerSalida().getIdAeropuerto());
            ps.setString(4,vuelo.getAerLlegada().getIdAeropuerto());
            ps.setTimestamp(5,vuelo.getFechaSalida());
            ps.setTimestamp(6, vuelo.getFechaLlegada());
            ps.setString(7,vuelo.getTiempoVuelo());
            ps.setInt(8,vuelo.getIdVuelos());
            System.out.println("Ejecutando query : "+SQL_UPDATE);
            rows = ps.executeUpdate();
            System.out.println("Registro afectados: "+rows);
        }
        catch(SQLException e) {
        	System.out.println("Error ejecutando sentencia: "+SQL_UPDATE);
        	throw new DAOExcepcion("Error ejecutando metodo SQL",e);
        }
        finally{
            conexionDB.close(ps);
            if (conn == null) {
                conexionDB.close(conn);
            }
        }
        return rows;
	}
	@Override
	public int deleteVuelos(Vuelos vuelo) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,vuelo.getIdVuelos());
            System.out.println("Ejecutando query : "+SQL_DELETE);
            rows = ps.executeUpdate();
            System.out.println("Registro afectados: "+rows);
        }
        catch(SQLException e) {
        	System.out.println("Error ejecutando sentencia: "+SQL_DELETE);
        	throw new DAOExcepcion("Error ejecutando metodo SQL",e);
        }
        finally{
            conexionDB.close(ps);
            if (conn == null) {
                conexionDB.close(conn);
            }
        }
        return rows;
	}
	@Override
	public List<Vuelos> getVuelos() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Vuelos> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String num = rs.getString(2);
                int cantidad = rs.getInt(3);
                String aeropuertosalida = rs.getString(4);
                String aeropuertollegada = rs.getString(5);
                Timestamp fyhsalida = rs.getTimestamp(6);
                Timestamp fyhllegada = rs.getTimestamp(7);
                String tiempo = rs.getString(8);
                
                Aeropuerto aerosalida = new Aeropuerto();
                aerosalida.setIdAeropuerto(aeropuertosalida);
                Aeropuerto aerollegada = new Aeropuerto();
                aerollegada.setIdAeropuerto(aeropuertollegada);
                Vuelos vuelo = new Vuelos(id,num,cantidad,aerosalida,aerollegada,fyhsalida,fyhllegada,tiempo);
                
                lista.add(vuelo)
            }
        }
        catch(SQLException e ) {
        	System.out.println("Error ejecutando sentencia: "+SQL_SELECT);
        	throw new DAOExcepcion("Error ejecutando metodo SQL",e);
        }
        finally{
            conexionDB.close(ps);
            conexionDB.close(rs);
            if (this.userConn == null) {
                conexionDB.close(conn);
            }
        }
        return lista;

	}
	
	
	
}
