package edu.usal.implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.conexion.conexionDB;
import edu.usal.dto.PasajeroFrecuente;
import edu.usal.excepciones.DAOExcepcion;
import edu.usal.interfaces.PasajeroFrecuenteDAO;

public class PasajeroFrecuenteImpJDBC implements PasajeroFrecuenteDAO{
	
	//Declaro en constantes las consultas SQL a realizar
	private final String SQL_INSERT = "INSERT INTO PasajeroFrecuente(alianza,aerolinea,numero,categoria) VALUES(?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE PasajeroFrecuente SET alianza=?,aerolinea=?,numero=?,categoria=? WHERE idPasFrec=?";
	private final String SQL_DELETE = "DELETE FROM PasajeroFrecuente WHERE idPasFrec = ?";
	private final String SQL_SELECT = "SELECT * FROM PasajeroFrecuente";
	private Connection userConn;
	
	//Constructores
	public PasajeroFrecuenteImpJDBC() {}
	public PasajeroFrecuenteImpJDBC(Connection userConn) {
		super();
		this.userConn = userConn;
	}

	//Metodos CRUD
	@Override
	public int addPasajeroFrecuente(PasajeroFrecuente pf) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_INSERT);
        	ps.setString(1,pf.getAlianza());
        	ps.setString(2,pf.getAerolinea());
        	ps.setString(3,pf.getNumero());
        	ps.setString(4,pf.getCategoria());
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
	public int updatePasajeroFrecuente(PasajeroFrecuente pf) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_UPDATE);
        	ps.setString(1,pf.getAlianza());
        	ps.setString(2,pf.getAerolinea());
        	ps.setString(3,pf.getNumero());
        	ps.setString(4,pf.getCategoria());
        	ps.setInt(5,pf.getIdPasajeroFrecuente());
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
	public int deletePasajeroFrecuente(PasajeroFrecuente pf) throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        
        try{
        	conn = (this.userConn != null)? this.userConn : conexionDB.getConexion();
        	ps = conn.prepareStatement(SQL_DELETE);
        	ps.setInt(1,pf.getIdPasajeroFrecuente());
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
	public List<PasajeroFrecuente> getPasajeroFrecuente() throws DAOExcepcion {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PasajeroFrecuente> lista = new ArrayList<>();
        try{
            conn = (this.userConn != null)? this.userConn:conexionDB.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String alianza = rs.getString(2);
                String aero = rs.getString(3);
                String numero = rs.getString(4);
                String categoria = rs.getString(5);
                PasajeroFrecuente pf = new PasajeroFrecuente(id,alianza,aero,numero,categoria);
                lista.add(pf);
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
