package br.com.bandtec.classes;

public class Texto {

    private String nome, descricao, autor;

    public Texto(String nome, String descricao, String autor) {
        this.nome = nome;
        this.descricao = descricao;
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", autor='" + autor + '\'';
    }
}
