import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

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

                    produtos.add(new Produto(nomeProduto, precoProduto, quantidadeProduto));

                    break;
                case 2:
                    for (Produto produto : produtos) {
                        produto.mostrarEstoque();
                    }
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