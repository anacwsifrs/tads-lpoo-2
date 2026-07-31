public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Caderno", 25.00, 30);
        
        p1.mostrarEstoque();

        System.out.println("--- Realizando Venda ---");
        p1.vender(5);
        p1.mostrarEstoque();

        System.out.println("--- Repondo Estoque ---");
        p1.repor(10);
        p1.mostrarEstoque();
    }
}