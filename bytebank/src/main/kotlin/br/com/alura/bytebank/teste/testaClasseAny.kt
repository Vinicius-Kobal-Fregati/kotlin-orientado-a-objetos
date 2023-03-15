package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaClasseAny() {
    val endereco = Endereco()
    println(endereco)

    imprime(Unit)
    imprime(1)
    imprime(1.0)

    val objeto: Any = Any()
    // referência para o object do java lang, mas ele não é um object, não faz herança dele
    imprime(objeto)

    val teste: Any = imprime(endereco)
    println(teste)
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}