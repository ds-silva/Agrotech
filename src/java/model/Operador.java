/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author josem
 */
public class Operador extends Funcionario {

    public Operador() throws Exception {

    }

    public Operador(String login, String senha, String cpfCnpj) throws Exception {
        super(login, senha, cpfCnpj);
    }

}
