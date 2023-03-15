package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")

    val endereco = Endereco(logradouro = "Rua Vergueiro", complemento = "Alura")
    var enderecoNovo = Endereco()

    println(endereco.equals(enderecoNovo))
    println(endereco.equals(endereco))

    enderecoNovo = endereco
    println(endereco.equals(enderecoNovo))

    println(endereco.hashCode())
    println(enderecoNovo.hashCode())

    // Representação do objeto
    println(endereco.toString())
    println(endereco)
    println(enderecoNovo.toString())

    println("${endereco.javaClass}@${
        Integer.toHexString(endereco.hashCode())}")
}