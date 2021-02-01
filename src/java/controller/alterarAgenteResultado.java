package controller;

import dao.FuncionarioDAO;
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
import model.Agente;
import model.Endereco;
import model.Estado;
import model.Nacionalidade;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;

/**
 *
 * @author santana
 */
@WebServlet(name = "alterarAgenteResultado", urlPatterns = {"/alterarAgenteResultado"})
public class alterarAgenteResultado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                Agente agt = new Agente();
                Regional reg = new Regional();
                TipoUsuario tpu = new TipoUsuario();
                Nacionalidade nac = new Nacionalidade();
                Endereco end = new Endereco();
                Estado est = new Estado();
                List<Telefone> telefones = new ArrayList<>();
                Telefone telefone1 = new Telefone();
                Telefone telefone2 = new Telefone();
                Telefone telefone3 = new Telefone();
                Telefone telefone4 = new Telefone();

                SimpleDateFormat fUS = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat fBR = new SimpleDateFormat("yyyy-MM-dd");

                agt.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                agt.setNome(request.getParameter("nomeUsuario"));
                agt.setSobrenome(request.getParameter("sobrenomeUsuario"));
                agt.setEmail(request.getParameter("emailUsuario"));
                agt.setMatricula(request.getParameter("matriculaUsuario"));
                //agt.setSenha(request.getParameter("senha"));

                tpu.setTipoUsuario(request.getParameter("tipoUsuario"));
                agt.setTipoUsuario(tpu);

                agt.setRgRne(request.getParameter("naturalizacaoDocumento"));
                agt.setOrgaoExpedidorRgRne(request.getParameter("orgaoDocumento"));
                String dataEmissaoView;
                Date dataEmissaoReg;

                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    dataEmissaoReg = fBR.parse(dataEmissaoView);
                    agt.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Emissão está vazio");
                    }
                }

                agt.setCpfCnpj(request.getParameter("numeroCpfCnpjUsuario"));
                agt.setSexo(request.getParameter("sexo"));

                String dataNascimeView;
                Date dataNascimeReg;

                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    dataNascimeReg = fBR.parse(dataNascimeView);
                    agt.setDataNascimento(dataNascimeReg);

                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Nascimento está vazio");
                    }
                }

                //nac.setDescricaoNacionalidade(request.getParameter("nacionalidadeUsuario"));
                nac.setIdNacionalidade(Integer.parseInt(request.getParameter("nacionalidadeUsuario")));
                agt.setNacionalidade(nac);

                //agt.setDescricaoOrgaoFuncional(request.getParameter("orgaoFuncional"));                
                reg.setIdOrgaoFuncional(Integer.parseInt(request.getParameter("orgaoFuncional")));

                //reg.setIdRegional(Integer.parseInt(request.getParameter("idRegional")));
                //reg.setDescricaoRegional(request.getParameter("regional"));
                reg.setIdRegional(Integer.parseInt(request.getParameter("regional")));
                agt.setRegional(reg);
                
                //== TELEFONES

                telefone1.setTipoTelefone(request.getParameter("tipoTelefone1"));
                telefone1.setNumeroTelefone(request.getParameter("telefone1"));
                telefone1.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone1")));
                telefone1.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone1")));

                agt.addTelefone(telefone1);

                if (!"".equals(request.getParameter("tipoTelefone2")) || !"".equals(request.getParameter("telefone2"))) {

                    telefone2.setTipoTelefone(request.getParameter("tipoTelefone2"));
                    telefone2.setNumeroTelefone(request.getParameter("telefone2"));
                    if (request.getParameter("idTelefone2").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone2.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone2")));
                    }

                    telefone2.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone2")));

                    agt.addTelefone(telefone2);
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

                    agt.addTelefone(telefone3);
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

                    agt.addTelefone(telefone4);
                }

                end.setBairro(request.getParameter("bairro"));
                end.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
                end.setCep(request.getParameter("cep"));
                end.setCidade(request.getParameter("cidade"));
                end.setComplemento(request.getParameter("complemento"));
                //est.setDescricaoEstado(request.getParameter("estado"));
                est.setIdEstado(Integer.parseInt(request.getParameter("estado")));
                end.setEstado(est);

                end.setLogradouro(request.getParameter("logradouro"));
                end.setNumero(request.getParameter("numeroEndereco"));
                end.setTipoLogradouro(request.getParameter("tipoLogradouro"));
                agt.setEndereco(end);

                agt.setLogin(request.getParameter("matriculaUsuario"));
                agt.setDescSituacaoUsuario(request.getParameter("situacaoUsuario"));

                FuncionarioDAO.alterarAgente(agt);

                out.print("ok");

            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

        }
    }

}
