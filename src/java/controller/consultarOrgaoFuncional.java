package controller;

import dao.OrgaoFuncionalDAO;
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
import model.Regional;


@WebServlet(name = "consultarOrgaoFuncional", urlPatterns = {"/consultarOrgaoFuncional"})
public class consultarOrgaoFuncional extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                Regional regional = new Regional();
                
                String oG = request.getParameter("orgaoFuncional");

                if (!"".equals(oG)) {
                    regional.setOrgaoFuncional(oG);
                    
                    List<Regional> orgaoF = OrgaoFuncionalDAO.consultarOrgaoFuncional(regional);
                    
                    if (orgaoF!=null){
                        HttpSession session = request.getSession();
                        session.setAttribute("listaOrgaoFuncional", orgaoF);
                        /*for (Regional r: OrgaoFuncionalDAO.consultarOrgaoFuncional(regional)){
                            out.println("Passou pela tabela! <br> Resultado: " + r.getOrgaoFuncional());
                        }*/
                    }
                    
                }else{
                    List<Regional> orgaoF = OrgaoFuncionalDAO.consultarOrgaoFuncional(regional);
                    HttpSession session = request.getSession();
                    session.setAttribute("listaOrgaoFuncional", orgaoF);
                    /*
                    for (Regional r: OrgaoFuncionalDAO.consultarOrgaoFuncional(regional)){
                        out.print(r.getOrgaoFuncional());
                    }*/

                }
                
                
                /*Telefone telefone = new Telefone();
                
                if (request.getParameter("tipoTelefone") != "") {
                    telefone.setTipoTelefone(request.getParameter("tipoTelefone"));
                    
                    List<Telefone> tiposTelefone = TipoTelefoneDAO.getTipoTelefone(telefone);

                    if (tiposTelefone!= null) {
                        HttpSession session=request.getSession();  
                        session.setAttribute("listaTiposTelefone",tiposTelefone);
                    }                     
                } else {
                    for (Telefone t: TipoTelefoneDAO.listarTodosTipoTelefone()){
                        out.println(t.getTipoTelefone());
                    }
                }*/

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
