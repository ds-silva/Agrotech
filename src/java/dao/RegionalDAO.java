package dao;

import connection.ConnectionFactory;
import excecoes.CancelarAlterarException;
import excecoes.CancelarDeletarException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Regional;
import model.Usuario;
import model.Endereco;
import model.Estado;

/**
 *
 * @author karin
 */
public final class RegionalDAO {

    //inserir situacao usuario
    public static boolean insertRegional(Regional regional, Endereco endereco, Estado estado) throws Exception {
        int idResult = 0;
        int resultadoPS = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null, rs1 = null;

        //int idEndereco=0;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.endereco "
                    + "(cep, tipo_logradouro, logradouro, numero, complemento, bairro, cidade, id_estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.setInt(8, Integer.parseInt(estado.getDescricaoEstado()));
            resultadoPS = ps.executeUpdate();
            //ps.close();

            if (resultadoPS == 1) {

                rs = ps.getGeneratedKeys();

                if (rs != null && rs.next()) {
                    int lastIsertedId = rs.getInt("id_endereco");
                    endereco.setIdEndereco(lastIsertedId);
                    //bean.setIdcliente(rs.getInt("idcliente"));
                    idResult = endereco.getIdEndereco();
                } else {
                    throw new Exception("Não foi possível passar o ID de endereco");
                }
            } else {
                throw new SQLException("Não foi possível cadastrar o endereço");
            }
            //rs.close();
            //ps.close();

            ps = con.prepareStatement("INSERT INTO agronegocio.regional "
                    + "(descricao_regional, id_endereco, id_orgao_funcional, telefone) "
                    + "VALUES(?, ?, ?, ?);");

            ps.setString(1, regional.getDescricaoRegional());
            ps.setInt(2, idResult);
            ps.setInt(3, Integer.parseInt(regional.getOrgaoFuncional()));
            ps.setString(4, regional.getTelefoneRegional());
            int i = ps.executeUpdate();

            if (i == 1) {
                //System.out.println("Regional foi cadastrada com sucesso.");
                return true;

            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static List<Regional> consultarRegional(Regional regional, Endereco end, Estado estad) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Regional> reg = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            String query = "SELECT orgao_funcional.id_orgao_funcional, "
                    + "orgao_funcional.descricao_orgao_funcional, "
                    + "regional.id_regional, "
                    + "regional.habilitado, "
                    + "regional.descricao_regional, "
                    + "regional.telefone, "
                    + "endereco.cidade, "
                    + "endereco.id_estado, "
                    + "estado.descricao_estado "
                    + "FROM agronegocio.regional, "
                    + "agronegocio.endereco, "
                    + "agronegocio.orgao_funcional, "
                    + "agronegocio.estado "
                    + "WHERE regional.id_endereco = endereco.id_endereco "
                    + "and orgao_funcional.id_orgao_funcional = regional.id_orgao_funcional "
                    + "and estado.id_estado = endereco.id_estado";

            String query1 = "";

            String queryOrgFuncional = "",
                    queryRegional = "",
                    queryCidade = "",
                    queryEstado = "";

            queryOrgFuncional += (regional.getOrgaoFuncional() != null ? " and orgao_funcional.id_orgao_funcional = '" + Integer.parseInt(regional.getOrgaoFuncional()) + "'" : "");
            queryRegional += (regional.getDescricaoRegional() != null ? " and id_regional = '" + Integer.parseInt(regional.getDescricaoRegional()) + "'" : "");
            queryCidade += (end.getCidade() != null ? " and cidade = '" + end.getCidade() + "'" : "");
            queryEstado += (estad.getDescricaoEstado() != null ? " and estado.id_estado = '" + Integer.parseInt(estad.getDescricaoEstado()) + "'" : "");

            query1 += query
                    + queryOrgFuncional
                    + queryRegional
                    + queryCidade
                    + queryEstado;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                Regional regi = new Regional();
                Endereco endereco = new Endereco();
                Estado estado = new Estado();

                regi.setDescricaoRegional(rs.getString("descricao_regional"));
                regi.setTelefone(rs.getString("telefone"));
                regi.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regi.setIdRegional(rs.getInt("id_regional"));
                regi.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));
                regi.setDesabilitarRegional(rs.getBoolean("habilitado"));

                endereco.setCidade(rs.getString("cidade"));

                estado.setDescricaoEstado(rs.getString("descricao_estado"));

                endereco.setEstado(estado);
                regi.setEndereco(endereco);

