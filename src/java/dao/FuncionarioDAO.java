package dao;

import connection.ConnectionFactory;
import excecoes.CancelarAlterarException;
import excecoes.CancelarDeletarException;
import excecoes.CancelarRegistroException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Administrador;
import model.Agente;
import model.Cliente;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Nacionalidade;
import model.Operador;
import model.Regional;
import model.Telefone;
import model.TipoUsuario;

public class FuncionarioDAO {

    public static boolean cadastrarAdministrador(Administrador administrador, Endereco endereco, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultadoPs = 0;
        int psU = 0, psE = 0;
        int[] psT; 

        try {

            // === CADASTRO ENDEREÇO ===
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("INSERT INTO agronegocio.endereco "
                    + " (cep, tipo_logradouro, logradouro, numero, "
                    + " complemento, bairro, cidade, id_estado) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.setInt(8, Integer.parseInt(estado.getDescricaoEstado()));

            psE = ps.executeUpdate();

            if (psE == 1) {

                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    endereco.setIdEndereco(rs.getInt("id_endereco"));
                }

            }

            // === Verifica se endereço tem ID === 
            if (endereco.getIdEndereco() == 0) {
                throw new CancelarRegistroException(" ID de endereço não localizado.");
            }

            // === CADASTRO USUARIO ===
            String query = "INSERT INTO agronegocio.usuario "
                    + " (senha, nome, sobrenome, email, "
                    + " matricula, rg_rne, orgao_expedidor_rg_rne, "
                    + " data_emissao_rg_rne, cpf_cnpj, sexo, data_nascimento, "
                    + " id_tipo_usuario, id_endereco, id_nacionalidade, id_regional, "
                    + " id_orgao_funcional, id_situacao_usuario, login) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, administrador.getSenha());
            ps.setString(2, administrador.getNome());
            ps.setString(3, administrador.getSobrenome());
            ps.setString(4, administrador.getEmail());
            ps.setString(5, administrador.getMatricula());
            ps.setString(6, administrador.getRgRne());
            ps.setString(7, administrador.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(administrador.getDataEmissaoRgRne().getTime());
            ps.setDate(8, sDate);
            ps.setString(9, administrador.getCpfCnpj());
            ps.setString(10, administrador.getSexo());
            java.sql.Date pDate = new Date(administrador.getDataNascimento().getTime());
            ps.setDate(11, pDate);
            ps.setInt(12, Integer.parseInt(administrador.getTipoUsuario().getTipoUsuario()));
            ps.setInt(13, endereco.getIdEndereco());
            ps.setInt(14, Integer.parseInt(administrador.getNacionalidade().getDescricaoNacionalidade()));
            ps.setInt(15, Integer.parseInt(administrador.getRegional().getDescricaoRegional()));
            ps.setInt(16, Integer.parseInt(administrador.getDescricaoOrgaoFuncional()));
            ps.setInt(17, Integer.parseInt(administrador.getDescSituacaoUsuario()));
            ps.setString(18, administrador.getLogin());

            psU = ps.executeUpdate();

            if (psU == 1) {
                //con.commit();
                //return true;
                
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    administrador.setIdUsuario(rs.getInt("id_usuario"));
                }
            }
            
            
            query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            for (int i = 0; i < administrador.getTelefones().size(); i++) {
                ps.setString(1, administrador.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, administrador.getIdUsuario());
                ps.setInt(3, Integer.parseInt(administrador.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }
            
            psT = ps.executeBatch();
            
            
            if (!Arrays.asList(psT).contains(1)) {
                con.commit();
                return true;
            }
            

        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Não foi possivel cadastrar administrador! " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static boolean cadastrarAgente(Agente agente, Endereco endereco, Estado estado) throws SQLException, CancelarRegistroException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultadoPs = 0;

        int psU = 0, psE = 0;
        int[] psT;

        try {

            // === CADASTRO ENDEREÇO ===
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("INSERT INTO agronegocio.endereco "
                    + " (cep, tipo_logradouro, logradouro, numero, "
                    + " complemento, bairro, cidade, id_estado) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.setInt(8, Integer.parseInt(estado.getDescricaoEstado()));

            psE = ps.executeUpdate();

            if (psE == 1) {

                rs = ps.getGeneratedKeys();

                if (rs.next()) {

                    endereco.setIdEndereco(rs.getInt("id_endereco"));

                }

            }

            // === Verifica se endereço tem ID === 
            if (endereco.getIdEndereco() == 0) {
                throw new CancelarRegistroException(" ID de endereço não localizado.");
            }

            // === CADASTRO USUARIO ===
            String query = "INSERT INTO agronegocio.usuario "
                    + " (senha, nome, sobrenome, email, "
                    + " matricula, rg_rne, orgao_expedidor_rg_rne, "
                    + " data_emissao_rg_rne, cpf_cnpj, sexo, data_nascimento, "
                    + " id_tipo_usuario, id_endereco, id_nacionalidade, id_regional, "
                    + " id_orgao_funcional, id_situacao_usuario, login) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, agente.getSenha());
            ps.setString(2, agente.getNome());
            ps.setString(3, agente.getSobrenome());
            ps.setString(4, agente.getEmail());
            ps.setString(5, agente.getMatricula());
            ps.setString(6, agente.getRgRne());
            ps.setString(7, agente.getOrgaoExpedidorRgRne());

            java.sql.Date sDate = new java.sql.Date(agente.getDataEmissaoRgRne().getTime());
            ps.setDate(8, sDate);

            ps.setString(9, agente.getCpfCnpj());
            ps.setString(10, agente.getSexo());

            java.sql.Date pDate = new java.sql.Date(agente.getDataNascimento().getTime());
            ps.setDate(11, pDate);

            ps.setInt(12, Integer.parseInt(agente.getTipoUsuario().getTipoUsuario()));
            ps.setInt(13, endereco.getIdEndereco());
            ps.setInt(14, Integer.parseInt(agente.getNacionalidade().getDescricaoNacionalidade()));
            ps.setInt(15, Integer.parseInt(agente.getRegional().getDescricaoRegional()));
            ps.setInt(16, Integer.parseInt(agente.getDescricaoOrgaoFuncional()));
            ps.setInt(17, Integer.parseInt(agente.getDescSituacaoUsuario()));
            ps.setString(18, agente.getLogin());

            psU = ps.executeUpdate();

            if (psU == 1) {
                //con.commit();
                //return true;
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    agente.setIdUsuario(rs.getInt("id_usuario"));
                }
            }
            
            
            query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            for (int i = 0; i < agente.getTelefones().size(); i++) {
                ps.setString(1, agente.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, agente.getIdUsuario());
                ps.setInt(3, Integer.parseInt(agente.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }
            
            psT = ps.executeBatch();
            
            
            if (!Arrays.asList(psT).contains(1)) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Não foi possivel cadastrar agente! ");
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static boolean cadastrarOperador(Operador operador, Endereco endereco, Estado estado) throws SQLException, CancelarRegistroException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultadoPs = 0;

        int psU = 0, psE = 0;
        int[] psT;

        try {

            // === CADASTRO ENDEREÇO ===
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("INSERT INTO agronegocio.endereco "
                    + " (cep, tipo_logradouro, logradouro, numero, "
                    + " complemento, bairro, cidade, id_estado) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.setInt(8, Integer.parseInt(estado.getDescricaoEstado()));

            psE = ps.executeUpdate();

            if (psE == 1) {

                rs = ps.getGeneratedKeys();

                if (rs.next()) {

                    endereco.setIdEndereco(rs.getInt("id_endereco"));

                }

            }

            // === Verifica se endereço tem ID === 
            if (endereco.getIdEndereco() == 0) {
                throw new CancelarRegistroException(" ID de endereço não localizado.");
            }

            // === CADASTRO USUARIO ===
            String query = "INSERT INTO agronegocio.usuario "
                    + " (senha, nome, sobrenome, email, "
                    + " matricula, rg_rne, orgao_expedidor_rg_rne, "
                    + " data_emissao_rg_rne, cpf_cnpj, sexo, data_nascimento, "
                    + " id_tipo_usuario, id_endereco, id_nacionalidade, id_regional, "
                    + " id_orgao_funcional, id_situacao_usuario, login) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, operador.getSenha());
            ps.setString(2, operador.getNome());
            ps.setString(3, operador.getSobrenome());
            ps.setString(4, operador.getEmail());
            ps.setString(5, operador.getMatricula());
            ps.setString(6, operador.getRgRne());
            ps.setString(7, operador.getOrgaoExpedidorRgRne());

            java.sql.Date sDate = new java.sql.Date(operador.getDataEmissaoRgRne().getTime());
            ps.setDate(8, sDate);

            ps.setString(9, operador.getCpfCnpj());
            ps.setString(10, operador.getSexo());

            java.sql.Date pDate = new java.sql.Date(operador.getDataNascimento().getTime());
            ps.setDate(11, pDate);

            ps.setInt(12, Integer.parseInt(operador.getTipoUsuario().getTipoUsuario()));
            ps.setInt(13, endereco.getIdEndereco());
            ps.setInt(14, Integer.parseInt(operador.getNacionalidade().getDescricaoNacionalidade()));
            ps.setInt(15, Integer.parseInt(operador.getRegional().getDescricaoRegional()));
            ps.setInt(16, Integer.parseInt(operador.getDescricaoOrgaoFuncional()));
            ps.setInt(17, Integer.parseInt(operador.getDescSituacaoUsuario()));
            ps.setString(18, operador.getLogin());

            psU = ps.executeUpdate();

            if (psU == 1) {
                //con.commit();
                //return true;
                
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    operador.setIdUsuario(rs.getInt("id_usuario"));
                }
            }
            
            query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            for (int i = 0; i < operador.getTelefones().size(); i++) {
                ps.setString(1, operador.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, operador.getIdUsuario());
                ps.setInt(3, Integer.parseInt(operador.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }
            
            psT = ps.executeBatch();
            
            
            if (!Arrays.asList(psT).contains(1)) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Não foi possivel cadastrar operador! ");
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
    /*public static boolean updateAdministrador(Administrador administrador, Endereco endereco, Estado estado) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("UPDATE agronegocio.tipo_produto \n"
                    + "SET descricao_tipo_produto=? \n"
                    + "WHERE descricao_tipo_produto=?;");

            ps.setString(1, descricaoProduto.getTipoProduto());
            ps.setInt(2, descricaoProduto.getIdTipoProduto());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;
    }*/
    
    public static boolean deletarAdministrador(int idAdm) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int idEndereco = 0;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("select id_endereco "
                    + "from agronegocio.usuario u "
                    + "where id_usuario ="+ idAdm);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                //throw new CancelarDeletarException(" Não existe endereço cadastrado!");
                idEndereco = rs.getInt("id_endereco");
            }
            

            ps = con.prepareStatement("delete from agronegocio.usuario where id_usuario = ?");
            
            ps.setInt(1, idAdm);
            
            int i = ps.executeUpdate();

            if (i != 1) {
                throw new CancelarDeletarException("Não foi possivel excluir o Usuário. ");
            }
            
            //deletar endereço
            ps = con.prepareStatement("DELETE FROM agronegocio.endereco "
                    + "WHERE id_endereco = ?");
            
            ps.setInt(1, idEndereco);
            
            i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Estado. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }
    
    public static boolean deletarAgente(int idAgente) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int idEndereco = 0;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("select id_endereco "
                    + "from agronegocio.usuario u "
                    + "where id_usuario ="+ idAgente);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                //throw new CancelarDeletarException(" Não existe endereço cadastrado!");
                idEndereco = rs.getInt("id_endereco");
            }
            

            ps = con.prepareStatement("delete from agronegocio.usuario where id_usuario = ?");
            
            ps.setInt(1, idAgente);
            
            int i = ps.executeUpdate();

            if (i != 1) {
                throw new CancelarDeletarException("Não foi possivel excluir o Usuário. ");
            }
            
            //deletar endereço
            ps = con.prepareStatement("DELETE FROM agronegocio.endereco "
                    + "WHERE id_endereco = ?");
            
            ps.setInt(1, idEndereco);
            
            i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Estado. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }
    
    public static boolean deletarOperador(int idOperador) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int idEndereco = 0;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("select id_endereco "
                    + "from agronegocio.usuario u "
                    + "where id_usuario ="+ idOperador);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                //throw new CancelarDeletarException(" Não existe endereço cadastrado!");
                idEndereco = rs.getInt("id_endereco");
            }
            

            ps = con.prepareStatement("delete from agronegocio.usuario where id_usuario = ?");
            
            ps.setInt(1, idOperador);
            
            int i = ps.executeUpdate();

            if (i != 1) {
                throw new CancelarDeletarException("Não foi possivel excluir o Usuário. ");
            }
            
            //deletar endereço
            ps = con.prepareStatement("DELETE FROM agronegocio.endereco "
                    + "WHERE id_endereco = ?");
            
            ps.setInt(1, idEndereco);
            
            i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Estado. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
    
    public static boolean desabilitarAdministrador(Administrador administrador) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, administrador.getIdUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
            }

            ps = con.prepareStatement("UPDATE agronegocio.usuario SET habilitado = ? WHERE id_usuario = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, administrador.getIdUsuario());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
        public static boolean desabilitarAgente(Agente agente) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, agente.getIdUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
            }

            ps = con.prepareStatement("UPDATE agronegocio.usuario SET habilitado = ? WHERE id_usuario = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, agente.getIdUsuario());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
        
    public static boolean desabilitarOperador(Operador operador) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, operador.getIdUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
            }

            ps = con.prepareStatement("UPDATE agronegocio.usuario SET habilitado = ? WHERE id_usuario = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, operador.getIdUsuario());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static List<Administrador> consultarUsuarioAdministrador(Administrador funci, Regional rgg, Endereco end, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Administrador> funcionarios = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, "
                    + "e.logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "WHERE u.id_tipo_usuario = 1 ";*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula, "
                    + "u.id_endereco, "
                    + "u.id_situacao_usuario, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documento_rg_rne, u.documento_cpf_cnpj, u.documento_comprovante_residencia, u.justificativa_validacao, "
                    + "u.login, e.logradouro, e.numero, e.complemento, e.bairro, es.uf_estado, "
                    + "e.cidade, e.cep, e.id_estado, re.descricao_regional, re.id_regional, "
                    + "org.descricao_orgao_funcional , org.id_orgao_funcional, su.descricao_situacao_usuario "
                    + "from agronegocio.usuario as u "
                    + "inner join agronegocio.tipo_usuario as tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco as e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.orgao_funcional as org on u.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado as es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario as su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.regional as re on u.id_regional = re.id_regional "
                    + "WHERE u.id_tipo_usuario = 1";

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            queryNome += (funci.getNome() != null ? " AND nome LIKE '" + funci.getNome() + "%'" : "");
            querySobrenome += (funci.getSobrenome() != null ? " AND sobrenome LIKE '" + funci.getSobrenome() + "%'" : "");
            queryEmail += (funci.getEmail() != null ? " AND email LIKE '" + funci.getEmail() + "%'" : "");
            queryMatricula += (funci.getMatricula() != null ? " AND matricula LIKE '" + funci.getMatricula() + "%'" : "");
            queryRgRne += (funci.getRgRne() != null ? " AND rg_rne LIKE '" + funci.getRgRne() + "%'" : "");
            queryCpfCnpj += (funci.getCpfCnpj() != null ? " AND cpf_cnpj LIKE '" + funci.getCpfCnpj() + "%'" : "");
            queryOf += (funci.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional LIKE '" + funci.getDescricaoOrgaoFuncional() + "%'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional LIKE '" + rgg.getDescricaoRegional() + "%'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade LIKE '" + end.getCidade() + "%'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado LIKE '" + estado.getDescricaoEstado() + "%'" : "");

            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Administrador funcc = new Administrador();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();

                funcc.setIdUsuario(rs.getInt("id_usuario"));
                funcc.setNome(rs.getString("nome"));
                funcc.setSobrenome(rs.getString("sobrenome"));
                funcc.setEmail(rs.getString("email"));

                funcc.setMatricula(rs.getString("matricula"));

                funcc.setRgRne(rs.getString("rg_rne"));
                funcc.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                funcc.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                funcc.setCpfCnpj(rs.getString("cpf_cnpj"));
                funcc.setSexo(rs.getString("sexo"));
                funcc.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_orgao_funcional"));

                funcc.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                //cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                funcc.setLogin(rs.getString("login"));
                funcc.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                funcc.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(funcc.getIdUsuario()));

                funcc.setTipoUsuario(tp);
                funcc.setEndereco(e);
                funcc.setRegional(regio);
                funcc.setCliente(cliente);
                e.setEstado(estad);

                funcionarios.add(funcc);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return funcionarios;
    }

    public static Administrador consultarUsuarioAdministrador(int idUsuario) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Administrador adm = new Administrador();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, n.id_nacionalidade, n.descricao_nacionalidade, "
                    + "ti.id_tipo_telefone, ti.tipo_telefone, "
                    + "t.id_usuario_telefone, t.numero_telefone, t.id_tipo_telefone, "
                    + "e.logradouro, e.tipo_logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, es.descricao_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.nacionalidade n on n.id_nacionalidade = u.id_nacionalidade "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.tipo_telefone ti on ti.id_tipo_telefone = t.id_tipo_telefone "
                    + "inner join agronegocio.telefone t on u.id_usuario = t.id_usuario "
                    + "WHERE u.id_usuario =" + idUsuario;*/
 /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula, u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.id_situacao_usuario, u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, u.id_endereco, u.matricula, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, u.documentos, u.justificativa_validacao, "
                    + "u.login, u.id_regional, u.data_nascimento, u.id_tipo_usuario, "
                    + "tp.tipo_usuario, n.id_nacionalidade, n.descricao_nacionalidade, "
                    + "ti.id_tipo_telefone, ti.tipo_telefone, "
                    + "t.id_usuario_telefone, t.numero_telefone, t.id_tipo_telefone, "
                    + "e.logradouro, e.tipo_logradouro, e.numero, e.complemento, e.bairro, "
                    + "es.uf_estado, es.descricao_estado, e.cidade, e.cep, e.id_estado, "
                    + "re.descricao_regional, re.id_orgao_funcional, org.descricao_orgao_funcional, "
                    + "su.descricao_situacao_usuario "
                    + "from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.nacionalidade n on n.id_nacionalidade = u.id_nacionalidade "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.telefone t on u.id_usuario =  t.id_usuario "
                    + "inner join agronegocio.tipo_telefone ti on ti.id_tipo_telefone = t.id_tipo_telefone "
                    + "WHERE u.id_usuario =" + idUsuario;*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, u.id_regional, "
                    + "u.data_nascimento, u.id_tipo_usuario, u.matricula, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, u.id_endereco, "
                    + "u.documentos, u.justificativa_validacao, u.login, u.id_situacao_usuario, "
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

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            /*queryNome += (funci.getNome() != null ? " AND nome = '" + funci.getNome() + "'" : "");
            querySobrenome += (funci.getSobrenome() != null ? " AND sobrenome = '" + funci.getSobrenome() + "'" : "");
            queryEmail += (funci.getEmail() != null ? " AND email = '" + funci.getEmail() + "'" : "");
            queryMatricula += (funci.getMatricula() != null ? " AND matricula = '" + funci.getMatricula() + "'" : "");
            queryRgRne += (funci.getRgRne() != null ? " AND rg_rne = '" + funci.getRgRne() + "'" : "");
            queryCpfCnpj += (funci.getCpfCnpj() != null ? " AND cpf_cnpj = '" + funci.getCpfCnpj() + "'" : "");
            queryOf += (funci.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional = '" + funci.getDescricaoOrgaoFuncional() + "'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional = '" + rgg.getDescricaoRegional() + "'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade = '" + end.getCidade() + "'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado = '" + estado.getDescricaoEstado() + "'" : "");*/
            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Administrador funcc = new Administrador();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();
                Nacionalidade nac = new Nacionalidade();

                funcc.setIdUsuario(rs.getInt("id_usuario"));
                funcc.setNome(rs.getString("nome"));
                funcc.setSobrenome(rs.getString("sobrenome"));
                funcc.setEmail(rs.getString("email"));

                funcc.setMatricula(rs.getString("matricula"));

                funcc.setRgRne(rs.getString("rg_rne"));
                funcc.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                funcc.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                funcc.setCpfCnpj(rs.getString("cpf_cnpj"));
                funcc.setSexo(rs.getString("sexo"));
                funcc.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setTipoLogradouro(rs.getString("tipo_logradouro"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                /*tel.setIdTelefone(rs.getInt("id_usuario_telefone"));
                tel.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tel.setNumeroTelefone(rs.getString("numero_telefone"));
                tel.setTipoTelefone(rs.getString("tipo_telefone"));*/
                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));
                estad.setDescricaoEstado(rs.getString("descricao_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_regional"));
                regio.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regio.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                funcc.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                funcc.setLogin(rs.getString("login"));
                funcc.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                funcc.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(funcc.getIdUsuario()));

                e.setEstado(estad);
                funcc.setNacionalidade(nac);
                funcc.setTipoUsuario(tp);
                funcc.setEndereco(e);
                funcc.setRegional(regio);
                //funcc.setTelefone(tel);
                funcc.setCliente(cliente);

                adm = funcc;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return adm;
    }

    public static List<Agente> consultarUsuarioAgente(Agente agn, Regional rgg, Endereco end, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Agente> agentes = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, "
                    + "e.logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "WHERE u.id_tipo_usuario = 2 ";*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula, "
                    + "u.id_endereco, "
                    + "u.id_situacao_usuario, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login, e.logradouro, e.numero, e.complemento, e.bairro, es.uf_estado, "
                    + "e.cidade, e.cep, e.id_estado, re.descricao_regional, re.id_regional, "
                    + "org.descricao_orgao_funcional , org.id_orgao_funcional, su.descricao_situacao_usuario "
                    + "from agronegocio.usuario as u "
                    + "inner join agronegocio.tipo_usuario as tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco as e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.orgao_funcional as org on u.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado as es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario as su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.regional as re on u.id_regional = re.id_regional "
                    + "WHERE u.id_tipo_usuario = 2";

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            queryNome += (agn.getNome() != null ? " AND nome LIKE '" + agn.getNome() + "%'" : "");
            querySobrenome += (agn.getSobrenome() != null ? " AND sobrenome LIKE '" + agn.getSobrenome() + "%'" : "");
            queryEmail += (agn.getEmail() != null ? " AND email LIKE '" + agn.getEmail() + "%'" : "");
            queryMatricula += (agn.getMatricula() != null ? " AND matricula LIKE '" + agn.getMatricula() + "%'" : "");
            queryRgRne += (agn.getRgRne() != null ? " AND rg_rne LIKE '" + agn.getRgRne() + "%'" : "");
            queryCpfCnpj += (agn.getCpfCnpj() != null ? " AND cpf_cnpj LIKE '" + agn.getCpfCnpj() + "%'" : "");
            queryOf += (agn.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional LIKE '" + agn.getDescricaoOrgaoFuncional() + "%'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional LIKE '" + rgg.getDescricaoRegional() + "%'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade LIKE '" + end.getCidade() + "%'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado LIKE '" + estado.getDescricaoEstado() + "%'" : "");

            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Agente agen = new Agente();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();

                agen.setIdUsuario(rs.getInt("id_usuario"));
                agen.setNome(rs.getString("nome"));
                agen.setSobrenome(rs.getString("sobrenome"));
                agen.setEmail(rs.getString("email"));

                agen.setMatricula(rs.getString("matricula"));

                agen.setRgRne(rs.getString("rg_rne"));
                agen.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                agen.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                agen.setCpfCnpj(rs.getString("cpf_cnpj"));
                agen.setSexo(rs.getString("sexo"));
                agen.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_orgao_funcional"));
                regio.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                agen.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                agen.setLogin(rs.getString("login"));
                agen.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                agen.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(agen.getIdUsuario()));

                agen.setTipoUsuario(tp);
                agen.setEndereco(e);
                agen.setRegional(regio);
                agen.setCliente(cliente);
                e.setEstado(estad);

                agentes.add(agen);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return agentes;

    }

    public static Agente consultarUsuarioAgente(int idUsuario) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Agente agt = new Agente();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, n.id_nacionalidade, n.descricao_nacionalidade, "
                    //+ "ti.id_tipo_telefone, ti.tipo_telefone, "
                    //+ "t.id_usuario_telefone, t.numero_telefone, t.id_tipo_telefone, "
                    + "e.logradouro, e.tipo_logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, es.descricao_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.nacionalidade n on n.id_nacionalidade = u.id_nacionalidade "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    //+ "inner join agronegocio.tipo_telefone ti on ti.id_tipo_telefone = t.id_tipo_telefone "
                    //+ "inner join agronegocio.telefone t on u.id_usuario = t.id_usuario "
                    + "WHERE id_usuario =" + idUsuario;*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, u.id_regional, "
                    + "u.data_nascimento, u.id_tipo_usuario, u.matricula, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, u.id_endereco, "
                    + "u.documentos, u.justificativa_validacao, u.login, u.id_situacao_usuario, "
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

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            /*queryNome += (funci.getNome() != null ? " AND nome = '" + funci.getNome() + "'" : "");
            querySobrenome += (funci.getSobrenome() != null ? " AND sobrenome = '" + funci.getSobrenome() + "'" : "");
            queryEmail += (funci.getEmail() != null ? " AND email = '" + funci.getEmail() + "'" : "");
            queryMatricula += (funci.getMatricula() != null ? " AND matricula = '" + funci.getMatricula() + "'" : "");
            queryRgRne += (funci.getRgRne() != null ? " AND rg_rne = '" + funci.getRgRne() + "'" : "");
            queryCpfCnpj += (funci.getCpfCnpj() != null ? " AND cpf_cnpj = '" + funci.getCpfCnpj() + "'" : "");
            queryOf += (funci.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional = '" + funci.getDescricaoOrgaoFuncional() + "'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional = '" + rgg.getDescricaoRegional() + "'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade = '" + end.getCidade() + "'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado = '" + estado.getDescricaoEstado() + "'" : "");*/
            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Agente funcc = new Agente();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();
                Nacionalidade nac = new Nacionalidade();

                funcc.setIdUsuario(rs.getInt("id_usuario"));
                funcc.setNome(rs.getString("nome"));
                funcc.setSobrenome(rs.getString("sobrenome"));
                funcc.setEmail(rs.getString("email"));

                funcc.setMatricula(rs.getString("matricula"));

                funcc.setRgRne(rs.getString("rg_rne"));
                funcc.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                funcc.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                funcc.setCpfCnpj(rs.getString("cpf_cnpj"));
                funcc.setSexo(rs.getString("sexo"));
                funcc.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setTipoLogradouro(rs.getString("tipo_logradouro"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                /*tel.setIdTelefone(rs.getInt("id_usuario_telefone"));
                tel.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tel.setNumeroTelefone(rs.getString("numero_telefone"));
                tel.setTipoTelefone(rs.getString("tipo_telefone"));*/
                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));
                estad.setDescricaoEstado(rs.getString("descricao_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_regional"));
                regio.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regio.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                funcc.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                funcc.setLogin(rs.getString("login"));
                funcc.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                funcc.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(funcc.getIdUsuario()));

                e.setEstado(estad);
                funcc.setNacionalidade(nac);
                funcc.setTipoUsuario(tp);
                funcc.setEndereco(e);
                funcc.setRegional(regio);
                //funcc.setTelefone(tel);
                funcc.setCliente(cliente);

                agt = funcc;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return agt;
    }

