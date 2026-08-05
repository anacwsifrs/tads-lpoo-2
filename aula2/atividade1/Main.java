import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ProdutoController pc = new ProdutoController();
        int opc = 0;

        while (opc != 5) {
            menu.exibirMenu();
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Qual tipo de produto deseja cadastrar?");
                    System.out.println("1 - Perecível | 2 - Não Perecível");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.println("Preço: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Quantidade: ");
                    int qtd = scanner.nextInt();

                    if (tipo == 1) {
                        ProdutoPerecivel pp = new ProdutoPerecivel(nome, preco, qtd, LocalDate.now().plusDays(30));
                        pc.cadastrarProduto(pp);
                    } else {
                        System.out.println("Garantia em meses: ");
                        int garantia = scanner.nextInt();
                        ProdutoNaoPerecivel pnp = new ProdutoNaoPerecivel(nome, preco, qtd, garantia);
                        pc.cadastrarProduto(pnp);
                    }
                    break;

                case 2:
                    pc.listarProdutos();
                    break;

                case 3:
                    System.out.println("Digite o nome do produto para vender: ");
                    String nomeVenda = scanner.nextLine();
                    Produto produtoVenda = pc.buscarPorNome(nomeVenda);

                    if (produtoVenda != null) {
                        System.out.println("Quantidade a vender: ");
                        int qtdVenda = scanner.nextInt();
                        produtoVenda.vender(qtdVenda);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do produto para repor estoque: ");
                    String nomeRepor = scanner.nextLine();
                    Produto produtoRepor = pc.buscarPorNome(nomeRepor);

                    if (produtoRepor != null) {
                        System.out.println("Quantidade a adicionar: ");
                        int qtdRepor = scanner.nextInt();
                        produtoRepor.repor(qtdRepor);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}