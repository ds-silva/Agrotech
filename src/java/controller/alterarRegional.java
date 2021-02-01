 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstadoDAO;
import dao.OrgaoFuncionalDAO;
import dao.RegionalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Endereco;
import model.Estado;
import model.Regional;


/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarRegional", urlPatterns = {"/alterarRegional"})
public class alterarRegional extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //out.println("chamou o servlet");
            int idRegional = Integer.parseInt(request.getParameter("id"));
            
            Regional regional = RegionalDAO.getRegional(idRegional);
            
            Regional regional1 = new Regional();
            Regional orgaoFuncional = new Regional();
            Endereco endereco = new Endereco();
            Estado estado = new Estado();
            
            //dropdown listar orgao funcional
            List<Regional> orgao = OrgaoFuncionalDAO.consultarOrgaoFuncional(orgaoFuncional);
            request.setAttribute("orgaoFuncional", orgao);
            
            //dropdown listar descricao regional
            List<Regional> dRegional = RegionalDAO.consultarRegional(regional1, endereco, estado);
            request.setAttribute("dRegional", dRegional);
            
            //dropdown listar estado
            List<Estado> est = EstadoDAO.listarTodosEstados();
            request.setAttribute("estado", est);
            
            
            request.setAttribute("regional",regional);
            RequestDispatcher rd=request.getRequestDispatcher("alterar_regional.jsp");  
            rd.forward(request, response);
            
       
        } catch (Exception ex) {
            Logger.getLogger(alterarRegional.class.getName()).log(Level.SEVERE, null, ex);
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
