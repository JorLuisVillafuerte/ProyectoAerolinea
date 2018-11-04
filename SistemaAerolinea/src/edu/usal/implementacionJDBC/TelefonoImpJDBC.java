package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.Telefono;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.TelefonoDAO;

public class TelefonoImpJDBC implements TelefonoDAO{

	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO Telefono(telPersonal,telCelular,telLaboral) VALUES(?,?,?)";
	private final String SQL_UPDATE = "UPDATE Telefono SET telPersonal=?,telCelular=?,telLaboral=? WHERE idTelefono=?";
	private final String SQL_DELETE = "DELETE FROM Telefono WHERE idTelefono = ?";
	private final String SQL_SELECT = "SELECT idTelefono,telPersonal,telCelular,telLaboral FROM Telefono";
	private Connection userConn;
	
	//Constructores
	public TelefonoImpJDBC() {}
	public TelefonoImpJDBC(Connection userConn) {
		this.userConn = userConn;
	}
	
	//Metodos CRUD
	@Override
	public int addTelefono(Telefono tel) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,tel.getNumeroPersonal());
            ps.setString(2,tel.getNumeroCelular());
            ps.setString(3,tel.getNumeroLaboral());
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
	public int updateTelefono(Telefono tel) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,tel.getNumeroPersonal());
            ps.setString(2,tel.getNumeroCelular());
            ps.setString(3,tel.getNumeroLaboral());
            ps.setInt(4,tel.getIdTelefono());
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
	public int deleteTelefono(Telefono tel) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,tel.getIdTelefono());
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
	public List<Telefono> getTelefonos() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Telefono> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String tel1 = rs.getString(2);
                String tel2 = rs.getString(3);
                String tel3 = rs.getString(4);
                Telefono tel = new Telefono(id,tel1,tel2,tel3);
                lista.add(tel);
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
