/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Telefone;
import model.Usuario;

/**
 *
 * @author josem
 */
public class TelefoneDAO {
    
    public static List<Telefone> consultarTelefonesFuncionarios(int idUsuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Telefone> telefones = new ArrayList<>();
        
        try {
            con = ConnectionFactory.getConnection();
            
            String query = "SELECT id_usuario_telefone, numero_telefone, telefone.id_usuario, tipo_telefone.id_tipo_telefone, "
                    + "tipo_telefone.tipo_telefone, telefone.habilitado "
                    + "FROM agronegocio.telefone "
                    + "INNER JOIN agronegocio.tipo_telefone "
                    + "ON telefone.id_tipo_telefone = tipo_telefone.id_tipo_telefone "
                    + "INNER JOIN agronegocio.usuario "
                    + "ON usuario.id_usuario = telefone.id_usuario "
                    + "WHERE telefone.id_usuario = ?";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Telefone tel = new Telefone();
                
                tel.setIdTipoTelefone(rs.getInt("id_tipo_telefone"));
                tel.setTipoTelefone(rs.getString("tipo_telefone"));
                tel.setIdTelefone(rs.getInt("id_usuario_telefone"));
                tel.setNumeroTelefone(rs.getString("numero_telefone"));
                
                telefones.add(tel);
            }
        }finally{ 
            ConnectionFactory.closeConnection(con, ps, rs);
        }
    
        return telefones;
    }
    
    public static boolean cadastrarTelefone(Telefone tel, Usuario u) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            
            String query = "INSERT INTO agronegocio.telefone (numero_telefone, id_usuario, id_tipo_telefone) "
                    + "VALUES (?, ?, ?)";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, tel.getNumeroTelefone());
            ps.setInt(2, u.getIdUsuario());
            ps.setInt(3, tel.getIdTipoTelefone());
            
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
