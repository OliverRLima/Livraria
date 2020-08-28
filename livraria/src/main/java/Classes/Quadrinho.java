package Classes;

public class Quadrinho extends Produto{

    public Quadrinho(String nome, String descricao, String autor, String editora, Integer numeroPaginas, Integer quantidadeEsoque, Double preco) {
        super(nome, descricao, autor, editora, numeroPaginas, quantidadeEsoque, preco);
    }

    @Override
    public Double getPreco() {
        return null;
    }

    @Override
    public String toString() {
        return "Quadrinho";
    }
}
