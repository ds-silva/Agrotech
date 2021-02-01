package model;


public class DescricaoProduto {
    
    
    private String descricaoProduto;
    private String unidadeProduto;
    private String tipoProduto;
    private int idDescricaoProduto;
    private int idTipoProduto;
    private boolean desabilitarTipoProduto;
    private boolean desabilitarDescricaoProduto;
    
    public DescricaoProduto(){}
    
    public DescricaoProduto (String tipoProduto) throws Exception{
        
        this.setTipoProduto(tipoProduto);
    }
    
    public DescricaoProduto (
            String descricaoProduto,  
            String tipoProduto) throws Exception{
        this.setDescricaoProduto(descricaoProduto);
        this.setTipoProduto(tipoProduto);
    }
    
    public DescricaoProduto (
            String descricaoProduto, 
            String unidadeProduto, 
            String tipoProduto) throws Exception{
        this.setDescricaoProduto(descricaoProduto);
        this.setUnidadeProduto(unidadeProduto);
        this.setTipoProduto(tipoProduto);
    }
    
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) throws Exception { 
       if (descricaoProduto.length() <=  0) {
            throw new Exception("O campo produto precisa ser preenchido!");
        } else {
           this.descricaoProduto = descricaoProduto;
       }
    }

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) throws Exception {
       if (unidadeProduto.trim().isEmpty()) {
           throw new Exception("O campo Unidade do Produto está vazio! ");
       } else {
           this.unidadeProduto = unidadeProduto;
       }
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) throws Exception {
        if (tipoProduto.trim().isEmpty()) {
            throw new Exception("Selecione um Tipo de produto.");
        } else if (tipoProduto == null){
            throw new Exception ("O campo tipo produto está vazio.");
        } else {
            this.tipoProduto = tipoProduto;
        }
    }

    public int getIdDescricaoProduto() {
        return idDescricaoProduto;
    }

    public void setIdDescricaoProduto(int idDescricaoProduto) {
        this.idDescricaoProduto = idDescricaoProduto;
    }

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public boolean getDesabilitarTipoProduto() {
        return desabilitarTipoProduto;
    }

    public void setDesabilitarTipoProduto(boolean desabilitarTipoProduto) {
        this.desabilitarTipoProduto = desabilitarTipoProduto;
    }

    public boolean getDesabilitarDescricaoProduto() {
        return desabilitarDescricaoProduto;
    }

    public void setDesabilitarDescricaoProduto(boolean desabilitarDescricaoProduto) {
        this.desabilitarDescricaoProduto = desabilitarDescricaoProduto;
    }
    
    
    
    

}
