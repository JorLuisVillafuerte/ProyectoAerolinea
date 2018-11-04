package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Aeropuerto;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.AeropuertoDAO;

public class AeropuertoImpJDBC implements AeropuertoDAO{
	
	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO Aeropuerto(idAeropuerto,ciudad,provincia,pais) VALUES(?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE Aeropuerto SET ciudad=?,provincia=?,pais=? WHERE idAeropuerto=?";
	private final String SQL_DELETE = "DELETE FROM Aeropuerto WHERE idAeropuerto = ?";
	private final String SQL_SELECT = "SELECT * FROM Aeropuerto";
	private Connection userConn;
	
	//Constructores
	public AeropuertoImpJDBC() {}
	public AeropuertoImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}
	
	//Metodos CRUD
	@Override
	public int addAeropuerto(Aeropuerto aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,aero.getIdAeropuerto());
            ps.setString(2,aero.getCiudad());
            ps.setString(3,aero.getProvincia());
            ps.setString(4,aero.getPais());
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
	public int updateAeropuerto(Aeropuerto aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1,aero.getCiudad());
            ps.setString(2,aero.getProvincia());
            ps.setString(3,aero.getPais());
            ps.setString(4,aero.getIdAeropuerto());
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
	public int deleteAeropuerto(Aeropuerto aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setString(1,aero.getIdAeropuerto());
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
	public List<Aeropuerto> getAeropuerto() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aeropuerto> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String ciudad = rs.getString(2);
                String prov = rs.getString(3);
                String pais = rs.getString(4);
                Aeropuerto aero = new Aeropuerto(id,ciudad,prov,pais);
                lista.add(aero);
            }
        }
        catch(SQLException e) {
        	System.out.println("Error ejecutando sentencia: "+SQL_SELECT);
        	throw new DAOExcepcion("Error ejecutando metodo SQL",e);
        }finally{
            conexionDB.close(ps);
            conexionDB.close(rs);
            if (this.userConn == null) {
                conexionDB.close(conn);
            }
        }
        return lista;
	}
	
	
		
}
