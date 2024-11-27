import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o peso do produto a ser transportado:");

        double peso = scanner.nextDouble();

        mostrarFretes(peso);

        scanner.close();
    }
    
    private static void mostrarFretes(double peso){
        // Criando estratégias
        FreteStrategy freteNormal = new FreteNormal();
        FreteStrategy freteExpresso = new FreteExpresso();
        FreteStrategy fretePromocional = new FretePromocional();

        // Pedidos com diferentes estratégias
        Pedido pedidoNormal = new Pedido(freteNormal);
        Pedido pedidoExpresso = new Pedido(freteExpresso);
        Pedido pedidoPromocional = new Pedido(fretePromocional);

        System.out.println("Frete Normal: R$ " + pedidoNormal.calcularTotal(peso));
        System.out.println("Frete Expresso: R$ " + pedidoExpresso.calcularTotal(peso));
        System.out.println("Frete Promocional: R$ " + pedidoPromocional.calcularTotal(peso));
    }
}
