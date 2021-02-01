/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DescricaoProduto;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarTipoProduto", urlPatterns = {"/alterarTipoProduto"})
public class alterarTipoProduto extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            int idTpd = Integer.valueOf(request.getParameter("id"));
            
            DescricaoProduto tipoProduto = TipoProdutoDAO.selectTipoProduto(idTpd);
            
            request.setAttribute("tipoProduto",tipoProduto);
            RequestDispatcher rd = request.getRequestDispatcher("alterar_tipo_produto.jsp");
            rd.forward(request, response);
                
            }catch (SQLException ex) {
            Logger.getLogger(consultarNacionalidadeResultado.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
            Logger.getLogger(alterarTipoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
