/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import excecoes.CancelarAlterarException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import model.Produtor;

/**
 *
 * @author resilia
 */
public class ProdutorDAO {

    public static boolean alterarProdutor(Produtor produtor) throws SQLException, Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int psU = 0, psE = 0;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);

            String queryEndereco = "UPDATE agronegocio.endereco "
                    + "SET tipo_logradouro=?, "
                    + "logradouro=?, "
                    + "numero=?, "
                    + "complemento=?, "
                    + "bairro=?, "
                    + "cidade=?, "
                    + "cep=?, "
                    + "id_estado=? "
                    + "WHERE id_endereco=?";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, produtor.getEndereco().getTipoLogradouro());
            ps.setString(2, produtor.getEndereco().getLogradouro());
            ps.setString(3, produtor.getEndereco().getNumero());
            ps.setString(4, produtor.getEndereco().getComplemento());
            ps.setString(5, produtor.getEndereco().getBairro());
            ps.setString(6, produtor.getEndereco().getCidade());
            ps.setString(7, produtor.getEndereco().getCep());
            ps.setInt(8, produtor.getEndereco().getEstado().getIdEstado());
            ps.setInt(9, produtor.getEndereco().getIdEndereco());

            psE = ps.executeUpdate();

            if (psE != 1) {
                throw new CancelarAlterarException(" Não foi possivel atualizar o endereço!");
            }

            String queryProd = "UPDATE agronegocio.usuario "
                    + "SET nome=?, "
                    + "sobrenome=?, "
                    + "email=?, "
                    + "rg_rne=?, "
                    + "orgao_expedidor_rg_rne=?, "
                    + "data_emissao_rg_rne=?, "
                    + "cpf_cnpj=?, "
                    + "sexo=?, "
                    + "data_nascimento=?, "
                    + "id_tipo_usuario= 5, "
                    + "id_nacionalidade=? "
                    + "WHERE id_usuario=?";

            ps = con.prepareStatement(queryProd);
            ps.setString(1, produtor.getNome());
            ps.setString(2, produtor.getSobrenome());
            ps.setString(3, produtor.getEmail());
            ps.setString(4, produtor.getRgRne());
            ps.setString(5, produtor.getOrgaoExpedidorRgRne());
            java.sql.Date sDate = new Date(produtor.getDataEmissaoRgRne().getTime());
            ps.setDate(6, sDate);
            ps.setString(7, produtor.getCpfCnpj());
            ps.setString(8, produtor.getSexo());
            java.sql.Date pDate = new Date(produtor.getDataNascimento().getTime());
            ps.setDate(9, pDate);
            //ps.setInt(10, produtor.getEndereco().getIdEndereco());
            ps.setInt(10, produtor.getNacionalidade().getIdNacionalidade());
            //ps.setInt(12, produtor.getIdSituacaoUsuario());
            ps.setInt(11, produtor.getIdUsuario());

            psU = ps.executeUpdate();

            if (psU == 1) {
                con.commit();
                return true;
            }

        } catch (Exception e) {
            con.rollback();
            throw new CancelarAlterarException("Não foi possível atualizar o produtor. " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return false;
    }
}
