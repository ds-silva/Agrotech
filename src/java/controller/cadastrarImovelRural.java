package controller;

import dao.ImovelRuralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.ImovelRural;

@WebServlet(name = "cadastrarImovelRural", urlPatterns = {"/cadastrarImovelRural"})
public class cadastrarImovelRural extends HttpServlet {

    private ImovelRural ir;
    private Endereco endereco;
    private Estado estado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                ir = new ImovelRural();
                endereco = new Endereco();
                estado = new Estado();

                //-- SETTER Imovel Rural
                ir.setnInscricaoEstadual(request.getParameter("numeroIR"));
                ir.setNirf(request.getParameter("nirf"));
                ir.setIdSituacaoImovelRural(Integer.parseInt(request.getParameter("situacaoIR")));
                ir.setTipoPropriedade(request.getParameter("tipoPropriedade"));
                ir.setTipoOcupacao(request.getParameter("tipoOcupacao"));
                ir.setMercadoAtuacao(request.getParameter("mercadoAtuacao"));
                ir.setAreaGeoreferenciada(Double.parseDouble(request.getParameter("areaGeoreferenciada")));
                ir.setAreaReservaAmbiental(Double.parseDouble(request.getParameter("areaReservaAmbiental")));
                ir.setAreaUtilizacaoAgricultura(Double.parseDouble(request.getParameter("areaAgricultura")));
                ir.setAreaUtilizacaoPecuaria(Double.parseDouble(request.getParameter("areaPecuaria")));
                ir.setLatitude(request.getParameter("latitude"));
                ir.setLongitude(request.getParameter("longitude"));

                //-- SETTER Endereço
                endereco.setCep(request.getParameter("cep"));
                endereco.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                endereco.setLogradouro(request.getParameter("logradouro"));
                endereco.setNumero(request.getParameter("numeroEndereco"));
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setCidade(request.getParameter("cidade"));

                //-- SETTER Estado
                estado.setDescricaoEstado(request.getParameter("estado"));

                //-- Composições
                endereco.setEstado(estado);
                ir.setEndereco(endereco);

                //-- DAO Cadastrar
                ImovelRuralDAO.inserirImovelRural(ir);

                out.print("ok");

            } catch (SQLException ex) {
                out.println(ex.getMessage());
            } catch (Exception e) {
                out.println(e.getMessage());
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
