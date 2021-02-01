package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                Usuario usuario = new Usuario();

                String login = request.getParameter("login");
                usuario.setLogin(login);
                String senha = request.getParameter("senha");
                usuario.setSenha(senha);

                if (UsuarioDAO.login(usuario)) {
                    HttpSession session = request.getSession();

                    session.setAttribute("user", login);
                    session.setAttribute("tipoUsuario", UsuarioDAO.retornaTipoUsuario(usuario).getTipoUsuario());
                    session.setAttribute("idUsuarioSession", UsuarioDAO.retornaIdUsuario(usuario));

                    out.print("ok");

                } else {

                    out.print("Não foi possivel localizar usuário!   ");
                }

            } catch (SQLException e) {

                out.print(e.getMessage());

            } catch (Exception ex) {

                out.print(ex.getMessage());

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
