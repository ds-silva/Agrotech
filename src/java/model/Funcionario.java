package model;

public class Funcionario extends Usuario {

    private String matricula;
    private String descricaoOrgaoFuncional;
    private Regional regional;

    public Funcionario() throws Exception {

    }

    public Funcionario(String descricaoOrgaoFuncional) throws Exception {
        this.setDescricaoOrgaoFuncional(descricaoOrgaoFuncional);
    }

    public Funcionario(String matricula, String senha) throws Exception {
        super(senha);
        this.setMatricula(matricula);
    }

    public Funcionario(
            String login,
            String senha,
            String cpfCnpj) throws Exception {
        
        super(login, senha, cpfCnpj);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws Exception {
       if (matricula == null) {
            throw new Exception("O campo Matrícula não pode estar vazio!");
        } else if (matricula.length() != 7) {
            throw new Exception("Matrícula inválida!.");
        } else if (matricula.matches("[A-Za-z]")) {
            throw new Exception("Matrícula não pode conter letras.");
        }
 
    }

    public String getDescricaoOrgaoFuncional() {
        return descricaoOrgaoFuncional;
    }

    public void setDescricaoOrgaoFuncional(String descricaoOrgaoFuncional) throws Exception {

        if (descricaoOrgaoFuncional.trim().isEmpty()) {
            throw new Exception("O campo Orgão funcional precisa ser preenchido!");
        } else {
            this.descricaoOrgaoFuncional = descricaoOrgaoFuncional;
        }

    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) throws Exception {

        this.regional = regional;
    }

}
