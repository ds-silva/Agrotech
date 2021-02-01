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
import model.Endereco;
import model.Estado;
import model.Produtor;
import model.Proprietario;

@WebServlet(name = "consultarCliente", urlPatterns = {"/consultarCliente"})
public class consultarCliente extends HttpServlet {

    //Declaração interna das variaveis utilizadas
    /* Variaveis da referencia da pagina jsp */
    private String refererencia;
    private String[] uriNames;
    private String paginaJsp;

    /*Variaveis dos objetos */
    private Proprietario proprietario;
    private Produtor produtor;
    private Endereco endereco;
    private Estado estado;


    /*Variaveis de referencias aos inputs */
    private String nomeUsuario,
            sobrenomeUsuario,
            emailUsuario,
            rgRne,
            cpfCnpjUsuario,
            cidade,
            estadoCampo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                refererencia = new URI(request.getHeader("referer")).getPath();
                uriNames = refererencia.split("/");
                paginaJsp = uriNames[uriNames.length - 1];

                produtor = new Produtor();
                proprietario = new Proprietario();
                endereco = new Endereco();
                estado = new Estado();

                nomeUsuario = request.getParameter("nomeUsuario");
                sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                emailUsuario = request.getParameter("emailUsuario");
                rgRne = request.getParameter("naturalizacaoDocumento");
                cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                cidade = request.getParameter("cidade");
                estadoCampo = request.getParameter("estado");

                switch (paginaJsp) {
                    case "consultar_proprietario.jsp":
                        out.print("Resultado Proprietário: <br> <br>");
                        for (Proprietario p : consultarProprietario()) {
                            out.print(
                                    p.getNome()
                                    + " "
                                    + p.getEmail()
                                    + " "
                                    + p.getEndereco().getLogradouro()
                                    + "<br>");
                        }
                        break;

                    case "consultar_produtor.jsp":
                        out.print("Resultado Produtor: <br> <br>");
                        for (Produtor pdt : consultarProdutor()) {
                            out.print(
                                    pdt.getNome()
                                    + " "
                                    + pdt.getEmail()
                                    + " "
                                    + pdt.getEndereco().getLogradouro()
                                    + "<br>");
                        }
                        break;
                    default:
                        out.print("Não foi possivel localizar a operação!");

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

    private List<Proprietario> consultarProprietario() throws Exception {

        List<Proprietario> proprietarioRetorno = new ArrayList<>();

        if (!"".equals(nomeUsuario)
                || !"".equals(sobrenomeUsuario)
                || !"".equals(emailUsuario)
                || !"".equals(rgRne)
                || !"".equals(cpfCnpjUsuario)
                || !"".equals(cidade)
                || !"".equals(estadoCampo)) {

            if (!"".equals(nomeUsuario)) {
                proprietario.setNome(nomeUsuario);
            }

            if (!"".equals(sobrenomeUsuario)) {
                proprietario.setSobrenome(sobrenomeUsuario);
            }

            if (!"".equals(emailUsuario)) {
                proprietario.setEmail(emailUsuario);
            }

            if (!"".equals(rgRne)) {
                proprietario.setRgRne(rgRne);
            }

            if (!"".equals(cpfCnpjUsuario)) {
                proprietario.setCpfCnpj(cpfCnpjUsuario);
            }

            if (!"".equals(cidade)) {
                endereco.setCidade(cidade);
            }

            if (!"".equals(estadoCampo)) {
                estado.setDescricaoEstado(estadoCampo);
            }

            for (Proprietario p : ClienteDAO.consultarUsuarioProprietario(proprietario, endereco, estado)) {

                proprietarioRetorno.add(p);

            }

            return proprietarioRetorno;

        } else {
            for (Proprietario p : ClienteDAO.consultarUsuarioProprietario(proprietario, endereco, estado)) {

                proprietarioRetorno.add(p);

            }

            return proprietarioRetorno;

        }

    }

    private List<Produtor> consultarProdutor() throws Exception {

        List<Produtor> produtorRetorno = new ArrayList<>();

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

            for (Produtor pdt : ClienteDAO.consultarUsuarioProdutor(produtor, endereco, estado)) {

                produtorRetorno.add(pdt);

            }

            return produtorRetorno;

        } else {
            for (Produtor pdt : ClienteDAO.consultarUsuarioProdutor(produtor, endereco, estado)) {

                produtorRetorno.add(pdt);

            }

            return produtorRetorno;

        }

    }

}
