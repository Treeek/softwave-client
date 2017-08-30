package br.net.softwave.client.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

    private String prontuario;
    private Permissao permissao;

    public Usuario() {
    }

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

        private final String typeSelected;

        private Permissao(String typeSelected) {
            this.typeSelected = typeSelected;
        }

        public String getTypeSelected() {
            return typeSelected;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "prontuario=" + prontuario + ", permissao=" + permissao + '}';
    }
    
}
