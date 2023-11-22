package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampanhasDAO;

@WebServlet("/excluir")
public class ExcluirCampanhasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idContato = Integer.parseInt(req.getParameter("id"));


		CampanhasDAO cdao = new CampanhasDAO();

		int idCampanhas = 0;
		cdao.removeById(idCampanhas);

		resp.sendRedirect("home");
	}

}