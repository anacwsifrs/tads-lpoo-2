import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {

    private LocalDate dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidadeEmEstoque, LocalDate dataValidade) {
        super(nome, preco, quantidadeEmEstoque);
        this.dataValidade = dataValidade;
    }

    @Override
    public void mostrarEstoque() {
        super.mostrarEstoque();
        System.out.println("Data de Validade: " + this.dataValidade);
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}