package dao;


import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DescricaoProduto;


public final class DescricaoTipoProdutoDAO {
    
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
}
