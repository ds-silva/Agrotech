package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Nacionalidade;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;
import model.Usuario;
import validacoes.ValidadorCamposSenhaPerfil;

/**
 *
 * @author lluan
 */
@WebServlet(name = "alterarPerfilResultado", urlPatterns = {"/alterarPerfilResultado"})
public class alterarPerfilResultado extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try {
                
                HttpSession session = request.getSession();
                String tipoUsuario = (String) session.getAttribute("tipoUsuario");
                int idUsuario = (int) session.getAttribute("idUsuarioSession");
                
                boolean isFuncionario = false;
                if (tipoUsuario.equals("Administrador") || tipoUsuario.equals("Agente") || tipoUsuario.equals("Operador")) {
                    isFuncionario = true;
                }
                
                Usuario usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                
                Regional reg = new Regional();
                TipoUsuario tpu = new TipoUsuario();
                Nacionalidade nac = new Nacionalidade();
                Endereco end = new Endereco();
                Estado est = new Estado();
                Telefone telefone1 = new Telefone();
                Telefone telefone2 = new Telefone();
                Telefone telefone3 = new Telefone();
                Telefone telefone4 = new Telefone();
                
                SimpleDateFormat fUS = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat fBR = new SimpleDateFormat("yyyy-MM-dd");
                
                usuario.setIdUsuario(idUsuario);
                usuario.setNome(request.getParameter("nomeUsuario"));
                usuario.setSobrenome(request.getParameter("sobrenomeUsuario"));
                usuario.setEmail(request.getParameter("emailUsuario"));
                
                tpu.setIdTipoUsuario(Integer.parseInt(request.getParameter("tipoUsuario")));
                usuario.setTipoUsuario(tpu);
                
                usuario.setRgRne(request.getParameter("naturalizacaoDocumento"));
                usuario.setOrgaoExpedidorRgRne(request.getParameter("orgaoDocumento"));
                
                String dataEmissaoView;
                Date dataEmissaoReg;
                
                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    dataEmissaoReg = fBR.parse(dataEmissaoView);
                    usuario.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Emissão está vazio");
                    }
                }
                
                usuario.setCpfCnpj(request.getParameter("numeroCpfCnpjUsuario"));
                usuario.setSexo(request.getParameter("sexo"));
                
                String dataNascimeView;
                Date dataNascimeReg;
                
                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    dataNascimeReg = fBR.parse(dataNascimeView);
                    usuario.setDataNascimento(dataNascimeReg);
                    
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Nascimento está vazio");
                    }
                }
                
                nac.setIdNacionalidade(Integer.parseInt(request.getParameter("nacionalidadeUsuario")));
                usuario.setNacionalidade(nac);
                
                telefone1.setTipoTelefone(request.getParameter("tipoTelefone1"));
                telefone1.setNumeroTelefone(request.getParameter("telefone1"));
                telefone1.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone1")));
                telefone1.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone1")));

                //pega a lista de telefones do usuario
                usuario.addTelefone(telefone1);
                
                if (!"".equals(request.getParameter("tipoTelefone2")) || !"".equals(request.getParameter("telefone2"))) {
                    
                    telefone2.setTipoTelefone(request.getParameter("tipoTelefone2"));
                    telefone2.setNumeroTelefone(request.getParameter("telefone2"));
                    if (request.getParameter("idTelefone2").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone2.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone2")));
                    }
                    
                    telefone2.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone2")));
                    
                    usuario.addTelefone(telefone2);
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
                    
                    usuario.addTelefone(telefone3);
                }
                
                if (!"".equals(request.getParameter("tipoTelefone4")) || !"".equals(request.getParameter("telefone4"))) {
                    
                    telefone4.setTipoTelefone(request.getParameter("tipoTelefone4"));
                    telefone4.setNumeroTelefone(request.getParameter("telefone4"));
                    if (request.getParameter("idTelefone4").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone4.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone4")));
                    }
                    
                    telefone4.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone4")));
                    
                    usuario.addTelefone(telefone4);
                }
                
                end.setBairro(request.getParameter("bairro"));
                end.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
                
                end.setCep(request.getParameter("cep"));
                end.setCidade(request.getParameter("cidade"));
                end.setComplemento(request.getParameter("complemento"));
                
                est.setIdEstado(Integer.parseInt(request.getParameter("estado")));
                end.setEstado(est);
                
                end.setLogradouro(request.getParameter("logradouro"));
                end.setNumero(request.getParameter("numeroEndereco"));
                end.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                usuario.setEndereco(end);
                
                if (isFuncionario) {
                    reg.setIdOrgaoFuncional(Integer.parseInt(request.getParameter("orgaoFuncional")));
                    reg.setIdRegional(Integer.parseInt(request.getParameter("regional")));
                    funcionario.setRegional(reg);
                    usuario.setFuncionario(funcionario);
                    
                }
                
                UsuarioDAO.alterarUsuario(usuario);
                
                if (ValidadorCamposSenhaPerfil.validaCamposConteudo(request.getParameter("senhaAtual"), request.getParameter("senhaNova"))) {
                    usuario.setSenha(request.getParameter("senhaAtual"));
                    UsuarioDAO.alterarSenhaUsuarioPerfil(usuario, request.getParameter("senhaNova"));
                }
                
                out.print("ok");
                
            } catch (SQLException e) {
                out.print(e.getMessage());
            } catch (Exception ex) {
                out.print(ex.getMessage());
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
