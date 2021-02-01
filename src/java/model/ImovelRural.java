package model;

import java.sql.Blob;
import java.util.Date;

public class ImovelRural {

    private int idImovelRural;
    private int idSituacaoImovelRural;

    private String nInscricaoEstadual;
    private String nirf;
    private String situacaoImovel;
    private String tipoPropriedade;
    private String tipoOcupacao;
    private String mercadoAtuacao;

    private Double areaGeoreferenciada;
    private Double areaReservaAmbiental;
    private Double areaUtilizacaoAgricultura;
    private Double areaUtilizacaoPecuaria;

    private String latitude;
    private String longitude;

    private boolean statusValidacao;

    private String validadoPor;
    private Date dataValidacao;
    private Blob documentos;

    private String justificativaValidacao;

    private Endereco endereco;

    private Produto produto;
    
    private boolean DesabilitarSituacaoImovelRural;
    
    private boolean DesabilitarImovelRural;

    public ImovelRural() {

    }

    public ImovelRural(String nInscricaoEstadual, String nirf, String situacaoImovel, String tipoPropriedade, String tipoOcupacao, String mercadoAtuacao, Double areaGeoreferenciada) throws Exception {

        this.setnInscricaoEstadual(nInscricaoEstadual);
        this.setNirf(nirf);
        this.setSituacaoImovel(situacaoImovel);
        this.setTipoPropriedade(tipoPropriedade);
        this.setTipoOcupacao(tipoOcupacao);
        this.setMercadoAtuacao(mercadoAtuacao);
        this.setAreaGeoreferenciada(areaGeoreferenciada);
        //this.setDocumentos(documentos);
        //this.setStatusValidacao(statusValidacao);
    }

    public int getIdImovelRural() {
        return idImovelRural;
    }

    public void setIdImovelRural(int idImovelRural) {
        this.idImovelRural = idImovelRural;
    }

    public int getIdSituacaoImovelRural() {
        return idSituacaoImovelRural;
    }

    public void setIdSituacaoImovelRural(int idSituacaoImovelRural) {
        this.idSituacaoImovelRural = idSituacaoImovelRural;
    }

    public String getnInscricaoEstadual() {
        return nInscricaoEstadual;
    }

    public void setnInscricaoEstadual(String nInscricaoEstadual) throws Exception {
        /*if (nInscricaoEstadual.trim().isEmpty()) {
            throw new Exception("O número de incrição estadual está vazio!");
        } else {
            this.nInscricaoEstadual = nInscricaoEstadual;
        }*/
        
        this.nInscricaoEstadual = nInscricaoEstadual;
    }

    public String getNirf() {
        return nirf;
    }

    public void setNirf(String nirf) throws Exception {
        if (nirf.trim() != null && nirf.length() > 7 && nirf.length() < 14) {
            this.nirf = nirf;
        } else {
            throw new Exception("O campo NIRF precisa ter entre 8 e 13 dígitos!");
        }
    }

    public String getTipoPropriedade() {
        return tipoPropriedade;
    }

    public void setTipoPropriedade(String tipoPropriedade) throws Exception {
        if (tipoPropriedade.trim().isEmpty()) {
            throw new Exception("O campo Tipo de Propriedade está vazio! ");
        } else {
            this.tipoPropriedade = tipoPropriedade;
        }
    }

    public String getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(String tipoOcupacao) throws Exception {
        if (tipoOcupacao.trim().isEmpty()) {
            throw new Exception("O campo Tipo de Ocupação está vazio! ");
        } else {
            this.tipoOcupacao = tipoOcupacao;
        }
    }

    public String getMercadoAtuacao() {
        return mercadoAtuacao;
    }

    public void setMercadoAtuacao(String mercadoAtuacao) throws Exception {
        if (mercadoAtuacao.trim().isEmpty()) {
            throw new Exception("O campo Mercado de Atuação está vazio!");
        } else {
            this.mercadoAtuacao = mercadoAtuacao;
        }
    }

    public Double getAreaGeoreferenciada() {
        return areaGeoreferenciada;
    }

    public void setAreaGeoreferenciada(Double areaGeoreferenciada) throws Exception {
        if (areaGeoreferenciada == 0) {
            throw new Exception("O campo Área georeferenciada está vazio! ");
        } else {
            this.areaGeoreferenciada = areaGeoreferenciada;
        }
    }

    public Double getAreaReservaAmbiental() {
        return areaReservaAmbiental;
    }

    public void setAreaReservaAmbiental(Double areaReservaAmbiental) throws Exception {
        if (areaReservaAmbiental == 0) {
            throw new Exception("O campo Área de Reserva Ambiental está vazio! ");
        } else {
            this.areaReservaAmbiental = areaReservaAmbiental;
        }

    }

    public Double getAreaUtilizacaoAgricultura() {
        return areaUtilizacaoAgricultura;
    }

    public void setAreaUtilizacaoAgricultura(Double areaUtilizacaoAgricultura) throws Exception {
        /*if (areaUtilizacaoAgricultura == 0) {
            throw new Exception("O campo área de utilização agricultura está vazio!");
        } else {
            this.areaUtilizacaoAgricultura = areaUtilizacaoAgricultura;
        }*/
        
        this.areaUtilizacaoAgricultura = areaUtilizacaoAgricultura;
        
    }

    public Double getAreaUtilizacaoPecuaria() {
        return areaUtilizacaoPecuaria;
    }

    public void setAreaUtilizacaoPecuaria(Double areaUtilizacaoPecuaria) throws Exception {
        /*if (areaUtilizacaoPecuaria == 0) {
            throw new Exception("O campo área de utilização pecuária está vazio!");
        } else {
            this.areaUtilizacaoPecuaria = areaUtilizacaoPecuaria;
        }*/
        
        this.areaUtilizacaoPecuaria = areaUtilizacaoPecuaria;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) throws Exception {
        /*if (latitude.trim() != null && latitude.length() > 0) {
            this.latitude = latitude;
        } else {
            throw new Exception("O campo Latitude está vazio!");
        }*/
        
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) throws Exception {
        /*if (longitude.trim() != null && longitude.length() > 0) {
            this.longitude = longitude;
        } else {
            throw new Exception("Campo Longitude está vazio!");
        }*/
        
        this.longitude = longitude;
    }

    public boolean isStatusValidacao() {
        return statusValidacao;
    }

    public void setStatusValidacao(boolean statusValidacao) {
        this.statusValidacao = statusValidacao;
    }

    public String getValidadoPor() {
        return validadoPor;
    }

    public void setValidadoPor(String validadoPor) {
        this.validadoPor = validadoPor;
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
        this.documentos = documentos;
    }

    public String getJustificativaValidacao() {
        return justificativaValidacao;
    }

    public void setJustificativaValidacao(String justificativaValidacao) {
        this.justificativaValidacao = justificativaValidacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getSituacaoImovel() {
        return situacaoImovel;
    }

    public void setSituacaoImovel(String situacaoImovel) {
        this.situacaoImovel = situacaoImovel;
    }

    public boolean getDesabilitarSituacaoImovelRural() {
        return DesabilitarSituacaoImovelRural;
    }

    public void setDesabilitarSituacaoImovelRural(boolean DesabilitarSituacaoImovelRural) {
        this.DesabilitarSituacaoImovelRural = DesabilitarSituacaoImovelRural;
    }

    public boolean getDesabilitarImovelRural() {
        return DesabilitarImovelRural;
    }

    public void setDesabilitarImovelRural(boolean DesabilitarImovelRural) {
        this.DesabilitarImovelRural = DesabilitarImovelRural;
    }
    
    

}
