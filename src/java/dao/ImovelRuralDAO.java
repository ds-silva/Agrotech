/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Endereco;
import connection.ConnectionFactory;
import excecoes.CancelarDeletarException;
import excecoes.CancelarRegistroException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estado;
import model.ImovelRural;

/**
 *
 * @author David.Silva
 */
public class ImovelRuralDAO {

    public static boolean inserirImovelRural(ImovelRural ir) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idEndereco = -1;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            ps = con.prepareStatement("INSERT INTO agronegocio.endereco "
                    + " (cep, tipo_logradouro, logradouro, numero, "
                    + " complemento, bairro, cidade, id_estado) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, ir.getEndereco().getCep());
            ps.setString(2, ir.getEndereco().getTipoLogradouro());
            ps.setString(3, ir.getEndereco().getLogradouro());
            ps.setString(4, ir.getEndereco().getNumero());
            ps.setString(5, ir.getEndereco().getComplemento());
            ps.setString(6, ir.getEndereco().getBairro());
            ps.setString(7, ir.getEndereco().getCidade());
            ps.setInt(8, Integer.parseInt(ir.getEndereco().getEstado().getDescricaoEstado()));

            int x = ps.executeUpdate();

            if (x == 1) {

                rs = ps.getGeneratedKeys();

                if (rs.next()) {

                    idEndereco = rs.getInt("id_endereco");

                }

            }

            // === Verifica se endereço tem ID === 
            if (idEndereco == 0 || idEndereco == -1) {
                throw new CancelarRegistroException(" ID de endereço não localizado.");
            }

            ps = con.prepareStatement("INSERT INTO agronegocio.imovel_rural "
                    + " (n_inscricao_estadual, nirf, id_situacao_imovel, "
                    + " tipo_propriedade, tipo_ocupacao, mercado_atuacao, "
                    + " area_georeferenciada, area_reserva_ambiental, area_utilizacao_agricultura, "
                    + " area_utilizacao_pecuaria, latitude, longitude,  status_validacao, id_endereco) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, ir.getnInscricaoEstadual());
            ps.setString(2, ir.getNirf());
            ps.setInt(3, ir.getIdSituacaoImovelRural());
            ps.setString(4, ir.getTipoPropriedade());
            ps.setString(5, ir.getTipoOcupacao());
            ps.setString(6, ir.getMercadoAtuacao());
            ps.setDouble(7, ir.getAreaGeoreferenciada());
            ps.setDouble(8, ir.getAreaReservaAmbiental());
            ps.setDouble(9, ir.getAreaUtilizacaoAgricultura());
            ps.setDouble(10, ir.getAreaUtilizacaoPecuaria());
            ps.setString(11, ir.getLatitude());
            ps.setString(12, ir.getLongitude());
            ps.setBoolean(13, false);
            ps.setInt(14, idEndereco);
            

            int y = ps.executeUpdate();

            if (y == 1) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarRegistroException("Erro ao cadastrar imovel rural: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
    
    public static List<ImovelRural> consultarImovelRural(ImovelRural imovelRu, Endereco end, Estado estad ) throws SQLException, IOException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<ImovelRural> imovelRural = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            
            String query = "SELECT endereco.cidade, "
                    + "estado.id_estado, "
                    + "estado.descricao_estado, "
                    + "imovel_rural.id_imovel_rural, "
                    + "imovel_rural.n_inscricao_estadual, "
                    + "imovel_rural.nirf, "
                    + "imovel_rural.id_situacao_imovel, "
                    + "imovel_rural.longitude, "
                    + "imovel_rural.latitude, "
                    + "imovel_rural.tipo_propriedade, "
                    + "imovel_rural.tipo_ocupacao, "
                    + "imovel_rural.mercado_atuacao, "
                    + "area_georeferenciada, "
                    + "area_reserva_ambiental, "
                    + "area_utilizacao_agricultura,"
                    + "area_utilizacao_pecuaria "
                    + "FROM agronegocio.endereco, agronegocio.estado, agronegocio.imovel_rural " 
                    + "WHERE endereco.id_estado = estado.id_estado AND imovel_rural.id_endereco = endereco.id_endereco";
  
            String query1 = "";
            
            String queryInscricaoEstd = "",
                    queryNirf = "",
                    querySituacaoImovel = "",
                    queryTipoPropriedade = "",
                    queryTipoOcupacao = "",
                    queryMercadoAtuacao = "",
                    queryArea_georeferenciada = "",
                    queryArea_reserva_ambiental = "",
                    queryArea_utilizacao_agricultura = "",
                    queryArea_utilizacao_pecuaria = "",
                    queryCidade = "",
                    queryEstado = "",
                    queryLongitude = "",
                    queryLatitude = "";
            
            
            queryInscricaoEstd += (imovelRu.getnInscricaoEstadual()!= null ? " AND n_inscricao_estadual = '" + imovelRu.getnInscricaoEstadual() + "'" : "");
      
            queryNirf += (imovelRu.getNirf()!= null ? " AND nirf = '" + imovelRu.getNirf() + "'" : "");

            querySituacaoImovel += (imovelRu.getSituacaoImovel()!= null ? " AND id_situacao_imovel = '" + Integer.parseInt(imovelRu.getSituacaoImovel()) + "'" : ""); 
              
            queryTipoPropriedade += (imovelRu.getTipoPropriedade() != null ? " AND tipo_propriedade = '" + imovelRu.getTipoPropriedade() + "'" : "");
           
            queryTipoOcupacao += (imovelRu.getTipoOcupacao()!= null ? " AND tipo_ocupacao = '" + imovelRu.getTipoOcupacao() + "'" : "");
           
            queryMercadoAtuacao += (imovelRu.getMercadoAtuacao()!= null ? " AND mercado_atuacao = '" + imovelRu.getMercadoAtuacao()+ "'" : "");
            
            queryArea_georeferenciada += (imovelRu.getAreaGeoreferenciada() != null ? " AND area_georeferenciada = '" + imovelRu.getAreaGeoreferenciada() + "'" : "" );
          
            queryArea_reserva_ambiental += (imovelRu.getAreaReservaAmbiental()!= null ? " AND area_reserva_ambiental = '" + imovelRu.getAreaReservaAmbiental() + "'" : "" );
                 
            queryArea_utilizacao_agricultura += (imovelRu.getAreaUtilizacaoAgricultura()!= null ? " AND area_utilizacao_agricultura = '" + imovelRu.getAreaUtilizacaoAgricultura() + "'" : "" );
                
            queryArea_utilizacao_pecuaria += (imovelRu.getAreaUtilizacaoPecuaria()!= null ? " AND area_utilizacao_pecuaria = '" + imovelRu.getAreaUtilizacaoPecuaria() + "'" : "" );
            
            queryCidade += (end.getCidade()!= null ? " AND cidade = '" + end.getCidade()+ "'" : "");
           
            queryEstado += (estad.getDescricaoEstado()!= null ? " AND estado.id_estado = '" + Integer.parseInt(estad.getDescricaoEstado())+ "'" : "");
           
            queryLongitude += (imovelRu.getLongitude() != null ? " AND imovel_rural.longitude = '" + imovelRu.getLongitude() + "'" : "" );
           
            queryLatitude += (imovelRu.getLatitude() != null ? " AND imovel_rural.latitude = '" + imovelRu.getLatitude() + "'" : "" );
            
            
            query1 += query
                    + queryInscricaoEstd
                    + queryNirf
                    + querySituacaoImovel
                    + queryTipoPropriedade
                    + queryTipoOcupacao
                    + queryMercadoAtuacao
                    + queryArea_georeferenciada
                    + queryArea_reserva_ambiental
                    + queryArea_utilizacao_agricultura
                    + queryArea_utilizacao_pecuaria
                    + queryCidade
                    + queryEstado
                    + queryLongitude
                    + queryLatitude;

            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();
            
            while (rs.next()) {

                ImovelRural iR = new ImovelRural();
                Endereco endere = new Endereco();
                Estado estado = new Estado();
                
                iR.setIdImovelRural(rs.getInt("id_imovel_rural"));
                iR.setnInscricaoEstadual(rs.getString("n_inscricao_estadual"));
                iR.setNirf(rs.getString("nirf"));
                iR.setSituacaoImovel(rs.getString("id_situacao_imovel"));
                iR.setTipoPropriedade(rs.getString("tipo_propriedade"));
                iR.setTipoOcupacao(rs.getString("tipo_ocupacao"));
                iR.setMercadoAtuacao(rs.getString("mercado_atuacao"));
                
                iR.setAreaGeoreferenciada(rs.getDouble("area_georeferenciada"));
                iR.setAreaReservaAmbiental(rs.getDouble("area_reserva_ambiental"));
                iR.setAreaUtilizacaoAgricultura(rs.getDouble("area_utilizacao_agricultura"));
                iR.setAreaUtilizacaoPecuaria(rs.getDouble("area_utilizacao_pecuaria"));
                iR.setLongitude(rs.getString("longitude"));
                iR.setLatitude(rs.getString("latitude"));
                    
                endere.setCidade(rs.getString("cidade"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));
                
                endere.setEstado(estado);
                iR.setEndereco(endere);
                
                imovelRural.add(iR);
            }
        } catch (Exception ex) {
            Logger.getLogger(ImovelRuralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return imovelRural;
    }
    
    public static List<ImovelRural> consultarTodosImovelRural( ) throws SQLException, IOException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<ImovelRural> imovelRural = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            
            String query = "SELECT endereco.cidade, "
                    + "estado.id_estado, "
                    + "endereco.id_endereco, "
                    + "estado.descricao_estado, "
                    + "imovel_rural.id_imovel_rural, "
                    + "imovel_rural.n_inscricao_estadual, "
                    + "imovel_rural.nirf, " 
                    + "imovel_rural.id_situacao_imovel, "
                    + "situacao_imovel.descricao_situacao, "
                    + "imovel_rural.longitude, "
                    + "imovel_rural.latitude, "
                    + "imovel_rural.tipo_propriedade, "
                    + "imovel_rural.tipo_ocupacao, "
                    + "imovel_rural.mercado_atuacao, "
                    + "area_georeferenciada, "
                    + "area_reserva_ambiental, "
                    + "area_utilizacao_agricultura,"
                    + "area_utilizacao_pecuaria "
                    + "FROM agronegocio.endereco, agronegocio.estado, agronegocio.imovel_rural, agronegocio.situacao_imovel " 
                    + "WHERE endereco.id_estado = estado.id_estado AND imovel_rural.id_endereco = endereco.id_endereco "
                    + "AND situacao_imovel.id_situacao_imovel = imovel_rural.id_situacao_imovel ";
            
   
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {

                ImovelRural iR = new ImovelRural();
                Endereco endere = new Endereco();
                Estado estado = new Estado();
                
                iR.setIdImovelRural(rs.getInt("id_imovel_rural"));
                iR.setnInscricaoEstadual(rs.getString("n_inscricao_estadual"));
                iR.setNirf(rs.getString("nirf"));
                iR.setSituacaoImovel(rs.getString("id_situacao_imovel"));
                iR.setTipoPropriedade(rs.getString("tipo_propriedade"));
                iR.setTipoOcupacao(rs.getString("tipo_ocupacao"));
                iR.setMercadoAtuacao(rs.getString("mercado_atuacao"));
                
                iR.setAreaGeoreferenciada(rs.getDouble("area_georeferenciada"));
                iR.setAreaReservaAmbiental(rs.getDouble("area_reserva_ambiental"));
                iR.setAreaUtilizacaoAgricultura(rs.getDouble("area_utilizacao_agricultura"));
                iR.setAreaUtilizacaoPecuaria(rs.getDouble("area_utilizacao_pecuaria"));
                iR.setLongitude(rs.getString("longitude"));
                iR.setLatitude(rs.getString("latitude"));
                iR.setSituacaoImovel(rs.getString("descricao_situacao"));
                    
                endere.setCidade(rs.getString("cidade"));
                endere.setIdEndereco(rs.getInt("id_endereco"));
                
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));
                

                endere.setEstado(estado);
                iR.setEndereco(endere);
                
                imovelRural.add(iR);
            }
        } catch (Exception ex) {
            Logger.getLogger(ImovelRuralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return imovelRural;
    }
    
    public static ImovelRural consultarImovelRural(int idImovelRural) throws SQLException, IOException {
        
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ImovelRural iR = null;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT ed.cidade, " +
                                        "ed.id_endereco, " +
                                        "ed.cep, " +
                                        "ed.tipo_logradouro, " +
                                        "ed.logradouro, " +
                                        "ed.numero, " +
                                        "ed.bairro, " +
                                        "ed.complemento, " +
                                        "est.id_estado, " +
                                        "est.descricao_estado, " +
                                        "sitIm.descricao_situacao, " +
                                        "ir.id_imovel_rural, " +
                                        "ir.habilitado, " +
                                        "ir.n_inscricao_estadual, " +
                                        "ir.nirf, " +
                                        "ir.id_situacao_imovel, " +
                                        "ir.tipo_propriedade, " +
                                        "ir.tipo_ocupacao, " +
                                        "ir.mercado_atuacao, " +
                                        "ir.area_georeferenciada, " +
                                        "ir.area_reserva_ambiental, " +
                                        "ir.area_utilizacao_agricultura, " +
                                        "ir.area_utilizacao_pecuaria, " +
                                        "ir.latitude, " +
                                        "ir.longitude " +
                                        "FROM agronegocio.imovel_rural as ir " +
                                        "LEFT JOIN agronegocio.endereco as ed on ir.id_endereco = ed.id_endereco " +
                                        "LEFT JOIN agronegocio.estado as est on ed.id_estado = est.id_estado " +
                                        "LEFT JOIN agronegocio.situacao_imovel as sitIM on ir.id_situacao_imovel = sitIM.id_situacao_imovel " +
                                        "WHERE ir.id_imovel_rural = " + idImovelRural);
            
            rs = ps.executeQuery();

            while (rs.next()) {

                iR = new ImovelRural();              
                Endereco endere = new Endereco();
                Estado estado = new Estado();
                
                iR.setIdImovelRural(rs.getInt("id_imovel_rural"));
                iR.setnInscricaoEstadual(rs.getString("n_inscricao_estadual"));
                iR.setNirf(rs.getString("nirf"));
                iR.setSituacaoImovel(rs.getString("descricao_situacao"));
                iR.setIdSituacaoImovelRural(rs.getInt("id_situacao_imovel"));
                iR.setDesabilitarImovelRural(rs.getBoolean("habilitado"));
                iR.setTipoPropriedade(rs.getString("tipo_propriedade"));
                iR.setTipoOcupacao(rs.getString("tipo_ocupacao"));
                iR.setMercadoAtuacao(rs.getString("mercado_atuacao"));        
                iR.setAreaGeoreferenciada(rs.getDouble("area_georeferenciada"));
                iR.setAreaReservaAmbiental(rs.getDouble("area_reserva_ambiental"));
                iR.setAreaUtilizacaoAgricultura(rs.getDouble("area_utilizacao_agricultura"));
                iR.setAreaUtilizacaoPecuaria(rs.getDouble("area_utilizacao_pecuaria"));
                iR.setLongitude(rs.getString("longitude"));
                iR.setLatitude(rs.getString("latitude"));
                    
                endere.setIdEndereco(rs.getInt("id_endereco"));
                endere.setCidade(rs.getString("cidade"));
                endere.setCep(rs.getString("cep"));
                endere.setLogradouro(rs.getString("logradouro"));
                endere.setTipoLogradouro(rs.getString("tipo_logradouro"));
                endere.setBairro(rs.getString("bairro"));
                endere.setNumero(rs.getString("numero"));
                endere.setComplemento(rs.getString("complemento"));
                
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setDescricaoEstado(rs.getString("descricao_estado"));
                
                endere.setEstado(estado);
                iR.setEndereco(endere);
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ImovelRuralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return iR;
    }
    
     public static boolean alterarImovelRural(ImovelRural ir) throws SQLException {
          
        Connection con = null;
        PreparedStatement ps  = null;
        ResultSet rs = null;
        

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            ps = con.prepareStatement("UPDATE agronegocio.imovel_rural "
                    + "SET n_inscricao_estadual=?, nirf=?, "
                    + "id_situacao_imovel=?, tipo_propriedade=?, tipo_ocupacao=?, "
                    + "mercado_atuacao=?, area_georeferenciada=?, area_reserva_ambiental=?, "
                    + "area_utilizacao_agricultura=?, area_utilizacao_pecuaria=?, "
                    + "latitude=?, longitude=? "
                    +"WHERE id_imovel_rural=? ");
            
                 ps.setString(1, ir.getnInscricaoEstadual());
                 ps.setString(2, ir.getNirf());
                 ps.setInt(3, Integer.parseInt(ir.getSituacaoImovel()));
                 ps.setString(4, ir.getTipoPropriedade());
                 ps.setString(5, ir.getTipoOcupacao());
                 ps.setString(6, ir.getMercadoAtuacao());
                 ps.setDouble(7, ir.getAreaGeoreferenciada());
                ps.setDouble(8, ir.getAreaReservaAmbiental());
                ps.setDouble(9, ir.getAreaUtilizacaoAgricultura());
                ps.setDouble(10, ir.getAreaUtilizacaoPecuaria());
                 ps.setString(11, ir.getLatitude());
                 ps.setString(12, ir.getLongitude());
//                 ps.setInt(13, ir.getEndereco().getIdEndereco());
                 ps.setInt(13, ir.getIdImovelRural());
                 
                 int i = ps.executeUpdate();
                 
                 if(i != 1){
                     throw new SQLException("Não foi possivel realizar o update do Imovel Rural");
                 }
                 
                         ps = con.prepareStatement("UPDATE agronegocio.endereco "
                         + "SET tipo_logradouro=?, logradouro=?, "
                         + "numero=?, complemento=?, bairro=?, cidade=?, "
                         + "cep=?, id_estado=? " 
                         +"WHERE id_endereco= " + ir.getEndereco().getIdEndereco());
                 
                 ps.setString(1, ir.getEndereco().getTipoLogradouro());
                 ps.setString(2, ir.getEndereco().getLogradouro());
                 ps.setString(3, ir.getEndereco().getNumero());
                 ps.setString(4, ir.getEndereco().getComplemento());
                 ps.setString(5, ir.getEndereco().getBairro());
                 ps.setString(6, ir.getEndereco().getCidade());
                 ps.setString(7, ir.getEndereco().getCep());
                 ps.setInt(8, ir.getEndereco().getEstado().getIdEstado());
      

             i = ps.executeUpdate();
             
             if (i == 1) {
                   con.commit();
                   return true;
            }
             
           } catch (Exception ex) {
            con.rollback();
            Logger.getLogger(ImovelRuralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return false;
    }

    public List<ImovelRural> listarSituacaoImovel() throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ImovelRural> list = new ArrayList<>();

        try {

            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT id_situacao_imovel, descricao_situacao \n"
                    + "FROM agronegocio.situacao_imovel\n"
                    + "WHERE  id_situacao_imovel = ?\n"
                    + "ORDER BY  descricao_situacao");

            rs = ps.executeQuery();

            while (rs.next()) {

                ImovelRural sitImovel = new ImovelRural();

                sitImovel.setSituacaoImovel(rs.getString("descricao_situacao"));

                list.add(sitImovel);
            }

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return list;
    }
	
	public static boolean deletarImovelRural(int idImovelRural) throws SQLException, CancelarDeletarException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idEndereco = -1;
        
        try {
           con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            

            ps = con.prepareStatement("SELECT id_usuario_imovel FROM agronegocio.usuario_imovel WHERE id_imovel_rural = ?");
            ps.setInt(1, idImovelRural);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                throw new CancelarDeletarException("O Imovel Rural está relacionado a um Usuário.");
            }
            // pegar endereço
             ps = con.prepareStatement("SELECT id_endereco FROM agronegocio.imovel_rural WHERE id_imovel_rural = ?");
             ps.setInt(1, idImovelRural);
             rs = ps.executeQuery();
             if (rs.next()){
                 idEndereco = rs.getInt("id_endereco");
                 
             }
             //deletar proprietario
             ps = con.prepareStatement("DELETE FROM agronegocio.imovel_rural WHERE id_imovel_rural = ?");
             
             ps.setInt(1, idImovelRural);
             
             int i = ps.executeUpdate();
             
             if (i != 1){
                 throw new CancelarDeletarException("Nao foi possivel deletar usuario");
             }
              //deletar endereço do proprietario
             ps = con.prepareStatement("DELETE FROM agronegocio.endereco WHERE id_endereco = ?");
             
             ps.setInt(1, idEndereco);
             
             int x = ps.executeUpdate();
             
             if (x != 1){
                 throw new CancelarDeletarException("Nao foi possivel deletar endereco");
             }
             con.commit();
             return true;
             
        } catch (Exception e) {
            con.rollback();
            throw new CancelarDeletarException("Não foi possivel excluir o imovel. " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
        public static boolean desabilitarImovelRural(ImovelRural ir) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean habilitado = false;

        try {
            con = ConnectionFactory.getConnection();
            
            ps = con.prepareStatement("SELECT id_imovel_rural, "      
                    + "habilitado "
                    + "FROM agronegocio.imovel_rural WHERE id_imovel_rural=" + ir.getIdImovelRural());
            
            rs = ps.executeQuery();
 
            if(rs.next()) {
                habilitado = rs.getBoolean("habilitado");
                
                if (habilitado == true) {
                    habilitado = false;
                } else {
                    habilitado = true;
                }
                
            }
            
            ps = con.prepareStatement("UPDATE  agronegocio.imovel_rural SET habilitado = ?  "
                    + "WHERE id_imovel_rural = ?");
            ps.setBoolean(1, habilitado);
            ps.setInt(2, ir.getIdImovelRural());
            
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
