package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.VideoGame;
import com.revature.daoImpl.VideoGameDAOImpl;

/**
 * Servlet implementation class VGServlet
 */
public class VGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		ObjectMapper mapper = new ObjectMapper();
		VideoGameDAOImpl vgdi = new VideoGameDAOImpl();
		int id = mapper.readValue(request.getParameter("vgid"), Integer.class);
		PrintWriter pw = response.getWriter();
		String vgJSON;
		
		try {
		vgJSON = mapper.writeValueAsString(vgdi.getVGById(id));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		pw.print(vgJSON);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		pw.flush();
	}

	//get a json from our ajax and save it to the db
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoGame vg = null;
		ObjectMapper mapper = new ObjectMapper();
		//convert JSON to Java Object
		vg = mapper.readValue(request.getInputStream(), VideoGame.class);
		System.out.println(vg);
		VideoGameDAOImpl vgdi = new VideoGameDAOImpl();
		vgdi.insertVG(vg);
		PrintWriter pw = response.getWriter();
		pw.write("<h3> Added Video Game</h3>");
		pw.close();
		
	}

}
