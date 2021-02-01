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
import model.Cliente;
import model.Endereco;
import model.Estado;
import model.Nacionalidade;
import model.Produtor;
import model.Proprietario;
import model.Telefone;
import model.TipoUsuario;

public class ClienteDAO {
    
    public static boolean cadastrarProprietario(Proprietario proprietario, Endereco endereco, Estado estado) throws SQLException, CancelarRegistroException {

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
                    + " (senha, nome, sobrenome, email, rg_rne, "
                    + " orgao_expedidor_rg_rne, data_emissao_rg_rne, "
                    + " cpf_cnpj, sexo, data_nascimento, id_tipo_usuario, "
                    + " id_endereco, id_nacionalidade,  id_situacao_usuario, "
                    + " status_validacao, validado_por, data_validacao, "
                    + " justificativa_validacao, login) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, proprietario.getSenha());
            ps.setString(2, proprietario.getNome());
            ps.setString(3, proprietario.getSobrenome());
            ps.setString(4, proprietario.getEmail());

            ps.setString(5, proprietario.getRgRne());
            ps.setString(6, proprietario.getOrgaoExpedidorRgRne());

            java.sql.Date sDate = new java.sql.Date(proprietario.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);

            ps.setString(8, proprietario.getCpfCnpj());
            ps.setString(9, proprietario.getSexo());

            java.sql.Date pDate = new java.sql.Date(proprietario.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            ps.setInt(11, Integer.parseInt(proprietario.getTipoUsuario().getTipoUsuario()));
            ps.setInt(12, endereco.getIdEndereco());
            ps.setInt(13, Integer.parseInt(proprietario.getNacionalidade().getDescricaoNacionalidade()));
            ps.setInt(14, Integer.parseInt(proprietario.getDescSituacaoUsuario()));
            ps.setBoolean(15, false);
            ps.setString(16, proprietario.getVailidadoPor());

            java.sql.Date nDate = new java.sql.Date(proprietario.getDataValidacao().getTime());
            ps.setDate(17, nDate);

            ps.setString(18, proprietario.getJustificativaValidacao());
            ps.setString(19, proprietario.getLogin());

            psU = ps.executeUpdate();

            if (psU == 1) {
                
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    proprietario.setIdUsuario(rs.getInt("id_usuario"));
                }
            }
            
             query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            for (int i = 0; i < proprietario.getTelefones().size(); i++) {
                ps.setString(1, proprietario.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, proprietario.getIdUsuario());
                ps.setInt(3, Integer.parseInt(proprietario.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }
            
            psT = ps.executeBatch();
            
            
            if (!Arrays.asList(psT).contains(1)) {
                con.commit();
                return true;
            }
            
            
        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Não foi possivel cadastrar proprietário! " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static boolean cadastrarProdutor(Produtor produtor, Endereco endereco, Estado estado) throws SQLException, CancelarRegistroException {

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
                    + " (senha, nome, sobrenome, email, rg_rne, "
                    + " orgao_expedidor_rg_rne, data_emissao_rg_rne, "
                    + " cpf_cnpj, sexo, data_nascimento, id_tipo_usuario, "
                    + " id_endereco, id_nacionalidade,  id_situacao_usuario, "
                    + " status_validacao, validado_por, data_validacao, "
                    + " justificativa_validacao, login) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, produtor.getSenha());
            ps.setString(2, produtor.getNome());
            ps.setString(3, produtor.getSobrenome());
            ps.setString(4, produtor.getEmail());

            ps.setString(5, produtor.getRgRne());
            ps.setString(6, produtor.getOrgaoExpedidorRgRne());

            java.sql.Date sDate = new java.sql.Date(produtor.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);

            ps.setString(8, produtor.getCpfCnpj());
            ps.setString(9, produtor.getSexo());

            java.sql.Date pDate = new java.sql.Date(produtor.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            ps.setInt(11, Integer.parseInt(produtor.getTipoUsuario().getTipoUsuario()));
            ps.setInt(12, endereco.getIdEndereco());
            ps.setInt(13, Integer.parseInt(produtor.getNacionalidade().getDescricaoNacionalidade()));
            ps.setInt(14, Integer.parseInt(produtor.getDescSituacaoUsuario()));
            ps.setBoolean(15, false);
            ps.setString(16, produtor.getVailidadoPor());

            java.sql.Date nDate = new java.sql.Date(produtor.getDataValidacao().getTime());
            ps.setDate(17, nDate);

            ps.setString(18, produtor.getJustificativaValidacao());
            ps.setString(19, produtor.getLogin());

            psU = ps.executeUpdate();

            if (psU == 1) {

                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    produtor.setIdUsuario(rs.getInt("id_usuario"));
                }
            }
            
            query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            for (int i = 0; i < produtor.getTelefones().size(); i++) {
                ps.setString(1, produtor.getTelefones().get(i).getNumeroTelefone());
                ps.setInt(2, produtor.getIdUsuario());
                ps.setInt(3, Integer.parseInt(produtor.getTelefones().get(i).getTipoTelefone()));
                ps.addBatch();
            }
            
            psT = ps.executeBatch();
            
            
            if (!Arrays.asList(psT).contains(1)) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Não foi possivel cadastrar produtor! " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }


    public static List<Proprietario> consultarUsuarioProprietario(Proprietario propri, Endereco end, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Proprietario> proprietarios = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.rg_rne, u.orgao_expedidor_rg_rne, u.data_emissao_rg_rne, "
                    + "u.cpf_cnpj, u.sexo, u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.id_endereco, "
                    + "e.logradouro, e.numero, e.complemento, e.bairro, e.cidade, e.cep, e.id_estado,"
                    + "es.uf_estado, u.id_situacao_usuario, su.descricao_situacao_usuario, u.status_validacao, u.validado_por,"
                    + "u.data_validacao, u.documentos, u.justificativa_validacao, u.login "
                    + "from agronegocio.usuario u inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "where u.id_tipo_usuario = 4 ";

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            queryNome += (propri.getNome() != null ? " AND nome LIKE '" + propri.getNome() + "%'" : "");
            querySobrenome += (propri.getSobrenome() != null ? " AND sobrenome LIKE '" + propri.getSobrenome() + "%'" : "");
            queryEmail += (propri.getEmail() != null ? " AND email LIKE '" + propri.getEmail() + "%'" : "");
            queryRgRne += (propri.getRgRne() != null ? " AND rg_rne LIKE '" + propri.getRgRne() + "%'" : "");
            queryCpfCnpj += (propri.getCpfCnpj() != null ? " AND cpf_cnpj LIKE '" + propri.getCpfCnpj() + "%'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade LIKE '" + end.getCidade() + "%'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado LIKE '" + estado.getDescricaoEstado() + "%'" : "");

            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryRgRne
                    + queryCpfCnpj
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Telefone tel = new Telefone();
                Cliente cliente = new Cliente();
                Proprietario proprie = new Proprietario();
                Endereco e = new Endereco();
                Estado estad = new Estado();
                
                proprie.setIdUsuario(rs.getInt("id_usuario"));
                proprie.setNome(rs.getString("nome"));
                proprie.setSobrenome(rs.getString("sobrenome"));
                proprie.setEmail(rs.getString("email"));

                proprie.setRgRne(rs.getString("rg_rne"));
                proprie.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                proprie.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                proprie.setCpfCnpj(rs.getString("cpf_cnpj"));
                proprie.setSexo(rs.getString("sexo"));
                proprie.setDataNascimento(rs.getDate("data_nascimento"));

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

                proprie.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                proprie.setStatusValidacao(rs.getBoolean("status_validacao"));
                proprie.setVailidadoPor(rs.getString("validado_por"));
                proprie.setDataValidacao(rs.getDate("data_validacao"));
                proprie.setDocumentos(rs.getBlob("documentos"));
                proprie.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                proprie.setLogin(rs.getString("login"));
                proprie.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                proprie.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(proprie.getIdUsuario()));

                proprie.setTipoUsuario(tp);
                proprie.setEndereco(e);
                proprie.setCliente(cliente);
                e.setEstado(estad);

                proprietarios.add(proprie);

            } 

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return proprietarios;
    }
    
    public static List<Produtor> consultarUsuarioProdutor(Produtor prod, Endereco end, Estado estado) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Produtor> produtors = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            String query = "SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, u.rg_rne, u.orgao_expedidor_rg_rne, u.data_emissao_rg_rne, "
                    + "u.cpf_cnpj, u.sexo, u.data_nascimento, u.id_tipo_usuario, tp.tipo_usuario, u.id_endereco, "
                    + "e.logradouro, e.numero, e.complemento, e.bairro, e.cidade, e.cep, e.id_estado,"
                    + "es.uf_estado, u.id_situacao_usuario, su.descricao_situacao_usuario, u.status_validacao, u.validado_por,"
                    + "u.data_validacao, u.documentos, u.justificativa_validacao, u.login "
                    + "from agronegocio.usuario u inner join agronegocio.tipo_usuario tp on u.id_tipo_usuario = tp.id_tipo_usuario "
                    + "inner join agronegocio.endereco e on u.id_endereco = e.id_endereco "
                    + "inner join agronegocio.estado es on e.id_estado = es.id_estado "
                    + "inner join agronegocio.situacao_usuario su on u.id_situacao_usuario = su.id_situacao_usuario "
                    + "where u.id_tipo_usuario = 5 ";

            //Secundária
            String query1 = "";

            //Acopladoras
            String queryNome = "",
                    querySobrenome = "",
                    queryEmail = "",
                    queryRgRne = "",
                    queryCpfCnpj = "",
                    queryCidade = "",
                    queryEstado = "";

            //Condicional
            queryNome += (prod.getNome() != null ? " AND nome LIKE '" + prod.getNome() + "%'" : "");
            querySobrenome += (prod.getSobrenome() != null ? " AND sobrenome LIKE '" + prod.getSobrenome() + "%'" : "");
            queryEmail += (prod.getEmail() != null ? " AND email LIKE '" + prod.getEmail() + "%'" : "");
            queryRgRne += (prod.getRgRne() != null ? " AND rg_rne LIKE '" + prod.getRgRne() + "%'" : "");
            queryCpfCnpj += (prod.getCpfCnpj() != null ? " AND cpf_cnpj LIKE '" + prod.getCpfCnpj() + "%'" : "");
            queryCidade += (end.getCidade() != null ? " AND cidade LIKE '" + end.getCidade() + "%'" : "");
            queryEstado += (estado.getDescricaoEstado() != null ? " AND es.id_estado LIKE '" + estado.getDescricaoEstado() + "%'" : "");

            //Query Final
            query1 += query
                    + queryNome
                    + querySobrenome
                    + queryEmail
                    + queryRgRne
                    + queryCpfCnpj
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoUsuario tp = new TipoUsuario();
                Telefone tel = new Telefone();
                Cliente cliente = new Cliente();
                Produtor produt = new Produtor();
                Endereco e = new Endereco();
                Estado estad = new Estado();

                produt.setIdUsuario(rs.getInt("id_usuario"));
                produt.setNome(rs.getString("nome"));
                produt.setSobrenome(rs.getString("sobrenome"));
                produt.setEmail(rs.getString("email"));

                produt.setRgRne(rs.getString("rg_rne"));
                produt.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                produt.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                produt.setCpfCnpj(rs.getString("cpf_cnpj"));
                produt.setSexo(rs.getString("sexo"));
                produt.setDataNascimento(rs.getDate("data_nascimento"));

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

                produt.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                produt.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));

                produt.setStatusValidacao(rs.getBoolean("status_validacao"));
                produt.setVailidadoPor(rs.getString("validado_por"));
                produt.setDataValidacao(rs.getDate("data_validacao"));
                produt.setDocumentos(rs.getBlob("documentos"));
                produt.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                produt.setLogin(rs.getString("login"));
                produt.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                produt.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(produt.getIdUsuario()));

                produt.setTipoUsuario(tp);
                produt.setEndereco(e);
                produt.setCliente(cliente);
                e.setEstado(estad);

                produtors.add(produt);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return produtors;
    }
    
    public static Proprietario getIdProprietario(int idUsuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Proprietario tipoProprietario = new Proprietario();

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, u.data_emissao_rg_rne, u.cpf_cnpj, "
                    + "u.sexo, "
                    + "u.data_nascimento, "
                    + "u.id_tipo_usuario, tp.tipo_usuario, n.id_nacionalidade, n.descricao_nacionalidade, "
                    + "u.id_endereco, e.tipo_logradouro, e.logradouro, e.numero, e.complemento, e.bairro, e.cidade, e.cep, e.id_estado, "
                    + "es.uf_estado, es.descricao_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario, "
                    + "u.status_validacao, u.validado_por, "
                    + "u.data_validacao, "
                    + "u.documentos, "
                    + "u.justificativa_validacao, "
                    + "u.login "
                    + "FROM agronegocio.usuario u, agronegocio.tipo_usuario tp, agronegocio.endereco e, "
                    + "agronegocio.estado es, agronegocio.situacao_usuario su, "
                    + "agronegocio.nacionalidade n "
                    + "WHERE u.id_tipo_usuario = tp.id_tipo_usuario AND "
                    + "u.id_endereco = e.id_endereco AND "
                    + "e.id_estado = es.id_estado AND "
                    + "n.id_nacionalidade = u.id_nacionalidade AND "
                    + "u.id_situacao_usuario = su.id_situacao_usuario "
                    + "AND u.id_usuario = " + idUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                TipoUsuario tp = new TipoUsuario();
                Telefone tel = new Telefone();
                Cliente cliente = new Cliente();
                Proprietario proprietario = new Proprietario();
                Endereco e = new Endereco();
                Estado estad = new Estado();
                Nacionalidade nac = new Nacionalidade();

                proprietario.setIdUsuario(rs.getInt("id_usuario"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setSobrenome(rs.getString("sobrenome"));
                proprietario.setEmail(rs.getString("email"));

                proprietario.setRgRne(rs.getString("rg_rne"));
                proprietario.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                proprietario.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                proprietario.setCpfCnpj(rs.getString("cpf_cnpj"));
                proprietario.setSexo(rs.getString("sexo"));
                proprietario.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));
                e.setTipoLogradouro(rs.getString("tipo_logradouro"));

                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));
                estad.setDescricaoEstado(rs.getString("descricao_estado"));

                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                proprietario.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));
                proprietario.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));

                proprietario.setStatusValidacao(rs.getBoolean("status_validacao"));
                proprietario.setVailidadoPor(rs.getString("validado_por"));
                proprietario.setDataValidacao(rs.getDate("data_validacao"));
                proprietario.setDocumentos(rs.getBlob("documentos"));
                proprietario.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                proprietario.setLogin(rs.getString("login"));
                proprietario.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                proprietario.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(proprietario.getIdUsuario()));

                e.setEstado(estad);
                proprietario.setTipoUsuario(tp);
                proprietario.setEndereco(e);
                proprietario.setCliente(cliente);
                proprietario.setNacionalidade(nac);

                tipoProprietario = proprietario;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tipoProprietario;
    }

    public static Produtor getIdProdutor(int idUsuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Produtor tipoProdutor = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT u.id_usuario, u.habilitado, u.nome, u.sobrenome, u.email, "
                    + "u.rg_rne, u.orgao_expedidor_rg_rne, u.data_emissao_rg_rne, u.cpf_cnpj, "
                    + "u.sexo, "
                    + "u.data_nascimento, "
                    + "u.id_tipo_usuario, tp.tipo_usuario, n.id_nacionalidade, n.descricao_nacionalidade, "
                    + "u.id_endereco, e.tipo_logradouro, e.logradouro, e.numero, e.complemento, e.bairro, e.cidade, e.cep, e.id_estado, "
                    + "es.uf_estado, es.descricao_estado, "
                    + "u.id_situacao_usuario, su.descricao_situacao_usuario, "
                    + "u.status_validacao, u.validado_por, "
                    + "u.data_validacao, "
                    + "u.documentos, "
                    + "u.justificativa_validacao, "
                    + "u.login "
                    + "FROM agronegocio.usuario u, agronegocio.tipo_usuario tp, agronegocio.endereco e, "
                    + "agronegocio.estado es, agronegocio.situacao_usuario su, "
                    + "agronegocio.nacionalidade n "
                    + "WHERE u.id_tipo_usuario = tp.id_tipo_usuario AND "
                    + "u.id_endereco = e.id_endereco AND "
                    + "e.id_estado = es.id_estado AND "
                    + "n.id_nacionalidade = u.id_nacionalidade AND "
                    + "u.id_situacao_usuario = su.id_situacao_usuario "
                    + "AND u.id_usuario = " + idUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                TipoUsuario tp = new TipoUsuario();
                Telefone tel = new Telefone();
                Cliente cliente = new Cliente();
                Produtor produt = new Produtor();
                Endereco e = new Endereco();
                Estado estad = new Estado();
                Nacionalidade nac = new Nacionalidade();

                produt.setIdUsuario(rs.getInt("id_usuario"));
                produt.setNome(rs.getString("nome"));
                produt.setSobrenome(rs.getString("sobrenome"));
                produt.setEmail(rs.getString("email"));

                produt.setRgRne(rs.getString("rg_rne"));
                produt.setOrgaoExpedidorRgRne(rs.getString("orgao_expedidor_rg_rne"));
                produt.setDataEmissaoRgRne(rs.getDate("data_emissao_rg_rne"));
                produt.setCpfCnpj(rs.getString("cpf_cnpj"));
                produt.setSexo(rs.getString("sexo"));
                produt.setDataNascimento(rs.getDate("data_nascimento"));

                tp.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
                tp.setTipoUsuario(rs.getString("tipo_usuario"));

                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setLogradouro(rs.getString("logradouro"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));
                e.setTipoLogradouro(rs.getString("tipo_logradouro"));

                estad.setIdEstado(rs.getInt("id_estado"));
                estad.setUfEstado(rs.getString("uf_estado"));
                estad.setDescricaoEstado(rs.getString("descricao_estado"));
                
                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));

                produt.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                produt.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));

                produt.setStatusValidacao(rs.getBoolean("status_validacao"));
                produt.setVailidadoPor(rs.getString("validado_por"));
                produt.setDataValidacao(rs.getDate("data_validacao"));
                produt.setDocumentos(rs.getBlob("documentos"));
                produt.setJustificativaValidacao(rs.getString("justificativa_validacao"));

                produt.setLogin(rs.getString("login"));
                produt.setDesabilitarUsuario(rs.getBoolean("habilitado"));
                
                //pega a lista de telefones do usuario
                produt.setTelefones(TelefoneDAO.consultarTelefonesFuncionarios(produt.getIdUsuario()));
                
                e.setEstado(estad);
                produt.setTipoUsuario(tp);
                produt.setEndereco(e);
                produt.setCliente(cliente);
                produt.setNacionalidade(nac);
                
                tipoProdutor = produt;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tipoProdutor;
    }
    
    /*public static boolean alterarProdutor(Produtor produtor) throws CancelarAlterarException, SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            

            String queryEndereco = "UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro = ?, "
                    + "logradouro = ?, "
                    + "numero = ?, "
                    + "complemento = ?, "
                    + "bairro = ?, "
                    + "cidade = ?, "
                    + "cep = ?, "
                    + "id_estado = ? "
                    + "WHERE id_endereco = ?";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, produtor.getEndereco().getTipoLogradouro());
            ps.setString(2, produtor.getEndereco().getLogradouro());
            ps.setString(3, produtor.getEndereco().getNumero());
            ps.setString(4, produtor.getEndereco().getComplemento());
            ps.setString(5, produtor.getEndereco().getBairro());
            ps.setString(6, produtor.getEndereco().getCidade());
            ps.setString(7, produtor.getEndereco().getCep());
            ps.setInt(8, produtor.getEndereco().getEstado().getIdEstado());
            ps.setBoolean(9, true);
            ps.setInt(10, produtor.getEndereco().getIdEndereco());

            int i = ps.executeUpdate();
            
            if (i != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }
            
            
            String queryProdutor = "UPDATE agronegocio.usuario "
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
                    + "id_endereco=?, "
                    + "id_nacionalidade=?, "
                    + "id_situacao_usuario=?, "
                    + "WHERE id_usuario=?";
            
            
            ps = con.prepareStatement(queryProdutor);
            ps.setString(1, produtor.getNome());
            ps.setString(2, produtor.getSobrenome());
            ps.setString(3, produtor.getEmail());
            
            ps.setString(5, produtor.getRgRne());
            ps.setString(6, produtor.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(produtor.getDataEmissaoRgRne().getTime());
            ps.setDate(7, sDate);

            ps.setString(8, produtor.getCpfCnpj());
            ps.setString(9, produtor.getSexo());
            java.sql.Date pDate = new Date(produtor.getDataNascimento().getTime());
            ps.setDate(10, pDate);

            ps.setString(11, produtor.getNacionalidade().getDescricaoNacionalidade());
            ps.setInt(12, produtor.getIdUsuario());

            int p = ps.executeUpdate();

            if (p == 1) {
                con.commit();
                return true;
            }
            
        } catch (Exception e) {
            con.rollback();
            throw new CancelarAlterarException("Não foi possivel cadastrar produtor. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }*/
    
    public static boolean alterarProdutor(Produtor produtor) throws CancelarAlterarException, SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int psu = 0, pse = 0, pst;
        boolean sucesso = false;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String queryEndereco = "UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro = ?, "
                    + "logradouro = ?, "
                    + "numero = ?, "
                    + "complemento = ?, "
                    + "bairro = ?, "
                    + "cidade = ?, "
                    + "cep = ?, "
                    + "id_estado = ? "
                    + "WHERE id_endereco = ?";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, produtor.getEndereco().getTipoLogradouro());
            ps.setString(2, produtor.getEndereco().getLogradouro());
            ps.setString(3, produtor.getEndereco().getNumero());
            ps.setString(4, produtor.getEndereco().getComplemento());
            ps.setString(5, produtor.getEndereco().getBairro());
            ps.setString(6, produtor.getEndereco().getCidade());
            ps.setString(7, produtor.getEndereco().getCep());
            ps.setInt(8, produtor.getEndereco().getEstado().getIdEstado());
            //ps.setBoolean(9, true);
            ps.setInt(9, produtor.getEndereco().getIdEndereco());

            pse = ps.executeUpdate();

            if (pse != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            String queryAdm = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 5 , "
                    + "id_nacionalidade=?, "
                    + "id_situacao_usuario=? "
                    + "WHERE id_usuario=?";

            ps = con.prepareStatement(queryAdm);
            ps.setString(1, produtor.getNome());
            ps.setString(2, produtor.getSobrenome());
            ps.setString(3, produtor.getEmail());

            ps.setString(4, produtor.getRgRne());
            ps.setString(5, produtor.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(produtor.getDataEmissaoRgRne().getTime());
            ps.setDate(6, sDate);

            ps.setString(7, produtor.getCpfCnpj());
            ps.setString(8, produtor.getSexo());
            java.sql.Date pDate = new Date(produtor.getDataNascimento().getTime());
            ps.setDate(9, pDate);
            ps.setInt(10, produtor.getNacionalidade().getIdNacionalidade());
            ps.setInt(11, produtor.getIdSituacaoUsuario());
            ps.setInt(12, produtor.getIdUsuario());

            psu = ps.executeUpdate();
            
            //throw new CancelarAlterarException("BLABLABLA     " + psu);
            
            if (psu != 1) {
                throw new CancelarAlterarException("Não foi possivel alterar proprietario. ");
            }
            
            String queryTelefone = "";
            
            String cadastroTel = "";

            //ps = con.prepareStatement(queryTelefone);

            for (int i = 0; i < produtor.getTelefones().size(); i++) {
                
                if (produtor.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, produtor.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, produtor.getIdUsuario());
                    ps.setInt(3, produtor.getTelefones().get(i).getIdTipoTelefone());
            
                    pst = ps.executeUpdate();
            
                    if (pst != 1) {
                        throw new CancelarAlterarException(" Não foi possivel cadastrar o Telefone!");
                    }
                } else {
                    queryTelefone = "UPDATE  agronegocio.telefone "
                    + "SET numero_telefone = ?, "
                    + "id_usuario = ?, "
                    + "id_tipo_telefone = ? "
                    + "WHERE id_usuario_telefone = ?";
                    
                    ps = con.prepareStatement(queryTelefone);
                
                    ps.setString(1, produtor.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, produtor.getIdUsuario());
                    ps.setInt(3, produtor.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, produtor.getTelefones().get(i).getIdTelefone());

                    pst = ps.executeUpdate();
                    
                    if (pst != 1) {
                        throw new CancelarAlterarException(" Não foi possivel atualizar o Telefone!");
                    }
                    
                }
                
            }
            
            
            con.commit();
            sucesso = true;
            
        } catch (Exception e) {
            con.rollback();
            throw new CancelarAlterarException("Não foi possivel alterar proprietario. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }
    
    
    //public static boolean alterarProprietario(Proprietario proprietario) throws CancelarAlterarException, SQLException {
    public static boolean alterarProprietario(Proprietario proprietario) throws CancelarAlterarException, SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int psu = 0, pse = 0, pst;
        boolean sucesso = false;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String queryEndereco = "UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro = ?, "
                    + "logradouro = ?, "
                    + "numero = ?, "
                    + "complemento = ?, "
                    + "bairro = ?, "
                    + "cidade = ?, "
                    + "cep = ?, "
                    + "id_estado = ? "
                    + "WHERE id_endereco = ?";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, proprietario.getEndereco().getTipoLogradouro());
            ps.setString(2, proprietario.getEndereco().getLogradouro());
            ps.setString(3, proprietario.getEndereco().getNumero());
            ps.setString(4, proprietario.getEndereco().getComplemento());
            ps.setString(5, proprietario.getEndereco().getBairro());
            ps.setString(6, proprietario.getEndereco().getCidade());
            ps.setString(7, proprietario.getEndereco().getCep());
            ps.setInt(8, proprietario.getEndereco().getEstado().getIdEstado());
            //ps.setBoolean(9, true);
            ps.setInt(9, proprietario.getEndereco().getIdEndereco());

            pse = ps.executeUpdate();

            if (pse != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            String queryAdm = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 4, "
                    + "id_nacionalidade=?, "
                    + "id_situacao_usuario=? "
                    + "WHERE id_usuario=?";

            ps = con.prepareStatement(queryAdm);
            ps.setString(1, proprietario.getNome());
            ps.setString(2, proprietario.getSobrenome());
            ps.setString(3, proprietario.getEmail());

            ps.setString(4, proprietario.getRgRne());
            ps.setString(5, proprietario.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(proprietario.getDataEmissaoRgRne().getTime());
            ps.setDate(6, sDate);

            ps.setString(7, proprietario.getCpfCnpj());
            ps.setString(8, proprietario.getSexo());
            java.sql.Date pDate = new Date(proprietario.getDataNascimento().getTime());
            ps.setDate(9, pDate);
            ps.setInt(10, proprietario.getNacionalidade().getIdNacionalidade());
            ps.setInt(11, proprietario.getIdSituacaoUsuario());
            ps.setInt(12, proprietario.getIdUsuario());

            psu = ps.executeUpdate();
            
            //throw new CancelarAlterarException("BLABLABLA     " + psu);
            
            if (psu != 1) {
                throw new CancelarAlterarException("Não foi possivel alterar proprietario. ");
            }
            
            String queryTelefone = "";
            
            String cadastroTel = "";

            //ps = con.prepareStatement(queryTelefone);

            for (int i = 0; i < proprietario.getTelefones().size(); i++) {
                
                if (proprietario.getTelefones().get(i).getIdTelefone() == 0) {
                    cadastroTel = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";
                    ps = con.prepareStatement(cadastroTel);
                    ps.setString(1, proprietario.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, proprietario.getIdUsuario());
                    ps.setInt(3, proprietario.getTelefones().get(i).getIdTipoTelefone());
            
                    pst = ps.executeUpdate();
            
                    if (pst != 1) {
                        throw new CancelarAlterarException(" Não foi possivel cadastrar o Telefone!");
                    }
                } else {
                    queryTelefone = "UPDATE  agronegocio.telefone "
                    + "SET numero_telefone = ?, "
                    + "id_usuario = ?, "
                    + "id_tipo_telefone = ? "
                    + "WHERE id_usuario_telefone = ?";
                    
                    ps = con.prepareStatement(queryTelefone);
                
                    ps.setString(1, proprietario.getTelefones().get(i).getNumeroTelefone());
                    ps.setInt(2, proprietario.getIdUsuario());
                    ps.setInt(3, proprietario.getTelefones().get(i).getIdTipoTelefone());
                    ps.setInt(4, proprietario.getTelefones().get(i).getIdTelefone());

                    pst = ps.executeUpdate();
                    
                    if (pst != 1) {
                        throw new CancelarAlterarException(" Não foi possivel atualizar o Telefone!");
                    }
                    
                }
                
            }
            
            
            con.commit();
            sucesso = true;
            
        } catch (Exception e) {
            con.rollback();
            throw new CancelarAlterarException("Não foi possivel alterar proprietario. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return sucesso;
    }
    
    public static boolean deletarProdutor(int idProdutor) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int idEndereco = -1;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("SELECT id_usuario_imovel FROM agronegocio.usuario_imovel WHERE id_usuario = ? ");
            ps.setInt(1, idProdutor);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Usuário possui imóvel rural.");
            }
            
            
            //Pega Endereço
            
            ps = con.prepareStatement("SELECT id_endereco FROM agronegocio.usuario WHERE id_usuario = ? ");
            ps.setInt(1, idProdutor);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                idEndereco = rs.getInt("id_endereco");
            }
            
            //Deletar Usuário
            
            ps = con.prepareStatement("DELETE FROM agronegocio.usuario WHERE id_usuario = ? ");  
            ps.setInt(1, idProdutor);
            
            int i = ps.executeUpdate();
            
            if(i != 1){
                throw new CancelarDeletarException(" Não foi possível deletar usuário.");
            }
            
            //Deletar Endereço do Usuário
            
            ps = con.prepareStatement("DELETE FROM agronegocio.endereco WHERE id_endereco = ? ");  
            ps.setInt(1, idEndereco);
            
            int x = ps.executeUpdate();
            
            if(x != 1){
                throw new CancelarDeletarException(" Não foi possível deletar o endereço do usuário.");
            }
            
            //Deletar Imóvel do Usuário
            
            /*ps = con.prepareStatement("DELETE FROM agronegocio.usuario_imovel WHERE id_usuario = ? ");  
            ps.setInt(1, idProdutor);
            
            int y = ps.executeUpdate();
            
            if(y == 1){
                con.commit();
                return true;
            } else {
                throw new CancelarDeletarException(" Não foi possível deletar o imóvel do usuário.");
                
            }*/
            
             con.commit();
             return true;
            
            
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Produtor. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        
    }
    
    public static boolean deletarProprietario(int idProprietario) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idEndereco = -1;
        try {
           con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            

            ps = con.prepareStatement("SELECT id_usuario_imovel FROM agronegocio.usuario_imovel WHERE id_usuario = ?");
            ps.setInt(1, idProprietario);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                throw new CancelarDeletarException("Usuario possui imovel rural");
            }
            // pegar endereço
             ps = con.prepareStatement("SELECT id_endereco FROM agronegocio.usuario WHERE id_usuario = ?");
             ps.setInt(1, idProprietario);
             rs = ps.executeQuery();
             if (rs.next()){
                 idEndereco = rs.getInt("id_endereco");
                 
             }
             //deletar proprietario
             ps = con.prepareStatement("DELETE FROM agronegocio.usuario WHERE id_usuario = ?");
             
             ps.setInt(1, idProprietario);
             
             int i = ps.executeUpdate();
             
             if (i != 1){
                 throw new CancelarDeletarException("Nao foi possivel deletar usuario");
             }
              //deletar endereço do proprietario
             ps = con.prepareStatement("DELETE FROM agronegocio.endereco WHERE id_endereco = ?");
             
             ps.setInt(1, idEndereco);
             
             int x = ps.executeUpdate();
             
             if (x != 1){
                 throw new CancelarDeletarException("Nao foi possivel deletar endereco");
             }
             con.commit();
             return true;
             
             
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Proprietario. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public static boolean desabilitarProprietario(Proprietario prop) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, prop.getIdUsuario());

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
            ps.setInt(2, prop.getIdUsuario());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
    public static boolean desabilitarProdutor(Produtor pdt) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.usuario WHERE id_usuario = ?");
            ps.setInt(1, pdt.getIdUsuario());

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
            ps.setInt(2, pdt.getIdUsuario());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
}