    public static List<Operador> consultarUsuarioOperador(Operador oper, Regional rgg, Endereco end, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Operador> operadors = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, "
                    + "e.logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "WHERE u.id_tipo_usuario = 3";*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula, "
                    + "u.id_endereco, "
                    + "u.id_situacao_usuario, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login, e.logradouro, e.numero, e.complemento, e.bairro, es.uf_estado, "
                    + "e.cidade, e.cep, e.id_estado, re.descricao_regional, re.id_regional, "
                    + "org.descricao_orgao_funcional , org.id_orgao_funcional, su.descricao_situacao_usuario "
                    + "from agronegocio.usuario as u "
                    + "inner join agronegocio.tipo_usuario as tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco as e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.orgao_funcional as org on u.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado as es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario as su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "inner join agronegocio.regional as re on u.id_regional = re.id_regional "
                    + "WHERE u.id_tipo_usuario = 3";

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            queryNome += (oper.getNome() != null ? " AND nome LIKE '" + oper.getNome() + "%'" : "");
            querySobrenome += (oper.getSobrenome() != null ? " AND sobrenome LIKE '" + oper.getSobrenome() + "%'" : "");
            queryEmail += (oper.getEmail() != null ? " AND email LIKE '" + oper.getEmail() + "%'" : "");
            queryMatricula += (oper.getMatricula() != null ? " AND matricula LIKE '" + oper.getMatricula() + "%'" : "");
            queryRgRne += (oper.getRgRne() != null ? " AND rg_rne LIKE '" + oper.getRgRne() + "%'" : "");
            queryCpfCnpj += (oper.getCpfCnpj() != null ? " AND cpf_cnpj LIKE '" + oper.getCpfCnpj() + "%'" : "");
            queryOf += (oper.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional LIKE '" + oper.getDescricaoOrgaoFuncional() + "%'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional LIKE '" + rgg.getDescricaoRegional() + "%'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade LIKE '" + end.getCidade() + "%'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado LIKE '" + estado.getDescricaoEstado() + "%'" : "");

            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Operador op = new Operador();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();

                op.setIdUsuario(rs.getInt("id_usuario"));
                op.setNome(rs.getString("nome"));
                op.setSobrenome(rs.getString("sobrenome"));
                op.setEmail(rs.getString("email"));

                op.setMatricula(rs.getString("matricula"));

                op.setRgRne(rs.getString("rg_rne"));
                op.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                op.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                op.setCpfCnpj(rs.getString("cpf_cnpj"));
                op.setSexo(rs.getString("sexo"));
                op.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_orgao_funcional"));
                regio.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                op.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                op.setLogin(rs.getString("login"));
                op.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                op.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(op.getIdUsuario()));

                op.setTipoUsuario(tp);
                op.setEndereco(e);
                op.setRegional(regio);
                op.setCliente(cliente);
                e.setEstado(estad);

                operadors.add(op);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return operadors;

    }

