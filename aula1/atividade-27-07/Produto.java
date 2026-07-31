public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void vender(int qtd) {
        if (qtd <= this.quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= qtd;
            System.out.println("Venda realizada! Quantidade vendida: " + qtd);
        } else {
            System.out.println("Estoque insuficiente para realizar a venda.");
        }
    }

    public void repor(int qtd) {
        this.quantidadeEmEstoque += qtd;
        System.out.println("Estoque reposto! Quantidade adicionada: " + qtd);
    }

    public void mostrarEstoque() {
        System.out.println("Produto: " + this.nome);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Quantidade em Estoque: " + this.quantidadeEmEstoque);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}