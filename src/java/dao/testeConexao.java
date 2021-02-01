/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.Telefone;

/**
 *
 * @author josem
 */
public class testeConexao {
    public static void main(String[] args) {
        try {
            Telefone tel = new Telefone();
            tel.setTipoTelefone("Celular");
            for (Telefone t : TipoTelefoneDAO.getTipoTelefone(tel)) {
                System.out.println(t.getTipoTelefone());

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
