import java.time.LocalDate;

public class ProdutoPerecivel extends Produto implements DescontoQuantidade {
    private LocalDate dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidade, LocalDate dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("--- Produto Perecível ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Quantidade: " + getQuantidadeEmEstoque());
        System.out.println("Validade: " + dataValidade);
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.10; 
    }
}