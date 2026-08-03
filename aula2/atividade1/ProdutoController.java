import java.util.ArrayArrayList;

public class ProdutoController {
    private ArrayList<Produto> produtos = new ArrayArrayList<>();

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }

    public ArrayList<Produto> venderProdutos() {
        return produtos;
    }

    public ArrayList<Produto> reporProdutos() {
        return produtos;
    }
}