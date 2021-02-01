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
import javax.swing.JOptionPane;
import model.Estado;

/**
 *
 * @author resilia
 */
public final class EstadoDAO {

    public static boolean insertEstado(Estado estado) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.estado (descricao_estado, uf_estado) VALUES(?, ?)");
            ps.setString(1, estado.getDescricaoEstado());
            ps.setString(2, estado.getUfEstado());
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
    
    public List<Estado> listar() throws Exception {

        List<Estado> estados = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("select * from estado;");
            rs = ps.executeQuery();

            while (rs.next()) {

                Estado estado = new Estado();
                
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));
                estado.setUfEstado(rs.getString("uf_estado"));
                estado.setDesabilitarEstado(rs.getBoolean("habilitado"));

                estados.add(estado);
            }

        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);

        }
        return estados;
    }
    
    public static List<Estado> listarTodosEstados() throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Estado> sn = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_estado, habilitado, descricao_estado, uf_estado "
                    + "FROM agronegocio.estado "
                    + "ORDER BY descricao_estado");

            rs = ps.executeQuery();
            while (rs.next()) {

                Estado est = new Estado();
                est.setIdEstado(rs.getInt("id_estado"));
                est.setDescricaoEstado(rs.getString("descricao_estado"));
                est.setUfEstado(rs.getString("uf_estado"));
                est.setDesabilitarEstado(rs.getBoolean("habilitado"));

                sn.add(est);
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return sn;

    }



  public static List<Estado> consultarEstado(Estado e) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Estado> sn = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //principal
            String query = "SELECT id_estado, habilitado, descricao_estado, uf_estado "
                    + "FROM agronegocio.estado";
             //"WHERE id_nacionalidade = ?";

            //secundaria
            String query1 = "";

            //aclopadoras
            String queryEstado = "";
            String queryUf = "";

            //condicional
            queryEstado += (e.getDescricaoEstado() != null || e.getUfEstado() != null ? " WHERE ":"");
            
            queryEstado += (e.getDescricaoEstado() != null ? "descricao_estado LIKE '" + e.getDescricaoEstado() + "%'" : "");
            queryEstado += (e.getDescricaoEstado() != null && e.getUfEstado() != null ? "AND ":"");
            queryUf += (e.getUfEstado() != null ? "uf_estado LIKE '" + e.getUfEstado() + "%'" : "");

            
            //query final
            query1 += query
                    + queryEstado
                    + queryUf;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();

            while (rs.next()) {

                Estado est = new Estado();
                est.setIdEstado(rs.getInt("id_estado"));
                est.setUfEstado(rs.getString("uf_estado"));
                est.setDescricaoEstado(rs.getString("descricao_estado"));
                est.setDesabilitarEstado(rs.getBoolean("habilitado"));

                sn.add(est);
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return sn;

    }
  
  public static Estado getEstado(int idEstado) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Estado est = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_estado, habilitado, descricao_estado, uf_estado "
                    + "FROM agronegocio.estado "
                    + "WHERE id_estado=" + idEstado);
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                est = new Estado();
                est.setIdEstado(rs.getInt("id_estado"));
                est.setDescricaoEstado(rs.getString("descricao_estado"));
                est.setUfEstado(rs.getString("uf_estado"));
                est.setDesabilitarEstado(rs.getBoolean("habilitado"));
            }
    
        }  finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return est;
    }
  
  public static boolean deletarEstado(int idEstado) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("SELECT id_estado "
                    + "FROM agronegocio.endereco "
                    + "WHERE id_estado ="+ idEstado);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Esse Estado está sendo usada no Sistema!");
            }
            
            ps = con.prepareStatement("DELETE FROM agronegocio.estado "
                    + "WHERE id_estado=?");
            
            ps.setInt(1, idEstado);
            
            int i = ps.executeUpdate();
            
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
  
  public static boolean alterarEstado(Estado estado) throws SQLException, IOException {
          
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("UPDATE agronegocio.estado "
                    + "SET descricao_estado=?, "
                    + "uf_estado=?  "
                    + "WHERE id_estado= ?");
            
                 ps.setString(1, estado.getDescricaoEstado());
                 ps.setString(2, estado.getUfEstado());
                 ps.setInt(3, estado.getIdEstado());

             int i = ps.executeUpdate();
             
             if (i == 1) {
                   return true;
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
  
    public static boolean desabilitarEstado(Estado e) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT habilitado "
                    + "FROM agronegocio.estado "
                    + "WHERE id_estado=" + e.getIdEstado());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE agronegocio.estado "
                    + "SET habilitado=? "
                    + "WHERE id_estado= ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, e.getIdEstado());
            
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
