/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrgaoFuncionalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Regional;

/**
 *
 * @author jhonatan
 */
@WebServlet(name = "alterarOrgaoFuncionalResultado", urlPatterns = {"/alterarOrgaoFuncionalResultado"})
public class alterarOrgaoFuncionalResultado extends HttpServlet {

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
            Regional regional = new Regional();
     
            String descricaofun = request.getParameter("orgaoFuncional");
            regional.setOrgaoFuncional(descricaofun);
            
            int oG = Integer.parseInt(request.getParameter("idOrgaoFuncional"));
            regional.setIdOrgaoFuncional(oG);
            
            OrgaoFuncionalDAO.alterarOrgaoFuncinal(regional);
            
            out.print("ok");
         //   request.setAttribute("og",og);
         //   RequestDispatcher rd=request.getRequestDispatcher("alterar_og.jsp"); 
         //   rd.forward(request, response);
       
        } catch (SQLException ex) {
            out.println(ex.getMessage());
            Logger.getLogger(alterarOrgaoFuncionalResultado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(alterarOrgaoFuncionalResultado.class.getName()).log(Level.SEVERE, null, ex);
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