public class ProdutoNaoPerecivel extends Produto {

    private int garantiaMeses;

    public ProdutoNaoPerecivel(String nome, double preco, int quantidadeEmEstoque, int garantiaMeses) {
        super(nome, preco, quantidadeEmEstoque);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarEstoque() {
        super.mostrarEstoque();
        System.out.println("Garantia: " + this.garantiaMeses + " meses");
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
}