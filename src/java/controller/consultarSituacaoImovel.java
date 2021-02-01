package controller;

import dao.SituacaoImovelDAO;
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
import model.ImovelRural;


@WebServlet(name = "consultarSituacaoImovel", urlPatterns = {"/consultarSituacaoImovel"})
public class consultarSituacaoImovel extends HttpServlet {

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
             try {

                ImovelRural ir = new ImovelRural();

                //if (!"".equals(request.getParameter("situacaoImovelRural"))) {
                //ir.setSituacaoImovel(request.getParameter("situacaoImovelRural"));
                //}
                if (request.getParameter("situacaoImovelRural") != "") {
                    ir.setSituacaoImovel(request.getParameter("situacaoImovelRural"));

                    List<ImovelRural> listIr = SituacaoImovelDAO.consultarSituacaoImovel(ir);
                    if (listIr != null) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("situacaoImovelRural", listIr);
                    }
                } else {
                     List<ImovelRural> listIr = SituacaoImovelDAO.ListarSituacaoImovelRural(); {
                        HttpSession session=request.getSession();  
                        session.setAttribute("situacaoImovelRural",listIr);
                    
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
