package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampanhasDAO;
import modelos.Campanhas;

@WebServlet("/editar")
public class AlterarCampanhaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Campanhas campanhaAlterada = new Campanhas();

        campanhaAlterada.setNome(req.getParameter("nome"));
        campanhaAlterada.setDescricao(req.getParameter("descricao"));
        campanhaAlterada.setMetaArrecadacao(new BigDecimal(req.getParameter("meta_arrecadacao")));

        try {
            String dataInicioStr = req.getParameter("data_inicio");
            String dataTerminoStr = req.getParameter("data_termino");

            if (!dataInicioStr.isEmpty() && !dataTerminoStr.isEmpty()) {
                LocalDate dataInicio = LocalDate.parse(dataInicioStr);
                LocalDate dataTermino = LocalDate.parse(dataTerminoStr);

                campanhaAlterada.setDataInicio(dataInicio);
                campanhaAlterada.setDataTermino(dataTermino);
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace(); 
        }

        campanhaAlterada.setIdCampanha(Integer.parseInt(req.getParameter("id")));

        CampanhasDAO campanhasDAO = new CampanhasDAO();
        campanhasDAO.update(campanhaAlterada);

        resp.sendRedirect("home");
    }
}
