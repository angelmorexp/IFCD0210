package Servlets;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		String usuario= request.getParameter("usuarioreg");
		String contraseña= request.getParameter("passwordreg");
		Boolean exists= false;
		File tempFile = new File("C:/Users/aula1/eclipse-workspace/ExamenUF1844/"+usuario+".txt");		//VARIABLE DEL NOMBRE DEL ARCHIVO
		exists = tempFile.exists();
		
		if (exists) {
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('El nombre de usuario ya existe');");
			out.println("location='index.jsp';");
			out.println("</script>");
			
		}
		else {
			String mensaje = usuario+"\r\n"+contraseña;
			
			response.setContentType("text/html");

		    try{
		        FileWriter writer = new FileWriter("C:/Users/aula1/eclipse-workspace/ExamenUF1844/"+usuario+".txt");
		        writer.write(mensaje);
		        writer.close();
		    }catch(Exception ex){
		        ex.printStackTrace();
		    }

		    response.getWriter().write(mensaje);
		    
			System.out.println("Bienvenido "+usuario);
			request.setAttribute("usuarioSign", usuario);
			request.setAttribute("contraseñaSign", contraseña);
			
			request.getRequestDispatcher("Registro.jsp").forward(request, response);
			
			 
		
		}
		
		
	}

}