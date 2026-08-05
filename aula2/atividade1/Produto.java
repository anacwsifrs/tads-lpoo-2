public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidade;
    }

    public void vender(int qtd) {
        if (qtd <= this.quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= qtd;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    public void repor(int qtd) {
        this.quantidadeEmEstoque += qtd;
        System.out.println("Estoque reposto com sucesso!");
    }

    public abstract void mostrarDetalhes();

    public String getNome() { 
        return nome; 
    }

    public double getPreco() { 
        return preco; 
    }

    public int getQuantidadeEmEstoque() { 
        return quantidadeEmEstoque; 
    }
}