    public static Operador consultarUsuarioOperador(int idUsuario) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Operador op = new Operador();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            /*String query = "SELECT u.id_usuario, u.nome, u.sobrenome, u.email, u.matricula,"
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, "
                    + "u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.matricula,"
                    + "u.id_endereco, n.id_nacionalidade, n.descricao_nacionalidade, "
                    //+ "ti.id_tipo_telefone, ti.tipo_telefone, "
                    //+ "t.id_usuario_telefone, t.numero_telefone, t.id_tipo_telefone, "
                    + "e.logradouro, e.tipo_logradouro, e.numero, e.complemento, e.bairro, "
                    + "e.cidade, e.cep, e.id_estado,u.id_regional, "
                    + "re.descricao_regional, re.id_orgao_funcional,  "
                    + "org.descricao_orgao_funcional,es.uf_estado, es.descricao_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario,  "
                    + "u.status_validacao, u.validado_por,u.data_validacao, "
                    + "u.documentos, u.justificativa_validacao, "
                    + "u.login from agronegocio.usuario u "
                    + "inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.regional re on u.id_orgao_funcional = re.id_regional "
                    + "inner join agronegocio.orgao_funcional org on re.id_orgao_funcional = org.id_orgao_funcional "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.nacionalidade n on n.id_nacionalidade = u.id_nacionalidade "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    //+ "inner join agronegocio.tipo_telefone ti on ti.id_tipo_telefone = t.id_tipo_telefone "
                    //+ "inner join agronegocio.telefone t on u.id_usuario = t.id_usuario "
                    + "WHERE id_usuario =" + idUsuario;*/
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.matricula, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, "
                    + "u.data_emissao_rg_rne, u.cpf_cnpj,u.sexo, u.id_regional, "
                    + "u.data_nascimento, u.id_tipo_usuario, u.matricula, "
                    + "u.status_validacao, u.validado_por,u.data_validacao, u.id_endereco, "
                    + "u.documentos, u.justificativa_validacao, u.login, u.id_situacao_usuario, "
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

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryMatricula = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryOf = "",
                    queryReg = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            /*queryNome += (funci.getNome() != null ? " AND nome = '" + funci.getNome() + "'" : "");
            querySobrenome += (funci.getSobrenome() != null ? " AND sobrenome = '" + funci.getSobrenome() + "'" : "");
            queryEmail += (funci.getEmail() != null ? " AND email = '" + funci.getEmail() + "'" : "");
            queryMatricula += (funci.getMatricula() != null ? " AND matricula = '" + funci.getMatricula() + "'" : "");
            queryRgRne += (funci.getRgRne() != null ? " AND rg_rne = '" + funci.getRgRne() + "'" : "");
            queryCpfCnpj += (funci.getCpfCnpj() != null ? " AND cpf_cnpj = '" + funci.getCpfCnpj() + "'" : "");
            queryOf += (funci.getDescricaoOrgaoFuncional() != null ? " AND descricao_orgao_funcional = '" + funci.getDescricaoOrgaoFuncional() + "'" : "");
            queryReg += (rgg.getDescricaoRegional() != null ? " AND descricao_regional = '" + rgg.getDescricaoRegional() + "'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade = '" + end.getCidade() + "'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado = '" + estado.getDescricaoEstado() + "'" : "");*/
            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryMatricula
                    + queryRgRne
                    + queryCpfCnpj
                    + queryOf
                    + queryReg
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Endereco e = new Endereco();
                Telefone tel = new Telefone();
                Operador funcc = new Operador();
                Regional regio = new Regional();
                Estado estad = new Estado();
                Cliente cliente = new Cliente();
                Nacionalidade nac = new Nacionalidade();

