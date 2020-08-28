package Classes;

public abstract class Produto extends Texto{

    private String editora;
    private Integer numeroPaginas, quantidadeEstoque;
    private Double valorCompra;

    public Produto(String nome, String descricao, String autor, String editora, Integer numeroPaginas, Integer quantidadeEstoque, Double preco) {
        super(nome, descricao, autor);
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorCompra = preco;
    }

    public abstract Double getPreco();

    @Override
    public String toString() {
        return "Produto";
    }
}
