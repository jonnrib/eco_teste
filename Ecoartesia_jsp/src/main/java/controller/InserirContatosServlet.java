package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatosDAO;
import modelos.Contatos;

@WebServlet("/InserirContatos")
public class InserirContatosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recebendo os dados do formulário via parâmetro
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String mensagem = request.getParameter("mensagem");

        // Criando o objeto Contatos
        Contatos contato = new Contatos();

        // Guardando os dados do formulário no objeto
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setTelefone(telefone);
        contato.setMensagem(mensagem);

        // Criando um objeto DAO para enviar o objeto Contatos para o banco de dados
        // usando o método create da classe ContatosDAO
        ContatosDAO contatosDAO = new ContatosDAO();
        contatosDAO.create(contato);

        response.sendRedirect("Contatos");
    }
}