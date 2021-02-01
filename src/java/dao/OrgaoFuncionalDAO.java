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
import model.Funcionario;
import model.Regional;


public final class OrgaoFuncionalDAO {

    public static boolean insertOrgaoFuncional(Funcionario orgaoFuncional) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO agronegocio.orgao_funcional (descricao_orgao_funcional) VALUES (?)");

            ps.setString(1, orgaoFuncional.getDescricaoOrgaoFuncional());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;
    }

    
    
    public static boolean deletarOrgaoFuncional(int idOrgaoFuncional) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("SELECT id_orgao_funcional FROM agronegocio.usuario WHERE id_orgao_funcional =" + idOrgaoFuncional);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new CancelarDeletarException(" Esse Orgão Funcional está sendo usada no Sistema!");
            }
            
            ps = con.prepareStatement("DELETE FROM agronegocio.orgao_funcional WHERE id_orgao_funcional =?");
            
            ps.setInt(1, idOrgaoFuncional);
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o Orgão Funcional. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }
    
    public static boolean alterarOrgaoFuncinal(Regional orgaof) throws SQLException, IOException {

          Connection con = null;
          PreparedStatement ps = null;
          ResultSet rs = null;


          try {
              con = ConnectionFactory.getConnection();
              ps = con.prepareStatement("UPDATE agronegocio.orgao_funcional SET descricao_orgao_funcional = ? where id_orgao_funcional = ?");
                   ps.setString(1, orgaof.getOrgaoFuncional());
                   ps.setInt(2, orgaof.getIdOrgaoFuncional());


               int i = ps.executeUpdate();

               if (i == 1) {
                     return true;
              }

          } catch (Exception ex) {
              Logger.getLogger(OrgaoFuncionalDAO.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
              ConnectionFactory.closeConnection(con, ps, rs);
          }
          return false;
      }
    
    public static List<Regional> consultarOrgaoFuncional(Regional r) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Regional> orgaoFuncional = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            //Principal
            String query = "SELECT id_orgao_funcional, habilitado, descricao_orgao_funcional FROM agronegocio.orgao_funcional";

            //Reserva
            String query1 = "";

            //Condicional
            query1 += (r.getOrgaoFuncional() != null ? " WHERE descricao_orgao_funcional LIKE '" + r.getOrgaoFuncional() + "%'" : "");
            query += query1;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Regional reg = new Regional();
                reg.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));
                reg.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                reg.setDesabilitarOrgaoFuncional(rs.getBoolean("habilitado"));
                
                orgaoFuncional.add(reg);

            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return orgaoFuncional;
    }
    
    public static Regional consultarOrgaoFuncional(int idOrgaoFuncional) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Regional orgaoF = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_orgao_funcional, habilitado, descricao_orgao_funcional FROM agronegocio.orgao_funcional WHERE id_orgao_funcional =" + idOrgaoFuncional);
            //ps = con.prepareStatement("SELECT id_tipo_telefone, tipo_telefone FROM agronegocio.tipo_telefone WHERE id_tipo_telefone=" + idTipoTelefone);
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                orgaoF = new Regional();
                orgaoF.setIdOrgaoFuncional(rs.getInt("id_orgao_funcional"));
                orgaoF.setOrgaoFuncional(rs.getString("descricao_orgao_funcional"));
                orgaoF.setDesabilitarOrgaoFuncional(rs.getBoolean("habilitado"));
                
            }
    
        }  finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return orgaoF;
    }

public static boolean desabilitarOrgaoFuncional(Regional regional) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean habilitado = false;
        
        try {
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT habilitado FROM agronegocio.orgao_funcional WHERE id_orgao_funcional = ?");
            
            ps.setInt(1, regional.getIdOrgaoFuncional());

            rs = ps.executeQuery();

            if (rs.next()) {
                habilitado = rs.getBoolean("habilitado");

                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
            }

            ps = con.prepareStatement("UPDATE agronegocio.orgao_funcional SET habilitado = ? WHERE id_orgao_funcional  = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, regional.getIdOrgaoFuncional());

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
