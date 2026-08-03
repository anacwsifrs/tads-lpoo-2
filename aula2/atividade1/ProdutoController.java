import java.util.ArrayList;

public class ProdutoController {
    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> venderProdutos() {
        return produtos;
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: R$ " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidadeEmEstoque());
        }
    }

    public ArrayList<Produto> reporProdutos() {
        return produtos;
    }
}