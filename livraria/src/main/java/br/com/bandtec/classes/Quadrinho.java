package br.com.bandtec.classes;

public class Quadrinho extends Produto{

    public Quadrinho(String nome, String descricao, String autor, String editora, Integer numeroPaginas, Integer quantidadeEsoque, Double preco) {
        super(nome, descricao, autor, editora, numeroPaginas, quantidadeEsoque, preco);
    }

    @Override
    public Double getPreco() {
        Double precoModerado = (getValorCompra() * 5) / (getQuantidadeEstoque() * 0.05);

        if(precoModerado > 150){
            return 150.0;
        } else if (precoModerado < 10) {
            return 20.0;
        }

        return precoModerado;
    }

    @Override
    public String toString() {
        return String.format("Quadrinho{%s}", super.toString());
    }
}
