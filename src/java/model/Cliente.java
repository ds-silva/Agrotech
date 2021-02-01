/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author josem
 */
public class Cliente extends Usuario{
    
    private Boolean statusValidacao;
    private String vailidadoPor;
    private Date dataValidacao;
    private Blob documentos;
    private String justificativaValidacao;
    
    public Cliente() throws Exception{}
    
    public Cliente(String login, String senha) throws Exception {
        super(login, senha);
    }
    
    public Cliente(String login, String senha, String cpfCnpj) throws Exception {
        super(login, senha, cpfCnpj);
    }
    
    /*public Cliente(String usuario,
    		String senha,
    		String nome,
    		String sobrenome,
    		String email,
    		String rgRne,
    		String orgaoExpedidorRgRne,
    		Date dataEmissaoRgRne,
    		String cpfCnpj,
    		String sexo,
    		Date dataNascimento,
    		Telefone[] telefones,
    		Nacionalidade nacionalidade,
    		String descSituacaoUsuario,
    		Endereco endereco,
    		TipoUsuario tipoUsuario,
    		boolean statusValidacao, 
    		String vailidadoPor, 
    		Date dataValidacao, 
    		Blob documentos, 
    		String justificativaValidacao) throws Exception {
    	super(usuario,
    			senha,
    			nome, 
    			sobrenome, 
    			email, 
    			rgRne, 
    			orgaoExpedidorRgRne, 
    			dataEmissaoRgRne, 
    			cpfCnpj,
    			sexo,
    			dataNascimento,
    			telefones,
    			nacionalidade,
    			descSituacaoUsuario,
    			endereco,
    			tipoUsuario);
    	this.setStatusValidacao(statusValidacao);
    	this.setVailidadoPor(vailidadoPor);
    	this.setDataValidacao(dataValidacao);
    	this.setDocumentos(documentos);
    	this.setJustificativaValidacao(justificativaValidacao);
    }*/

    public boolean getStatusValidacao() {
        return statusValidacao;
    }

    public void setStatusValidacao(Boolean statusValidacao) {
        
    	this.statusValidacao = statusValidacao;
    }

    public String getVailidadoPor() {
        return vailidadoPor;
    }

    public void setVailidadoPor(String vailidadoPor) {
        this.vailidadoPor = vailidadoPor;
    }

    public Date getDataValidacao() {
        return dataValidacao;
    }

    public void setDataValidacao(Date dataValidacao) {
        this.dataValidacao = dataValidacao;
    }

    public Blob getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Blob documentos) {
        /*if(documentos. > 0 )  {
        	this.documentos = documentos;
        }*/
        this.documentos = documentos;
    }

    public String getJustificativaValidacao() {
        return justificativaValidacao;
    }

    public void setJustificativaValidacao(String justificativaValidacao) {
        this.justificativaValidacao = justificativaValidacao;
    }
    
    
    
}
