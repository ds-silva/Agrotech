/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Funcionario;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Nacionalidade;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;
import model.Estado;
/**
 *
 * @author resilia
 */
@WebServlet(name = "consultarUsu", urlPatterns = {"/consultarUsu"})

public class consultarUsu extends HttpServlet {

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
        try(PrintWriter out = response.getWriter()) {
            
            try {
                //out.println("entrei!");
                Funcionario funcionario = new Funcionario(request.getParameter("numeroCpfCnpjUsuario"), 
                        request.getParameter("senha"), 
                        request.getParameter("numeroCpfCnpjUsuario"));
                //out.println("entrei depois do funcionario!");

                TipoUsuario tipoUsuario = new TipoUsuario();

                //Nacionalidade nacionalidade = new Nacionalidade();

                Regional regional = new Regional();

                Telefone telefone = new Telefone();

                Endereco endereco = new Endereco();

                Estado estado = new Estado();

                //out.println("entrei 2!");

                String nomeUsuario = request.getParameter("nomeUsuario");
                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String matricula = request.getParameter("matriculaUsuario");
                //String confirmaSenha = request.getParameter("confirmaSenha");
                //String naturalizacaoUsuario = request.getParameter("naturalizacaoUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String orgaoDocumento = request.getParameter("orgaoDocumento");
                //String dataEmissaoDocumento = request.getParameter("emissaoDocumento");
                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                String sexo = request.getParameter("sexo");
                //String nascimentoUsuario = request.getParameter("nascimentoUsuario");
                String tipoUsuarioCampo = request.getParameter("tipoUsuario");
                String nacionalidadeUsuario = request.getParameter("nacionalidadeUsuario");
                String orgaoFuncional = request.getParameter("orgaoFuncional");
                String regionalCampo = request.getParameter("regional");
                String tipoTelefone = request.getParameter("tipoTelefone1");
                //String tipoTelefone = String.valueOf(request.getAttribute("tipoTelefone1"));
                String numeroTelefone = request.getParameter("telefone1");
                String cep = request.getParameter("cep");
                String tipoLogradouro = request.getParameter("tipoLogradouro");
                String logradouro = request.getParameter("logradouro");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String estadoCampo = request.getParameter("estado");
                //String uf = request.getParameter("uf");

                //out.println("entrei 3!");

                Nacionalidade nacionalidade = new Nacionalidade(nacionalidadeUsuario);

                SimpleDateFormat fUS = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat fBR = new SimpleDateFormat("dd/MM/yyyy");

                String dataEmissaoView;
                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    Date dataEmissaoReg = fBR.parse(dataEmissaoView);
                    funcionario.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex){
                    if (ex.getErrorOffset() == 0){
                        throw new Exception ("O campo Data de Emissão está vazio");
                    } else {
                        out.println(ex.getMessage());
                    }
                    //out.println("O campo Data de Emissão está vazio");
                    //out.println(ex.getErrorOffset());
                }
                
                //out.println("entrei datEmissao!");

                String dataNascimeView;
                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    Date dataNascimeReg = fBR.parse(dataNascimeView);
                    funcionario.setDataNascimento(dataNascimeReg);
                } catch (ParseException ex){
                    if (ex.getErrorOffset() == 0){
                        throw new Exception ("O campo Data de Nascimento está vazio");
                    } else {
                        out.println(ex.getMessage());
                    }
                    //out.println("O campo Data de Nascimento está vazio");
                    //out.println(ex.getMessage());
                }
                

                //out.println("entrei 4!");

                funcionario.setNome(nomeUsuario);
                funcionario.setSobrenome(sobrenomeUsuario);
                funcionario.setEmail(emailUsuario);
                //out.println("entrei 5!");
                funcionario.setMatricula(matricula);
                //out.println("entrei 6!");
                funcionario.setRgRne(rgRne);
                funcionario.setOrgaoExpedidorRgRne(orgaoDocumento);
                //out.println("entrei 7!");
                funcionario.setCpfCnpj(cpfCnpjUsuario);
                funcionario.setSexo(sexo); 
                //out.println("entrei 8!");
                tipoUsuario.setTipoUsuario(tipoUsuarioCampo);
                //out.println("entrei 9!");
                nacionalidade.setDescricaoNacionalidade(nacionalidadeUsuario);
                //out.println("entrei 10!");
                funcionario.setDescricaoOrgaoFuncional(orgaoFuncional);
                regional.setDescricaoRegional(regionalCampo);
                //out.println("entrei 11!");
                
                telefone.setTipoTelefone(tipoTelefone);
                //out.println("entrei 11.1!");
                telefone.setNumeroTelefone(numeroTelefone);
                
                
                
                //out.println("entrei 12!");
                endereco.setCep(cep);
                endereco.setTipoLogradouro(tipoLogradouro);
                endereco.setLogradouro(logradouro);
                endereco.setNumero(numeroEndereco);
                endereco.setComplemento(complemento);
                //out.println("entrei 13!");
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                estado.setDescricaoEstado(estadoCampo);
                //estado.setUfEstado(uf);
                //out.println("entrei 14!");
                
                /*String telefones[] = new String[4];
                String telsTipo, telsNum;
                int accTelefones = 1,  accTipoTelefones = 1;
                for (int i = 0; i < 4; i++) {
                    telsTipo = String.valueOf(request.getParameter("tipoTelefone" + accTipoTelefones++));
                    telsNum = String.valueOf(request.getParameter("telefone" + + accTelefones++));
                    telefone.setTipoTelefone(telsTipo);
                    telefone.setNumeroTelefone(telsNum);
                    telefones[i] = telefone.getTipoTelefone() + telefone.getNumeroTelefone();
                }*/

                //out.println(Arrays.toString(telefones) + "<br>");
                
                //out.println(numeroTelefone);
                
                //out.println(tipoTelefone.getClass().getSimpleName());
                //out.println(tipoTelefone);
                
                out.print("ok");


            } catch (Exception ex) {
                out.println(ex.getMessage());
                //out.println("error");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(consultarUsu.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(consultarUsu.class.getName()).log(Level.SEVERE, null, ex);
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
