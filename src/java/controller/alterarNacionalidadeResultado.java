/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NacionalidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nacionalidade;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarNacionalidadeResultado", urlPatterns = {"/alterarNacionalidadeResultado"})
public class alterarNacionalidadeResultado extends HttpServlet {

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
            
             Nacionalidade nac = new Nacionalidade();
//             int idNac = Integer.valueOf(request.getParameter("id"));
//             String pais = request.getParameter("pais");
//             String sigla = request.getParameter("sigla");
             
//             nac.setIdNacionalidade(idNac);
//             nac.setDescricaoNacionalidade(pais);
//             nac.setSiglaNacionalidade(sigla);

            int id = Integer.parseInt(request.getParameter("idNacionalidade"));
            String pais = request.getParameter("pais");
            String sigla = request.getParameter("sigla");
             
            nac.setIdNacionalidade(id);
            nac.setDescricaoNacionalidade(pais);
            nac.setSiglaNacionalidade(sigla);
//              boolean n = NacionalidadeDAO.alterarNacionalidade(nac);
            
            
             NacionalidadeDAO.alterarNacionalidade(nac);
             
             
              out.print("ok");
//            request.setAttribute("nac", n);
//            RequestDispatcher rd=request.getRequestDispatcher("li_consulta_nac.jsp");  
//            rd.forward(request, response);
                    
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
