package Classes;

public class Texto {

    private String nome, descricao, autor;

    public Texto(String nome, String descricao, String autor) {
        this.nome = nome;
        this.descricao = descricao;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Texto";
    }
}
