/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import dao.OrgaoFuncionalDAO;
import dao.RegionalDAO;
import dao.SituacaoUsuarioDAO;
import dao.TipoTelefoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Endereco;
import model.Estado;
import model.Regional;
import model.Telefone;
import model.Usuario;

/**
 *
 * @author josem
 */
@WebServlet(name = "alterarAdministrador", urlPatterns = {"/alterarAdministrador"})
public class alterarAdministrador extends HttpServlet {

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
            int idAdm = Integer.valueOf(request.getParameter("id"));
            
            Administrador adm = FuncionarioDAO.consultarUsuarioAdministrador(idAdm);
            
            Regional orgaoFuncional = new Regional();
            Regional regional = new Regional();
            Endereco endereco = new Endereco();
            Estado estado = new Estado();
            Telefone tipoTelefone = new Telefone();
            
            List<Regional> orgaoF = OrgaoFuncionalDAO.consultarOrgaoFuncional(orgaoFuncional);
            List<Regional> reg = RegionalDAO.consultarRegional(regional, endereco, estado);
            List<Telefone> tiposTelefone = TipoTelefoneDAO.listarTodosTipoTelefone();
            List<Usuario> sitUsu = SituacaoUsuarioDAO.listarSituacaoUsuario();
            
            
            request.setAttribute("situacaoUsuario", sitUsu);
            request.setAttribute("orgaoFuncional", orgaoF);
            request.setAttribute("regional", reg);
            request.setAttribute("AltTipoTelefone", tiposTelefone);
            request.setAttribute("administrador",adm);
            //comentar o Dispatcher e colcoar os out.print para exibir os campos que estão sendo recebidos
            RequestDispatcher rd=request.getRequestDispatcher("alterar_adm.jsp");  
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(consultarAdministradorResultado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(consultarAdministradorResultado.class.getName()).log(Level.SEVERE, null, ex);
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
