package controller;

import dao.RegionalDAO;
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
import model.Endereco;
import model.Estado;
import model.Regional;

@WebServlet(name = "consultarRegional", urlPatterns = {"/consultarRegional"})
public class consultarRegional extends HttpServlet {

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
               
                Endereco endereco = new Endereco();
                Regional r = new Regional();
                Estado estad = new Estado();
                
                String regional = request.getParameter("regional");
                String orgaoFuncional = request.getParameter("orgaoFuncional");
                String cidade = request.getParameter("cidade");
                String estado = request.getParameter("estado"); 
                
                  
  
                if(regional !="" || orgaoFuncional !="" || cidade!="" || estado !="" ){
                    //entram regional, orgao funcional, cidade e estado
                if(regional !=""){
                    r.setDescricaoRegional(regional); 
                }
                if(orgaoFuncional !=""){
                    r.setOrgaoFuncional(orgaoFuncional);
                }
                 if(cidade!=""){
                 endereco.setCidade(cidade);
                }                
                 if( estado !=""){
                 estad.setDescricaoEstado(estado);
                 }
                 
                 List<Regional> reg = RegionalDAO.consultarRegional(r, endereco, estad);
                 
                 HttpSession sessao = request.getSession();
                 sessao.setAttribute("listarRegional", reg);
                
                 //out.print("Entrou no if"); 
            }else { 
                //out.print("Entrou no else");
                
                List<Regional> reg = RegionalDAO.consultarRegional(r, endereco, estad);
                 
                 HttpSession sessao = request.getSession();
                 sessao.setAttribute("listarRegional", reg);
            }
            

          out.print("ok");
            
            }catch (SQLException ex){
                out.println(ex.getMessage());
            }catch (Exception ex){
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
