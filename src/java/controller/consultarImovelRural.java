package controller;

import dao.ImovelRuralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Endereco;
import model.Estado;
import model.ImovelRural;

@WebServlet(name = "consultarImovelRural", urlPatterns = {"/consultarImovelRural"})
public class consultarImovelRural extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                Endereco endereco = new Endereco();

                Estado e = new Estado();

                ImovelRural ir = new ImovelRural();

                String numeroInscricaoEstadual = request.getParameter("numeroIR");

                String nirf = request.getParameter("NIRF");

                String situacaoImovelRural = request.getParameter("situacaoIR");

                String tipoPropriedade = request.getParameter("tipoPropriedade");

                String tipoOcupacao = request.getParameter("tipoOcupacao");

                String mercadoAtuacao = request.getParameter("mercadoAtuacao");

                String cidade = request.getParameter("cidade");

                String estado = request.getParameter("estado");

                if (numeroInscricaoEstadual != "" || nirf != "" || situacaoImovelRural != "" || tipoPropriedade != ""
                        || tipoOcupacao != "" || mercadoAtuacao != "" || cidade != "" || estado != "") {

                    if (numeroInscricaoEstadual != "") {
                        ir.setnInscricaoEstadual(numeroInscricaoEstadual);
                    }
                    if (nirf != "") {
                        ir.setNirf(nirf);
                    }
                    if (situacaoImovelRural != "") {
                        ir.setSituacaoImovel(situacaoImovelRural);
                    }
                    if (tipoPropriedade != "") {
                        ir.setTipoPropriedade(tipoPropriedade);
                    }
                    if (tipoOcupacao != "") {
                        ir.setTipoOcupacao(tipoOcupacao);
                    }
                    if (mercadoAtuacao != "") {
                        ir.setMercadoAtuacao(mercadoAtuacao);
                    }
                    if (cidade != "") {
                        endereco.setCidade(cidade);
                    }

                    if (estado != "") {
                        e.setDescricaoEstado(estado);
                    }

                    
                    List<ImovelRural> listImovel = ImovelRuralDAO.consultarImovelRural(ir, endereco, e);
                    if (listImovel != null){
                        HttpSession session = request.getSession();
                        session.setAttribute("listaImovelRural", listImovel);
                    }
           
                } else {
                    //out.println("entrou no else");
                    List<ImovelRural> listImovel = ImovelRuralDAO.consultarTodosImovelRural();
                    if (listImovel != null){
                        HttpSession session = request.getSession();
                        session.setAttribute("listaImovelRural", listImovel);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(consultarImovelRural.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(consultarImovelRural.class.getName()).log(Level.SEVERE, null, ex);
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
