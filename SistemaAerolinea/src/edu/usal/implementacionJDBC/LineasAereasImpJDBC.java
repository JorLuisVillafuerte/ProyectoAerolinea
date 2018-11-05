package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.LineasAereas;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.LineasAereasDAO;

public class LineasAereasImpJDBC implements LineasAereasDAO{
	
	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO LineasAereas(nombreAerolinea,alianza) VALUES(?,?,?)";
	private final String SQL_UPDATE = "UPDATE LineasAereas SET nombreAerolinea=?,alianza=? WHERE idLineaAerea=?";
	private final String SQL_DELETE = "DELETE FROM LineasAereas WHERE idLineaAerea = ?";
	private final String SQL_SELECT = "SELECT * FROM LineasAereas";
	private Connection userConn;
		
	//Constructores
	public LineasAereasImpJDBC() {}
	public LineasAereasImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}
	
	//Metodos CRUD
	@Override
	public int addLineasAereas(LineasAereas aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,aero.getNombreAero());
            ps.setString(2, aero.getAlianza());
          
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
	public int updateLineasAereas(LineasAereas aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,aero.getNombreAero());
            ps.setString(2, aero.getAlianza());
            ps.setInt(3, aero.getIdLineasAereas());
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
	public int deleteLineasAereas(LineasAereas aero) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,aero.getIdLineasAereas());
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
	public List<LineasAereas> getLineasAereas() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<LineasAereas> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String lineaaerea = rs.getString(2);
                String alianza = rs.getString(3);
                LineasAereas linea = new LineasAereas(id,lineaaerea,alianza);
                lista.add(linea);
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
