package br.com.bandtec.classes;

public class Manga extends Produto{

    public Manga(String nome, String descricao, String autor, String editora, Integer numeroPaginas, Integer quantidadeEsoque, Double preco) {
        super(nome, descricao, autor, editora, numeroPaginas, quantidadeEsoque, preco);
    }

    @Override
    public Double getPreco() {
        Double precoModerado = (getValorCompra() * 5) / (getQuantidadeEstoque() * 0.05);

        if(precoModerado > 200){
            return 200.0;
        } else if (precoModerado < 30) {
            return 30.0;
        }

        return precoModerado;
    }

    @Override
    public String toString() {
        return String.format("Manga{%s}", super.toString());
    }
}
