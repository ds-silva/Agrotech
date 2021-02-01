
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
import model.DescricaoProduto;


public final class TipoProdutoDAO {
    
    public static boolean insertTipoTipoProduto (DescricaoProduto dtp) throws Exception{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.tipo_produto (descricao_tipo_produto) VALUES (?)");
            ps.setString(1, dtp.getTipoProduto());        
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
    
    // selecionar tipo produto
    public static List<DescricaoProduto> selectTipoProduto(DescricaoProduto tipoProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<DescricaoProduto> tp = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_tipo_produto, "
                    + "descricao_tipo_produto, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_produto "
                    + "WHERE descricao_tipo_produto like '" + tipoProduto.getTipoProduto() + "%'");

            rs = ps.executeQuery();

            while (rs.next()) {

                DescricaoProduto tProduto = new DescricaoProduto();

                tProduto.setIdTipoProduto(rs.getInt("id_tipo_produto"));
                tProduto.setTipoProduto(rs.getString("descricao_tipo_produto"));
                tProduto.setDesabilitarTipoProduto(rs.getBoolean("habilitado"));

                tp.add(tProduto);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tp;
    }

    // listar tipo de produtos
    public static List<DescricaoProduto> listarDescricaoProduto() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<DescricaoProduto> tp = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_tipo_produto, "
                    + "descricao_tipo_produto, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_produto "
                    + "ORDER BY descricao_tipo_produto;");
            rs = ps.executeQuery();

            while (rs.next()) {
                DescricaoProduto tipoProduto = new DescricaoProduto();
                tipoProduto.setIdTipoProduto(rs.getInt("id_tipo_produto"));
                tipoProduto.setTipoProduto(rs.getString("descricao_tipo_produto"));
                tipoProduto.setDesabilitarTipoProduto(rs.getBoolean("habilitado"));
                tp.add(tipoProduto);

            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tp;
    }

    //update tipo de produto
    public static boolean updateTipoProduto(DescricaoProduto descricaoProduto) throws SQLException, IOException  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("UPDATE agronegocio.tipo_produto SET descricao_tipo_produto=? WHERE id_tipo_produto=?");

            ps.setString(1, descricaoProduto.getTipoProduto());
            ps.setInt(2, descricaoProduto.getIdTipoProduto());
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                return true;
            }
            
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }

    //delete tipo de produto
    public static boolean deleteTipoProduto(DescricaoProduto dtp) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("DELETE FROM agronegocio.tipo_produto \n"
                    + "WHERE descricao_tipo_produto = ?");
            ps.setInt(1, dtp.getIdTipoProduto());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }

    public static DescricaoProduto selectTipoProduto(int idTipoProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DescricaoProduto dp = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_tipo_produto, "
                    + "descricao_tipo_produto, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_produto "
                    + "WHERE id_tipo_produto=" + idTipoProduto);

            rs = ps.executeQuery();

            if (rs.next()) {
                dp = new DescricaoProduto();
                dp.setIdTipoProduto(rs.getInt("id_tipo_produto"));
                dp.setTipoProduto(rs.getString("descricao_tipo_produto"));
                dp.setDesabilitarTipoProduto(rs.getBoolean("habilitado"));
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return dp;
    }
    
     //delete tipo de produto
    public static boolean deleteTipoProduto(int idTipoProduto) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String query1 = "SELECT id_tipo_produto "
                    + " FROM agronegocio.descricao_produto "
                    + " WHERE id_tipo_produto = ? ";

            String query2 = "DELETE FROM agronegocio.tipo_produto WHERE id_tipo_produto = ?";

            ps = con.prepareStatement(query1);
            ps.setInt(1, idTipoProduto);
            rs = ps.executeQuery();

            if (rs.next()) {
                throw new CancelarDeletarException(" Esse Tipo de Produto está sendo usada no Sistema!");
            }

            //==== /
            ps = con.prepareStatement(query2);
            ps.setInt(1, idTipoProduto);

            int i = ps.executeUpdate();

            if (i == 1) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Tipo Produto. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
    public static boolean desabilitarTipoProduto(DescricaoProduto dP) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT id_tipo_produto, "
                    + "descricao_tipo_produto, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_produto "
                    + "WHERE id_tipo_produto="  + dP.getIdTipoProduto());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE agronegocio.tipo_produto "
                    + "SET habilitado=? "
                    + "WHERE id_tipo_produto=?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, dP.getIdTipoProduto());
            
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
