package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatosDAO;
import modelos.Contatos; //

@WebServlet(urlPatterns = {"/Contato", "/Contato-create", "/Contato-edit", "/Contato-update", "/Contato-delete" })
public class ContatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ContatosDAO cdao = new ContatosDAO();
    Contatos contato = new Contatos();

    public ContatosServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/Contato":
                read(request, response);
                break;

            case "/Contato-create":
                create(request, response);
                break;

            case "/Contato-edit":
                edit(request, response);
                break;

            case "/Contato-update":
                update(request, response);
                break;

            case "/Contato-delete":
                delete(request, response);
                break;
                
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    protected void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contatos> lista = cdao.read();

        request.setAttribute("listaContatos", lista);

        RequestDispatcher rd = request.getRequestDispatcher("./views/Contatos/index.jsp");
        rd.forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        contato.setNome(request.getParameter("nome"));
        contato.setEmail(request.getParameter("email"));
        contato.setTelefone(request.getParameter("telefone"));
        contato.setMensagem(request.getParameter("mensagem"));

        cdao.create(contato);
        response.sendRedirect("Contatos");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        contato = cdao.readByID(id);
        request.setAttribute("Contato", contato);

        RequestDispatcher rd = request.getRequestDispatcher("./views/Contatos/update.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        contato.setNome(request.getParameter("nome"));
        contato.setEmail(request.getParameter("email"));
        contato.setTelefone(request.getParameter("telefone"));
        contato.setMensagem(request.getParameter("mensagem"));
        contato.setId(Integer.parseInt(request.getParameter("id")));

        cdao.update(contato);
        response.sendRedirect("Contatos");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("Contatos");
    }
}
