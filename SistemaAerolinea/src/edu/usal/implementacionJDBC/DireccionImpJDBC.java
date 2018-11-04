package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Direccion;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.DireccionDAO;

public class DireccionImpJDBC implements DireccionDAO{

	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO Direccion(calle,altura,ciudad,provincia,pais,codigoPostal) VALUES(?,?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE Direccion SET calle=?,altura=?,ciudad=?,provincia=?,pais=?,codigoPostal=? WHERE idDireccion=?";
	private final String SQL_DELETE = "DELETE FROM Direccion WHERE idDireccion = ?";
	private final String SQL_SELECT = "SELECT * FROM Direccion";
	private Connection userConn;
	
	//Constructores
	public DireccionImpJDBC() {}
	public DireccionImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}
	
	//Metodos CRUD
	@Override
	public int addDireccion(Direccion dir) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,dir.getCalle());
            ps.setString(2,dir.getAltura());
            ps.setString(3,dir.getCiudad());
            ps.setString(4,dir.getProvincia());
            ps.setString(5,dir.getPais());
            ps.setString(6,dir.getCodigoPostal());
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
	public int updateDireccion(Direccion dir) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,dir.getCalle());
            ps.setString(2,dir.getAltura());
            ps.setString(3,dir.getCiudad());
            ps.setString(4,dir.getProvincia());
            ps.setString(5,dir.getPais());
            ps.setString(6,dir.getCodigoPostal());
            ps.setInt(7,dir.getIdDireccion());
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
	public int deleteDireccion(Direccion dir) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,dir.getIdDireccion());
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
	public List<Direccion> getDirecciones() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Direccion> lista = new ArrayList<Direccion>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String calle = rs.getString(2);
                String altura = rs.getString(3);
                String ciudad = rs.getString(4);
                String prov = rs.getString(5);
                String pais = rs.getString(6);
                String codigo = rs.getString(7);
                Direccion dir = new Direccion(id,calle,altura,ciudad,prov,pais,codigo);
                lista.add(dir);
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
