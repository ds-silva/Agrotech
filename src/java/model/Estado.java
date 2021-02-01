package model;

public class Estado {

    private String descricaoEstado;
    private String ufEstado;
    private int idEstado;
    private boolean desabilitarEstado;
    
    public Estado() throws Exception {}
    
    public Estado(
            String descricaoEstado) throws Exception {
        this.setDescricaoEstado(descricaoEstado);
        
    }

    public Estado(
            String descricaoEstado, 
            String ufEstado) throws Exception {
        this.setDescricaoEstado(descricaoEstado);
        this.setUfEstado(ufEstado);
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) throws Exception {
        if(descricaoEstado.trim().isEmpty()){
            throw new Exception("O campo Estado precisa ser preenchido!");
        }else{
            this.descricaoEstado = descricaoEstado;
        }
        
    }

    public String getUfEstado() {
        return ufEstado;
    }

    public void setUfEstado(String ufEstado) throws Exception{
        if(ufEstado.trim().isEmpty()){
            throw new Exception("O campo Sigla precisa ser preenchido!");
        }else{
           this.ufEstado = ufEstado; 
        }
        
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public boolean getDesabilitarEstado() {
        return desabilitarEstado;
    }

    public void setDesabilitarEstado(boolean desabilitarEstado) {
        this.desabilitarEstado = desabilitarEstado;
    }
    
    

}
