/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import excecoes.CancelarDeletarException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nacionalidade;

/**
 *
 * @author Felipe Toledo
 */
public final class NacionalidadeDAO {

    public static boolean insertNacionalidade(Nacionalidade nac) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.nacionalidade (descricao_nacionalidade, sigla_nacionalidade) VALUES (?,?)");
            ps.setString(1, nac.getDescricaoNacionalidade());
            ps.setString(2, nac.getSiglaNacionalidade());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;
    }

    public static List<Nacionalidade> listarNacionalidade() throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Nacionalidade> sn = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_nacionalidade, descricao_nacionalidade, sigla_nacionalidade, habilitado\n"
                    + "FROM agronegocio.nacionalidade\n"
                    + "ORDER BY descricao_nacionalidade");

            rs = ps.executeQuery();
            while (rs.next()) {

                Nacionalidade nac = new Nacionalidade();
                nac.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nac.setSiglaNacionalidade(rs.getString("sigla_nacionalidade"));
                nac.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));
                nac.setDesabilitarNacionalidade(rs.getBoolean("habilitado"));

                sn.add(nac);
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return sn;

    }

    public static List<Nacionalidade> consultarNacionalidade(Nacionalidade n) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Nacionalidade> sn = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //principal
            String query = "SELECT id_nacionalidade, descricao_nacionalidade, sigla_nacionalidade, habilitado FROM agronegocio.nacionalidade";
            //"WHERE id_nacionalidade = ?";

            //secundaria
            String query1 = "";

            //aclopadoras
            String queryPais = "";
            String querySigla = "";

            //condicional
            queryPais += (n.getDescricaoNacionalidade() != null || n.getSiglaNacionalidade() != null ? " WHERE " : "");

            queryPais += (n.getDescricaoNacionalidade() != null ? "descricao_nacionalidade LIKE '" + n.getDescricaoNacionalidade() + "%'" : "");
            queryPais += (n.getDescricaoNacionalidade() != null && n.getSiglaNacionalidade() != null ? "AND " : "");
            querySigla += (n.getSiglaNacionalidade() != null ? "sigla_nacionalidade LIKE '" + n.getSiglaNacionalidade() + "%'" : "");

            //query final
            query1 += query
                    + queryPais
                    + querySigla;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                Nacionalidade naci = new Nacionalidade();
                naci.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                naci.setSiglaNacionalidade(rs.getString("sigla_nacionalidade"));
                naci.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));
                naci.setDesabilitarNacionalidade(rs.getBoolean("habilitado"));

                sn.add(naci);
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return sn;

    }

    public static Nacionalidade getNacionalidade(int idNacionalidade) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Nacionalidade nc = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_nacionalidade, descricao_nacionalidade, sigla_nacionalidade, habilitado FROM agronegocio.nacionalidade WHERE id_nacionalidade=" + idNacionalidade);

            rs = ps.executeQuery();

            if (rs.next()) {

                nc = new Nacionalidade();
                nc.setIdNacionalidade(rs.getInt("id_nacionalidade"));
                nc.setSiglaNacionalidade(rs.getString("sigla_nacionalidade"));
                nc.setDescricaoNacionalidade(rs.getString("descricao_nacionalidade"));
                nc.setDesabilitarNacionalidade(rs.getBoolean("habilitado"));
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return nc;
    }

    //public static boolean alterarNacionalidade(Nacionalidade nacionalidade) throws SQLException, IOException {
    public static boolean alterarNacionalidade(Nacionalidade nacionalidade) throws SQLException, IOException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("UPDATE agronegocio.nacionalidade SET descricao_nacionalidade=?, sigla_nacionalidade=? WHERE id_nacionalidade=?");
            ps.setString(1, nacionalidade.getDescricaoNacionalidade());
            ps.setString(2, nacionalidade.getSiglaNacionalidade());
            ps.setInt(3, nacionalidade.getIdNacionalidade());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(NacionalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }

    public static boolean deletarNacionalidade(int idNacionalidade) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("select id_nacionalidade "
                    + "from agronegocio.usuario "
                    + "where id_nacionalidade =" + idNacionalidade);

            rs = ps.executeQuery();

            if (rs.next()) {
                throw new CancelarDeletarException(" Essa Nacionalidade está sendo usada no Sistema!");
            }

            ps = con.prepareStatement("DELETE FROM agronegocio.nacionalidade "
                    + "WHERE  id_nacionalidade = ?");

            ps.setInt(1, idNacionalidade);

            int i = ps.executeUpdate();

            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o País. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }

    public static boolean desabilitarNacionalidade(Nacionalidade nac) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT id_nacionalidade, "
                    + "descricao_nacionalidade, "
                    + "sigla_nacionalidade, "
                    + "habilitado "
                    + "FROM agronegocio.nacionalidade WHERE id_nacionalidade=" + nac.getIdNacionalidade());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }

            }

            ps = con.prepareStatement("UPDATE  agronegocio.nacionalidade SET habilitado = ?  "
                    + "WHERE id_nacionalidade = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, nac.getIdNacionalidade());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;

    }

}
