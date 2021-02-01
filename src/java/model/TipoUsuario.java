package model;

public class TipoUsuario {

    private int idTipoUsuario;
    private String tipoUsuario;
    private String permissoes;

    public TipoUsuario() {
    }

    public TipoUsuario(
            String tipoUsuario,
            String permissoes) throws Exception {
        this.setTipoUsuario(tipoUsuario);
        this.setPermissoes(permissoes);
    }

    public TipoUsuario(String tipoUsuario) throws Exception {
        this.setTipoUsuario(tipoUsuario);

    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) throws Exception {
        if (tipoUsuario.trim().isEmpty()) {
            throw new Exception("O campo tipo de usuário está vazio!");
        } else {
            this.tipoUsuario = tipoUsuario;
        }
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) throws Exception {
        if (permissoes.trim().isEmpty()) {
            throw new Exception("O campo permissoes está vazio!");
        } else {
            this.permissoes = permissoes;
        }
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

}
