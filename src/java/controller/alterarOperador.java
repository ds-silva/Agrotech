package controller;

import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Operador;


@WebServlet(name = "alterarOperador", urlPatterns = {"/alterarOperador"})
public class alterarOperador extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                        int idOp = Integer.valueOf(request.getParameter("id"));
                        
                        Operador op = FuncionarioDAO.consultarUsuarioOperador(idOp);
                        
                        request.setAttribute("op", op);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("alterar_operador.jsp");
                        rd.forward(request, response);
            
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
        }
    }
}
