package com.frasesmatonas.db;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.frasesmatonas.model.Frase;
import com.frasesmatonas.model.Persona;
import com.mysql.cj.protocol.Resultset;

public class DatabaseManager {
	
	private Connection conn;

	public DatabaseManager(Connection conn) {
		this.conn = conn;
	}
	
	public void crearPersona(Persona persona)
	{
		String query = "insert into persona(nombre,edad,carrera) "
				+ "values("+persona.toString()+")";
		Statement stmn = null;
		try 
		{
			stmn = conn.createStatement();
			stmn.executeUpdate(query);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void crearFrase(Frase frase)
	{
		String query = "insert into frase(contenido,cantidad,fechaDesde)"
				+ "values(?,?,?)";
		PreparedStatement stmn = null;
		try 
		{
			stmn = conn.prepareStatement(query);
			stmn.setString(1, frase.getContenido());
			stmn.setInt(2, frase.getCantidad());				
			stmn.setDate(3, frase.getFechaDesde());
			
			stmn.executeUpdate();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void crearFrasePersona(int idPersona, int idFrase)
	{
		String query = "insert into persona_frase(idPersona, idFrase)"
				+ "values("+idPersona+","+idFrase+")";
		Statement stmn = null;
		try 
		{
			stmn = conn.createStatement();
			stmn.executeUpdate(query);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Persona> consultarPersonas()
	{
		String query = "select * from persona";
		Statement stmn = null;
		ResultSet rs = null;		
		List<Persona> listPersona = null;
		
		try 
		{
			stmn = conn.createStatement();
			rs = stmn.executeQuery(query);
			listPersona = new ArrayList<>();
			
			
			
			while(rs.next())
			{
				Persona persona = new Persona();
				persona.setIdPersona(rs.getInt("idPersona"));
				persona.setNombre(rs.getString("nombre"));
				persona.setEdad(rs.getByte("edad"));
				persona.setCarrera(rs.getString("carrera"));
				persona.setFecha(rs.getDate("fecha"));
				
				//adding model to the list
				listPersona.add(persona);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listPersona;
	}
	
	public List<Frase> consultarFrases()
	{
		String query = "select * from frase";
		Statement stmn = null;
		ResultSet rs = null;		
		List<Frase> listFrase = null;
		
		try 
		{
			stmn = conn.createStatement();
			rs = stmn.executeQuery(query);
			listFrase = new ArrayList<>();
			
			
			
			while(rs.next())
			{
				Frase frase = new Frase();
				frase.setIdFrase(rs.getInt("idFrase"));
				frase.setCantidad(rs.getInt("cantidad"));
				frase.setContenido(rs.getString("contenido"));
				frase.setFecha(rs.getDate("fecha"));
				frase.setFechaDesde(rs.getDate("fechaDesde"));
				
				//adding model to the list
				listFrase.add(frase);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listFrase;
	}
	
	public List<Frase> consultarFrasesPersona(int idPersona)
	{
		String query = "select frase.idFrase, frase.contenido, frase.cantidad, frase.fechaDesde, frase.fecha"
				+"from frase inner join persona_frase" + 
				"on persona_frase.idFrase = frase.idFrase" + 
				"where idPersona = "+idPersona+"";
		
		Statement stmn = null;
		ResultSet rs = null;		
		List<Frase> listFrase = null;
		
		try 
		{
			stmn = conn.createStatement();
			rs = stmn.executeQuery(query);
			listFrase = new ArrayList<>();
			
			
			
			while(rs.next())
			{
				Frase frase = new Frase();
				frase.setIdFrase(rs.getInt("idFrase"));
				frase.setCantidad(rs.getInt("cantidad"));
				frase.setContenido(rs.getString("contenido"));
				frase.setFecha(rs.getDate("fecha"));
				frase.setFechaDesde(rs.getDate("fechaDesde"));
				
				//adding model to the list
				listFrase.add(frase);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listFrase;
	}

}
