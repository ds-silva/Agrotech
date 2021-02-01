package controller;

import dao.FuncionarioDAO;
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
import model.Agente;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Operador;
import model.Regional;

@WebServlet(name = "consultarFuncionario", urlPatterns = {"/consultarFuncionario"})
public class consultarFuncionario extends HttpServlet {

    //Declaração interna das variaveis utilizadas
    /* Variaveis da referencia da pagina jsp */
    private String refererencia;
    private String[] uriNames;
    private String paginaJsp;

    /*Variaveis dos objetos */
    private Funcionario funcionario;
    private Agente agente;
    private Operador operador;
    private Regional regional;
    private Endereco endereco;
    private Estado estado;


    /*Variaveis de referencias aos inputs */
    private String nomeUsuario,
            sobrenomeUsuario,
            emailUsuario,
            matricula,
            rgRne,
            cpfCnpjUsuario,
            orgaoFuncional,
            regionalCampo,
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

                funcionario = new Funcionario();
                agente = new Agente();
                operador = new Operador();
                regional = new Regional();
                endereco = new Endereco();
                estado = new Estado();
                
                nomeUsuario = request.getParameter("nomeUsuario");
                sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                emailUsuario = request.getParameter("emailUsuario");
                matricula = request.getParameter("matriculaUsuario");
                rgRne = request.getParameter("naturalizacaoDocumento");
                cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                orgaoFuncional = request.getParameter("orgaoFuncional");
                regionalCampo = request.getParameter("regional");
                cidade = request.getParameter("cidade");
                estadoCampo = request.getParameter("estado");

