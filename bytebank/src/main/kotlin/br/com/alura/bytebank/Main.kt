package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")
    var enderecoNulo: Endereco? = null
    // Apenas pega o campo se não for nulo
    enderecoNulo?.logradouro
    //Garantimos que o objeto não é nulo
    val enderecoNaoNulo: Endereco = enderecoNulo!!
    enderecoNaoNulo.logradouro
}