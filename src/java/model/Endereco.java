package model;

public class Endereco {

    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private Estado estado;
    private int idEndereco;

    public Endereco() {
    }

    public Endereco(
            String logradouro,
            String numero,
            String bairro,
            String cidade,
            String cep) throws Exception {

        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCep(cep);
    }

    public Endereco(
            String logradouro,
            String numero,
            String bairro,
            String cidade,
            String cep,
            Estado estado) throws Exception {

        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCep(cep);
        this.setEstado(estado);
    }

    public Endereco(
            String logradouro,
            String numero,
            String bairro,
            String cidade,
            String cep,
            String tipoLogradouro,
            String complemento) throws Exception {

        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCep(cep);
        this.setTipoLogradouro(tipoLogradouro);
        this.setComplemento(complemento);

    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws Exception {
        if (logradouro.trim().isEmpty()) {
            throw new Exception("O campo Logradouro precisa ser preenchido!");

        } else {

            this.logradouro = logradouro;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws Exception {
        if (numero.trim().isEmpty()) {
            throw new Exception("O campo Número precisa ser preenchido!");

        } else {

            this.numero = numero;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        if (bairro.trim().isEmpty()) {

            throw new Exception("O campo Bairro está vazio!");

        } else {

            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        /*if (cidade.isEmpty()) {
            throw new Exception("O campo Cidade está vazio!");
        } else if (cidade.matches("([A-Za-z ^\\s]{1,}?)")) { 
            this.cidade = cidade;
        } else {
            throw new Exception("Tipo de caractere inválido no campo Cidade!");
        }*/
        this.cidade = cidade;
        
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws Exception {
        if (cep.trim().isEmpty()) {
            throw new Exception("O campo Cep está vazio!");

        } else {
            this.cep = cep;
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) throws Exception {
        if (estado == null) {
            throw new Exception("O campo Estado está vazio!");

        } else {
            this.estado = estado;
        }
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

}