                funcc.setIdUsuario(rs.getInt("id_usuario"));
                funcc.setNome(rs.getString("nome"));
                funcc.setSobrenome(rs.getString("sobrenome"));
                funcc.setEmail(rs.getString("email"));

                funcc.setMatricula(rs.getString("matricula"));

                funcc.setRgRne(rs.getString("rg_rne"));
                funcc.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                funcc.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                funcc.setCpfCnpj(rs.getString("cpf_cnpj"));
                funcc.setSexo(rs.getString("sexo"));
                funcc.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setTipoLogradouro(rs.getString("tipo_logradouro"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));

                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                /*tel.setIdTelefone(rs.getInt("id_usuario_telefone"));
                tel.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tel.setNumeroTelefone(rs.getString("numero_telefone"));
                tel.setTipoTelefone(rs.getString("tipo_telefone"));*/
                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));
                estad.setDescricaoEstado(rs.getString("descricao_estado"));

                regio.setIdRegional(rs.getInt("id_regional"));
                regio.setDescricaoRegional(rs.getString("descricao_regional"));
                regio.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regio.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));

                funcc.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                cliente.setStatusValidacao(rs.getBoolean("status_validacao"));
                cliente.setVailidadoPor(rs.getString("validado_por"));
                cliente.setDataValidacao(rs.getDate("data_validacao"));
                cliente.setDocumentos(rs.getBlob("documentos"));
                cliente.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                funcc.setLogin(rs.getString("login"));
                funcc.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                funcc.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(funcc.getIdUsuario()));

                e.setEstado(estad);
                funcc.setNacionalidade(nac);
                funcc.setTipoUsuario(tp);
                funcc.setEndereco(e);
                funcc.setRegional(regio);
                //funcc.setTelefone(tel);
                funcc.setCliente(cliente);

                op = funcc;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return op;
    }
    
    public static boolean alterarAdministrador(Administrador adm) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //int resultadoPs = 0;
        int psU = 0, psE = 0, psI = 0;
        //int[] psT;
        int[] psT;
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
            ps.setString(1, adm.getEndereco().getTipoLogradouro());
            ps.setString(2, adm.getEndereco().getLogradouro());
            ps.setString(3, adm.getEndereco().getNumero());
            ps.setString(4, adm.getEndereco().getComplemento());
            ps.setString(5, adm.getEndereco().getBairro());
            ps.setString(6, adm.getEndereco().getCidade());
            ps.setString(7, adm.getEndereco().getCep());
            ps.setInt(8, adm.getEndereco().getEstado().getIdEstado());
            ps.setInt(9, adm.getEndereco().getIdEndereco());

            psE = ps.executeUpdate();

            if (psE != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            /*ps = con.prepareStatement(queryTelefone);
            for (int i = 0; i < adm.getTelefones().size(); i++) {
                ps.setString(1, adm.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, adm.getIdUsuario());
                ps.setInt(3, Integer.parseInt(adm.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }

            psT = ps.executeBatch();

            if (!Arrays.asList(psT).contains(1)) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o(s) telefone(s)!");
            }*/
            
            String queryAdm = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "matricula=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 1, "
                    + "id_nacionalidade=?, "
                    + "id_orgao_funcional=?, "
                    + "id_regional=? "
                    + "WHERE id_usuario =?";
            
            ps = con.prepareStatement(queryAdm);
            ps.setString(1, adm.getNome());
            ps.setString(2, adm.getSobrenome());
            ps.setString(3, adm.getEmail());
            ps.setString(4, adm.getMatricula());
            ps.setString(5, adm.getRgRne());
            ps.setString(6, adm.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(adm.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);

            ps.setString(8, adm.getCpfCnpj());
            ps.setString(9, adm.getSexo());
            java.sql.Date pDate = new Date(adm.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            ps.setInt(11, adm.getNacionalidade().getIdNacionalidade());
            ps.setInt(12, adm.getRegional().getIdOrgaoFuncional());
            ps.setInt(13, adm.getRegional().getIdRegional());
            ps.setInt(14, adm.getIdUsuario());

            psU = ps.executeUpdate();

            if (psU != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o Administrador!");
            }
            
            /*String queryTelefone = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";*/
            
            String queryTelefone = "";
            
            String cadastroTel = "";

            //ps = con.prepareStatement(queryTelefone);

            for (int i = 0; i < adm.getTelefones().size(); i++) {
                
                if (adm.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, adm.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, adm.getIdUsuario());
                    ps.setInt(3, adm.getTelefones().get(i).getIdTipoTelefone());
            
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
                
                    ps.setString(1, adm.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, adm.getIdUsuario());
                    ps.setInt(3, adm.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, adm.getTelefones().get(i).getIdTelefone());

                    psI = ps.executeUpdate();
                    
                    if (psI != 1) {
                        throw new CancelarAlterarException(" Não foi possivel atualizar o Telefone!");
                    }
                    
                }
                
            }
            
            
            con.commit();
            sucesso = true;

        } catch (CancelarAlterarException | SQLException e) {
            con.rollback();
            throw new SQLException(e.getMessage());
            //throw new CancelarAlterarException("Não foi possivel atualizar administrador. " + e);
            //throw new CancelarAlterarException("Não foi possivel atualizar administrador. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }
    
    public static boolean alterarOperador(Operador op) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //int resultadoPs = 0;
        int psU = 0, psE = 0, psI = 0;
        //int[] psT;
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

            /*String queryTelefone = "UPDATE agronegocio.endereco "
                    + "SET numero_telefone = ?, "
                    + "id_usuario = ?, "
                    + "id_tipo_telefone = ? "
                    + "WHERE id_telefone= ?";*/
            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, op.getEndereco().getTipoLogradouro());
            ps.setString(2, op.getEndereco().getLogradouro());
            ps.setString(3, op.getEndereco().getNumero());
            ps.setString(4, op.getEndereco().getComplemento());
            ps.setString(5, op.getEndereco().getBairro());
            ps.setString(6, op.getEndereco().getCidade());
            ps.setString(7, op.getEndereco().getCep());
            ps.setInt(8, op.getEndereco().getEstado().getIdEstado());
            ps.setInt(9, op.getEndereco().getIdEndereco());

            psE = ps.executeUpdate();

            if (psE != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            String queryAdm = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "matricula=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 3,  "
                    + "id_nacionalidade=?, "
                    + "id_orgao_funcional=?, "
                    + "id_regional=? "
                    + "WHERE id_usuario =?";

            ps = con.prepareStatement(queryAdm);
            ps.setString(1, op.getNome());
            ps.setString(2, op.getSobrenome());
            ps.setString(3, op.getEmail());
            ps.setString(4, op.getMatricula());
            ps.setString(5, op.getRgRne());
            ps.setString(6, op.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(op.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);

            ps.setString(8, op.getCpfCnpj());
            ps.setString(9, op.getSexo());
            java.sql.Date pDate = new Date(op.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            // ps.setInt(11, op.getTipoUsuario().getIdTipoUsuario());
            ps.setInt(11, op.getNacionalidade().getIdNacionalidade());
            ps.setInt(12, op.getRegional().getIdOrgaoFuncional());
            ps.setInt(13, op.getRegional().getIdRegional());
            ps.setInt(14, op.getIdUsuario());

            psU = ps.executeUpdate();

            if (psU != 1) {
                throw new CancelarAlterarException("Não foi possivel atualizar o Operador!");
            }

            String queryTelefone = "";

            String cadastroTel = "";

            for (int i = 0; i < op.getTelefones().size(); i++) {

                if (op.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                            + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, op.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, op.getIdUsuario());
                    ps.setInt(3, op.getTelefones().get(i).getIdTipoTelefone());

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

                    ps.setString(1, op.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, op.getIdUsuario());
                    ps.setInt(3, op.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, op.getTelefones().get(i).getIdTelefone());

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
            throw new CancelarAlterarException("Não foi possivel atualizar o operador. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }

    public static boolean alterarAgente(Agente agt) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultadoPs = 0;
        int psU = 0, psE = 0, psI = 0;
        int[] psT;
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
            ps.setString(1, agt.getEndereco().getTipoLogradouro());
            ps.setString(2, agt.getEndereco().getLogradouro());
            ps.setString(3, agt.getEndereco().getNumero());
            ps.setString(4, agt.getEndereco().getComplemento());
            ps.setString(5, agt.getEndereco().getBairro());
            ps.setString(6, agt.getEndereco().getCidade());
            ps.setString(7, agt.getEndereco().getCep());
            ps.setInt(8, agt.getEndereco().getEstado().getIdEstado());
            ps.setInt(9, agt.getEndereco().getIdEndereco());

            psE = ps.executeUpdate();

            if (psE != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }


            /*String queryTelefone = "UPDATE  agronegocio.telefone "
                    + "SET numero_telefone = ?, "
                    + "id_usuario = ?, "
                    + "id_tipo_telefone = ? "
                    + "WHERE id_usuario_telefone = ?";*/

 /*ps = con.prepareStatement(queryTelefone);
            for (int i = 0; i < agt.getTelefones().size(); i++) {
                ps.setString(1, agt.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, agt.getIdUsuario());
                ps.setInt(3, Integer.parseInt(agt.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }

            psT = ps.executeBatch();

            if (!Arrays.asList(psT).contains(1)) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o(s) telefone(s)!");
            }*/
            String queryAdm = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "matricula=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 2,  "
                    + "id_nacionalidade=?, "
                    + "id_orgao_funcional=?, "
                    + "id_regional=? "
                    + "WHERE id_usuario =?";

            ps = con.prepareStatement(queryAdm);
            ps.setString(1, agt.getNome());
            ps.setString(2, agt.getSobrenome());
            ps.setString(3, agt.getEmail());
            ps.setString(4, agt.getMatricula());
            ps.setString(5, agt.getRgRne());
            ps.setString(6, agt.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(agt.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);
            ps.setString(8, agt.getCpfCnpj());
            ps.setString(9, agt.getSexo());
            java.sql.Date pDate = new Date(agt.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            ps.setInt(11, agt.getNacionalidade().getIdNacionalidade());
            ps.setInt(12, agt.getRegional().getIdOrgaoFuncional());
            ps.setInt(13, agt.getRegional().getIdRegional());
            ps.setInt(14, agt.getIdUsuario());

            psU = ps.executeUpdate();

            if (psU != 1) {
                throw new CancelarAlterarException("Não foi possivel atualizar o Agente!");
            }

            String queryTelefone = "";

            String cadastroTel = "";

            for (int i = 0; i < agt.getTelefones().size(); i++) {

                if (agt.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                            + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, agt.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, agt.getIdUsuario());
                    ps.setInt(3, agt.getTelefones().get(i).getIdTipoTelefone());

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

                    ps.setString(1, agt.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, agt.getIdUsuario());
                    ps.setInt(3, agt.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, agt.getTelefones().get(i).getIdTelefone());

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
            throw new CancelarAlterarException("Não foi possível atualizar o agente. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }
    
}


