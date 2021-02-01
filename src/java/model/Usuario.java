package model;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import validacoes.ValidadorEmail;
import validacoes.ValidadorSenha;

public class Usuario {

    private int idUsuario;

    private String nome;
    private String sobrenome;
    private String login;
    private String email;
    private String senha;
    private String rgRne;
    private String orgaoExpedidorRgRne;
    private Date dataEmissaoRgRne;
    private String cpfCnpj;
    private String sexo;
    private Date dataNascimento;
    private List<Telefone> telefones = new ArrayList<Telefone>();
    private Nacionalidade nacionalidade;
    private String descSituacaoUsuario;
    private Endereco endereco;
    private TipoUsuario tipoUsuario;
    private Cliente cliente;
    private Funcionario funcionario;    
    private byte[] documentoRgRne;
    private byte[] documentoCpfCnpj;
    private byte[] documentoComprovanteResidencia;
    private int idSituacaoUsuario;
    private boolean DesabilitarUsuario;
    private boolean desabilitardescSituacaoUsuario;

    public Usuario() throws Exception {

    }

    public Usuario(String descSituacaoUsuario) throws Exception {
        this.setDescSituacaoUsuario(descSituacaoUsuario);
    }

    public Usuario(
            String login,
            String senha,
            String cpfCnpj) throws Exception {

        this.setLogin(login);
        this.setSenha(senha);
        this.setCpfCnpj(cpfCnpj);
    }

    public Usuario(
            String login,
            String senha) throws Exception {

        this.setLogin(login);
        this.setSenha(senha);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.trim().isEmpty()) {
            throw new Exception("O campo nome não pode estar vazio!");
        } else {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) throws Exception {
        if (sobrenome.trim().isEmpty()) {
            throw new Exception("O campo sobrenome não pode estar vazio!");
        } else {
            this.sobrenome = sobrenome;
        }

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws Exception {
        if (login.trim().isEmpty()) {
            throw new Exception("O campo login não pode estar vazio!");
        } else {
            this.login = login;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
       if (ValidadorEmail.isEmailValid(email)) {
            this.email = email;
        } else {
            throw new Exception("O email é inválido!");
        }
 this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {

        if (senha.trim().isEmpty()) {
            throw new Exception("O campo senha não pode estar vazio!");
        }

        if (ValidadorSenha.isValidPassword(senha)) {
            this.senha = senha;
        } else {
            throw new Exception("A senha precisa de pelo menos um número, uma letra minúscula, uma letra maiúscula, um caráter especial e ter no mínimo 8 caracteres e no maxixo 20!");
        }

    }

    public String getRgRne() {
        return rgRne;
    }

    public void setRgRne(String rgRne) throws Exception {

        if (rgRne.trim().isEmpty()) {
            throw new Exception("O campo RG/RNE não pode estar vazio!");
        } else {
            this.rgRne = rgRne;
        }

    }

    public String getOrgaoExpedidorRgRne() {
        return orgaoExpedidorRgRne;
    }

    public void setOrgaoExpedidorRgRne(String orgaoExpedidorRgRne) throws Exception {
        if (orgaoExpedidorRgRne.trim().isEmpty()) {
            throw new Exception("O campo do orgão expedidor não pode estar vazio!");
        } else {
            this.orgaoExpedidorRgRne = orgaoExpedidorRgRne;
        }

    }

    public Date getDataEmissaoRgRne() {
        return dataEmissaoRgRne;
    }

    public void setDataEmissaoRgRne(Date dataEmissaoRgRne) throws Exception {
        if (dataEmissaoRgRne == null) {
            throw new Exception("O campo de data de emissão não pode estar vazio!");
        } else {
            this.dataEmissaoRgRne = dataEmissaoRgRne;
        }

    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) throws Exception {

        if (cpfCnpj == null) {
            throw new Exception("O campo CPF/CNPJ não pode estar vazio!");
        } else if (cpfCnpj.length() < 10 || cpfCnpj.length() > 18) {
            throw new Exception("CPF/CNPJ inválido.");
        } else if (cpfCnpj.matches("[A-Za-z]")) {
            throw new Exception("CPF/CNPJ não pode conter letras.");
        } else {
            this.cpfCnpj = cpfCnpj;
        }

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) throws Exception {
        if (sexo.trim().isEmpty()) {
            throw new Exception("O campo sexo não pode estar vazio!");
        } else {
            this.sexo = sexo;
        }

    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNascimento);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if (age < 18) {
            throw new Exception("Idade menor de 18 anos");
        } else {
            this.dataNascimento = dataNascimento;
        }

    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(Telefone telefone) throws Exception {
        if (telefones.size() > 4) {
            throw new Exception("A quantidade de telefones não pode ser maior do que Quatro!");
        } else {
            telefones.add(telefone);
        }
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) throws Exception {
        if (nacionalidade == null) {
            throw new Exception("A Nacionalidade encontra-se vazia!");
        } else {
            this.nacionalidade = nacionalidade;
        }

    }

    public String getDescSituacaoUsuario() {
        return descSituacaoUsuario;
    }

    public void setDescSituacaoUsuario(String descSituacaoUsuario) throws Exception {

        if (descSituacaoUsuario.trim().isEmpty()) {
            throw new Exception("O campo Situação de Usuario não pode estar vazio!");
        } else {
            this.descSituacaoUsuario = descSituacaoUsuario;
        }

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) throws Exception {
        if (endereco == null) {
            throw new Exception("O endereço encontra-se vazia!");
        } else {
            this.endereco = endereco;
        }

    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        if (tipoUsuario == null) {
            throw new Exception("O campo Tipo de Usuario encontra-se vazia!");
        } else {
            this.tipoUsuario = tipoUsuario;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public byte[] getDocumentoRgRne() {
        return documentoRgRne;
    }

    public void setDocumentoRgRne(byte[] documentoRgRne) throws Exception {
        
        if (documentoRgRne == null) {
            throw new Exception("O campo de documento encontra-se vazio!");
        }
        this.documentoRgRne = documentoRgRne;
    }

    public byte[] getDocumentoCpfCnpj() {
        return documentoCpfCnpj;
    }

    public void setDocumentoCpfCnpj(byte[] documentoCpfCnpj) throws Exception {
        
        if (documentoCpfCnpj == null) {
            throw new Exception("O campo de documento encontra-se vazio!");
        }
        this.documentoCpfCnpj = documentoCpfCnpj;
    }

    public byte[] getDocumentoComprovanteResidencia() {
        return documentoComprovanteResidencia;
    }

    public void setDocumentoComprovanteResidencia(byte[] documentoComprovanteResidencia) throws Exception {
        
        if (documentoComprovanteResidencia == null) {
            throw new Exception("O campo de documento encontra-se vazio!");
        }
        this.documentoComprovanteResidencia = documentoComprovanteResidencia;
    }    
    

    public int getIdSituacaoUsuario() {
        return idSituacaoUsuario;
    }

    public void setIdSituacaoUsuario(int idSituacaoUsuario) {
        this.idSituacaoUsuario = idSituacaoUsuario;
    }

    public boolean getDesabilitarUsuario() {
        return DesabilitarUsuario;
    }

    public void setDesabilitarUsuario(boolean DesabilitarUsuario) {
        this.DesabilitarUsuario = DesabilitarUsuario;
    }

    public boolean getDesabilitardescSituacaoUsuario() {
        return desabilitardescSituacaoUsuario;
    }

    public void setDesabilitardescSituacaoUsuario(boolean desabilitardescSituacaoUsuario) {
        this.desabilitardescSituacaoUsuario = desabilitardescSituacaoUsuario;
    }
       
    
}
