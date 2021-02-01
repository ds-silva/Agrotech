/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegionalDAO;
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
import model.Endereco;
import model.Estado;
import model.Regional;

/**
 *
 * @author karinaxavier
 */
@WebServlet(name = "alterarRegionalResultado", urlPatterns = {"/alterarRegionalResultado"})
public class alterarRegionalResultado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //out.print("chamou servlet");
           try{
               //out.print("entrou no try");
                String e = request.getParameter("estado");
                String tl = request.getParameter("tipoLogradouro");
                String l = request.getParameter("logradouro");
                String n = request.getParameter("numeroEndereco");
                String c = request.getParameter("complemento");
                String b = request.getParameter("bairro");
                String cid = request.getParameter("cidade");
                String cep = request.getParameter("cep");
                String dr = request.getParameter("regional");
                String t = request.getParameter("telefone1");
                String og = request.getParameter("orgaoFuncional");
                int idR = Integer.valueOf(request.getParameter("idRegional"));
                int iOg = Integer.parseInt(request.getParameter("orgaoFuncional"));
                int idE = Integer.valueOf(request.getParameter("idEndereco"));
                //out.println("pegou as variaveis");
           Estado estado = new Estado();
                    estado.setIdEstado(Integer.valueOf(request.getParameter("estado")));// String descricaoEstado;
                    estado.setDescricaoEstado(e);//private String ufEstado;
            //out.println("add estado");
            Endereco endereco = new Endereco();
                    endereco.setTipoLogradouro(tl);// private String tipoLogradouro;
                    endereco.setLogradouro(l);// private String logradouro;
                    endereco.setNumero(n);// private String numero;
                    endereco.setComplemento(c);//private String complemento;
                    endereco.setBairro(b);//private String bairro;
                    endereco.setCidade(cid);//private String cidade;
                    endereco.setCep(cep);//private String cep;
                    endereco.setEstado(estado);//private Estado estado;
                    endereco.setIdEndereco(idE);//private int idEndereco;
            //out.println("add endereco");
            
            Regional regional = new Regional();     
            //out.println("regional");
                    regional.setDescricaoRegional(dr);//    private String descricaoRegional;
                    //out.println("aqui");
                    regional.setTelefone(t);//    private String telefoneRegional;
                    //out.println("aqui");
                    regional.setEndereco(endereco);//    private Endereco endereco;
                    //out.println("aqui");
                    regional.setOrgaoFuncional(og);//    private String orgaoFuncional;
                    //out.println("aqui");
                    regional.setIdRegional(idR);//    private int idRegional;
                    //out.println(request.getParameter("orgaoFuncional"));
                    //out.println("aqui");
                    regional.setIdOrgaoFuncional(iOg);//    private int idOrgaoFuncional;
            //out.println("aqui");
            RegionalDAO.alterarRegional(regional);
            //out.println("aqui");
            out.print("ok");
           
//            request.setAttribute("regional",regional);
//            RequestDispatcher rd=request.getRequestDispatcher("resultado_cons_regional.jsp");  
//            rd.forward(request, response);
           }catch (SQLException ex) {
            out.println(ex.getMessage());
            Logger.getLogger(alterarRegionalResultado.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(alterarRegionalResultado.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(alterarRegionalResultado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(alterarRegionalResultado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
