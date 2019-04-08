package Servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerDatos_Servlet
 */
@WebServlet("/VerDatos_Servlet")
public class VerDatos_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerDatos_Servlet() {
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
		String usuario= request.getParameter("usuariolog");
		String contraseña= request.getParameter("passwordlog");
		
		Boolean exists= false;
		File tempFile = new File("C:/Users/aula1/eclipse-workspace/ExamenUF1844/WebContent/usuarios/"+usuario+".txt");		//VARIABLE DEL NOMBRE DEL ARCHIVO
		exists = tempFile.exists();
		
		if (exists) {
			
			String myfile= "C:/Users/aula1/eclipse-workspace/ExamenUF1844/WebContent/usuarios/"+usuario+".txt";
			
			BufferedReader abc = new BufferedReader(new FileReader(myfile));
			List<String> lines = new ArrayList<String>();

			String line;
			while((line = abc.readLine()) != null) {
			    lines.add(line);
			}
			abc.close();
			
			System.out.println(lines);
			
			String[] info = new String[lines.size()]; 
			
	        // ArrayList to Array Conversion 
	        for (int i =0; i < lines.size(); i++) 
	            info[i] = lines.get(i);

			if (request.getParameter("passwordlog").equals(info[1])) {
				
				request.setAttribute("usuarioLog", usuario);
				request.setAttribute("contraseñaLog", contraseña);
				request.setAttribute("nombre", info[2]);
				request.setAttribute("apellido", info[3]);
				if (info[4].contentEquals("Hombre")) {
					request.setAttribute("genHom", "checked" ) ;
				}
				else if (info[4].contentEquals("Mujer")) {
					request.setAttribute("genMuj", "checked" ) ;
				}
				else if (info[4].contentEquals("NoBinario")) {
					request.setAttribute("genNo", "checked" ) ;
				}
				
				if (info[5].contentEquals("Estudiante,Trabajador, ")){
					request.setAttribute("est", "checked" ) ;
					request.setAttribute("trab", "checked" ) ;
				}
				else if (info[5].contentEquals("Estudiante, ")){
					request.setAttribute("est", "checked" ) ;
				}
				else if (info[5].contentEquals("Trabajador, ")){
					request.setAttribute("trab", "checked" ) ;
				}
				request.setAttribute("otros", info[6]);
				
				request.getRequestDispatcher("Datos.jsp").forward(request, response);
			}
			else {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('La contraseña no es correcta');");
				out.println("location='index.jsp';");
				out.println("</script>");

			}
		}
		else {
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Este nombre de usuario no existe');");
			out.println("location='index.jsp';");
			out.println("</script>");
		
		}

	}
}
