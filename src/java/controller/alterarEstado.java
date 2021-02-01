
package controller;

import dao.EstadoDAO;
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
import model.Estado;


@WebServlet(name = "alterarEstado", urlPatterns = {"/alterarEstado"})
public class alterarEstado extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
             int idEst = Integer.valueOf(request.getParameter("id"));
            
            Estado estado = EstadoDAO.getEstado(idEst);
            
            request.setAttribute("estado", estado);
            RequestDispatcher rd = request.getRequestDispatcher("alterar_estado.jsp");
            rd.forward(request, response);
                
            }catch (SQLException ex) {
            Logger.getLogger(consultarNacionalidadeResultado.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
            Logger.getLogger(alterarTipoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

