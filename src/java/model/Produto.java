package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Produto {

    private String ano;
    private Double quantidadeProduzida;
    private String mesSafra;
    private DescricaoProduto descricaoProduto;
    private int idProduto;
    private boolean desabilitarProduto;

    public Produto() {
    }

    public Produto(
            String ano,
            Double quantidadeProduzida) throws Exception {
        this.setAno(ano);
        this.setQuantidadeProduzida(quantidadeProduzida);
        //this.quantidadeProduzida = quantidadeProduzida;
    }

    public Produto(
            String ano,
            Double quantidadeProduzida,
            DescricaoProduto descricaoProduto) throws Exception {
        this.setAno(ano);
        this.setQuantidadeProduzida(quantidadeProduzida);
        this.setDescricaoProduto(descricaoProduto);
        //this.quantidadeProduzida = quantidadeProduzida;
    }

    public Produto(
            String ano,
            String mesSafra,
            Double quantidadeProduzida,
            DescricaoProduto descricaoProduto) throws Exception {
        this.setAno(ano);
        this.setQuantidadeProduzida(quantidadeProduzida);
        this.setMesSafra(mesSafra);
        this.setDescricaoProduto(descricaoProduto);

    }

    public String getAno() {

        return ano;

    }

    public final void setAno(String ano) throws Exception {
        /*
        Date data = new Date();
        SimpleDateFormat formata = new SimpleDateFormat("yyyy");

        //String novaData = formata.format(data.toString());
        int anoAtual = Integer.parseInt(formata.format(data));
        int anoInserido = Integer.parseInt(ano);

        Pattern alphabet = Pattern.compile("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        
        Matcher hasAlphabet = alphabet.matcher(ano);
        Matcher hasSpecial = special.matcher(ano);

        if (anoAtual < anoInserido) {
            throw new Exception("O ano inserido não pode ser maior que o ano atual!");
        } else if (hasAlphabet.find() || hasSpecial.find()) {
            throw new Exception("O campo não pode possuir caracteres especiais ou letras!");
        } else if (ano.trim().isEmpty()) {
            throw new Exception("O campo está vazio!");
        } else {*/
        //this.ano = ano;
        //}

        /*if (ano.trim().isEmpty()) {
            throw new Exception("O campo Ano está vazio!");
        } else if (ano.matches("([0-9]{4})")) { //
            this.ano = ano;
        } else {
            throw new Exception("O campo Ano deve ter quatro dígitos (ex:AAAA).");
        }*/
        
        this.ano = ano;

    }

    public Double getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(Double quantidadeProduzida) throws Exception {

        if (quantidadeProduzida == null || quantidadeProduzida <= 0) {
            throw new Exception("Quantidade produzida inválida! ");
        } else {
            this.quantidadeProduzida = quantidadeProduzida;
        }
    }

    public String getMesSafra() {

        return mesSafra;

    }

    public final void setMesSafra(String mesSafra) throws Exception {
        /*if (mesSafra == null || mesSafra.matches("([A-Za-z ^\\s]{1,}?)") ) {
            this.mesSafra = mesSafra;
       
        } else {
            throw new Exception("Mês inválido");
        }*/
        this.mesSafra = mesSafra;
        

    }

    public DescricaoProduto getDescricaoProduto() {
        return descricaoProduto;

    }

    public final void setDescricaoProduto(DescricaoProduto descricaoProduto) /*throws Exception */ {

        //if (descricaoProduto == null){
        //     throw new Exception("O campo está vazio!");
        //}
        this.descricaoProduto = descricaoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public boolean getDesabilitarProduto() {
        return desabilitarProduto;
    }

    public void setDesabilitarProduto(boolean desabilitarProduto) {
        this.desabilitarProduto = desabilitarProduto;
    }

}
