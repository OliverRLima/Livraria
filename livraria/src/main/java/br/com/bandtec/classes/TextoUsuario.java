package br.com.bandtec.classes;

public class TextoUsuario extends Texto{

    private String titulo, enredo;

    public TextoUsuario(String nome, String descricao, String autor, String titulo, String enredo) {
        super(nome, descricao, autor);
        this.titulo = titulo;
        this.enredo = enredo;
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
