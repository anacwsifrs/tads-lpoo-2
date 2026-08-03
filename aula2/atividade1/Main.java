import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        opc = scanner.nextInt();

        while(opc !=5){
            menu.exibirMenu();
            switch(opc){
                case 1:
                    System.out.println("Escreva o nome do produto: ");
            }
        }

    }
}