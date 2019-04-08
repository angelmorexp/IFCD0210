package Servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Datos_Servlet
 */
@WebServlet("/Datos_Servlet")
public class Datos_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datos_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario= request.getParameter("usuarioreg");
		String contraseña= request.getParameter("passwordreg");
		String nombre= request.getParameter("nombre");
		String apellidos= request.getParameter("apellidos");
		String genero= request.getParameter("genero");
		if(genero== null) {
			genero="No indicado";
		}
		String[] ocupacionDatos = request.getParameterValues("ocupacion");
		if (ocupacionDatos == null) {
			ocupacionDatos[0] = "Ni estudio ni trabajo";
		}
		String ocupacion = String.join(",", ocupacionDatos);
		if (ocupacion == null) {
			ocupacion = "Ni estudio ni trabajo";
		}
		String otros = request.getParameter("mensaje");
		
			
			String mensaje = usuario+"\r\n"+contraseña+"\r\n"+nombre+"\r\n"+apellidos+"\r\n"+genero+"\r\n"+ocupacion+"\r\n"+otros;
			
			response.setContentType("text/html");

		    try{
		        FileWriter writer = new FileWriter("C:/Users/aula1/eclipse-workspace/ExamenUF1844/WebContent/usuarios/"+usuario+".txt");
		        writer.write(mensaje);
		        writer.close();
		    }catch(Exception ex){
		        ex.printStackTrace();
		    }
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
