package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    println("Bem vindo ao Bytebank")
    // Com Higher-order function não precisaríamos dessa variável
//    val endereco = Endereco(logradouro = "rua vergueiro", numeroEndereco = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
//    println(enderecoEmMaiusculo)

    val enderecoEmMaiusculo = Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }
    println(enderecoEmMaiusculo)

    // Encadeando as funções, não precisamos criar nenhuma variável
    Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }.let { enderecoEmMaiusculoNoLet ->
        println(enderecoEmMaiusculoNoLet)
    }

    // Maneira mais enxuta ainda
    Endereco(
        logradouro = "rua vergueiro",
        numeroEndereco = 3185
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numeroEndereco}".uppercase()
    }.let(::println)


    // Fazendo a chamada para filtrar uma lista com higher-order function
    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    ).filter { endereco -> endereco.complemento?.isNotEmpty() ?: false }
        .let(::println)
}