                switch (paginaJsp) {
                    case "consultar_adm.jsp":
                        out.print("Resultado Administrador: <br> <br>");
                        for (Funcionario f : consultarAdministrador()) {
                            out.print(
                                    f.getNome()
                                    + " "
                                    + f.getEmail()
                                    + " "
                                    + f.getEndereco().getLogradouro()
                                    + " "
                                    + f.getMatricula()
                                    + "<br>");
                        }
                        break;

                    case "consultar_agente.jsp":
                        out.print("Resultado Agente: <br> <br>");
                        for (Agente a : consultarAgente()) {
                            out.print(
                                    a.getNome()
                                    + " "
                                    + a.getEmail()
                                    + " "
                                    + a.getEndereco().getLogradouro()
                                    + " "
                                    + a.getMatricula()
                                    + "<br>");
                        }
                        break;

                    case "consultar_operador.jsp":
                        out.print("Resultado Operador: <br> <br>");
                        for (Operador opr : consultarOperador()) {
                            out.print(
                                    opr.getNome()
                                    + " "
                                    + opr.getEmail()
                                    + " "
                                    + opr.getEndereco().getLogradouro()
                                    + " "
                                    + opr.getMatricula()
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

    private List<Funcionario> consultarAdministrador() throws Exception {

        List<Funcionario> funcionarioRetorno = new ArrayList<>();

        if (!"".equals(nomeUsuario)
                || !"".equals(sobrenomeUsuario)
                || !"".equals(emailUsuario)
                || !"".equals(matricula)
                || !"".equals(rgRne)
                || !"".equals(cpfCnpjUsuario)
                || !"".equals(orgaoFuncional)
                || !"".equals(regionalCampo)
                || !"".equals(cidade)
                || !"".equals(estadoCampo)) {

            if (!"".equals(nomeUsuario)) {
                funcionario.setNome(nomeUsuario);
            }

            if (!"".equals(sobrenomeUsuario)) {
                funcionario.setSobrenome(sobrenomeUsuario);
            }

            if (!"".equals(emailUsuario)) {
                funcionario.setEmail(emailUsuario);
            }

            if (!"".equals(matricula)) {
                funcionario.setMatricula(matricula);
            }

            if (!"".equals(rgRne)) {
                funcionario.setRgRne(rgRne);
            }

            if (!"".equals(cpfCnpjUsuario)) {
                funcionario.setCpfCnpj(cpfCnpjUsuario);
            }

            if (!"".equals(orgaoFuncional)) {
                funcionario.setDescricaoOrgaoFuncional(orgaoFuncional);
            }

            if (!"".equals(regionalCampo)) {
                regional.setDescricaoRegional(regionalCampo);
            }

            if (!"".equals(cidade)) {
                endereco.setCidade(cidade);
            }

            if (!"".equals(estadoCampo)) {
                estado.setDescricaoEstado(estadoCampo);
            }

            /*for (Funcionario f : FuncionarioDAO.consultarUsuarioAdministrador(funcionario, regional, endereco, estado)) {

                funcionarioRetorno.add(f);

            }*/

            return funcionarioRetorno;

        } else {
            /*for (Funcionario f : FuncionarioDAO.consultarUsuarioAdministrador(funcionario, regional, endereco, estado)) {
                funcionarioRetorno.add(f);
            }*/

            return funcionarioRetorno;

        }

    }

    private List<Agente> consultarAgente() throws Exception {

        List<Agente> agenteRetorno = new ArrayList<>();

        if (!"".equals(nomeUsuario)
                || !"".equals(sobrenomeUsuario)
                || !"".equals(emailUsuario)
                || !"".equals(matricula)
                || !"".equals(rgRne)
                || !"".equals(cpfCnpjUsuario)
                || !"".equals(orgaoFuncional)
                || !"".equals(regionalCampo)
                || !"".equals(cidade)
                || !"".equals(estadoCampo)) {

            if (!"".equals(nomeUsuario)) {
                agente.setNome(nomeUsuario);
            }

            if (!"".equals(sobrenomeUsuario)) {
                agente.setSobrenome(sobrenomeUsuario);
            }

            if (!"".equals(emailUsuario)) {
                agente.setEmail(emailUsuario);
            }

            if (!"".equals(matricula)) {
                agente.setMatricula(matricula);
            }

            if (!"".equals(rgRne)) {
                agente.setRgRne(rgRne);
            }

            if (!"".equals(cpfCnpjUsuario)) {
                agente.setCpfCnpj(cpfCnpjUsuario);
            }

            if (!"".equals(orgaoFuncional)) {
                agente.setDescricaoOrgaoFuncional(orgaoFuncional);
            }

            if (!"".equals(regionalCampo)) {
                regional.setDescricaoRegional(regionalCampo);
            }

            if (!"".equals(cidade)) {
                endereco.setCidade(cidade);
            }

            if (!"".equals(estadoCampo)) {
                estado.setDescricaoEstado(estadoCampo);
            }

            for (Agente a : FuncionarioDAO.consultarUsuarioAgente(agente, regional, endereco, estado)) {

                agenteRetorno.add(a);

            }

            return agenteRetorno;

        } else {
            for (Agente a : FuncionarioDAO.consultarUsuarioAgente(agente, regional, endereco, estado)) {

                agenteRetorno.add(a);

            }

            return agenteRetorno;
        }

    }

    private List<Operador> consultarOperador() throws Exception {

        List<Operador> operadorRetorno = new ArrayList<>();

        if (!"".equals(nomeUsuario)
                || !"".equals(sobrenomeUsuario)
                || !"".equals(emailUsuario)
                || !"".equals(matricula)
                || !"".equals(rgRne)
                || !"".equals(cpfCnpjUsuario)
                || !"".equals(orgaoFuncional)
                || !"".equals(regionalCampo)
                || !"".equals(cidade)
                || !"".equals(estadoCampo)) {

            if (!"".equals(nomeUsuario)) {
                operador.setNome(nomeUsuario);
            }

            if (!"".equals(sobrenomeUsuario)) {
                operador.setSobrenome(sobrenomeUsuario);
            }

            if (!"".equals(emailUsuario)) {
                operador.setEmail(emailUsuario);
            }

            if (!"".equals(matricula)) {
                operador.setMatricula(matricula);
            }

            if (!"".equals(rgRne)) {
                operador.setRgRne(rgRne);
            }

            if (!"".equals(cpfCnpjUsuario)) {
                operador.setCpfCnpj(cpfCnpjUsuario);
            }

            if (!"".equals(orgaoFuncional)) {
                operador.setDescricaoOrgaoFuncional(orgaoFuncional);
            }

            if (!"".equals(regionalCampo)) {
                regional.setDescricaoRegional(regionalCampo);
            }

            if (!"".equals(cidade)) {
                endereco.setCidade(cidade);
            }

            if (!"".equals(estadoCampo)) {
                estado.setDescricaoEstado(estadoCampo);
            }

            for (Operador ops : FuncionarioDAO.consultarUsuarioOperador(operador, regional, endereco, estado)) {

                operadorRetorno.add(ops);

            }

            return operadorRetorno;

        } else {
            for (Operador ops : FuncionarioDAO.consultarUsuarioOperador(operador, regional, endereco, estado)) {

                operadorRetorno.add(ops);

            }

            return operadorRetorno;
        }

    }

}
