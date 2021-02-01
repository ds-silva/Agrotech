/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DescricaoProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DescricaoProduto;

/**
 *
 * @author josem
 */
@WebServlet(name = "consultarDescricaoProduto", urlPatterns = {"/consultarDescricaoProduto"})
public class consultarDescricaoProduto extends HttpServlet {

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
                // DescricaoProduto descricaoProduto = new DescricaoProduto(request.getParameter("nomeProduto"), request.getParameter("tipoProduto"));

                DescricaoProduto descricaoProduto = new DescricaoProduto();

                String nomeProduto = request.getParameter("nomeProduto");
                String tipoProduto = request.getParameter("tipoProduto");

                if(nomeProduto != "" || tipoProduto != "")  {
                    if (nomeProduto != "") {
                        descricaoProduto.setDescricaoProduto(nomeProduto);
                    }
                    if (tipoProduto != "") {
                        descricaoProduto.setTipoProduto(tipoProduto);
                        //out.println(descricaoProduto.getTipoProduto());
                    }
                    
                    /*out.println("Entrou no IF");
                    for(DescricaoProduto dP : DescricaoProdutoDAO.consultarDescricaoProduto(descricaoProduto)) {
                        out.println(dP.getIdDescricaoProduto());
                        out.println(dP.getDescricaoProduto());
                        out.println(dP.getIdTipoProduto());
                        out.println(dP.getUnidadeProduto());
                    }*/
                    
                    List<DescricaoProduto> descProd = DescricaoProdutoDAO.consultarDescricaoProduto(descricaoProduto);
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("listarDescricaoProduto", descProd);
                    
                } else {
                    /*out.println("Entrou no Else");
                    for(DescricaoProduto dP : DescricaoProdutoDAO.listarTodosDescricaoProduto()) {
                        out.println(dP.getIdDescricaoProduto());
                        out.println(dP.getDescricaoProduto());
                        out.println(dP.getTipoProduto());
                        out.println(dP.getUnidadeProduto());
                    }*/
                    
                    List<DescricaoProduto> descProduto = DescricaoProdutoDAO.listarTodosDescricaoProduto();
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("listarDescricaoProduto", descProduto);
                }

                out.print("ok");

            } catch(SQLException ex){
                out.println(ex.getMessage());
            } catch (Exception ex) {
                out.println(ex.getMessage());
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
