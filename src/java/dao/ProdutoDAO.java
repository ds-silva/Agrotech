/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.DescricaoProduto;
import model.Produto;

/**
 *
 * @author David.Silva
 */
public class ProdutoDAO {
    public static boolean insertProduto(DescricaoProduto descricaoProduto, Produto produto) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.produto "
                    + "(ano, "
                    + "quantidade_produzida, "
                    + "mes_safra, "
                    + "id_descricao_produto, "
                    + "id_imovel_rural) "
                    + "VALUES (?, ?, ?, ?, ?)");
            
            ps.setString(1, produto.getAno());
            ps.setDouble(2, produto.getQuantidadeProduzida());
            ps.setString(3, produto.getMesSafra());
            ps.setInt(4, Integer.parseInt(descricaoProduto.getDescricaoProduto()));
            ps.setInt(5, Integer.parseInt(descricaoProduto.getTipoProduto()));
            
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
    
    public static List<Produto> consultarProduto(Produto prod, DescricaoProduto descP) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            
            String query = "SELECT tipo_produto.id_tipo_produto, "
                    + "tipo_produto.descricao_tipo_produto, "
                    + "descricao_produto.id_descricao_produto, "
                    + "descricao_produto.descricao_produto, "
                    + "produto.ano, "
                    + "produto.habilitado, "
                    + "produto.mes_safra, "
                    + "produto.id_produto "
                    + "FROM agronegocio.descricao_produto, "
                    + "agronegocio.produto, "
                    + "agronegocio.tipo_produto "
                    + "WHERE produto.id_descricao_produto = descricao_produto.id_descricao_produto "
                    + "AND tipo_produto.id_tipo_produto = descricao_produto.id_tipo_produto";
            

            String query1 = "";
            
            String queryTipoProduto = "",
                    queryDescProduto = "",
                    queryAno = "",
                    queryMesSafra = "";

            queryTipoProduto += (descP.getTipoProduto()!= null ? " and tipo_produto.id_tipo_produto = '" + Integer.parseInt(descP.getTipoProduto()) + "'" : "");
            queryDescProduto += (descP.getDescricaoProduto()!= null ? " and descricao_produto.id_descricao_produto = '" + Integer.parseInt(descP.getDescricaoProduto()) + "'" : "");
            queryAno += (prod.getAno()!= null ? " and ano = '" + prod.getAno() + "'" : "");
            queryMesSafra += (prod.getMesSafra()!= null ? " and mes_safra = '" + prod.getMesSafra() + "'" : "");
            
            
            query1 += query
                    + queryTipoProduto
                    + queryDescProduto
                    + queryAno
                    + queryMesSafra;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {

                DescricaoProduto dP = new DescricaoProduto();
                Produto p = new Produto();
               
                dP.setDescricaoProduto(rs.getString("descricao_produto"));
                dP.setTipoProduto(rs.getString("descricao_tipo_produto"));
                p.setAno(rs.getString("ano"));
                p.setMesSafra(rs.getString("mes_safra"));
                p.setIdProduto(rs.getInt("id_produto"));
                p.setDesabilitarProduto(rs.getBoolean("habilitado"));
                p.setDescricaoProduto(dP);
                
                produtos.add(p);
                
                
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return produtos;
    }
    public static Produto getProduto(int idProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Produto produtos = new Produto();

        try {
            con = ConnectionFactory.getConnection();

            String query = "SELECT tipo_produto.id_tipo_produto, "
                    + "tipo_produto.descricao_tipo_produto, "
                    + "descricao_produto.id_descricao_produto, "
                    + "descricao_produto.descricao_produto, "
                    + "descricao_produto.descricao_unidade_produto, "
                    + "produto.ano, "
                    + "produto.mes_safra, "
                    + "produto.habilitado, "
                    + "produto.id_produto, "
                    + "produto.quantidade_produzida "
                    + "FROM agronegocio.descricao_produto, "
                    + "agronegocio.produto, "
                    + "agronegocio.tipo_produto "
                    + "WHERE produto.id_descricao_produto = descricao_produto.id_descricao_produto "
                    + "AND tipo_produto.id_tipo_produto = descricao_produto.id_tipo_produto "
                    + "AND produto.id_produto = " + idProduto;

            String query1 = "";

            String queryTipoProduto = "",
                    queryDescProduto = "",
                    queryAno = "",
                    queryMesSafra = "";

            query1 += query
                    + queryTipoProduto
                    + queryDescProduto
                    + queryAno
                    + queryMesSafra;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            if (rs.next()) {

                DescricaoProduto dP = new DescricaoProduto();
                Produto p = new Produto();

                dP.setDescricaoProduto(rs.getString("descricao_produto"));
                dP.setTipoProduto(rs.getString("descricao_tipo_produto"));
                dP.setUnidadeProduto(rs.getString("descricao_unidade_produto"));
                dP.setIdDescricaoProduto(rs.getInt("id_descricao_produto"));
                dP.setIdTipoProduto(rs.getInt("id_tipo_produto"));
                p.setAno(rs.getString("ano"));
                p.setMesSafra(rs.getString("mes_safra"));
                p.setIdProduto(rs.getInt("id_produto"));
                p.setQuantidadeProduzida(rs.getDouble("quantidade_produzida"));
                p.setDesabilitarProduto(rs.getBoolean("habilitado"));
                p.setDescricaoProduto(dP);

                produtos = p;

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return produtos;
    }

    public static boolean alterarProduto(Produto produto) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("UPDATE "
                    + "agronegocio.produto "
                    + "SET ano = ?, "
                    + "quantidade_produzida = ?, "
                    + "mes_safra = ?, "
                    + "id_descricao_produto = ? "
                    + "WHERE id_produto = ?");
            
            ps.setString(1, produto.getAno());
            ps.setDouble(2, produto.getQuantidadeProduzida());
            ps.setString(3, produto.getMesSafra());
            ps.setInt(4, produto.getDescricaoProduto().getIdDescricaoProduto());
            ps.setInt(5, produto.getIdProduto());

            int i = ps.executeUpdate();

            if (i == 1) {
                con.commit();
                return true;
            }

        } catch (Exception ex) {
            con.rollback();
            throw new CancelarAlterarException("Erro ao alterar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;

    }
    
    public static boolean deleteProduto(int idProduto) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("DELETE FROM agronegocio.produto "
                    + "WHERE id_produto=?");
            
            ps.setInt(1, idProduto);
            int i = ps.executeUpdate();
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("não foi Possível Deletar Produto. " + e.getMessage());
            
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }
    
    public static boolean desabilitarProduto(Produto p) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT habilitado "
                    + "FROM agronegocio.produto "
                    + "WHERE produto.id_produto ="  + p.getIdProduto());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE agronegocio.produto "
                    + "SET habilitado=? "
                    + "WHERE id_produto=?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, p.getIdProduto());
            
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
