package model;

public class Nacionalidade {

    private String siglaNacionalidade;
    private String descricaoNacionalidade;
    private int idNacionalidade;
    private boolean DesabilitarNacionalidade;

    public Nacionalidade() {
    }

    public Nacionalidade(String siglaNacionalidade, String descricaoNacionalidade) throws Exception {
        this.setDescricaoNacionalidade(descricaoNacionalidade);
        this.setSiglaNacionalidade(siglaNacionalidade);
    }

    public Nacionalidade(String descricaoNacionalidade) throws Exception {
        this.setDescricaoNacionalidade(descricaoNacionalidade);
    }

    public String getSiglaNacionalidade() throws Exception {
        return siglaNacionalidade;
    }

    public void setSiglaNacionalidade(String siglaNacionalidade) throws Exception {

        /*Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasDigit = digit.matcher(siglaNacionalidade);
        Matcher hasSpecial = special.matcher(siglaNacionalidade);
            
           if (siglaNacionalidade.trim().isEmpty()) {
            throw new Exception("O campo está vazio!");
        } else if (siglaNacionalidade.length() != 2) {
            throw new Exception("O campo deve conter apenas dois dígitos!");
        } else if (hasDigit.find() || hasSpecial.find()) {
            throw new Exception("O campo não pode possuir caracteres especiais ou números!");
        } else {
            this.siglaNacionalidade = siglaNacionalidade;
        }*/
        if (siglaNacionalidade.trim().isEmpty()) {
            throw new Exception("O campo sigla precisa ser preenchido!");
        } else {
            this.siglaNacionalidade = siglaNacionalidade;
        }

    }

    public String getDescricaoNacionalidade() {
        return descricaoNacionalidade;
    }

    public void setDescricaoNacionalidade(String descricaoNacionalidade) throws Exception {
        if (descricaoNacionalidade.trim().isEmpty()) {
            throw new Exception("O campo País precisa ser preenchido!");
        } else {
            this.descricaoNacionalidade = descricaoNacionalidade;
        }
    }

    public int getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(int idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public boolean getDesabilitarNacionalidade() {
        return DesabilitarNacionalidade;
    }

    public void setDesabilitarNacionalidade(boolean DesabilitarNacionalidade) {
        this.DesabilitarNacionalidade = DesabilitarNacionalidade;
    }
    
    
    
    
}
