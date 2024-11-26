use std::io;

fn main() {
    
    //Funções para cada questão
    // questao_01_main();
    // questao_02_main();
    
}

// Funções para a primeira questão
fn media_positivos(numeros: [i32; 10], count_positivos: i32) -> Option<i32> {
// Calcula a média dos números positivos de um array
// Verifica se não há números positivos no array, se não tiver retorna None
    if count_positivos == 0 {
        return None;
    }
    // define a variável para somar os valores positivos
    let mut soma: i32 = 0;
    // soma os valores positivos no array
    for elem in numeros {
        if elem > 0 {
            soma += elem;
        }
    }
    // retorna a média dos valores positivos
    Some(soma / count_positivos)
}

fn produto_pares(numeros: [i32; 10]) -> i32 {
// função para calcular o produto  dos números pares

// variável para acumular o produto dos valores pares
// ja inicia com 1 porque não quando multiplicar os valores não altera o produto final
// e se caso não houver valores pares, já retorna 1
    let mut produto: i32 = 1; 
// calcula os números pares e já acumula na variável produto
// não conta com os números 0
    for elem in numeros {
        if elem % 2 == 0 && elem != 0 {
            produto *= elem;
        }
    }
    produto // retorna a variável produto
}
// função que resolve a primeira questão
fn questao_01_main() {

    // array de numeros inicializado
    let mut numeros: [i32; 10] = [0; 10];
    let mut i = 0; // iterador para o loop de leitura
    let mut count_positivos = 0; // contador de numeros positivos
    
    // loop de leitura
    loop {
        if i > 9 { // lê só 10 numeros e para o loop
            break;
        }
        
        let mut x = String::new(); // variavel para ler do teclado
        
        io::stdin() // leitura da variável
            .read_line(&mut x)
            .expect("Insira um numero valido");
        // conversão de String para int
        numeros[i] = x.trim().parse().expect("Insira um numero valido");
        
        // if para contar os numeros positivos 
        if numeros[i] > 0 {
            count_positivos += 1;
        }
        
        i += 1;
    }
    // verifica se o que é retornado é um valor ou um none e imprime conforme o retorno
    match media_positivos(numeros, count_positivos) {
        Some(media) => println!("Média dos números positivos: {}", media),
        None => println!("Não há números positivos."),
    }
    // calcula o produto e imprime o valor
    let produto = produto_pares(numeros);
    println!("Produto dos números pares: {}", produto);
}

// funções para a segunda questão
fn ler_inteiro()-> i32{
    let mut x = String::new(); // variável para ler do teclado
    io::stdin() // leitura dos números em formato string
            .read_line(&mut x)
            .expect("Insira um numero valido");
    // conversão para inteiro e retorno do valor
    let x : i32 = x.trim().parse().expect("Insira um numero valido");
    x
}

// função para calcular a nova tupla a partir de uma outra tupla
fn analisar_tupla(tup: (i32, i32, i32)) -> (i32, i32, i32) {
// definição das variáveis para a tupla resultante
    let soma = tup.0 + tup.1 + tup.2;
    let mut maior = tup.0;
    let mut menor = tup.0;

// ifs para calcular o menor e maior valor
    if tup.1 > maior {
        maior = tup.1;
    }
    if tup.2 > maior {
        maior = tup.2;
    }
    
    if tup.1 < menor {
        menor = tup.1;
    }
    if tup.2 < menor {
        menor = tup.2;
    }

    (soma, maior, menor) // retorno da tupla com os valores de soma, maior e menor valor
}

// função para resolver a segunda questão
fn questao_02_main(){
    println!("Insira 3 numeros inteiros");
    // leitura dos valores para compor a tupla original
    let x = ler_inteiro();
    let y = ler_inteiro();
    let z = ler_inteiro();
    
    let tup : (i32, i32, i32) = (x,y,z); // definição da tupla original
    let nova_tup = analisar_tupla(tup); // cálculo da tupla resultante
    println!("Tupla resultante: {:?}", nova_tup);
    
}
