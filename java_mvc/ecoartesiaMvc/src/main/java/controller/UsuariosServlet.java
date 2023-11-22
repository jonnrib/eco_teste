package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuariosDAO;
import model.Usuarios;




@WebServlet(urlPatterns = {"/Usuario", "/Usuario-create", "/Usuario-edit", "/Usuario-update", "/Usuario-delete" })
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO udao = new UsuariosDAO();
	Usuarios usuario = new Usuarios();
	
	
    public UsuariosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/Usuario":
			read(request, response);
			break;
			
		case "/Usuario-create":
		create(request,response);
		break;
		
		case "/Usuario-edit":
			edit(request,response);
			break;
			
		case "/Usuario-update":
			update(request,response);
			break;
		
		case "/Usuario-delete":
			delete(request, response);
			break;
			default:
				response.sendRedirect("index.jsp");
				break;}
	}
			

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Usuarios> lista = udao.read();
		System.out.println(lista);
		
		request.setAttribute("listaUsuarios", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Usuarios/index.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		udao.create(usuario);
		response.sendRedirect("Usuarios");
		
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuario = udao.readByID(id);
		request.setAttribute("Usuarios", usuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Usuarios/update.jsp");
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		
		udao.update(usuario);
		response.sendRedirect("Usuarios");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		udao.delete(id);
		response.sendRedirect("Usuarios");
		
	}
	
}