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
		File tempFile = new File("C:/Users/aula1/eclipse-workspace/ExamenUF1844/WebContent/usuarios/"+usuario+".html");		//VARIABLE DEL NOMBRE DEL ARCHIVO
		exists = tempFile.exists();
		
		if (exists) {
			
			request.setAttribute("usuarioLog", usuario);
			request.setAttribute("contraseñaLog", contraseña);
			
			request.getRequestDispatcher("Datos.jsp").forward(request, response);
			
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
