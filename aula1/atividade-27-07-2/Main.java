import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Caderno", 25.00, 30));
        produtos.add(new ProdutoPerecivel("Leite", 7.90, 20, LocalDate.of(2026, 8, 20)));
        produtos.add(new ProdutoNaoPerecivel("Teclado", 150.00, 15, 12));

        System.out.println("=== LISTAGEM DE ESTOQUE (POLIMORFISMO) ===");
        for (Produto p : produtos) {
            p.mostrarEstoque();
            System.out.println("------------------------------------");
        }

        System.out.println("\n=== TESTANDO OPERAÇÕES ===");
        produtos.get(1).vender(5);
        produtos.get(2).repor(5);

        System.out.println("\n=== ESTOQUE ATUALIZADO DO LEITE E TECLADO ===");
        produtos.get(1).mostrarEstoque();
        System.out.println("------------------------------------");
        produtos.get(2).mostrarEstoque();
    }
}