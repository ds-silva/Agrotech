package model;

public class Telefone {
	
    private String tipoTelefone;
    private String numeroTelefone;
    private int idTipoTelefone;
    private int idTelefone;
    private boolean desabilitarTipoTelefone;
    
    public Telefone(){}
    
    public Telefone(String tipoTelefone) throws Exception {
        this.setTipoTelefone(tipoTelefone);
    }
    
    public Telefone(
            String tipoTelefone, 
            String numeroTelefone) throws Exception {
        this.setTipoTelefone(tipoTelefone);
        this.setNumeroTelefone(numeroTelefone);
    }
    
    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) throws Exception {
        /*if (tipoTelefone.equals(null) || tipoTelefone.equals("null") || tipoTelefone.contains(null) || tipoTelefone.contains(null)) {
            throw new Exception("o campo tipo telefone está vázio!");
        } else {
            this.tipoTelefone = tipoTelefone;
        }*/
        if (tipoTelefone.length() <= 0 || tipoTelefone.equals("") || tipoTelefone.trim().isEmpty() || tipoTelefone == null) {
            throw new Exception("O campo tipo telefone está vazio!");
        } else {
            this.tipoTelefone = tipoTelefone;
        }
        //this.tipoTelefone = tipoTelefone;
    }
    
    public String getNumeroTelefone() {
	return numeroTelefone;
    }

    //public void setNumeroTelefone(String numeroTelefone) throws Exception {
	/*if (numeroTelefone.length() > 0) {
            this.numeroTelefone = numeroTelefone;
        } else {
            throw new Exception("o campo telefone está vázio!");
        }*/
        //this.numeroTelefone = numeroTelefone;
        
    public void setNumeroTelefone(String numeroTelefone) throws Exception {
	/*if ((numeroTelefone.length()<0 && numeroTelefone.length()>=8) || numeroTelefone == null){
            throw new Exception ("O Número de telefone não foi preenchido corretamente ou está vazio.");
        }else if (numeroTelefone.matches("[A-Za-z]"))
            throw new Exception ("O número de telefone não deve conter letras.");
        if (numeroTelefone.matches("\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\s?\\d{4,5}")) {
            this.numeroTelefone = numeroTelefone;        
        }else
            throw new Exception ("Número de telefone inválido.");*/
        if (numeroTelefone.length() < 7) {
             throw new Exception ("O Número de telefone é inválido.");
        } else {
            this.numeroTelefone = numeroTelefone; 
        }
    }

    public int getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(int idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public boolean getDesabilitarTipoTelefone() {
        return desabilitarTipoTelefone;
    }

    public void setDesabilitarTipoTelefone(boolean desabilitarTipoTelefone) {
        this.desabilitarTipoTelefone = desabilitarTipoTelefone;
    }
    
    
    
    
    
	
}