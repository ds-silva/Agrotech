/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estado;

/**
 *
 * @author josem
 */
@WebServlet(name = "consultarEstado", urlPatterns = {"/consultarEstado"})
public class consultarEstado extends HttpServlet {

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

                Estado est = new Estado();
                
                if(request.getParameter("estado") != "" || request.getParameter("uf") != ""){
                if (request.getParameter("estado") != "") {
                    est.setDescricaoEstado(request.getParameter("estado"));
                }
                if(request.getParameter("uf") != ""){
                    est.setUfEstado(request.getParameter("uf"));
                }    
                    
                    List<Estado> listEst = EstadoDAO.consultarEstado(est);
                    if (listEst != null ) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("listaEstado",listEst);
                    }
                } else {
                  
                     List<Estado> listEst = EstadoDAO.listarTodosEstados();
                    if (listEst != null) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("listaEstado",listEst);
                    }
                }
                out.print("ok");

            } catch (SQLException ex) {
                out.println(ex.getMessage());
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
        }
    }
          
//        try (PrintWriter out = response.getWriter()) {
//            try {
//
//                Estado est = new Estado();
//
//                String a = request.getParameter("estado");
//
//                String b = request.getParameter("uf");
//
//                if (!"".equals(b) || !"".equals(a)) {
//                    if (!"".equals(a)) {
//                        est.setDescricaoEstado(a);
//                    }
//                    if (!"".equals(b)) {
//                        est.setUfEstado(b);
//                    }
//                    List<Estado> listEst = EstadoDAO.consultarEstado(est);
//                    if (listEst != null ) {
//                        HttpSession session=request.getSession();  
//                        session.setAttribute("listaEstado",listEst);
//                    }
//                } else {
//                  
//                    List<Estado> listEst = EstadoDAO.listarTodosEstados();
//                    if (listEst != null) {
//                        HttpSession session=request.getSession();  
//                        session.setAttribute("listaEstado", listEst);
//                    }
//                }
//                out.print("ok");
//
//            } catch (SQLException ex) {
//              out.println(ex.getMessage());
//            } catch (Exception ex) {
//                out.println(ex.getMessage());
//            }
//        } 

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
