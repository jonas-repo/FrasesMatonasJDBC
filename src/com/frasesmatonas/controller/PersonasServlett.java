package com.frasesmatonas.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frasesmatonas.db.DatabaseManager;
import com.frasesmatonas.fmmvc.DatabaseUtil;
import com.frasesmatonas.model.Persona;


@WebServlet("/personas")
public class PersonasServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//objects creation
		Connection conn = null;
		DatabaseManager dbManager = null;
		List<Persona> personas = null;
		RequestDispatcher requestDis = null;
		
		//database connection
		conn = DatabaseUtil.getConnection();
		dbManager = new DatabaseManager(conn);
		
		//get the list of data
		personas = dbManager.consultarPersonas();
	//prepare to sent data to the view
		req.setAttribute("listPersona", personas);
		req.getRequestDispatcher("personas.jsp").forward(req, resp);
		
	}
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//objects creation
		Connection conn = null;
		DatabaseManager dbManager = null;
		Persona persona = null;
		
		//get data from the front end with the names
		String txtNombre = request.getParameter("txtNombre");
		String txtEdad = request.getParameter("txtEdad");
		String txtCarrera = request.getParameter("txtCarrera");
		
		//initialize variables 
		persona = new Persona();
		persona.setNombre(txtNombre);
		persona.setEdad(Byte.parseByte(txtEdad));
		persona.setCarrera(txtCarrera);
		
		//save the data
		conn = DatabaseUtil.getConnection();
		dbManager = new DatabaseManager(conn);
		
		//process the data
		
		dbManager.crearPersona(persona);
		DatabaseUtil.closeConnection(conn);
	}

}
