
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
import model.Usuario;


public final class SituacaoUsuarioDAO {

    public static boolean insertSituacaoUsuario(Usuario situacaoUsuario) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.situacao_usuario (descricao_situacao_usuario) VALUES (?)");
            ps.setString(1, situacaoUsuario.getDescSituacaoUsuario());
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
    
    public static List<Usuario> selectSituacaoUsuario(Usuario sitUsuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Usuario> u = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_usuario, "
                    + "descricao_situacao_usuario, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_usuario "
                    + "WHERE descricao_situacao_usuario like '" + sitUsuario.getDescSituacaoUsuario() + "%'");
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario SitUsu = new Usuario();

                SitUsu.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));
                SitUsu.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                SitUsu.setDesabilitardescSituacaoUsuario(rs.getBoolean("habilitado"));

                u.add(SitUsu);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return u;
    }
    
     public static List<Usuario> consultarSituacaoUsuario(Usuario u) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Usuario> list = new ArrayList<>();

        try {

            con = ConnectionFactory.getConnection();

            String query = "SELECT id_situacao_usuario, "
                    + "descricao_situacao_usuario, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_usuario";
                    //"WHERE id_tipo_usuario = ?";

            String query1 = "";

            query1 += (u.getDescSituacaoUsuario()!= null ? " WHERE descricao_situacao_usuario  = '" + u.getDescSituacaoUsuario()+ "'" : "");
            query += query1;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario su = new Usuario();

                su.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));
                su.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                su.setDesabilitardescSituacaoUsuario(rs.getBoolean("habilitado"));

                list.add(su);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return list;
    }
     
     public static List<Usuario> listarSituacaoUsuario() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Usuario> Usu = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_usuario, "
                    + "descricao_situacao_usuario, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_usuario "
                    + "ORDER BY id_situacao_usuario;");
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));
                u.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                u.setDesabilitardescSituacaoUsuario(rs.getBoolean("habilitado"));

                Usu.add(u);

            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return Usu;

    }

    public static Usuario selectSituacaoUsuario(int idSitUsuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Usuario u = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_usuario, "
                    + "descricao_situacao_usuario, "
                    + "habilitado "
                    + "FROM agronegocio.situacao_usuario "
                    + "WHERE id_situacao_usuario =" + idSitUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdSituacaoUsuario(rs.getInt("id_situacao_usuario"));
                u.setDescSituacaoUsuario(rs.getString("descricao_situacao_usuario"));
                u.setDesabilitardescSituacaoUsuario(rs.getBoolean("habilitado"));
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return u;
    }
    
    public static boolean alterarSituacaoUsuario(Usuario usuario) throws SQLException, IOException {
          
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("UPDATE agronegocio.situacao_usuario "
                    + "SET descricao_situacao_usuario=? "
                    + "WHERE id_situacao_usuario=?");
            
                 ps.setString(1, usuario.getDescSituacaoUsuario());
                 ps.setInt(2, usuario.getIdSituacaoUsuario());
                 
 
             int i = ps.executeUpdate();
             
             if (i == 1) {
                   return true;
            }
             
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
    
    public static boolean deletarSituacaoUsuario(int idSituacaoUsuario) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("SELECT id_situacao_usuario FROM agronegocio.usuario "
                    + "WHERE id_situacao_usuario =" + idSituacaoUsuario);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Essa Situação Usuário está sendo usada no Sistema!");
            }
            
            ps = con.prepareStatement("DELETE FROM agronegocio.situacao_usuario WHERE id_situacao_usuario = ?");
            
            ps.setInt(1, idSituacaoUsuario);
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir a situação usuario. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return false;
    }
    
    public static boolean desabilitarSitUsuario(Usuario sitUsu) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT id_situacao_usuario, descricao_situacao_usuario,"
                    + "habilitado "
                    + "FROM agronegocio.situacao_usuario "
                    + "WHERE id_situacao_usuario =" + sitUsu.getIdSituacaoUsuario());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE  agronegocio.situacao_usuario "
                    + "SET habilitado = ? "
                    + "WHERE id_situacao_usuario = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, sitUsu.getIdSituacaoUsuario());
            
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
