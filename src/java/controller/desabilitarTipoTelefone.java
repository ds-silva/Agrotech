/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoTelefoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Telefone;

/**
 *
 * @author josem
 */
@WebServlet(name = "desabilitarTipoTelefone", urlPatterns = {"/desabilitarTipoTelefone"})
public class desabilitarTipoTelefone extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                //out.println("aqui");
                Telefone t = new Telefone();
                int idTipoTelefone = Integer.parseInt(request.getParameter("idTipoTelefone"));
                //String tipoTelefone = request.getParameter("tipoTelefone");

                t.setIdTipoTelefone(idTipoTelefone);
                //t.setTipoTelefone(tipoTelefone);
                /*out.println(request.getParameter("desabilitarTipoTelefone"));
                boolean desabilitarTipoTelefone = Boolean.parseBoolean(request.getParameter("desabilitarTipoTelefone"));
                //out.println("aqui");
                out.println(desabilitarTipoTelefone);
                if (desabilitarTipoTelefone == true) {
                    out.println("entrou no if");
                    t.setDesabilitarTipoTelefone(false);
                } else {
                    out.println("entrou no else");
                    t.setDesabilitarTipoTelefone(true);
                }*/

                TipoTelefoneDAO.desabilitarTipoTelefone(t);

                
                out.print("ok");
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception e) {
                out.print(e.getMessage());
            }
        }    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
