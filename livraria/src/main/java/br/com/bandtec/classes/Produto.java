package br.com.bandtec.classes;

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

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", editora='" + editora + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", valorCompra=" + valorCompra ;
    }

}
