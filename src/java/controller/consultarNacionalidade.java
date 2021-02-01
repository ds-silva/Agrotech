package controller;

import dao.NacionalidadeDAO;
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
import model.Nacionalidade;

@WebServlet(name = "consultarNacionalidade", urlPatterns = {"/consultarNacionalidade"})
public class consultarNacionalidade extends HttpServlet {

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

                Nacionalidade nac = new Nacionalidade();
                
                if(request.getParameter("pais") != "" || request.getParameter("sigla") != ""){
                if (request.getParameter("pais") != "") {
                    nac.setDescricaoNacionalidade(request.getParameter("pais"));
                }
                if(request.getParameter("sigla") != ""){
                    nac.setSiglaNacionalidade(request.getParameter("sigla"));
                }    
                    
                    List<Nacionalidade> listNac = NacionalidadeDAO.consultarNacionalidade(nac);
                    if (listNac != null ) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("listaNacionalidade",listNac);
                    }
                } else {
                  
                     List<Nacionalidade> listNac = NacionalidadeDAO.listarNacionalidade();
                    if (listNac != null) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("listaNacionalidade",listNac);
                    }
                }
                out.print("ok");

            } catch (SQLException ex) {
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
