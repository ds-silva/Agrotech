/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

/**
 *
 * @author karina.farias
 */
@WebServlet(name = "cadastrarFuncionario", urlPatterns = {"/cadastrarFuncionario"})
public class cadastrarFuncionario extends HttpServlet {

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
            try {
                /*Funcionario funcionario = new Funcionario(request.getParameter("numeroCpfCnpjUsuario"), 
                        request.getParameter("senha"), 
                        request.getParameter("numeroCpfCnpjUsuario"));*/
                Funcionario funcionario = new Funcionario();
                
                //String login = request.getParameter("numeroCpfCnpjUsuario");
                //String senha = request.getParameter("senha");
                //String cpfCnpj = request.getParameter("numerpCpfCnpjUsuario");
                

                TipoUsuario tipoUsuario = new TipoUsuario();

                //Nacionalidade nacionalidade = new Nacionalidade(nacionalidadeUsuario);

                Regional regional = new Regional();

                Telefone telefone1 = new Telefone();
                
                Telefone telefone2 = new Telefone();
                
                Telefone telefone3 = new Telefone();
                
                Telefone telefone4 = new Telefone();

                Endereco endereco = new Endereco();

                Estado estado = new Estado();
                
                //out.println("Entrou 2!");

                String nomeUsuario = request.getParameter("nomeUsuario");
                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String matricula = request.getParameter("matriculaUsuario");
                String senha = request.getParameter("senha");
                String confirmaSenha = request.getParameter("confirmaSenha");
                //String naturalizacaoUsuario = request.getParameter("naturalizacaoUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String orgaoDocumento = request.getParameter("orgaoDocumento");
                //String dataEmissaoDocumento = request.getParameter("emissaoDocumento");
                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");
                String login = request.getParameter(cpfCnpjUsuario);
                
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
                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    Date dataEmissaoReg = fBR.parse(dataEmissaoView);
                    funcionario.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex){
                    if (ex.getErrorOffset() == 0){
                        throw new Exception ("O campo Data de Emissão está vazio");
                    } else {
                        //out.println(ex.getMessage());
                    }
                    //out.println("O campo Data de Emissão está vazio");
                    //out.println(ex.getErrorOffset());
                }    
                

