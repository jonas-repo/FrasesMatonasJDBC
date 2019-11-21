package com.frasesmatonas.fmmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String URL_FORMAT ="jdbc:%S://%S:%S/%S?useUnicode=true" + 
			"&useJDBCCompliantTimezoneShift=true" + 
			"&useLegacyDatetimeCode=false" + 
			"&serverTimezone=UTC"; //%s is used to be replaced for another variable 
	
	/*
	 0:Driver DBMS
	 1:The one who connect to database 
	 **/
	
	public static Connection getConnection()
	{
		String dbms = "mysql";
		String host ="localhost";
		String port ="3306";
		String databaseName = "frases_matonas";
		String user ="root";
		String password = "root";
		String url = String.format(URL_FORMAT, dbms,host,port,databaseName); //format the string of URL_FORMAT with new values 
		
		Connection connection = null;
		
		try 
		{
			//creando instancia del drive en memoria para ser accedida
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtener la conexion a la base de datos
			connection = DriverManager.getConnection(url,user,password);
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
	}
}
