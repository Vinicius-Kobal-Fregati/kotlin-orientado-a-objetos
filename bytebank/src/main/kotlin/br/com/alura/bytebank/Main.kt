package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")

    println()
    println(1)
    println(1.1)
    println(true)
    println("teste")

    val endereco = Endereco()
    println(endereco)

    val objeto: Any = Any()
    imprime(objeto)

    val teste: Any = imprime(endereco)
    println(teste)
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}