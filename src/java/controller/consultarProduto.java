/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
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
import model.DescricaoProduto;
import model.Produto;

/**
 *
 * @author vinic
 */
@WebServlet(name = "consultarProduto", urlPatterns = {"/consultarProduto"})
public class consultarProduto extends HttpServlet {

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
                DescricaoProduto descricaoProduto = new DescricaoProduto();
                Produto produto = new Produto();
                
                String dProduto = request.getParameter("nomeProduto");
                String tipoProduto = request.getParameter("tipoProduto");
                String ano = request.getParameter("ano");
                String mSafra = request.getParameter("mesSafra");
                
             
                if (!"".equals(dProduto) || !"".equals(tipoProduto) || !"".equals(ano) || !"".equals(mSafra)) {
                    
                    
                    if (!"".equals(dProduto)) {
                        descricaoProduto.setDescricaoProduto(dProduto);
                    }

                    if (!"".equals(tipoProduto)) {
                        descricaoProduto.setTipoProduto(tipoProduto);
                    }

                    if (!"".equals(ano)) {
                        produto.setAno(ano);
                    }

                    if (!"".equals(mSafra)) {
                        produto.setMesSafra(mSafra);
                    }
                    
                    //out.println("entrou no if! ");
                    
                    
                    List <Produto> pt = ProdutoDAO.consultarProduto(produto, descricaoProduto);
                    HttpSession session = request.getSession();
                    session.setAttribute("listaProdutos", pt);
                    //for (Produto p : pt) {
                      //  out.println("Resultado: " + p.getDescricaoProduto().getTipoProduto() + " ");
                      //  out.println(p.getDescricaoProduto().getDescricaoProduto() + " ");
                      //  out.println(p.getAno() + " ");
                      //  out.println(p.getMesSafra() + " ");
                     
                    //}
                    
                } else {
                    //out.println("entrou no else! ");
                    
                    List <Produto> pt = ProdutoDAO.consultarProduto(produto, descricaoProduto);
                    HttpSession session = request.getSession();
                    session.setAttribute("listaProdutos", pt); 
                }

                out.print("ok");

            } catch (SQLException ex) {
                out.println(ex.getMessage());
            }catch (Exception ex) {
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
