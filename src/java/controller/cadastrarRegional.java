package controller;

import dao.RegionalDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.Regional;
import model.Telefone;

@WebServlet(name = "cadastrarRegional", urlPatterns = {"/cadastrarRegional"})
public class cadastrarRegional extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                
                Regional regional = new Regional();
                regional.setOrgaoFuncional(request.getParameter("orgaoFuncional"));
                regional.setDescricaoRegional(request.getParameter("regional"));
                
                Endereco endereco = new Endereco();
                /*(request.getParameter("cep"),
                        request.getParameter("tipoLogradouro"),
                        request.getParameter("logradouro"),
                        request.getParameter("numeroEndereco"),
                        request.getParameter("complemento"),
                        request.getParameter("bairro"),
                        request.getParameter("cidade"));*/
                        
                endereco.setCep(request.getParameter("cep"));
                endereco.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                endereco.setLogradouro(request.getParameter("logradouro"));
                endereco.setNumero(request.getParameter("numeroEndereco"));
                endereco.setComplemento(request.getParameter("complemento"));
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setCidade(request.getParameter("cidade"));
                
                Estado estado = new Estado(request.getParameter("estado"));
                
                regional.setTelefone(request.getParameter("telefone1"));
                
                
                RegionalDAO.insertRegional(regional, endereco, estado);
                
                out.print("ok");
                
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
