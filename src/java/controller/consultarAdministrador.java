/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
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
import model.Administrador;
import model.Agente;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Operador;
import model.Regional;

/**
 *
 * @author josem
 */
@WebServlet(name = "consultarAdministrador", urlPatterns = {"/consultarAdministrador"})
public class consultarAdministrador extends HttpServlet {

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
            try{
                Administrador adm = new Administrador();
                //agente = new Agente();
                //operador = new Operador();
                Regional regional = new Regional();
                Endereco endereco = new Endereco();
                Estado estado = new Estado();
                
                String nomeUsuario = request.getParameter("nomeUsuario");
                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String matricula = request.getParameter("matriculaUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                String orgaoFuncional = request.getParameter("orgaoFuncional");
                String regionalCampo = request.getParameter("regional");
                String cidade = request.getParameter("cidade");
                String estadoCampo = request.getParameter("estado");
                
                
                if (!"".equals(nomeUsuario)
                    || !"".equals(sobrenomeUsuario)
                    || !"".equals(emailUsuario)
                    || !"".equals(matricula)
                    || !"".equals(rgRne)
                    || !"".equals(cpfCnpjUsuario)
                    || !"".equals(orgaoFuncional)
                    || !"".equals(regionalCampo)
                    || !"".equals(cidade)
                    || !"".equals(estadoCampo)) {

                    if (!"".equals(nomeUsuario)) {
                        adm.setNome(nomeUsuario);
                    }

                    if (!"".equals(sobrenomeUsuario)) {
                        adm.setSobrenome(sobrenomeUsuario);
                    }

                    if (!"".equals(emailUsuario)) {
                        adm.setEmail(emailUsuario);
                    }

                    if (!"".equals(matricula)) {
                        adm.setMatricula(matricula);
                    }

                    if (!"".equals(rgRne)) {
                        adm.setRgRne(rgRne);
                    }

                    if (!"".equals(cpfCnpjUsuario)) {
                        adm.setCpfCnpj(cpfCnpjUsuario);
                    }

                    if (!"".equals(orgaoFuncional)) {
                        adm.setDescricaoOrgaoFuncional(orgaoFuncional);
                    }

                    if (!"".equals(regionalCampo)) {
                        regional.setDescricaoRegional(regionalCampo);
                    }

                    if (!"".equals(cidade)) {
                        endereco.setCidade(cidade);
                    }

                    if (!"".equals(estadoCampo)) {
                        estado.setDescricaoEstado(estadoCampo);
                    }
                    
                    //out.println("entrou no if");
                    
                    List<Administrador> adms = FuncionarioDAO.consultarUsuarioAdministrador(adm, regional, endereco, estado);
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("listarAdm", adms);
        
                    
                    /*for (Funcionario n : FuncionarioDAO.consultarUsuarioAdministrador(adm, regional, endereco, estado)) {
                        out.println("Passou pela tabela! <br> Resultado: "
                                + n.getIdUsuario()
                                + " "
                                + n.getNome());
                    }*/
                
                } else {
                    //out.println("entrou no else");
                    
                    List<Administrador> adms = FuncionarioDAO.consultarUsuarioAdministrador(adm, regional, endereco, estado);
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("listarAdm", adms);
                    
                    /*for (Funcionario n : FuncionarioDAO.consultarUsuarioAdministrador(adm, regional, endereco, estado)) {
                        out.println("Passou pela tabela! <br> Resultado: "
                                + n.getIdUsuario()
                                + " "
                                + n.getNome());
                    }*/
                }
                
                
                //out.println(request.getParameter("nomeUsuario"));
                out.print("ok");

            }catch (SQLException ex) {
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
