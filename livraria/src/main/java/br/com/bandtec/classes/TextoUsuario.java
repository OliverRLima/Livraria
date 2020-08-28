package br.com.bandtec.classes;

public class TextoUsuario extends Texto{

    private String titulo, enredo;

    public TextoUsuario(String nome, String descricao, String autor) {
        super(nome, descricao, autor);
    }

    public void adicionaTitulo(String titulo){
        this.titulo = titulo;
    }

    public void adicionaEnredo(String enredo){
        this.enredo = enredo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEnredo() {
        return enredo;
    }

    @Override
    public String toString() {
        return "TextoUsuario{" +
                super.toString() +
                ", titulo='" + titulo + '\'' +
                ", enredo='" + enredo + '\'' +
                '}';
    }
}
