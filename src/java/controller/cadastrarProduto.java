package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DescricaoProduto;
import model.Produto;


@WebServlet(name = "cadastrarProduto", urlPatterns = {"/cadastrarProduto"})
public class cadastrarProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                //tipoProduto descricaoProduto ok
                //nomeProduto DescricaoProduto ok
                //quantidadeProduzida Produto ok
                //ano e mesSafra Produto  
                String tipoProduto = request.getParameter("tipoProduto");
                String nomeProduto = request.getParameter("nomeProduto");
                Double quantidadeP;
                Double quantidadeProduzida;
                Produto produto = new Produto();
                
                String ano = request.getParameter("ano");
                String mesSafra = request.getParameter("mesSafra");
                
                DescricaoProduto descricaoProduto = new DescricaoProduto();
                
                
                descricaoProduto.setTipoProduto(tipoProduto);
                descricaoProduto.setDescricaoProduto(nomeProduto);
                
                if (request.getParameter("quantidadeProduzida") == ""){
                    //out.println("entrou no if");
                quantidadeP = -1.;
                produto.setQuantidadeProduzida(quantidadeP);
                }else{
                quantidadeProduzida = Double.parseDouble(request.getParameter("quantidadeProduzida"));
                produto.setQuantidadeProduzida(quantidadeProduzida);
                }
                
                produto.setAno(ano);
                
                if (mesSafra != "") {
                    produto.setMesSafra(mesSafra);
                }                         
             
                ProdutoDAO.insertProduto(descricaoProduto, produto);
                 
                out.print("ok");

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
