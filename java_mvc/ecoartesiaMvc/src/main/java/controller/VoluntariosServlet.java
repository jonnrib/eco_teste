package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoluntariosDAO;
import model.Voluntarios;




@WebServlet(urlPatterns = {"/Voluntario", "/Voluntario-create", "/Voluntario-edit", "/Voluntario-update", "/Voluntario-delete" })
public class VoluntariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VoluntariosDAO vdao = new VoluntariosDAO();
	Voluntarios voluntario = new Voluntarios();
	
	
    public VoluntariosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/Voluntario":
			read(request, response);
			break;
			
		case "/Voluntario-create":
		create(request,response);
		break;
		
		case "/Voluntario-edit":
			edit(request,response);
			break;
			
		case "/Voluntario-update":
			update(request,response);
			break;
		
		case "/Voluntario-delete":
			delete(request, response);
			break;
			default:
				response.sendRedirect("index.jsp");
				break;}
	}
			

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Voluntarios> lista = vdao.read();
		System.out.println(lista);
		
		request.setAttribute("listaVoluntarios", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Voluntarios/index.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		voluntario.setNome(request.getParameter("nome"));
		voluntario.setEmail(request.getParameter("email"));
		voluntario.setDisponibilidade(request.getParameter("disponibilidade"));
		voluntario.setInteresses(request.getParameter("interesses"));
		
		vdao.create(voluntario);
		response.sendRedirect("Voluntarios");
		
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		voluntario = vdao.readByID(id);
		request.setAttribute("Voluntarios", voluntario);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Voluntarios/update.jsp");
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		voluntario.setNome(request.getParameter("nome"));
		voluntario.setEmail(request.getParameter("email"));
		voluntario.setDisponibilidade(request.getParameter("disponibilidade"));
		voluntario.setInteresses(request.getParameter("interesses"));
		voluntario.setId(Integer.parseInt(request.getParameter("id")));

		vdao.update(voluntario);
		response.sendRedirect("Voluntarios");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		vdao.delete(id);
		response.sendRedirect("Voluntarios");
		
	}
	
}