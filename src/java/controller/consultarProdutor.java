package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Endereco;
import model.Estado;
import model.Produtor;


@WebServlet(name = "consultarProdutor", urlPatterns = {"/consultarProdutor"})
public class consultarProdutor extends HttpServlet {
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
        try ( PrintWriter out = response.getWriter()) {
            try {

                Produtor produtor = new Produtor();
                
                Endereco endereco = new Endereco();
                Estado estado = new Estado();

                String nomeUsuario = request.getParameter("nomeUsuario");
                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                String cidade = request.getParameter("cidade");
                String estadoCampo = request.getParameter("estado");

                if (!"".equals(nomeUsuario)
                        || !"".equals(sobrenomeUsuario)
                        || !"".equals(emailUsuario)
                        || !"".equals(rgRne)
                        || !"".equals(cpfCnpjUsuario)
                        || !"".equals(cidade)
                        || !"".equals(estadoCampo)) {

                    if (!"".equals(nomeUsuario)) {
                        produtor.setNome(nomeUsuario);
                    }

                    if (!"".equals(sobrenomeUsuario)) {
                        produtor.setSobrenome(sobrenomeUsuario);
                    }

                    if (!"".equals(emailUsuario)) {
                        produtor.setEmail(emailUsuario);
                    }

                    if (!"".equals(rgRne)) {
                        produtor.setRgRne(rgRne);
                    }

                    if (!"".equals(cpfCnpjUsuario)) {
                        produtor.setCpfCnpj(cpfCnpjUsuario);
                    }

                    if (!"".equals(cidade)) {
                        endereco.setCidade(cidade);
                    }

                    if (!"".equals(estadoCampo)) {
                        estado.setDescricaoEstado(estadoCampo);
                    }

                    List<Produtor> produtores = ClienteDAO.consultarUsuarioProdutor(produtor, endereco, estado);

                    HttpSession session = request.getSession();
                    session.setAttribute("listarProdutor", produtores);

                } else {
                    List<Produtor> produtores = ClienteDAO.consultarUsuarioProdutor(produtor, endereco, estado);

                    HttpSession session = request.getSession();
                    session.setAttribute("listarProdutor", produtores);
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
