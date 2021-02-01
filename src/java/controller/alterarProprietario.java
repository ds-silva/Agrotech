/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.TipoTelefoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.Nacionalidade;
import model.Produtor;
import model.Proprietario;
import model.Telefone;

/**
 *
 * @author resilia
 */
@WebServlet(name = "alterarProprietario", urlPatterns = {"/alterarProprietario"})
public class alterarProprietario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private SimpleDateFormat fUS;
    private SimpleDateFormat fBR;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Proprietario produtor = new Proprietario();
                Endereco endereco = new Endereco();
                Nacionalidade nac = new Nacionalidade();
                Estado estado = new Estado();
                List<Telefone> telefones = new ArrayList<>();
                Telefone telefone1 = new Telefone();
                Telefone telefone2 = new Telefone();
                Telefone telefone3 = new Telefone();
                Telefone telefone4 = new Telefone();
                SimpleDateFormat fUS = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat fBR = new SimpleDateFormat("yyyy-MM-dd");

                int idProdutor = Integer.parseInt(request.getParameter("idProprietario"));

                String nomeUsuario = request.getParameter("nomeUsuario");

                String sobrenomeUsuario = request.getParameter("sobrenomeUsuario");

                String emailUsuario = request.getParameter("emailUsuario");
                String rgRne = request.getParameter("naturalizacaoDocumento");
                String orgaoExpedidor = request.getParameter("orgaoDocumento");

                String cpfCnpjUsuario = request.getParameter("numeroCpfCnpjUsuario");

                String sexo = request.getParameter("sexo");

                int idSitUsuario = Integer.parseInt(request.getParameter("situacaoUsuario"));

                String dataEmissaoView;
                Date dataEmissaoReg;

                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    dataEmissaoReg = fBR.parse(dataEmissaoView);
                    produtor.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Emissão está vazio");
                    }
                }

                String dataNascimeView;
                Date dataNascimeReg;

                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    dataNascimeReg = fBR.parse(dataNascimeView);
                    produtor.setDataNascimento(dataNascimeReg);

                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Nascimento está vazio");
                    }
                }

                int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));

                produtor.setIdSituacaoUsuario(idSitUsuario);
                produtor.setIdUsuario(idProdutor);
                produtor.setNome(nomeUsuario);
                produtor.setSobrenome(sobrenomeUsuario);
                produtor.setEmail(emailUsuario);
                produtor.setRgRne(rgRne);
                produtor.setOrgaoExpedidorRgRne(orgaoExpedidor);
                produtor.setCpfCnpj(cpfCnpjUsuario);
                produtor.setSexo(sexo);
                nac.setIdNacionalidade(Integer.parseInt(request.getParameter("nacionalidadeUsuario")));
                produtor.setNacionalidade(nac);

                telefone1.setTipoTelefone(request.getParameter("tipoTelefone1"));
                telefone1.setNumeroTelefone(request.getParameter("telefone1"));
                telefone1.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone1")));
                telefone1.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone1")));

                //pega a lista de telefones do usuario
                //adm.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(adm.getIdUsuario()));
                produtor.addTelefone(telefone1);
                /*if (testeTel.getTelefones().size() == 0) {
                    TelefoneDAO.cadastrarTelefone(telefone1, adm);
                } else {
                    adm.addTelefone(telefone1);
                }    */

                if (!"".equals(request.getParameter("tipoTelefone2")) || !"".equals(request.getParameter("telefone2"))) {

                    telefone2.setTipoTelefone(request.getParameter("tipoTelefone2"));
                    telefone2.setNumeroTelefone(request.getParameter("telefone2"));
                    if (request.getParameter("idTelefone2").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone2.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone2")));
                    }

                    telefone2.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone2")));

                    produtor.addTelefone(telefone2);
                }

                if (!"".equals(request.getParameter("tipoTelefone3")) || !"".equals(request.getParameter("telefone3"))) {

                    telefone3.setTipoTelefone(request.getParameter("tipoTelefone3"));
                    telefone3.setNumeroTelefone(request.getParameter("telefone3"));
                    if (request.getParameter("idTelefone3").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone3.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone3")));
                    }

                    telefone3.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone3")));

                    produtor.addTelefone(telefone3);
                }

                if (!"".equals(request.getParameter("tipoTelefone4")) || !"".equals(request.getParameter("telefone4"))) {

                    /*out.println(request.getParameter("tipoTelefone4").length());
                    out.println(request.getParameter("telefone4").length());
                    out.println(request.getParameter("idTipoTelefone4").length());*/
                    telefone4.setTipoTelefone(request.getParameter("tipoTelefone4"));
                    telefone4.setNumeroTelefone(request.getParameter("telefone4"));
                    if (request.getParameter("idTelefone4").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone4.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone4")));
                    }

                    telefone4.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone4")));

                    produtor.addTelefone(telefone4);
                }

                //produtor.setIdUsuario(idTipoUsuario);
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
                endereco.setCep(request.getParameter("cep"));
                endereco.setCidade(request.getParameter("cidade"));
                endereco.setComplemento(request.getParameter("complemento"));

                //est.setDescricaoEstado(request.getParameter("estado"));
                estado.setIdEstado(Integer.parseInt(request.getParameter("estado")));
                endereco.setEstado(estado);
                endereco.setLogradouro(request.getParameter("logradouro"));
                endereco.setNumero(request.getParameter("numeroEndereco"));
                endereco.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                produtor.setEndereco(endereco);

                ClienteDAO.alterarProprietario(produtor);
                


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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(alterarProprietario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(alterarProprietario.class.getName()).log(Level.SEVERE, null, ex);
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
