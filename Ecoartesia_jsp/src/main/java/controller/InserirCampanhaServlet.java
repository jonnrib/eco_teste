package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampanhasDAO;
import modelos.Campanhas;

@WebServlet("/InserirCampanha")
public class InserirCampanhaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recebendo os dados do formulário via parâmetro
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String metaArrecadacao = request.getParameter("meta_arrecadacao");
        String dataInicioStr = request.getParameter("data_inicio");
        String dataTerminoStr = request.getParameter("data_termino");

        // Criando o objeto Campanha
        Campanhas campanha = new Campanhas();

        // Guardando os dados do formulário no objeto
        campanha.setNome(nome);
        campanha.setDescricao(descricao);
        campanha.setMetaArrecadacao(new BigDecimal(metaArrecadacao));

        try {
            // Parsing das datas
            if (!dataInicioStr.isEmpty() && !dataTerminoStr.isEmpty()) {
                LocalDate dataInicio = LocalDate.parse(dataInicioStr);
                LocalDate dataTermino = LocalDate.parse(dataTerminoStr);

                campanha.setDataInicio(dataInicio);
                campanha.setDataTermino(dataTermino);
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            // Trate a exceção de parsing de data conforme necessário
        }

        // Criando um objeto DAO para enviar o objeto Campanha para o banco de dados
        // usando o método save da classe CampanhasDAO
        CampanhasDAO campanhaDAO = new CampanhasDAO();
        campanhaDAO.save(campanha);

        response.sendRedirect("index.jsp");
    }
}