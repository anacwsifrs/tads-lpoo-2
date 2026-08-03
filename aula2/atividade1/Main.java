import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        int opc = 0;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        while(opc !=5){
            menu.exibirMenu();
            opc = scanner.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Escreva o nome do produto: ");
                    break;
                case 2:
                    System.out.println("Escreva o nome do produto: ");
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