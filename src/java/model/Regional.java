/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author josem
 */
public class Regional {

    private String descricaoRegional;
    private String telefoneRegional;
    private Endereco endereco;
    private String orgaoFuncional;
    private int idRegional;
    private int idOrgaoFuncional;
    private boolean desabilitarOrgaoFuncional;
    private boolean desabilitarRegional;

    public Regional() {
    }

    /*public Regional(String descricaoRegional, 
            String telefoneRegional, 
            Endereco endereco, 
            String orgaoFuncional) {
        this.setDescricaoRegional(descricaoRegional);
        this.setTelefone(telefoneRegional);
        this.setEndereco(endereco);
        this.setOrgaoFuncional(orgaoFuncional);
    }*/
    public Regional(String descricao_regional,
            String telefone_regional,
            String orgao_funcional) throws Exception {
        this.setDescricaoRegional(descricao_regional);
        this.setTelefone(telefone_regional);
        this.setOrgaoFuncional(orgao_funcional);
    }

    public String getDescricaoRegional() {
        return descricaoRegional;
    }

    public void setDescricaoRegional(String descricaoRegional)
            throws Exception {
        if (descricaoRegional.length() <= 0) {
            throw new Exception("o campo Regional está vázio!");

        } else {
            this.descricaoRegional = descricaoRegional;
        }
        
        //this.descricaoRegional = descricaoRegional;
    }

    public String getTelefoneRegional() {
        return telefoneRegional;
    }

    public void setTelefone(String telefoneRegional) throws Exception {

        /*if (telefoneRegional.length() == 14 || telefoneRegional.length() == 13) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(telefoneRegional);
            if (matcher.matches()) {
                this.telefoneRegional = telefoneRegional;
                
            }

        } else {
            throw new Exception("o campo não pode conter Caracteres especiais");

        }*/
        
        /*if (telefoneRegional.trim().isEmpty()) {
            throw new Exception("O campo Telefone está vazio");
        } else
            this.telefoneRegional = telefoneRegional;*/
        
        if ((telefoneRegional.length()<0 && telefoneRegional.length()>=12) || telefoneRegional == null){
            throw new Exception ("O Número de telefone não foi preenchido corretamente ou está vazio.");
        }else if (telefoneRegional.matches("[A-Za-z]"))
            throw new Exception ("O número de telefone não deve conter letras.");
        if (telefoneRegional.matches("\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\s?\\d{4,5}")) {
            this.telefoneRegional = telefoneRegional;        
        }else
            throw new Exception ("Número de telefone inválido.");
    
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) throws Exception {
        if (endereco == null) {
            throw new Exception("o campo está vázio!");
        } else {
            this.endereco = endereco;
        }
    }

    public String getOrgaoFuncional() {
        return orgaoFuncional;
    }

    public void setOrgaoFuncional(String orgaoFuncional) throws Exception {
        if (orgaoFuncional.length() <= 0) {
            throw new Exception("o campo Orgão Funcional está vázio!");
        } else {
            this.orgaoFuncional = orgaoFuncional;
        }
    }

    public int getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(int idRegional) {
        this.idRegional = idRegional;
    }

    public int getIdOrgaoFuncional() {
        return idOrgaoFuncional;
    }

    public void setIdOrgaoFuncional(int idOrgaoFuncional) {
        this.idOrgaoFuncional = idOrgaoFuncional;
    }

    public boolean getDesabilitarOrgaoFuncional() {
        return desabilitarOrgaoFuncional;
    }

    public void setDesabilitarOrgaoFuncional(boolean desabilitarOrgaoFuncional) {
        this.desabilitarOrgaoFuncional = desabilitarOrgaoFuncional;
    }

    public boolean getDesabilitarRegional() {
        return desabilitarRegional;
    }

    public void setDesabilitarRegional(boolean desabilitarRegional) {
        this.desabilitarRegional = desabilitarRegional;
    }
    
    

}
