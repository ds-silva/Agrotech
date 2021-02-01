/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacoes;

/**
 *
 * @author lluan
 */
public class ValidadorCamposSenhaPerfil {

    public static boolean validaCamposConteudo(String senhaAtual, String senhaNova) throws Exception {

        if (!"".equals(senhaAtual) && senhaNova.trim().isEmpty()) {
            throw new Exception("O campo nova senha não pode ficar vazia se o campo de senha atual tem algo!");
        }

        if (!"".equals(senhaNova) && senhaAtual.trim().isEmpty()) {
            throw new Exception("O campo senha atual não pode ficar vazia se o campo de nova senha tem algo!");
        }

        return !"".equals(senhaAtual) && !"".equals(senhaNova);

    }

}
