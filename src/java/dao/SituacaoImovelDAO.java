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
import model.ImovelRural;

public final class SituacaoImovelDAO {

    public static boolean insertSituacaoImovel(ImovelRural ir) throws Exception{
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.situacao_imovel (descricao_situacao) VALUES(?)");
            ps.setString(1, ir.getSituacaoImovel());        
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
    
    public static List<ImovelRural> consultarSituacaoImovel(ImovelRural sit) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ImovelRural> list = new ArrayList<>();

        try {

            con = ConnectionFactory.getConnection();

            String query = "SELECT id_situacao_imovel, "
                    + "descricao_situacao, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_imovel";
            //+ "WHERE  id_situacao_imovel = ?";

            String query1 = "";

            query1 += (sit.getSituacaoImovel() != null ? " WHERE descricao_situacao = '" + sit.getSituacaoImovel() + "'" : "");
            query += query1;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            

            while (rs.next()) {

                ImovelRural sitImovel = new ImovelRural();

                sitImovel.setIdSituacaoImovelRural(rs.getInt("id_situacao_imovel"));
                sitImovel.setSituacaoImovel(rs.getString("descricao_situacao"));
                sitImovel.setDesabilitarSituacaoImovelRural(rs.getBoolean("habilitado"));

                list.add(sitImovel);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return list;
    }
    
    public static List<ImovelRural> ListarSituacaoImovelRural() throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ImovelRural> ir = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_imovel, "
                    + "descricao_situacao, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_imovel "
                    + "ORDER BY  id_situacao_imovel;");

            rs = ps.executeQuery();
            while (rs.next()) {

                ImovelRural sitImovel = new ImovelRural();

                sitImovel.setIdSituacaoImovelRural(rs.getInt("id_situacao_imovel"));
                sitImovel.setSituacaoImovel(rs.getString("descricao_situacao"));
                sitImovel.setDesabilitarSituacaoImovelRural(rs.getBoolean("habilitado"));
                
                ir.add(sitImovel);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return ir;

    }
    
    public static ImovelRural getSituacaoImovel(int idSItuacaoImovel) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ImovelRural sitImovel = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_imovel, "
                    + "descricao_situacao, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_imovel "
                    + "WHERE id_situacao_imovel=" + idSItuacaoImovel);
            rs = ps.executeQuery();

            if (rs.next()) {
                sitImovel = new ImovelRural();
                sitImovel.setIdSituacaoImovelRural(rs.getInt("id_situacao_imovel"));
                sitImovel.setSituacaoImovel(rs.getString("descricao_situacao"));
                sitImovel.setDesabilitarSituacaoImovelRural(rs.getBoolean("habilitado"));

            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return sitImovel;

    }
    
    public static ImovelRural getSituacaoImovel(ImovelRural situacaoImovel) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ImovelRural ir = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_imovel, "
                    + "descricao_situacao, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_imovel "
                    + "WHERE descricao_situacao LIKE '" + situacaoImovel.getSituacaoImovel() + "%'");
            rs = ps.executeQuery();

            if (rs.next()) {

                ir = new ImovelRural();
                ir.setIdSituacaoImovelRural(rs.getInt("id_situacao_imovel"));
                ir.setSituacaoImovel(rs.getString("descricao_situacao"));
                ir.setDesabilitarSituacaoImovelRural(rs.getBoolean("habilitado"));

            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return ir;

    }
    
    public static boolean deletarSituacaoImovel(int idSituacaoImovel) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("SELECT id_situacao_imovel FROM agronegocio.imovel_rural WHERE id_situacao_imovel=" + idSituacaoImovel);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Essa Situação Imovel está sendo usada no Sistema!");
            }
            
            ps = con.prepareStatement("DELETE FROM agronegocio.situacao_imovel WHERE id_situacao_imovel=?");
            
            ps.setInt(1, idSituacaoImovel);
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir a situação Imovel. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
    
     public static boolean updateSituacaoImovel(ImovelRural altImovelRural) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("UPDATE agronegocio.situacao_imovel SET descricao_situacao=? WHERE id_situacao_imovel=?");

            ps.setString(1, altImovelRural.getSituacaoImovel());
            ps.setInt(2, altImovelRural.getIdSituacaoImovelRural() );

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
     
     public static boolean desabilitarSituacaoImovel(ImovelRural ir) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.situacao_imovel WHERE id_situacao_imovel = ?");
            ps.setInt(1, ir.getIdSituacaoImovelRural());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
            }

            ps = con.prepareStatement("UPDATE agronegocio.situacao_imovel "
                    + "SET habilitado = ? "
                    + "WHERE id_situacao_imovel = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, ir.getIdSituacaoImovelRural());

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
