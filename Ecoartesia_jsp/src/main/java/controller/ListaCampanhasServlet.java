package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Campanhas;
import dao.CampanhasDAO;


@WebServlet("/home")
public class ListaCampanhasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  List<Campanhas> campanhas  = new ArrayList<Campanhas>();
          CampanhasDAO campanhaDAO = new CampanhasDAO();
          try {
			campanhas = campanhaDAO.getCampanhas();
		} catch (Exception e) {

			e.printStackTrace();
		}
          req.setAttribute("listaCampanhas", campanhas);
    	
          RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro2.jsp");
  		dispatcher.forward(req, resp);
  	}

  }