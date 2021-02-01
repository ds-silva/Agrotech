package dao;

import connection.ConnectionFactory;
import excecoes.CancelarDeletarException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import model.Telefone;

public final class TipoTelefoneDAO {

    public static boolean insertTipoTelefone(Telefone tipoTelefone) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.tipo_telefone (tipo_telefone) VALUES (?)");
            ps.setString(1, tipoTelefone.getTipoTelefone());
            
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
    
    public static List<Telefone> getTipoTelefone(Telefone tipoTelefone) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Telefone> tipoTel = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_tipo_telefone, "
                    + "tipo_telefone, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_telefone "
                    + "WHERE tipo_telefone LIKE '" + tipoTelefone.getTipoTelefone() + "%'");
            
            rs = ps.executeQuery();
 
            while(rs.next()) {
                Telefone tipo = new Telefone();
                tipo.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tipo.setTipoTelefone(rs.getString("tipo_telefone"));
                tipo.setDesabilitarTipoTelefone(rs.getBoolean("habilitado"));
                tipoTel.add(tipo);
            }
    
        }  finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tipoTel;
    }
    
    public static List<Telefone> listarTodosTipoTelefone() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Telefone> tipoTelefone = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT "
                    + "id_tipo_telefone, "
                    + "tipo_telefone, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_telefone ORDER BY id_tipo_telefone");
            
            rs = ps.executeQuery();

            while (rs.next()) {

                Telefone tipo = new Telefone();
                tipo.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tipo.setTipoTelefone(rs.getString("tipo_telefone"));
                tipo.setDesabilitarTipoTelefone(rs.getBoolean("habilitado"));
                tipoTelefone.add(tipo);
                
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return tipoTelefone;
    }

    /* UPDATE 
    
    public static boolean updateTipoTelefone(Telefone tipoTelefone) {
        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement();
            ps.setString(1, tipoTelefone.getTipoTelefone());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
        return false;
    }*/
    
    public static Telefone getTipoTelefone(int idTipoTelefone) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Telefone tipoTel = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_tipo_telefone, "
                    + "tipo_telefone, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_telefone WHERE id_tipo_telefone=" + idTipoTelefone);
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                tipoTel = new Telefone();
                tipoTel.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tipoTel.setTipoTelefone(rs.getString("tipo_telefone"));
                tipoTel.setDesabilitarTipoTelefone(rs.getBoolean("habilitado"));
            }
    
        }  finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return tipoTel;
    }
    
    public static boolean alterarTipoTelefone(Telefone telefone) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();
            
            
            ps = con.prepareStatement("UPDATE  agronegocio.tipo_telefone SET tipo_telefone = ?  WHERE id_tipo_telefone = ?");
            ps.setString(1, telefone.getTipoTelefone());
            ps.setInt(2, telefone.getIdTipoTelefone());
            
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
            
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        
        return false;

    }
    
    public static boolean deletarTipoTelefone(int idTipoTelefone) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String query1 = "SELECT id_tipo_telefone "
                    + " FROM agronegocio.telefone "
                    + " WHERE id_tipo_telefone = " + idTipoTelefone;

            String query2 = "DELETE FROM agronegocio.tipo_telefone WHERE id_tipo_telefone = ?";

            ps = con.prepareStatement(query1);

            rs = ps.executeQuery();

            if (rs.next()) {
                throw new CancelarDeletarException(" Essa Nacionalidade está sendo usada no Sistema!");
            }

            //==== /
            
            ps = con.prepareStatement(query2);
            ps.setInt(1, idTipoTelefone);

            int i = ps.executeUpdate();

            if (i == 1) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Tipo Telefone. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
    public static boolean desabilitarTipoTelefone(Telefone telefone) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT id_tipo_telefone, "
                    + "tipo_telefone, "
                    + "habilitado "
                    + "FROM agronegocio.tipo_telefone WHERE id_tipo_telefone=" + telefone.getIdTipoTelefone());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE  agronegocio.tipo_telefone SET habilitado = ?  "
                    + "WHERE id_tipo_telefone = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, telefone.getIdTipoTelefone());
            
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
