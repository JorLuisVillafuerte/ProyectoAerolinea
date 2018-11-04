package edu.usal.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import edu.usal.util.PropertiesUtil;

public class conexionDB {

	//Variables de conexion
	private static String JDBC_DRIVER; 
	private static String JDBC_URL;
 	private static String JDBC_USER;
	private static String JDBC_PASS;
	private static Driver driver;
	private static String JDBC_FILE_NAME = "jdbc";

	//Metodo para conectar con la DB
	public static synchronized Connection getConexion() throws SQLException{
		if(driver==null) {
			try {
				//Se traen los valores del properties
				Properties prop = PropertiesUtil.cargarProperties(JDBC_FILE_NAME);
				//Se asigna cada valor de la conexion a cada variable
				JDBC_DRIVER = prop.getProperty("driver");
		        JDBC_URL = prop.getProperty("url");
		        JDBC_USER = prop.getProperty("user");
		        JDBC_PASS = prop.getProperty("pass");
				
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}catch(Exception e) {
				System.out.println("Fallo al cargar el driver");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
	}
	//Metodo para cerrar recursos
	public static void close(ResultSet rs){
        try{
            if (rs != null) {
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
	//Metodo para cerrar recursos
	public static void close(PreparedStatement ps){
        try{
            if (ps != null) {
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
	//Metodo para cerrar recursos
	public static void close(Connection conn){
        try{
            if (conn != null) {
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
