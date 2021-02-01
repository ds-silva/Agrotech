package dao;

import connection.ConnectionFactory;
import excecoes.CancelarAlterarException;
import excecoes.CancelarBuscaPermissoesException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Cliente;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Nacionalidade;
import model.Regional;
import model.TipoUsuario;
import model.Usuario;

public class UsuarioDAO {

    public static boolean login(Usuario usuario) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT * FROM agronegocio.usuario WHERE login = ? AND senha = ?");
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

        return false;
    }

    public static int retornaIdUsuario(Usuario usuario) throws SQLException, CancelarBuscaPermissoesException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idUsuario = -1;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_usuario FROM agronegocio.usuario WHERE login = ?");
            ps.setString(1, usuario.getLogin());

            rs = ps.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("id_usuario");
            } else {
                throw new CancelarBuscaPermissoesException(" Não foi possivel buscar o id do usuário!");
            }

            return idUsuario;

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

    }

    public static TipoUsuario retornaTipoUsuario(Usuario usuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoUsuario tipoUsuario = new TipoUsuario();
        int idTipoUsuario = 0;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT id_tipo_usuario FROM agronegocio.usuario WHERE login = ? AND senha = ?");
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();

            if (rs.next()) {
                idTipoUsuario = rs.getInt("id_tipo_usuario");
                tipoUsuario.setIdTipoUsuario(idTipoUsuario);

            }

            ps = con.prepareStatement("SELECT tipo_usuario FROM agronegocio.tipo_usuario WHERE id_tipo_usuario = ?");
            ps.setInt(1, idTipoUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {

                tipoUsuario.setTipoUsuario(rs.getString("tipo_usuario"));

            } else {
                return tipoUsuario;
            }

            return tipoUsuario;

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

    }

    public static String retornaPermissoesUsuario(Usuario usuario) throws SQLException, CancelarBuscaPermissoesException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idTipoUsuario = 0;
        String permissoes = "";

        try {

            ps = con.prepareStatement("SELECT id_tipo_usuario FROM agronegocio.usuario WHERE login = ?");
            ps.setString(1, usuario.getLogin());

            rs = ps.executeQuery();

            if (rs.next()) {
                idTipoUsuario = rs.getInt("id_tipo_usuario ");
            }

            ps = con.prepareStatement("SELECT permissoes FROM agronegocio.tipo_usuario WHERE id_tipo_usuario = ?  ");
            ps.setInt(1, idTipoUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                permissoes = rs.getString("permissoes");
            }

            return permissoes;

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
    }

    public static Usuario consultarUsuario(int idUsuario) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Usuario usuario = null;

        try {
            con = ConnectionFactory.getConnection();

            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, u.id_regional, "
                    + "u.data_nascimento, u.id_tipo_usuario, u.matricula, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, u.id_endereco, "
                    + "u.login, u.id_situacao_usuario, "
                    + "su.descricao_situacao_usuario, "
                    + "u.id_nacionalidade, n.descricao_nacionalidade, "
                    + "tp.id_tipo_usuario, tp.tipo_usuario, "
                    + "su.id_situacao_usuario, su.id_situacao_usuario, "
                    + "e.logradouro, e.tipo_logradouro, e.numero, e.complemento, e.bairro, "
                    + "es.descricao_estado, "
                    + "re.id_orgao_funcional, re.descricao_regional, "
                    + "org.id_orgao_funcional, org.descricao_orgao_funcional, "
                    + "e.cidade, e.cep, e.id_estado,es.uf_estado "
                    + "from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_regional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.nacionalidade n on u.id_nacionalidade = n.id_nacionalidade "
                    + "WHERE u.id_usuario =" + idUsuario;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                usuario = new Usuario();
                Funcionario funcionario = new Funcionario();
                Cliente cliente = new Cliente();
                TipoUsuario tipoUsuario = new TipoUsuario();
                Endereco endereco = new Endereco();
                Estado estado = new Estado();
                Nacionalidade nacionalidade = new Nacionalidade();
                Regional regional = new Regional();

                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setEmail(rs.getString("email"));

                funcionario.setMatricula(rs.getString("matricula"));
                usuario.setRgRne(rs.getString("rg_rne"));
                usuario.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                usuario.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                usuario.setCpfCnpj(rs.getString("cpf_cnpj"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setDataNascimento(rs.getDate("data_nascimento"));

                tipoUsuario.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tipoUsuario.setTipoUsuario(rs.getString("tipo_usuario"));

                endereco.setIdEndereco(rs.getInt("id_endereco"));
                endereco.setTipoLogradouro(rs.getString("tipo_logradouro"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));

                nacionalidade.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nacionalidade.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));

                regional.setIdRegional(rs.getInt("id_regional"));
                regional.setDescricaoRegional(rs.getString("descricao_regional"));
                regional.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regional.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                usuario.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                usuario.setLogin(rs.getString("login"));
                usuario.setDesabilitarUsuario(rs.getBoolean("habilitado"));

                //pega a lista de telefones do usuario
                usuario.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(usuario.getIdUsuario()));

                endereco.setEstado(estado);
                usuario.setNacionalidade(nacionalidade);
                usuario.setTipoUsuario(tipoUsuario);
                usuario.setEndereco(endereco);
                funcionario.setRegional(regional);
                usuario.setCliente(cliente);
                usuario.setFuncionario(funcionario);

                return usuario;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return usuario;
    }

    public static boolean alterarUsuario(Usuario usuario) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int psU = 0, psE = 0, psI = 0;
        boolean sucesso = false;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String queryEndereco = "UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro=?, "
                    + "logradouro=?, "
                    + "numero=?, "
                    + "complemento=?, "
                    + "bairro=?, "
                    + "cidade=?, "
                    + "cep=?, "
                    + "id_estado=? "
                    + "WHERE id_endereco=?";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, usuario.getEndereco().getTipoLogradouro());
            ps.setString(2, usuario.getEndereco().getLogradouro());
            ps.setString(3, usuario.getEndereco().getNumero());
            ps.setString(4, usuario.getEndereco().getComplemento());
            ps.setString(5, usuario.getEndereco().getBairro());
            ps.setString(6, usuario.getEndereco().getCidade());
            ps.setString(7, usuario.getEndereco().getCep());
            ps.setInt(8, usuario.getEndereco().getEstado().getIdEstado());
            ps.setInt(9, usuario.getEndereco().getIdEndereco());

            psE = ps.executeUpdate();

            if (psE != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            String query = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= ?, "
                    + "id_nacionalidade=? "
                    + "WHERE id_usuario =?";

            ps = con.prepareStatement(query);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getRgRne());
            ps.setString(5, usuario.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(usuario.getDataEmissaoRgRne().getTime());
            ps.setDate(6, sDate);

            ps.setString(7, usuario.getCpfCnpj());
            ps.setString(8, usuario.getSexo());
            java.sql.Date pDate = new Date(usuario.getDataNascimento().getTime());
            ps.setDate(9, pDate);

            ps.setInt(10, usuario.getTipoUsuario().getIdTipoUsuario());

            ps.setInt(11, usuario.getNacionalidade().getIdNacionalidade());
            ps.setInt(12, usuario.getIdUsuario());

            psU = ps.executeUpdate();

            if (psU != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o Administrador!");
            }

            //ATUALIZAR OG 
            if (usuario.getFuncionario().getRegional().getIdOrgaoFuncional() > 0) {
                String query2 = "UPDATE agronegocio.usuario "
                        + "SET id_orgao_funcional=?, "
                        + " id_regional=? "
                        + "WHERE id_usuario =?";

                ps = con.prepareStatement(query2);
                ps.setInt(1, usuario.getFuncionario().getRegional().getIdOrgaoFuncional());
                ps.setInt(2, usuario.getFuncionario().getRegional().getIdRegional());
                ps.setInt(3, usuario.getIdUsuario());

                psU = ps.executeUpdate();

                if (psU != 1) {
                    throw new CancelarAlterarException(" Não foi possivel atualizar o Regional!");
                }
            }

            // == TELEFONES
            String queryTelefone = "";

            String cadastroTel = "";

            //ps = con.prepareStatement(queryTelefone);
            for (int i = 0; i < usuario.getTelefones().size(); i++) {

                if (usuario.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                            + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, usuario.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, usuario.getIdUsuario());
                    ps.setInt(3, usuario.getTelefones().get(i).getIdTipoTelefone());

                    psI = ps.executeUpdate();

                    if (psI != 1) {
                        throw new CancelarAlterarException(" Não foi possivel cadastrar o Telefone!");
                    }
                } else {
                    queryTelefone = "UPDATE  agronegocio.telefone "
                            + "SET numero_telefone = ?, "
                            + "id_usuario = ?, "
                            + "id_tipo_telefone = ? "
                            + "WHERE id_usuario_telefone = ?";

                    ps = con.prepareStatement(queryTelefone);

                    ps.setString(1, usuario.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, usuario.getIdUsuario());
                    ps.setInt(3, usuario.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, usuario.getTelefones().get(i).getIdTelefone());

                    psI = ps.executeUpdate();

                    if (psI != 1) {
                        throw new CancelarAlterarException(" Não foi possivel atualizar o Telefone!");
                    }

                }

            }

            con.commit();
            sucesso = true;

        } catch (Exception e) {
            con.rollback();
            throw new CancelarAlterarException("Não foi possivel alterar! " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }

    public static boolean alterarSenhaUsuarioPerfil(Usuario usuario, String novaSenha) throws SQLException, CancelarAlterarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean isValida = false;

        try {

            // 1º Verifica se a senha do campo "Senha Atual" é a mesma do banco!
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT senha FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, usuario.getIdUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                String senhaBanco = rs.getString("senha");
                String senhaUsuario = usuario.getSenha();

                if (senhaBanco.equals(senhaUsuario)) {
                    isValida = true;
                } else {
                    throw new CancelarAlterarException(" A senha atual não confere!");
                }
            }

            if (isValida) {

                // 2º Altera a senha do usuario de para a nova
                con = ConnectionFactory.getConnection();
                ps = con.prepareStatement("UPDATE agronegocio.usuario SET senha = ? WHERE id_usuario = ?;");
                ps.setString(1, novaSenha);
                ps.setInt(2, usuario.getIdUsuario());

                int i = ps.executeUpdate();

                if (i != 1) {
                    throw new CancelarAlterarException(" Não foi possivel alterar senha!");
                }

                return true;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;

    }

}
