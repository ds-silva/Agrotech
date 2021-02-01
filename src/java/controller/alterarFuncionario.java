/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Nacionalidade;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;

/**
 *
 * @author josem
 */
@WebServlet(name = "alterarFuncionario", urlPatterns = {"/alterarFuncionario"})
public class alterarFuncionario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try {
                Funcionario funcionario = new Funcionario(request.getParameter("numeroCpfCnpjUsuario"), 
                        request.getParameter("senha"), 
                        request.getParameter("numeroCpfCnpjUsuario"));

                TipoUsuario tipoUsuario = new TipoUsuario();

                //Nacionalidade nacionalidade = new Nacionalidade(nacionalidadeUsuario);

                Regional regional = new Regional();

                Telefone telefone = new Telefone();

                Endereco endereco = new Endereco();

                Estado estado = new Estado();
                
                //out.println("Entrou 2!");

                String nomeUsuario = request.getParameter("nomeUsuario");
                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String matricula = request.getParameter("matriculaUsuario");
                String confirmaSenha = request.getParameter("confirmaSenha");
                //String naturalizacaoUsuario = request.getParameter("naturalizacaoUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String orgaoDocumento = request.getParameter("orgaoDocumento");
                //String dataEmissaoDocumento = request.getParameter("emissaoDocumento");
                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                
                //out.println("Entrou 3!");
                
                String sexo = request.getParameter("sexo");
                //String nascimentoUsuario = request.getParameter("nascimentoUsuario");
                String tipoUsuarioCampo = request.getParameter("tipoUsuario");
                String nacionalidadeUsuario = request.getParameter("nacionalidadeUsuario");
                String orgaoFuncional = request.getParameter("orgaoFuncional");
                String regionalCampo = request.getParameter("regional");
                
                //out.println("Entrou 4!");
                
                String tipoTelefone1 = request.getParameter("tipoTelefone1");
                String numeroTelefone1 = request.getParameter("telefone1");
                
                String tipoTelefone2 = request.getParameter("tipoTelefone2");
                String numeroTelefone2 = request.getParameter("telefone2");
                
                String tipoTelefone3 = request.getParameter("tipoTelefone3");
                String numeroTelefone3 = request.getParameter("telefone3");
                
                String tipoTelefone4 = request.getParameter("tipoTelefone4");
                String numeroTelefone4 = request.getParameter("telefone4");
                
                
                
                String cep = request.getParameter("cep");
                String tipoLogradouro = request.getParameter("tipoLogradouro");
                String logradouro = request.getParameter("logradouro");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String estadoCampo = request.getParameter("estado");
                //String uf = request.getParameter("uf");

                Nacionalidade nacionalidade = new Nacionalidade(nacionalidadeUsuario);

                SimpleDateFormat fUS = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat fBR = new SimpleDateFormat("dd/MM/yyyy");

                String dataEmissaoView;
                
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    Date dataEmissaoReg = fBR.parse(dataEmissaoView);
                    funcionario.setDataEmissaoRgRne(dataEmissaoReg);
                

                String dataNascimeView;
                
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    Date dataNascimeReg = fBR.parse(dataNascimeView);
                    funcionario.setDataNascimento(dataNascimeReg);
                
                
                //out.println("Entrou 5!");    

                funcionario.setNome(nomeUsuario);
                funcionario.setSobrenome(sobrenomeUsuario);
                funcionario.setEmail(emailUsuario);
                funcionario.setMatricula(matricula);
                funcionario.setRgRne(rgRne);
                funcionario.setOrgaoExpedidorRgRne(orgaoDocumento);;
                funcionario.setCpfCnpj(cpfCnpjUsuario);
                funcionario.setSexo(sexo);
                
                //out.println("Entrou 6!");
                
                tipoUsuario.setTipoUsuario(tipoUsuarioCampo);
                //nacionalidade.setDescricaoNacionalidade(nacionalidadeUsuario);
                funcionario.setDescricaoOrgaoFuncional(orgaoFuncional);
                regional.setDescricaoRegional(regionalCampo);
                
                //out.println("Entrou 7!");
                
                telefone.setTipoTelefone(tipoTelefone1);
                //out.println("Entrou tipoTelefone ok!");
                telefone.setNumeroTelefone(numeroTelefone1);
                //out.println("Entrou numeroTelefone ok!");
                endereco.setCep(cep);
                //out.println("Entrou cep ok!");
                endereco.setTipoLogradouro(tipoLogradouro);
                //out.println("Entrou tipoLogradouro ok!");
                endereco.setLogradouro(logradouro);
                
                //out.println("Entrou 8!");
                
                endereco.setNumero(numeroEndereco);
                //out.println("Entrou numeroEndereco ok!");
                endereco.setComplemento(complemento);
                //out.println("Entrou complemento ok!");
                endereco.setBairro(bairro);
                
                //out.println("Entrou 9!");
                
                endereco.setCidade(cidade);
                estado.setDescricaoEstado(estadoCampo);
                //estado.setUfEstado(uf);
                
                //out.println(matricula);
                //out.println(funcionario.getMatricula());
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
