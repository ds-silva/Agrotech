package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.Nacionalidade;
import model.Produtor;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;

/**
 *
 * @author lluan
 */
@WebServlet(name = "cadastrarProdutor", urlPatterns = {"/cadastrarProdutor"})
public class cadastrarProdutor extends HttpServlet {

    //Objetos
    private Produtor produtor;
    private TipoUsuario tipoUsuario;
    private Nacionalidade nacionalidade;
    private Regional regional;
    private Endereco endereco;
    private Estado estado;
    private List<Telefone> telefones;
    private Telefone telefone1;
    private Telefone telefone2;
    private Telefone telefone3;
    private Telefone telefone4;
    private SimpleDateFormat fUS;
    private SimpleDateFormat fBR;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try {
                
                produtor = new Produtor();
                regional = new Regional();
                endereco = new Endereco();
                estado = new Estado();
                tipoUsuario = new TipoUsuario();
                nacionalidade = new Nacionalidade();
                fUS = new SimpleDateFormat("dd/mm/yyyy");
                fBR = new SimpleDateFormat("yyyy-MM-dd");
                
                telefones = new ArrayList<>();
                telefone1 = new Telefone();
                telefone2 = new Telefone();
                telefone3 = new Telefone();
                telefone4 = new Telefone();

                //Dados do Usuário
                produtor.setNome(request.getParameter("nomeUsuario"));
                produtor.setSobrenome(request.getParameter("sobrenomeUsuario"));
                produtor.setEmail(request.getParameter("emailUsuario"));
                
                if (request.getParameter("senha") == request.getParameter("confirmaSenha")) {
                    produtor.setSenha(request.getParameter("senha"));
                } else {
                    out.println("As senhas não estão inguais!");
                }
                produtor.setRgRne(request.getParameter("naturalizacaoDocumento"));
                produtor.setOrgaoExpedidorRgRne(request.getParameter("orgaoDocumento"));
                
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
                
                produtor.setCpfCnpj(request.getParameter("numeroCpfCnpjUsuario"));
                
                produtor.setSexo(request.getParameter("sexo"));
                
                String dataNascimeView;
                Date dataNascimeReg = null;
                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    dataNascimeReg = fBR.parse(dataNascimeView);
                    produtor.setDataNascimento(dataNascimeReg);
                    
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Nascimento está vazio");
                    }
                }
                
                nacionalidade.setDescricaoNacionalidade(request.getParameter("nacionalidadeUsuario"));
                produtor.setNacionalidade(nacionalidade);
                
                tipoUsuario.setTipoUsuario(request.getParameter("tipoUsuario"));
                produtor.setTipoUsuario(tipoUsuario);
                
                //telefones
                
                String tipoTel1 = request.getParameter("tipoTelefone1");
                String tel1 = request.getParameter("telefone1");
                
                telefone1.setTipoTelefone(tipoTel1);
                telefone1.setNumeroTelefone(tel1);
                
                produtor.addTelefone(telefone1);
                               
                if (!"".equals(request.getParameter("tipoTelefone2")) || !"".equals(request.getParameter("telefone2"))) {
                    String tipoTel2 = request.getParameter("tipoTelefone2");
                    String tel2 = request.getParameter("telefone2");
                    
                    telefone2.setTipoTelefone(tipoTel2);
                    telefone2.setNumeroTelefone(tel2);
                
                    produtor.addTelefone(telefone2);
                }
                
                if (!"".equals(request.getParameter("tipoTelefone3")) || !"".equals(request.getParameter("telefone3"))) {
                    String tipoTel3 = request.getParameter("tipoTelefone3");
                    String tel3 = request.getParameter("telefone3");
                    
                    telefone3.setTipoTelefone(tipoTel3);
                    telefone3.setNumeroTelefone(tel3);
                
                    produtor.addTelefone(telefone3);
                }
                
                if (!"".equals(request.getParameter("tipoTelefone4")) || !"".equals(request.getParameter("telefone4"))) {
                    String tipoTel4 = request.getParameter("tipoTelefone4");
                    String tel4 = request.getParameter("telefone4");
                    
                    telefone4.setTipoTelefone(tipoTel4);
                    telefone4.setNumeroTelefone(tel4);
                
                    produtor.addTelefone(telefone4);
                }

                //Endereço + Estado/
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setCep(request.getParameter("cep"));
                endereco.setCidade(request.getParameter("cidade"));
                endereco.setComplemento(request.getParameter("complemento"));
                
                estado.setDescricaoEstado(request.getParameter("estado"));
                
                endereco.setEstado(estado);
                endereco.setLogradouro(request.getParameter("logradouro"));
                endereco.setNumero(request.getParameter("numeroEndereco"));
                endereco.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                
                produtor.setEndereco(endereco);
                
                produtor.setLogin(request.getParameter("numeroCpfCnpjUsuario"));
                produtor.setDescSituacaoUsuario("1");
                produtor.setStatusValidacao(false);
                produtor.setVailidadoPor("XX-XX");
                produtor.setDataValidacao(dataNascimeReg);
                produtor.setJustificativaValidacao("YY-YY");
                
                ClienteDAO.cadastrarProdutor(produtor, endereco, estado);
                
                out.print("ok");
                
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception e) {
                out.print(e.getMessage());
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
