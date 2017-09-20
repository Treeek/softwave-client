package br.net.softwave.client.domain;

public class AreaConhecimento {

    private int id;
    private String nome;
    private String enderecoImagem;

    public AreaConhecimento() {
    }

    public AreaConhecimento(int id, String nome, String enderecoImagem) {
        this.id = id;
        this.nome = nome;
        this.enderecoImagem = enderecoImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoImagem() {
        return enderecoImagem;
    }

    public void setEnderecoImagem(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
    }

    @Override
    public String toString() {
        return "AreaConhecimento{" + "id=" + id + ", nome=" + nome + ", enderecoImagem=" + enderecoImagem + '}';
    }
    
}