                String dataNascimeView;
                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    Date dataNascimeReg = fBR.parse(dataNascimeView);
                    funcionario.setDataNascimento(dataNascimeReg);
                } catch (ParseException ex){
                    if (ex.getErrorOffset() == 0){
                        throw new Exception ("O campo Data de Nascimento está vazio");
                    } else {
                        //out.println(ex.getMessage());
                    }
                    //out.println("O campo Data de Nascimento está vazio");
                    //out.println(ex.getMessage());
                }    
                
                
                //out.println("Entrou 5!");    
                funcionario.setSenha(senha);
                funcionario.setLogin(login);
                //funcionario.setCpfCnpj(cpfCnpjUsuario);
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
                
                telefone1.setTipoTelefone(tipoTelefone1);
                //out.println("Entrou tipoTelefone ok!");
                telefone1.setNumeroTelefone(numeroTelefone1);
                
                if (numeroTelefone2 != "" || tipoTelefone2 != ""){
                    telefone2.setTipoTelefone(tipoTelefone2);
                    telefone2.setNumeroTelefone(numeroTelefone2);
                }
                
                if (numeroTelefone3 != "" || tipoTelefone3 != ""){
                    telefone3.setTipoTelefone(tipoTelefone3);
                    telefone3.setNumeroTelefone(numeroTelefone3);
                }
                
                if (numeroTelefone4 != "" || tipoTelefone4 != ""){ 
                    telefone4.setTipoTelefone(tipoTelefone4);
                    telefone4.setNumeroTelefone(numeroTelefone4);
                }
                
                
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
                
                
                /*if (funcionario.getSenha() == confirmaSenha){
                    out.print("ok");
                } else {
                    out.print("As senhas precisam ser iguais!");
                }*/
                
                /*if (senha == confirmaSenha){
                    out.print("ok");
                } else {
                    out.print("As senhas precisam ser iguais!");
                }*/
                
                
                
                out.print("ok");
                
                /* TODO output your page here. You may use following sample code. */
                //Funcionario funcionario = new Funcionario(request.getParameter("login"), request.getParameter("senha"));

                /*out.println(funcionario.getLogin() + "<br>");
                out.println(funcionario.getSenha() + "<br>");*/
                /*System.out.println("servlet foi chamado");
                //formatando a data de string para Date
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
                Date emissao = df.parse(request.getParameter("emissaoDocumento"));
                Date nascimento = df1.parse(request.getParameter("nascimentoUsuario"));

                //incluindo telefone
                Telefone[] telefone = new Telefone[]{
                    new Telefone(request.getParameter("tipoTelefone"),
                                 request.getParameter("telefone"))
                            };                


                //incluindo nacionalidade
                Nacionalidade nacionalidade = new Nacionalidade(
                        request.getParameter("uf"),
                        request.getParameter("estado")

                );

                //incluindo endereco do usuario
                Endereco enderecoUsu = new Endereco(
                        request.getParameter("tipoLogradouro"),
                        request.getParameter("logradouro"),
                        request.getParameter("numeroEndereco"),
                        request.getParameter("complemento"),
                        request.getParameter("bairro"),
                        request.getParameter("cidade"),
                        request.getParameter("cep")
                );

                //incluindo endereco da regional
                  Endereco enderecoRegional = new Endereco(
                        request.getParameter("tipoLogradouro"),
                        request.getParameter("logradouro"),
                        request.getParameter("numeroEndereco"),
                        request.getParameter("complemento"),
                        request.getParameter("bairro"),
                        request.getParameter("cidade"),
                        request.getParameter("cep")
                );

                //incluindo tipo usuario
                TipoUsuario tipoUsuario = new TipoUsuario(
                        request.getParameter("tipoUsuario"),
                        request.getParameter("")
                );

                //regional
                Regional regional = new Regional(
                        request.getParameter(""),
                        request.getParameter(""),
                        enderecoRegional, //endereco regional
                        request.getParameter("regional")
                );

                Funcionario funcionario = new Funcionario(
                        request.getParameter("nickUsuario"),
                        request.getParameter("senha"),
                        request.getParameter("nomeUsuario"),
                        request.getParameter("sobrenomeUsuario"),
                        request.getParameter("emailUsuario"),
                        request.getParameter("naturalizacaodocumento"),
                        request.getParameter("orgaoDocumento"),
                        emissao, //date
                        request.getParameter("cpfCnpjUsuario"),
                        request.getParameter("sexo"),
                        nascimento,  //date
                        telefone,  //telefone
                        nacionalidade, //nacionalidade
                        request.getParameter("descricaoUsuario"),
                        enderecoUsu, //endereco
                        tipoUsuario, //tipousuario
                        request.getParameter("matriculaUsuario"),
                        request.getParameter("descricaoOrgaoFuncional"),
                        regional //regional
                );


                out.println("<html>");
                out.println("<head>");
                out.println("<body>");
                out.println(funcionario.getUsuario()+ "<br>");
                out.println(funcionario.getSenha() + "<br>");
                out.println(funcionario.getNome()+ "<br>");
                out.println(funcionario.getSobrenome()+ "<br>");
                out.println(funcionario.getEmail() + "<br>");
                out.println(funcionario.getRgRne()+ "<br>");
                out.println(funcionario.getOrgaoExpedidorRgRne()+ "<br>");
                out.println(funcionario.getDataEmissaoRgRne()+ "<br>");
                out.println(funcionario.getCpfCnpj()+ "<br>");
                out.println(funcionario.getSexo()+ "<br>");
                out.println(funcionario.getDataNascimento()+ "<br>");
                out.println(Arrays.toString(funcionario.getTelefone())+ "<br>");
                out.println(funcionario.getMatricula()+ "<br>");
                out.println(funcionario.getRegional()+ "<br>");
               out.println("</body>");
               out.println("</head>");
               out.println("</html>");*/
                
                //out.print("ok");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(cadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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

