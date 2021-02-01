/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SituacaoUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarSitResultado", urlPatterns = {"/alterarSitResultado"})
public class alterarSitResultado extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            try{
            
             Usuario sitUsuario = new Usuario();

            int id = Integer.parseInt(request.getParameter("idSituacaoUsuario"));
            String situcaoUsu = request.getParameter("situacaoUsuario");
         
            sitUsuario.setIdSituacaoUsuario(id);
            sitUsuario.setDescSituacaoUsuario(situcaoUsu);

             SituacaoUsuarioDAO.alterarSituacaoUsuario(sitUsuario);
    
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
