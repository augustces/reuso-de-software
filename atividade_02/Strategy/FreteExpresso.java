// Implementação de Frete Expresso
public class FreteExpresso implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 10.0; // Exemplo: taxa maior por kg
    }
}