package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")
    var enderecoNulo: Endereco? = Endereco(logradouro = "Rua Vergueiro")

    // O let coloca nosso objeto dentro de uma scope function
    enderecoNulo?.let {
        println(it.logradouro.length)
    }

    /*
    // Outras formas de usar o let
    enderecoNulo?.let {endereco ->
        println(endereco.logradouro.length)
    }

    // Encadeamento de safe call
    enderecoNulo.let {endereco: Endereco? ->
        println(endereco?.logradouro?.length)
    }
    */

    /*
    // Apenas pega o campo se não for nulo
    enderecoNulo?.logradouro
    //Garantimos que o objeto não é nulo
    val enderecoNaoNulo: Endereco = enderecoNulo!!
    enderecoNaoNulo.logradouro
     */
}