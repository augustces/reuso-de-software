// Classe Pedido que utiliza o Strategy
public class Pedido {
    private FreteStrategy estrategiaFrete;

    public Pedido(FreteStrategy estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public double calcularTotal(double pesoProduto) {
        return estrategiaFrete.calcularFrete(pesoProduto);
    } 
}
