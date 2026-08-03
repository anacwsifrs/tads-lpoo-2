import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ProdutoController pc = new ProdutoController();
        int opc = 0;
        String nomeProduto;
        double precoProduto;
        int quantidadeProduto;

        while(opc !=5){
            menu.exibirMenu();
            opc = scanner.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Escreva o nome do produto: ");
                    nomeProduto = scanner.nextLine();

                    System.out.println("Escreva o preço do produto: ");
                    precoProduto = scanner.nextDouble();

                    System.out.println("Escreva a quantidade do produto: ");
                    quantidadeProduto = scanner.nextInt();

                    Produto p = new Produto(nomeProduto, precoProduto, quantidadeProduto);
                    pc.cadastrarProduto(p);
                    break;
                case 2:
                    pc.listarProdutos();
                    break;
                case 3:
                    System.out.println("Escreva o nome do produto: ");
                    break;
                case 4:
                    System.out.println("Escreva o nome do produto: ");
                    break;
            }
        }

    }
}