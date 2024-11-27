// Implementação de Frete Normal
public class FreteNormal implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 2.0; // Exemplo: taxa por kg
    }
}