                reg.add(regi);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return reg;
    }

    public static Regional getRegional(int idRegional) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Regional reg = new Regional();

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT orgao_funcional.id_orgao_funcional, "
                    + "orgao_funcional.descricao_orgao_funcional, "
                    + "regional.id_regional, "
                    + "regional.habilitado, "
                    + "regional.descricao_regional, "
                    + "regional.telefone, "
                    + "endereco.cidade, "
                    + "endereco.tipo_logradouro, "
                    + "endereco.logradouro, "
                    + "endereco.numero, "
                    + "endereco.complemento, "
                    + "endereco.bairro, "
                    + "endereco.cep, "
                    + "endereco.id_endereco, "
                    + "estado.uf_estado, "
                    + "estado.id_estado, "
                    + "estado.descricao_estado "
                    + "FROM agronegocio.regional, "
                    + "agronegocio.endereco, "
                    + "agronegocio.orgao_funcional, "
                    + "agronegocio.estado "
                    + "WHERE regional.id_endereco = endereco.id_endereco "
                    + "and orgao_funcional.id_orgao_funcional = regional.id_orgao_funcional "
                    + "and estado.id_estado = endereco.id_estado "
                    + "and id_regional=?");

            ps.setInt(1, idRegional);

            rs = ps.executeQuery();

            if (rs.next()) {

                Regional regi = new Regional();
                Endereco end = new Endereco();
                Estado estado = new Estado();

                regi.setDescricaoRegional(rs.getString("descricao_regional"));
                regi.setTelefone(rs.getString("telefone"));
                regi.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                regi.setIdRegional(rs.getInt("id_regional"));
                regi.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));
                regi.setDesabilitarRegional(rs.getBoolean("habilitado"));
                //falta endereco que sera pego ali embaixo
                end.setIdEndereco(rs.getInt("id_endereco"));
                end.setTipoLogradouro(rs.getString("tipo_logradouro"));
                end.setLogradouro(rs.getString("logradouro"));
                end.setNumero(rs.getString("numero"));
                end.setComplemento(rs.getString("complemento"));
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setCep(rs.getString("cep"));
                //falta estado que sera pego ali embaixo              
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                //passando o estado para endereco
                end.setEstado(estado);
                //passando endereco para regional
                regi.setEndereco(end);

                reg = regi;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return reg;

    }

    public static boolean excluirRegional(int idRegional) throws CancelarDeletarException, SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idEndereco = -1;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            // 1º - Salva o ID de endereço
            ps = con.prepareStatement("SELECT id_endereco FROM agronegocio.regional WHERE id_regional = ?");
            ps.setInt(1, idRegional);

            rs = ps.executeQuery();

            if (rs.next()) {
                idEndereco = rs.getInt("id_endereco");
            } else {
                throw new CancelarDeletarException(" Não foi possivel localizar o endereço!");
            }

            // 2º Verifica se usuário estar utilizando a regional
            ps = con.prepareStatement("SELECT id_regional FROM agronegocio.usuario WHERE id_regional = ?");
            ps.setInt(1, idRegional);

            rs = ps.executeQuery();

            if (rs.next()) {
                throw new CancelarDeletarException(" Regional está sendo utilizada por algum usuário!");
            }

            //3º Deletar Regional
            ps = con.prepareStatement("DELETE FROM agronegocio.regional WHERE id_regional = ?");
            ps.setInt(1, idRegional);

            int i = ps.executeUpdate();

            if (i != 1) {
                throw new CancelarDeletarException(" Erro ao deletar regional! (Regional não encontrada)");
            }

            //4º Deletar o endereço
            ps = con.prepareStatement("DELETE FROM agronegocio.endereco WHERE id_endereco = ?");
            ps.setInt(1, idEndereco);

            int x = ps.executeUpdate();

            if (x != 1) {
                throw new CancelarDeletarException(" Erro ao deletar regional! (Endereço não encontrado)");
            } else {
                con.commit();
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi deletar a Regional: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static boolean alterarRegional(Regional regional) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE agronegocio.regional "
                    + "SET descricao_regional = ?, "
                    + "id_endereco = ?, "
                    + "id_orgao_funcional = ?, "
                    + "telefone = ? "
                    + "WHERE id_regional=? ");

            ps.setString(1, regional.getDescricaoRegional());
            ps.setInt(2, regional.getEndereco().getIdEndereco());
            ps.setInt(3, regional.getIdOrgaoFuncional());
            ps.setString(4, regional.getTelefoneRegional());
            ps.setInt(5, regional.getIdRegional());

            int i = ps.executeUpdate();
            if (i != 1) {
                throw new SQLException("Não foi possivel realizar o update do Imovel Rural");
            }

            ps = con.prepareStatement("UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro=?, logradouro=?, "
                    + "numero=?, complemento=?, bairro=?, cidade=?, "
                    + "cep=?, id_estado=? "
                    + "WHERE id_endereco= " + regional.getEndereco().getIdEndereco());

            ps.setString(1, regional.getEndereco().getTipoLogradouro());
            ps.setString(2, regional.getEndereco().getLogradouro());
            ps.setString(3, regional.getEndereco().getNumero());
            ps.setString(4, regional.getEndereco().getComplemento());
            ps.setString(5, regional.getEndereco().getBairro());
            ps.setString(6, regional.getEndereco().getCidade());
            ps.setString(7, regional.getEndereco().getCep());
            ps.setInt(8, regional.getEndereco().getEstado().getIdEstado());

            i = ps.executeUpdate();

            if (i == 1) {
                con.commit();
                return true;
            }

        } catch (Exception ex) {
            con.rollback();
            throw new CancelarAlterarException("Erro ao alterar: " + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    public static boolean desabilitarRegional(Regional r) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado "
                    + "FROM agronegocio.regional "
                    + "where id_regional=" + r.getIdRegional());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }

            }

            ps = con.prepareStatement("UPDATE  agronegocio.regional "
                    + "SET habilitado = ?  "
                    + "WHERE id_regional = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, r.getIdRegional());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;

    }

    public static List<Regional> listarRegionalPorOf(Regional r) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Regional> listaRegional = new ArrayList<>();
        Regional regional;

        try {

            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT id_regional, descricao_regional FROM agronegocio.regional WHERE id_orgao_funcional = ?");
            ps.setInt(1, r.getIdOrgaoFuncional());

            rs = ps.executeQuery();

            while (rs.next()) {

                regional = new Regional();

                regional.setIdRegional(rs.getInt("id_regional"));
                regional.setDescricaoRegional(rs.getString("descricao_regional"));

                listaRegional.add(regional);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return listaRegional;
    }

}
