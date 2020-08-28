package br.com.bandtec.classes;

public class Livro extends Produto{

    public Livro(String nome, String descricao, String autor, String editora, Integer numeroPaginas, Integer quantidadeEstoque, Double preco) {
        super(nome, descricao, autor, editora, numeroPaginas, quantidadeEstoque, preco);
    }

    @Override
    public Double getPreco() {
        Double precoModerado = (getValorCompra() * 5) / (getQuantidadeEstoque() * 0.05);

        if(precoModerado > 100){
            return 100.0;
        } else if (precoModerado < 10) {
            return 10.0;
        }

        return precoModerado;
    }

    @Override
    public String toString() {
        return String.format("Livro{%s}", super.toString());
    }
}