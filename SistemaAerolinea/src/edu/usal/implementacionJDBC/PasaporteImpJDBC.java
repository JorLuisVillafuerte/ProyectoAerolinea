package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Pasaporte;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.PasaporteDAO;

public class PasaporteImpJDBC implements PasaporteDAO{

	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO Pasaporte(nroPasaporte,paisEmision,autEmision,fechaEmision,fechaVenc) VALUES(?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE Pasaporte SET nroPasaporte= ?,paisEmision=?,autEmision=?,fechaEmision=?,fechaVenc=? WHERE idPasaporte=?";
	private final String SQL_DELETE = "DELETE FROM Pasaporte WHERE idPasaporte = ?";
	private final String SQL_SELECT = "SELECT * FROM Pasaporte";
	private Connection userConn;
	
	//Constructores
	public PasaporteImpJDBC() {}
	public PasaporteImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}

	//Metodos CRUD
	@Override
	public int addPasaporte(Pasaporte pas) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,pas.getNumeroPasaporte());
            ps.setString(2,pas.getPaisEmision());
            ps.setString(3,pas.getAutoridadEmision());
            ps.setDate(4,pas.getFechaEmision());
            ps.setDate(5,pas.getFechaVencimiento());
            ps.setInt(6, pas.getIdPasaporte());
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
	public int updatePasaporte(Pasaporte pas) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,pas.getNumeroPasaporte());
            ps.setString(2,pas.getPaisEmision());
            ps.setString(3,pas.getAutoridadEmision());
            ps.setDate(4,pas.getFechaEmision());
            ps.setDate(5,pas.getFechaVencimiento());
            ps.setInt(6,pas.getIdPasaporte());
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
	public int deletePasaporte(Pasaporte pas) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,pas.getIdPasaporte());
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
	public List<Pasaporte> getPasaportes() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pasaporte> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nro = rs.getString(2);
                String pais = rs.getString(3);
                String aut = rs.getString(4);
                Date fecha = rs.getDate(5);
                Date venc = rs.getDate(6);
                Pasaporte pas = new Pasaporte(id,nro,pais,aut,fecha,venc);
                lista.add(pas);
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
