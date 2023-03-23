package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")
    Endereco().let {
        it
    }
    // Passamos uma função dentro da outra
    "".let (::testeRecebeString)
    // Seu generics faz com que o tipo do it seja o tipo do objeto que invocou o let
    1.let {
        it
    }
    teste {}

    // Quando a função não está por último,
    // ela precisa ficar dentro dos parêntesis
    testePrimeiroFuncao({}, 2)

    // Quando a função está por último nos parâmetros,
    // ela não precisa ficar dentro dos parêntesis
    testeUltimoFuncao(2) {}
}

// Podemos passar uma função como parâmetro de outra função
fun teste(bloco: () -> Unit) {

}

fun testeRecebeString(valor: String) {

}

// Higher order function, quando uma função recebe outra, ou quando retorna outra
fun testePrimeiroFuncao(bloco: () -> Unit, numero: Int) {}
fun testeUltimoFuncao(numero: Int, bloco: () -> Unit) {}
fun testeRetornaFuncao(numero: Int): () -> Unit {return {}}