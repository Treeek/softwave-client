package br.net.softwave.client.domain;

public class Usuario {
    
    private String prontuario;
    private Permissao permissao;

    public Usuario(String prontuario, Permissao permissao) {
        this.prontuario = prontuario;
        this.permissao = permissao;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
    
    public enum Permissao {
        
        ALUNO("ALUNO"), PROFESSOR("PROFESSOR"), ADMIN("ADMIN");
        
        private final String tipoSelecionado;

        private Permissao(String tipoSelecionado) {
            this.tipoSelecionado = tipoSelecionado;
        }

        public String getTipoSelecionado() {
            return tipoSelecionado;
        }
        
    }

}
