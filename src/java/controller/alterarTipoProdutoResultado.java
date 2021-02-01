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
@WebServlet(name = "alterarTipoProdutoResultado", urlPatterns = {"/alterarTipoProdutoResultado"})
public class alterarTipoProdutoResultado extends HttpServlet {

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
            
            try{
            
             DescricaoProduto descP = new DescricaoProduto();

            int id = Integer.parseInt(request.getParameter("idTipoProduto"));
            String tipoProduto = request.getParameter("tipoProduto");
         
            descP.setIdTipoProduto(id);
            descP.setTipoProduto(tipoProduto);

             TipoProdutoDAO.updateTipoProduto(descP);
    
              out.print("ok");                
        }catch (SQLException ex) {
             out.print(ex.getMessage());
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
    }
}
//            try {
//                Nacionalidade nacionalidade = new Nacionalidade(
//                        request.getParameter("sigla"), 
//                        request.getParameter("pais"));
//                    out.println("País" + nacionalidade.getSiglaNacionalidade() + "<br>");
//                    out.println("Sigla" + nacionalidade.getDescricaoNacionalidade() + "<br>");
//            } catch (Exception ex) {
//                Logger.getLogger(alterarNacionalidade.class.getName()).log(Level.SEVERE, null, ex);
//      }
//  }    
         
 }
