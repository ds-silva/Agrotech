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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import model.Usuario;

/**
 *
 * @author vinic
 */
@WebServlet(name = "alterarUsu", urlPatterns = {"/alterarUsu"})
public class alterarUsu extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Nacionalidade nac = new Nacionalidade();
            Regional reg = new Regional();

            Estado uf = new Estado(
                    request.getParameter("estado"),
                    request.getParameter("uf"));

            Endereco endereco = new Endereco(
                    request.getParameter("logradouro"),
                    request.getParameter("numeroEndereco"),
                    request.getParameter("bairro"),
                    request.getParameter("cidade"),
                    request.getParameter("cep"),
                    request.getParameter("tipoLogradouro"),
                    request.getParameter("complemento"));

            Telefone tel = new Telefone(request.getParameter("tipoTelefone"),
                    request.getParameter("telefone"));

            Usuario us = new Usuario(
                    request.getParameter("log"),
                    request.getParameter("senha"),
                    request.getParameter("numeroCpfCnpjUsuario"));

            TipoUsuario tu = new TipoUsuario(request.getParameter("tipoUsuario"));

            Funcionario fn = new Funcionario(request.getParameter("orgaoFuncional"));

            String nomeUsuario = request.getParameter("nomeUsuario"),
                    sobrenomeUsuario = request.getParameter("sobrenomeUsuario"),
                    emailUsuario = request.getParameter("emailUsuario"),
                    matriculaUsuario = request.getParameter("matriculaUsuario"),
                    situacaoUsuario = request.getParameter("situacaoUsuario"),
                    confirmaSenha = request.getParameter("confirmaSenha"),
                    naturalizacaoUsuario = request.getParameter("naturalizacaoUsuario"),
                    naturalizacaodocumento = request.getParameter("naturalizacaoDocumento"),
                    orgaoDocumento = request.getParameter("orgaoDocumento"),
                    cpfCnpjUsuario = request.getParameter("cpfCnpjUsuario"),
                    sexo = request.getParameter("sexo"),
                    nacionalidadeUsuario = request.getParameter("nacionalidadeUsuario"),
                    regional = request.getParameter("regional");
            
            Nacionalidade nac = new Nacionalidade(nacionalidadeUsuario);
                   
            SimpleDateFormat fUS = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fBR = new SimpleDateFormat("dd/MM/yyyy");

            String dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
            String dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));

            Date dataEmissaoReg = fBR.parse(dataEmissaoView);
            Date dataNascimeReg = fBR.parse(dataNascimeView);

            us.setNome(nomeUsuario);
            us.setSobrenome(sobrenomeUsuario);
            us.setEmail(emailUsuario);
            us.setDescSituacaoUsuario(situacaoUsuario);
            
            us.setRgRne(naturalizacaodocumento);
            
            us.setOrgaoExpedidorRgRne(orgaoDocumento);
            
            us.setSexo(sexo);
            
            us.setDataEmissaoRgRne(dataEmissaoReg);
            us.setDataNascimento(dataNascimeReg);
            
            //nac.setDescricaoNacionalidade(nacionalidadeUsuario);
            reg.setDescricaoRegional(regional);

            out.println("Nome:" + us.getNome() + "<br>");
            out.println("Sobrenome:" + us.getSobrenome() + "<br>");
            out.println("E-mail:" + us.getEmail() + "<br>");
            out.println("Matrícula:" + matriculaUsuario + "<br>"); //não tem o get e o set no model!
            out.println("Situação Usuário:" + us.getDescSituacaoUsuario() + "<br>");
            out.println("Senha:" + us.getSenha() + "<br>");
            out.println("Confirme sua Senha:" + confirmaSenha + "<br>"); //não tem o get e o set no model!
            out.println("Naturalização:" + naturalizacaoUsuario + "<br>"); //não tem o get e o set no model!
            out.println("Número Doc.:" + us.getRgRne() + "<br>"); 
            out.println("Orgão Exp.:" + us.getOrgaoExpedidorRgRne() + "<br>");
            out.println("Data Emissão:" + fBR.format(us.getDataEmissaoRgRne()) + "<br>");
            out.println("CPF/CNPJ:" + cpfCnpjUsuario + "<br>");
            out.println("Número:" + us.getCpfCnpj() + "<br>");
            out.println("Sexo:" + us.getSexo() + "<br>");
            out.println("Data Nasc.:" + fBR.format(us.getDataNascimento()) + "<br>");
            out.println("Tipo Usuario:" + tu.getTipoUsuario() + "<br>");
            out.println("Nacionalidade:" + nac.getDescricaoNacionalidade() + "<br>"); //composição!
            out.println("Org. Func.:" + fn.getDescricaoOrgaoFuncional() + "<br>");
            out.println("Regional:" + reg.getDescricaoRegional() + "<br>"); //composição!
            out.println("Tipo Tel.:" + tel.getTipoTelefone() + "<br>");
            out.println("Telefone:" + tel.getNumeroTelefone() + "<br>");
            out.println("CEP:" + endereco.getCep() + "<br>");
            out.println("Tipo Logradouro:" + endereco.getTipoLogradouro() + "<br>");
            out.println("Logradouro:" + endereco.getLogradouro() + "<br>");
            out.println("Número:" + endereco.getNumero() + "<br>");
            out.println("Complemento:" + endereco.getComplemento() + "<br>");
            out.println("Bairro:" + endereco.getBairro() + "<br>");
            out.println("Cidade:" + endereco.getCidade() + "<br>");
            out.println("Estado:" + uf.getDescricaoEstado() + "<br>");
            out.println("UF:" + uf.getUfEstado() + "<br>");

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(alterarUsu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(alterarUsu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
