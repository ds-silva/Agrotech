package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DescricaoProduto;
import model.Produto;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarProduto", urlPatterns = {"/alterarProduto"})
public class alterarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                DescricaoProduto descricaoProduto = new DescricaoProduto();
                Produto produto = new Produto();

                String ano = request.getParameter("ano");
                double quantidadeProduzida = Double.parseDouble(request.getParameter("quantidadeProduzida"));
                String mesSafra = request.getParameter("mesSafra");
                int idDescricao = Integer.parseInt(request.getParameter("nomeProduto"));
                int idProduto = Integer.valueOf(request.getParameter("idProduto"));

                produto.setAno(mesSafra);
                produto.setAno(ano);
                produto.setQuantidadeProduzida(quantidadeProduzida);
                produto.setMesSafra(mesSafra);
                descricaoProduto.setIdDescricaoProduto(idDescricao);
                produto.setDescricaoProduto(descricaoProduto);

                produto.setIdProduto(idProduto);
                ProdutoDAO.alterarProduto(produto);

                out.print("ok");
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception e) {
                out.print(e);
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
