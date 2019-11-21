package com.frasesmatonas.fmmvc;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

public class testDatabaseConnection {
	
	@Test //testing annotation
	public void testConnection() 
	{
		Connection connection = DatabaseUtil.getConnection();
		assertNotNull("No se realizo la conexion",connection);
		
		try {
			connection.close();
			assertTrue("No se cerro la conexion",connection.isClosed());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
