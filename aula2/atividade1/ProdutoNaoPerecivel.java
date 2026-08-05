public class ProdutoNaoPerecivel extends Produto {

    private int garantiaMeses;

    public ProdutoNaoPerecivel(String nome, double preco, int quantidadeEmEstoque, int garantiaMeses) {
        super(nome, preco, quantidadeEmEstoque);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("--- Produto Não Perecível ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Quantidade: " + getQuantidadeEmEstoque());
        System.out.println("Garantia: " + this.garantiaMeses + " meses");
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
}