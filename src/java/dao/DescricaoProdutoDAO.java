package dao;


import connection.ConnectionFactory;
import excecoes.CancelarDeletarException;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DescricaoProduto;


public final class DescricaoProdutoDAO {
    
    public static boolean insertDescricaoTipoProduto (DescricaoProduto dp) throws Exception{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.descricao_produto(descricao_produto, descricao_unidade_produto, id_tipo_produto) VALUES(?, ?, ?);");
            ps.setString(1, dp.getDescricaoProduto());  
            ps.setString(2, dp.getUnidadeProduto());
            ps.setInt(3, Integer.parseInt(dp.getTipoProduto()));

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
    
    public static List<DescricaoProduto> consultarDescricaoProduto(DescricaoProduto descricaoProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<DescricaoProduto> dP = new ArrayList<>();
        
        try 
        {
            con = ConnectionFactory.getConnection();
            
            
            /*String query = "SELECT descricao_produto.*, "
                    + "tipo_produto.* "
                    + "FROM agronegocio.descricao_produto descricao_produto, "
                    + "agronegocio.tipo_produto tipo_produto "
                    + "WHERE descricao_produto.id_tipo_produto = tipo_produto.id_tipo_produto and ";*/
            
            
            String query = "SELECT descricao_produto.id_descricao_produto, "
                    + "descricao_produto.descricao_produto, "
                    + "descricao_produto.descricao_unidade_produto, "
                    + "tipo_produto.id_tipo_produto, "
                    + "descricao_produto.habilitado, "
                    + "tipo_produto.descricao_tipo_produto "
                    + "FROM agronegocio.descricao_produto "
                    + "INNER JOIN agronegocio.tipo_produto "
                    + "ON tipo_produto.id_tipo_produto = descricao_produto.id_tipo_produto "
                    + "WHERE ";
                    
            //Secundária
            String query1 = "";
            
            //Acopladoras
            String queryTipoProduto = "",
            queryDescProduto = "";
    
            queryDescProduto += (descricaoProduto.getDescricaoProduto()!= null ? "descricao_produto LIKE '" + descricaoProduto.getDescricaoProduto() + "%'" : "");
            queryDescProduto += (descricaoProduto.getDescricaoProduto()!= null && descricaoProduto.getTipoProduto() != null ? " OR " : "");
            queryTipoProduto += (descricaoProduto.getTipoProduto() != null ? "descricao_produto.id_tipo_produto LIKE '" + Integer.parseInt(descricaoProduto.getTipoProduto()) + "%'" : "");
            
            //Query Final
            query1 += query
                    + queryDescProduto
                    + queryTipoProduto;
            
            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                DescricaoProduto descP = new DescricaoProduto();
                
                descP.setIdDescricaoProduto(rs.getInt("id_descricao_produto"));
                descP.setDescricaoProduto(rs.getString("descricao_produto"));
                descP.setTipoProduto(rs.getString("id_tipo_produto"));
                descP.setUnidadeProduto(rs.getString("descricao_unidade_produto"));
                descP.setDesabilitarDescricaoProduto(rs.getBoolean("habilitado"));
                
                dP.add(descP);
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return dP;
    } 
    
    public static List<DescricaoProduto> listarTodosDescricaoProduto() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<DescricaoProduto> dP = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT tipo_produto.id_tipo_produto, "
                    + "tipo_produto.descricao_tipo_produto, "
                    + "descricao_produto.descricao_unidade_produto, "
                    + "descricao_produto.id_descricao_produto, "
                    + "descricao_produto.habilitado, "
                    + "descricao_produto.descricao_produto "
                    + "FROM  agronegocio.tipo_produto, agronegocio.descricao_produto "
                    + "WHERE tipo_produto.id_tipo_produto = descricao_produto.id_tipo_produto");
            
            rs = ps.executeQuery();

            while (rs.next()) {

                DescricaoProduto descP = new DescricaoProduto();
                
                descP.setIdDescricaoProduto(rs.getInt("id_descricao_produto"));
                descP.setDescricaoProduto(rs.getString("descricao_produto"));
                descP.setTipoProduto(rs.getString("descricao_tipo_produto"));
                descP.setUnidadeProduto(rs.getString("descricao_unidade_produto"));
                descP.setDesabilitarDescricaoProduto(rs.getBoolean("habilitado"));
                
                dP.add(descP);
                
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return dP;
    }
    
    public static DescricaoProduto getDescricaoProduto(int idDescricaoProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        DescricaoProduto descricaoProduto = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT tipo_produto.id_tipo_produto, "
                    + "tipo_produto.descricao_tipo_produto, "
                    + "descricao_produto.id_descricao_produto, "
                    + "descricao_produto.descricao_produto, "
                    + "descricao_produto.habilitado, "
                    + "descricao_produto.descricao_unidade_produto "
                    + "FROM  agronegocio.tipo_produto, agronegocio.descricao_produto "
                    + "WHERE tipo_produto.id_tipo_produto = descricao_produto.id_tipo_produto "
                    + "AND id_descricao_produto =" + idDescricaoProduto);
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                descricaoProduto = new DescricaoProduto();
                descricaoProduto.setIdDescricaoProduto(rs.getInt("id_descricao_produto"));
                descricaoProduto.setDescricaoProduto(rs.getString("descricao_produto"));
                descricaoProduto.setUnidadeProduto(rs.getString("descricao_unidade_produto"));
                descricaoProduto.setTipoProduto(rs.getString("descricao_tipo_produto"));
                descricaoProduto.setIdTipoProduto(rs.getInt("id_tipo_produto"));
                descricaoProduto.setDesabilitarDescricaoProduto(rs.getBoolean("habilitado"));
            }
    
        }  finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return descricaoProduto;
    }
    
    public static boolean alterarDescricaoProduto(DescricaoProduto dP) throws SQLException, IOException {
          
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        try {
            con = ConnectionFactory.getConnection();
  
            ps = con.prepareStatement("UPDATE agronegocio.descricao_produto "
                    + "SET descricao_produto = ?, "
                    + "descricao_unidade_produto = ?, "
                    + "id_tipo_produto = ? "
                    + "WHERE id_descricao_produto = ?");
            
                 ps.setString(1, dP.getDescricaoProduto());
                 ps.setString(2, dP.getUnidadeProduto());
                 ps.setInt(3, Integer.parseInt(dP.getTipoProduto()));
                 ps.setInt(4, dP.getIdDescricaoProduto());
                 
                 
 
             int i = ps.executeUpdate();
             
             if (i == 1) {
                   return true;
            }
             
        } catch (Exception ex) {
            Logger.getLogger(DescricaoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
    
    public static boolean deletarDescricaoProduto(int idDescricaoProduto) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("Select id_produto FROM agronegocio.produto WHERE id_descricao_produto ="+ idDescricaoProduto);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Essa descrição do produto está sendo usada no Sistema!");
            }
            
            ps = con.prepareStatement("DELETE FROM agronegocio.descricao_produto"
                    + " WHERE id_descricao_produto = ? ");
            
            ps.setInt(1, idDescricaoProduto);
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir a Descrição do Produto. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }
    
    public static boolean desabilitarDescricaoProduto(DescricaoProduto dP) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado "
                    + "FROM agronegocio.descricao_produto "
                    + "WHERE id_descricao_produto=" + dP.getIdDescricaoProduto());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }

            }
            
            ps = con.prepareStatement("UPDATE agronegocio.descricao_produto "
                    + "SET habilitado = ? "
                    + "WHERE id_descricao_produto = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, dP.getIdDescricaoProduto());

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
