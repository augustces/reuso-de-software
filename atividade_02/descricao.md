# Atividade 02: Padrões de Software
O padrão escolhido foi o Strategy com o problema fictício de um sistema de entrega de pedidos para um aplicativo de compras online.

## Padrão de Software Strategy
Para uma classe X, há necessidade de um método que calcula uma função de diferentes formas, porém a classe X só calcula de uma forma.

O padrão Strategy resolve o problema quando abre a classe X para outras maneiras de calcular a função sem alterar seu código fonte. O objetivo principal do padrão é parametrizar os algoritmos usados por uma classe, encapsulando uma família de algoritmos os tornando intercabiáveis. Seu uso é recomendando quando uma classse é usuária de um certo tipo de algoritmo, como Ordenação.

## Problema
Há um sistema de entrega de pedidos para um aplicativo de compras online. Esse aplicativo deve calcular o valor do frete dependendo do peso do produto para cada forma de entrega:
- Frete normal: entrega padrão.
- Frete expresso: entrega mais rápida.
- Frete promocional: redução ou isenção de taxas.

## Solução
Será definida uma interface FreteStrategy com um método "calcularFrete" implementado por várias classes concretas: FreteNormal, FreteExpresso e FretePromocional. Esse método vai calcular o valor do frete de modo diferente para cada tipo de frete.