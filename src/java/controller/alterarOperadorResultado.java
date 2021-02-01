
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
import model.Endereco;
import model.Estado;
import model.Nacionalidade;
import model.Operador;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;

/**
 *
 * @author josem
 */
@WebServlet(name = "alterarOperadorResultado", urlPatterns = {"/alterarOperadorResultado"})
public class alterarOperadorResultado extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                
                Operador op = new Operador();
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

                 
                op.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                 
                op.setNome(request.getParameter("nomeUsuario"));
                 
                op.setSobrenome(request.getParameter("sobrenomeUsuario"));
                  
                op.setEmail(request.getParameter("emailUsuario"));
                 
                op.setMatricula(request.getParameter("matriculaUsuario"));
                 
                reg.setIdOrgaoFuncional(Integer.parseInt(request.getParameter("orgaoFuncional")));
                //adm.setSenha(request.getParameter("senha"));

                op.setRegional(reg);
                tpu.setTipoUsuario(request.getParameter("tipoUsuario"));
                op.setTipoUsuario(tpu);

                op.setRgRne(request.getParameter("naturalizacaoDocumento"));
                op.setOrgaoExpedidorRgRne(request.getParameter("orgaoDocumento"));
            
                String dataEmissaoView;
                Date dataEmissaoReg;

                try {
                    dataEmissaoView = fBR.format(fUS.parse(request.getParameter("emissaoDocumento")));
                    dataEmissaoReg = fBR.parse(dataEmissaoView);
                    op.setDataEmissaoRgRne(dataEmissaoReg);
                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Emissão está vazio");
                    }
                }

                op.setCpfCnpj(request.getParameter("numeroCpfCnpjUsuario"));
                op.setSexo(request.getParameter("sexo"));

                String dataNascimeView;
                Date dataNascimeReg;

                
                try {
                    dataNascimeView = fBR.format(fUS.parse(request.getParameter("nascimentoUsuario")));
                    dataNascimeReg = fBR.parse(dataNascimeView);
                    op.setDataNascimento(dataNascimeReg);

                } catch (ParseException ex) {
                    if (ex.getErrorOffset() == 0) {
                        throw new Exception("O campo Data de Nascimento está vazio");
                    }
                }

                //nac.setDescricaoNacionalidade(request.getParameter("nacionalidadeUsuario"));
                nac.setIdNacionalidade(Integer.parseInt(request.getParameter("nacionalidadeUsuario")));

                op.setNacionalidade(nac);

                //adm.setDescricaoOrgaoFuncional(request.getParameter("orgaoFuncional"));
                reg.setIdOrgaoFuncional(Integer.parseInt(request.getParameter("orgaoFuncional")));
                reg.setIdRegional(Integer.parseInt(request.getParameter("regional")));
                op.setRegional(reg);

                // == TELEFONES 
                telefone1.setTipoTelefone(request.getParameter("tipoTelefone1"));
                telefone1.setNumeroTelefone(request.getParameter("telefone1"));
                telefone1.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone1")));
                telefone1.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone1")));

                op.addTelefone(telefone1);

                if (!"".equals(request.getParameter("tipoTelefone2")) || !"".equals(request.getParameter("telefone2"))) {

                    telefone2.setTipoTelefone(request.getParameter("tipoTelefone2"));
                    telefone2.setNumeroTelefone(request.getParameter("telefone2"));
                    if (request.getParameter("idTelefone2").length() == 0) {
                        telefone4.setIdTelefone(0);
                    } else {
                        telefone2.setIdTelefone(Integer.parseInt(request.getParameter("idTelefone2")));
                    }

                    telefone2.setIdTipoTelefone(Integer.parseInt(request.getParameter("tipoTelefone2")));

                    op.addTelefone(telefone2);
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

                    op.addTelefone(telefone3);
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

                    op.addTelefone(telefone4);
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
                op.setEndereco(end);

             
                op.setLogin(request.getParameter("matriculaUsuario"));
                op.setDescSituacaoUsuario(request.getParameter("situacaoUsuario"));

                
               FuncionarioDAO.alterarOperador(op);

                out.print("ok");

            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
    }
}
