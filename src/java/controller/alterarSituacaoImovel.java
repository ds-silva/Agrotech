/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SituacaoImovelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImovelRural;

/**
 *
 * @author Felipe Toledo
 */
@WebServlet(name = "alterarSituacaoImovel", urlPatterns = {"/alterarSituacaoImovel"})
public class alterarSituacaoImovel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                ImovelRural ir = new ImovelRural();

                String situacaoimovel = request.getParameter("situacaoImovelRural");
                int idSituacaoImovel = Integer.parseInt(request.getParameter("idSituacaoImovelRural"));

                ir.setSituacaoImovel(situacaoimovel);
                ir.setIdSituacaoImovelRural(idSituacaoImovel);

                SituacaoImovelDAO.updateSituacaoImovel(ir);

                out.print("ok");
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception e) {
                out.print(e.getMessage());
            }

        }
    }
}
